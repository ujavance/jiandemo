package com.uj.jian.controller;

import com.uj.jian.bean.Comment;
import com.uj.jian.bean.User;
import com.uj.jian.dao.RedisService;
import com.uj.jian.service.ArticleService;
import com.uj.jian.utils.Msg;
import com.uj.jian.utils.SingletonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /*保存评论*/
    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    @ResponseBody
    public Msg saveComment(Comment comment) {
        comment.setCommentcreatetime(new Date());
        if (articleService.saveComment(comment)) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /*点赞*/
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseBody
    public Msg addLikeNumber(Integer userId, Integer articleId) {
        SingletonLogger.logger.info("addLikeNum userId is {}, articleId is {} ", userId, articleId);
        return articleService.addLikeNumber(userId, articleId)?Msg.success():Msg.fail().add("info", "已经点过赞了！");
    }
}
