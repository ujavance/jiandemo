package com.uj.jian.service;

import com.uj.jian.bean.ArticleWithBLOBs;
import com.uj.jian.bean.Comment;
import com.uj.jian.bean.User;
import com.uj.jian.dao.ArticleMapper;
import com.uj.jian.dao.CommentMapper;
import com.uj.jian.utils.SingletonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * @Description: 保存评论
     * eg: 插入时，后台保存当前时间
     * @Param: [comment] `commentBody`、`articleId`, `userId`
     * @return: com.uj.jian.utils.Msg
     * @Author: Administrator
     * @Date: 2018/11/17
     * TODO： 测试发布评论是否成功
     * TODO： 测试点赞是否成功
     * TODO：关注好友是否成功
     */
    public boolean saveComment(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }
    /**
     * 点赞
    * @Description:  赞数增加一
     * 1. 找到对应文章
     * 2. 文章赞数+1
     * 3. 更新文章赞数
    * @Param:  Integer userId 用户id, Integer articleId 文章id
    * @return:  boolean 是否点赞
    * @Author: lei
    * @Date: 2018/11/15
    */
    public boolean addLikeNumber(Integer userId, Integer articleId) {
        boolean isLike = checkArticleLiked(userId, articleId);
        if (isLike) {
            /*已经点赞*/
            return false;
        } else {
            /*找到文章*/
            ArticleWithBLOBs articleWithBLOBs = articleMapper.selectByPrimaryKey(articleId);
            articleWithBLOBs.setLikenum(articleWithBLOBs.getLikenum() + 1);
            SingletonLogger.logger.info("addLikeNumber find the number {}", articleWithBLOBs);
            /*插入点赞记录*/
            saveLikedRecord(userId, articleId, 1);
            /*文章数加一*/
            return articleMapper.updateByPrimaryKeySelective(articleWithBLOBs) == 1;
        }
    }
    /**
     * @Description:  插入点赞记录
     * @Param: [userId, articleId, i]  i有两个值 1 表示已经点赞，0表示未点赞
     * @return: boolean 是否插成功
     * @Author: Administrator
     * @Date: 2018/11/15
     */
    private boolean saveLikedRecord(Integer userId, Integer articleId, Integer i) {

        return articleMapper.saveArticleLiked(userId, articleId, i) > 0;
    }
    /**
     * @Description:  检查是否点赞
     * @Param: [userId, articleId]
     * @return: boolean
     * @Author: Administrator
     * @Date: 2018/11/15
     */
    private boolean checkArticleLiked(Integer userId, Integer articleId) {

        return articleMapper.countArticleLiked(userId, articleId) > 0;
    }

    public List<User> getRecommondUserInfo(Integer userid) {
        /*
        * redisDao.savaList("userId1", );
        * TODO: 其他
        * */
        return null;
    }
}
