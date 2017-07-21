package cn.buildworld.ahlive.bean;

import java.io.Serializable;

/**
 * 作者：MiChong on 2017/7/18 0018 14:34
 * 邮箱：1564666023@qq.com
 */
public class BundleArticle implements Serializable{

    private String article;
    private String author;
    private String title;

    public BundleArticle(String article, String author, String title) {
        this.article = article;
        this.author = author;
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
