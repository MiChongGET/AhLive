package cn.buildworld.ahlive.bean;

/**
 * 作者：MiChong on 2017/7/27 0027 21:19
 * 邮箱：1564666023@qq.com
 */
public class NewsHotlistBean {

    String newscenter_title;
    String keywords;
    String media_name;
    long behot_time;
    String newscenter_img1;
    String newscenter_img2;
    String newscenter_img3;
    int mArticleType;

    public NewsHotlistBean(String newscenter_title, String keywords, String media_name, long behot_time, String newscenter_img1, String newscenter_img2, String newscenter_img3, int articleType) {
        this.newscenter_title = newscenter_title;
        this.keywords = keywords;
        this.media_name = media_name;
        this.behot_time = behot_time;
        this.newscenter_img1 = newscenter_img1;
        this.newscenter_img2 = newscenter_img2;
        this.newscenter_img3 = newscenter_img3;
        mArticleType = articleType;
    }

    public String getNewscenter_title() {
        return newscenter_title;
    }

    public void setNewscenter_title(String newscenter_title) {
        this.newscenter_title = newscenter_title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public long getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(long behot_time) {
        this.behot_time = behot_time;
    }

    public String getNewscenter_img1() {
        return newscenter_img1;
    }

    public void setNewscenter_img1(String newscenter_img1) {
        this.newscenter_img1 = newscenter_img1;
    }

    public String getNewscenter_img2() {
        return newscenter_img2;
    }

    public void setNewscenter_img2(String newscenter_img2) {
        this.newscenter_img2 = newscenter_img2;
    }

    public String getNewscenter_img3() {
        return newscenter_img3;
    }

    public void setNewscenter_img3(String newscenter_img3) {
        this.newscenter_img3 = newscenter_img3;
    }

    public int getArticleType() {
        return mArticleType;
    }

    public void setArticleType(int articleType) {
        mArticleType = articleType;
    }

    @Override
    public String toString() {
        return "NewsHotlistBean{" +
                "newscenter_title='" + newscenter_title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", media_name='" + media_name + '\'' +
                ", behot_time=" + behot_time +
                ", newscenter_img1='" + newscenter_img1 + '\'' +
                ", newscenter_img2='" + newscenter_img2 + '\'' +
                ", newscenter_img3='" + newscenter_img3 + '\'' +
                ", mArticleType=" + mArticleType +
                '}';
    }
}
