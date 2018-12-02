package com.uj.jian.controller;

import com.uj.jian.bean.*;
import com.uj.jian.service.TagService;
import com.uj.jian.service.WriteService;
import com.uj.jian.utils.Msg;
import com.uj.jian.utils.SingletonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WriteContoller {

    @Autowired
    private TagService tagService;

    @Autowired
    private WriteService writeService;

    /*每一次加载条数*/
    private static final int PAGEITEMS = 5;
    /*保存发表文章*/
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String saveArticle(ArticleDO articleDO ,MultipartFile img) throws Exception{
        writeService.saveArticle(img, articleDO);
        return "/home";
    }
    /*获得评论*/
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Msg getComments(Integer id) {
        List<CommentUser> commments = writeService.getCommentOfArticle(id);
        SingletonLogger.logger.info("文章ID {} ， 评论合集 {}", id, commments);
        return Msg.success().add("comments", commments);
    }

    /*============ 标签 ==================*/

    /*输入值 -> 匹配标签集*/
    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    @ResponseBody
    public Msg getTags(String tagName) {
        List<Tag> tags = tagService.getTags(tagName);
        if (tags == null || tags.size() < 1) {
            return Msg.fail();
        }
        List<SelectDO> selectDOS = writeService.formatTags(tags);
        return Msg.success().add("tags", selectDOS);
    }

    /*创建标签*/
    @RequestMapping(value = "/tag", method = RequestMethod.PUT)
    @ResponseBody
    public Msg createTags(String tagname) {
        return tagService.create(tagname)?Msg.success().add("info", "创建成功"):Msg.fail().add("info", "创建失败!后台已经存在该标签");
    }

    @RequestMapping(value = "/person/info", method = RequestMethod.GET)
    @ResponseBody
    public Msg getInfo(Integer userid) {
        return  Msg.success().add("info", "创建成功").add("articleNum", tagService.getArticleNum(userid)).add("tagNum", tagService.getTagOfUser(userid));
    }



    /*============ 首页 ==================*/
    /* 登录后 -> 用户首页文章信息*/
    @RequestMapping(value = "/read",method=RequestMethod.GET)
    @ResponseBody
    public Msg getArticlesWithUserId(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpSession httpSession) {
        return writeService.getUserFollowInfo(((User)httpSession.getAttribute("user")).getUserid(), pn);
    }
    /*获取某一位用户的文章*/
    @RequestMapping(value = "/user/person",method=RequestMethod.GET)
    @ResponseBody
    public Msg getUserArticle(Integer userId, Integer pn, HttpSession httpSession) {
        return writeService.getArticleOfUser(((User)httpSession.getAttribute("user")).getUserid(), pn);
    }
    /*推荐用户*/
    @RequestMapping(value = "/recommond",method = RequestMethod.GET)
    @ResponseBody
    public Msg getRecommendUserInfo(Integer userid) {
        List<User> userInfo = writeService.getRecommondUserInfo(userid);
        return Msg.success().add("recommondUserInfo", userInfo);
    }
    /*关注用户*/
    @RequestMapping(value = "/observe", method = RequestMethod.PUT)
    @ResponseBody
    public Msg followerSb(Integer userId, Integer followId) {
        SingletonLogger.logger.info("follower Sb {}, articleId is {} ", userId, followId);
        return writeService.followsb(userId, followId)?Msg.success().add("info", "成功关注！"):Msg.fail().add("info", "已经关注了该用户");
    }

    /*========== 个人用户界面 ===============*/
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public Msg getPersonalArticle(Integer userId, Integer pn) {
        return writeService.getPersonalArticle(userId, pn);
    }
}
