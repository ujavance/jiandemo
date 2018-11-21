package com.uj.jian.bean;

public class ArticleWithBLOBs extends Article {
    private String articlewords;

    private String articlebody;

    public String getArticlewords() {
        return articlewords;
    }

    public void setArticlewords(String articlewords) {
        this.articlewords = articlewords == null ? null : articlewords.trim();
    }

    public String getArticlebody() {
        return articlebody;
    }

    public void setArticlebody(String articlebody) {
        this.articlebody = articlebody == null ? null : articlebody.trim();
    }
}