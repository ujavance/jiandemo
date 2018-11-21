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
import java.util.LinkedList;
import java.util.List;

@Controller
public class WriteContoller {

    @Autowired
    private TagService tagService;

    @Autowired
    private WriteService writeService;

    /*
    * 每一次加载条数*/
    private static final int PAGEITEMS = 5;

    /**
     * @Description: 保存发表文章
     * @Param: [img, articleDO] 上传图片 ，文章内容主体
     * @return: java.lang.String 返回视图 jsp 名字
     * @Author: Administrator
     * @Date: 2018/11/18
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String saveArticle(MultipartFile img, ArticleDO articleDO) throws Exception{
        writeService.saveArticle(img, articleDO);
        return "home";
    }
    /*获得评论*/
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Msg getComments(Integer id) {
        List<CommentUser> commments = writeService.getCommentOfArticle(id);
        SingletonLogger.logger.info("文章ID {} ， 评论合集 {}", id, commments);
        return Msg.success().add("comments", commments);
    }
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
}
