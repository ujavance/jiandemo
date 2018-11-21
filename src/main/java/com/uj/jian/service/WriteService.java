package com.uj.jian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.uj.jian.bean.*;
import com.uj.jian.dao.ArticleMapper;
import com.uj.jian.dao.FollowerMapper;
import com.uj.jian.utils.Msg;
import com.uj.jian.utils.SingletonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WriteService {

    @Value("${img.url}")
    private String imgUrl;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private FollowerMapper followerMapper;
    /**
    * @Description: 保存发表的文章
    * @Param:
     * MultipartFile img 上传的图片, 保存在 "D:\jian\img"[配置在 other.propeties], 格式 “时间秒数” + 原来的文件名
     * ArticleDO articleDO[tagId、userId、content/标签id，用户id， 内容]
     * eg: {content:sfldfk, tagId: 3,userid: 1,img 图片}
     * eg: 记录当前时间，插入数据库，供浏览动态使用
    * @return: boolean 是否保存成功
    * @Author: lei
    * @Date: 2018/11/15
    */
    public boolean saveArticle(MultipartFile img, ArticleDO articleDO) throws IOException {
        SingletonLogger.logger.info(" saveArticle article body is {}", articleDO.toString());
        SingletonLogger.logger.info(" saveArticle save img dirction is {}", imgUrl);

        String filename = img.getOriginalFilename();
        final String imgFile = System.currentTimeMillis() +"-"+ filename;
        SingletonLogger.logger.info(" saveArticle img name is {}", imgFile);
        File dic =new File(imgUrl);
        if (!dic.exists()) {
            dic.mkdirs();
        }
        File file=new File(dic, imgFile);
        img.transferTo(file);
        ArticleWithBLOBs articleWithBLOBs = new ArticleWithBLOBs();
        articleWithBLOBs.setArticlebody(articleDO.getContent());
        articleWithBLOBs.setTagid(articleDO.getTagId());
        articleWithBLOBs.setUserid(articleDO.getUserId());
        articleWithBLOBs.setArticletime(new Date());
        articleWithBLOBs.setArticlehead(imgFile);
        return articleMapper.insertSelective(articleWithBLOBs) > 0;
    }
    /**
    * @Description: 用户登录后，进入首页，获取当前一个星期的文章信息。【用户自己，以及关注用户】
    * @Param:  用户id， 当前页码
    * @return:  带有分页信息的 json
    * @Author: lei
    * @Date: 2018/11/15
    */
    public Msg getUserFollowInfo(Integer userId, int pn) {
        if (userId != null) {
            ArticleExample articleExample = new ArticleExample();
            /*发布时间排序*/
            articleExample.setOrderByClause("articleTime DESC");
            ArticleExample.Criteria criteria = articleExample.createCriteria();
            /*某一位用户*/
           // criteria.andUseridEqualTo(userId);
            List<Integer> followsIdSet = parseFollowersUserIdSet(getFollowersId(userId));
            followsIdSet.add(userId);
            SingletonLogger.logger.info("User {}, Follow USerId set {}", userId, followsIdSet);
            criteria.andUseridInWithUser(followsIdSet);
            /*日期限定在一周内*/
            criteria.andArticletimeBetween(new Date(System.currentTimeMillis() - 7*24*60*60*1000), new Date());
            PageHelper.startPage(pn, 5);
            List<ArticleWithBLOBsAndUser> articles = articleMapper.selectByExampleWithBLOBsWithUser(articleExample);
            PageInfo page = new PageInfo(articles,5);
            return Msg.success().add("pageInfo", page);
        }
        return null;
    }
    /**
    * @Description: 获得用户关注列表。【List<Follower> (关注用户集合)】
    * @Param:  用户 id
    * @return:  List<Follower>
    * @Author: lei
    * @Date: 2018/11/15
    */
    private List<Follower> getFollowersId(Integer userId) {
        FollowerExample followerExample = new FollowerExample();
        followerExample.createCriteria().andUseridEqualTo(userId);
        return  followerMapper.selectByExample(followerExample);
    }
    /**
    * @Description:  获取评论
    * @Param:  文章id
    * @return:  文章对应评论集合
    * @Author: lei
    * @Date: 2018/11/15
    */
    public List<CommentUser> getCommentOfArticle(Integer id) {
        return articleMapper.selectCommentOfArticle(id);
    }
    /**
     * @Description:  当前格式 -> 目标格式
     * @Param:  {tagid="", targName=""} 集合
     * @return:  {id="", text=""} 集合转换
     * @Author: lei
     * @Date: 2018/11/15
     */
    public List<SelectDO> formatTags(List<Tag> tags) {
        List<SelectDO> selectDOS = new LinkedList<>();
        for (Tag tag : tags) {
            selectDOS.add(new SelectDO(tag.getTagid(), tag.getTagname()));
        }
        return selectDOS;
    }
    /**
    * @Description:  提取 Follower 集合的id
    * @Param:  List<Follower>
    * @return:  List<Integer>
    * @Author: lei
    * @Date: 2018/11/15
    */
    private List<Integer> parseFollowersUserIdSet(List<Follower> followerList) {
        if (followerList == null || followerList.size() < 1)
            return null;
        return followerList.stream().map(follower -> follower.getFollowid()).collect(Collectors.toList());
    }
    /**
     * @Description: 获取后一位用户的文章
     * @Param: [user, pn] 用户id， 当前页数
     * @return: com.uj.jian.utils.Msg
     * @Author: Administrator
     * @Date: 2018/11/15
     */
    public Msg getArticleOfUser(Integer userId, Integer pn) {
        if (userId != null) {
            ArticleExample articleExample = new ArticleExample();
            /*发布时间排序*/
            articleExample.setOrderByClause("articleTime DESC");
            ArticleExample.Criteria criteria = articleExample.createCriteria();
            /*某一位用户*/
             criteria.andUseridEqualTo(userId);
            criteria.andArticletimeBetween(new Date(System.currentTimeMillis() - 7*24*60*60*1000), new Date());
            PageHelper.startPage(pn, 5);
            List<ArticleWithBLOBsAndUser> articles = articleMapper.selectByExampleWithBLOBsWithUser(articleExample);
            PageInfo page = new PageInfo(articles,5);
            return Msg.success().add("pageInfo", page);
        }
        return null;
    }
}
