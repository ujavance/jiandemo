package com.uj.jian.controller;

import com.uj.jian.bean.User;
import com.uj.jian.service.UserService;
import com.uj.jian.utils.Msg;
import com.uj.jian.utils.SingletonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Value("${img.url}")
    private String imgUrl;

    @Autowired
    UserService userService;

    /*根据ID，获取用户信息*/
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Msg checkUser(@PathVariable("id") Integer id) {
        return Msg.success().add("info", userService.getUser(id));
    }
    /*============登录、注册逻辑================*/
    @RequestMapping("/quit")
    public String clientLoginOut(HttpSession httpSession){
        httpSession.invalidate();
        return "/";
    }
    /*登录判断*/
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Msg checkUserInfo(HttpServletResponse httpResponse, User user, HttpSession httpSession){
        SingletonLogger.logger.info("login --- check userinfo {}", user);
        List<User> users = userService.checkUserInfo(user);
        SingletonLogger.logger.info("login --- get userinfo result info {}", users);

        if (users!=null || users.size() == 1) {
            String userIdValue = String.valueOf(users.get(0).getUserid());
            Cookie cookie = new Cookie("userId", userIdValue);//创建新cookie
            cookie.setMaxAge(5 * 60 *60 *24);// 设置存在时间为5分钟
            cookie.setPath("/");//设置作用域
            httpResponse.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
            httpSession.setAttribute("user", users.get(0));
            return Msg.success().add("userId", users.get(0).getUserid());
        }
        return Msg.fail().add("result", "登录出错");
    }
    /*重复用户名判断*/
    @ResponseBody
    public Msg checkUserName(@RequestParam("username") String userName){
        return checkUserNameSame(userName)? Msg.success():Msg.fail();
    }
    private boolean checkUserNameSame(String userName) {
        SingletonLogger.logger.info("login --- check ！ have this name ？ {}", userName);
        List<User> users = userService.checkUserName(userName);
        if (users!=null && users.size() > 0) {
            /*存在重复名字 或者 用户名无法校验都 fail*/
            return false;
        }
        return true;
    }
    /*注册判断*/
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Msg registerUserInfo(User registerUser){
        if (checkUserNameSame(registerUser.getUsername())) {
            return userService.saveUser(registerUser) ? Msg.success() : Msg.fail();
        }
        return Msg.fail();
    }
    /*登录界面*/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }
    /*注册界面*/
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage() {
        return "register";
    }
    /*========== 首页 逻辑============*/
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(HttpSession httpSession, Model model) {
        model.addAttribute("userId", ((User)httpSession.getAttribute("user")).getUserid());
        return "home";
    }
    /*==========404 错误===============*/
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String showErrorPage() {
        return "404";
    }
    /*========== 个人用户界面 ===============*/
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String showPersonal() {
        return "person";
    }
}
