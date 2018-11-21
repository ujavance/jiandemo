package com.uj.jian.dao;

import com.uj.jian.bean.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    
    
    long countByExample(ArticleExample example);
    

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer articleid);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example);
    List<ArticleWithBLOBsAndUser> selectByExampleWithBLOBsWithUser(ArticleExample example);

    /*查询待作者的文章信息*/
    List<ArticleWithBLOBs> selectArticleWithUser(Integer id);

    List<Article> selectByExample(ArticleExample example);

    List<CommentUser>  selectCommentOfArticle(Integer id);

    ArticleWithBLOBs selectByPrimaryKey(Integer articleid);

    int updateByExampleSelective(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);

    //  是否已经点赞
    long countArticleLiked(Integer userId, Integer articleId);
    // 插入点赞记录
    int saveArticleLiked(Integer userId, Integer articleId, Integer i);
}