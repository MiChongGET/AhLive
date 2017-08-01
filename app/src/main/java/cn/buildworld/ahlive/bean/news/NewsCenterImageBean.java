package cn.buildworld.ahlive.bean.news;

import java.util.List;

/**
 * 作者：MiChong on 2017/7/29 0029 16:21
 * 邮箱：1564666023@qq.com
 */
public class NewsCenterImageBean {

    /**
     * avatar_url : http://p3.pstatp.com/thumb/289e001843c8447bf94c
     * behot_time : 1501315969
     * bury_count : 11458
     * cell_type : 3
     * comment_count : 9216
     * content : 盯着中心看30秒再看看自己的手心
     * create_time : 1499750916
     * cursor : 1501315969999
     * digg_count : 100118
     * filter_words : []
     * group_flags : 0
     * group_id : 63322782932
     * label :
     * label_style : 0
     * large_image : {"height":500,"uri":"large/2ead0002773328d930ac","url":"http://p3.pstatp.com/large/2ead0002773328d930ac","url_list":[{"url":"http://p3.pstatp.com/large/2ead0002773328d930ac"},{"url":"http://pb9.pstatp.com/large/2ead0002773328d930ac"},{"url":"http://pb1.pstatp.com/large/2ead0002773328d930ac"}],"width":500}
     * log_pb : {"impr_id":"2017072916124901000802806850728D"}
     * middle_image : {"height":500,"uri":"middle/2ead0002773328d930ac","url":"http://p3.pstatp.com/middle/2ead0002773328d930ac","url_list":[{"url":"http://p3.pstatp.com/middle/2ead0002773328d930ac"},{"url":"http://pb9.pstatp.com/middle/2ead0002773328d930ac"},{"url":"http://pb1.pstatp.com/middle/2ead0002773328d930ac"}],"width":500}
     * read_count : 0
     * repin_count : 43143
     * rid : 2017072916124901000802806850728D
     * screen_name : 狗头军弹药专家
     * share_url : http://toutiao.com/group/63322782932/?iid=5866847280
     * title :
     * ugc_recommend : {}
     * user_id : 52617008690
     * user_repin : 0
     * user_verified : 0
     * verified_content :
     */

    private String avatar_url;
    private int behot_time;
    private int bury_count;
    private int cell_type;
    private int comment_count;
    private String content;
    private int create_time;
    private long cursor;
    private int digg_count;
    private int group_flags;
    private long group_id;
    private String label;
    private int label_style;
    private LargeImageBean large_image;
    private LogPbBean log_pb;
    private MiddleImageBean middle_image;
    private int read_count;
    private int repin_count;
    private String rid;
    private String screen_name;
    private String share_url;
    private String title;
    private String ugc_recommend;
    private long user_id;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private List<?> filter_words;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getGroup_flags() {
        return group_flags;
    }

    public void setGroup_flags(int group_flags) {
        this.group_flags = group_flags;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLabel_style() {
        return label_style;
    }

    public void setLabel_style(int label_style) {
        this.label_style = label_style;
    }

    public LargeImageBean getLarge_image() {
        return large_image;
    }

    public void setLarge_image(LargeImageBean large_image) {
        this.large_image = large_image;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(String ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public List<?> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<?> filter_words) {
        this.filter_words = filter_words;
    }

    public static class LargeImageBean {
        /**
         * height : 500
         * uri : large/2ead0002773328d930ac
         * url : http://p3.pstatp.com/large/2ead0002773328d930ac
         * url_list : [{"url":"http://p3.pstatp.com/large/2ead0002773328d930ac"},{"url":"http://pb9.pstatp.com/large/2ead0002773328d930ac"},{"url":"http://pb1.pstatp.com/large/2ead0002773328d930ac"}]
         * width : 500
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBean> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p3.pstatp.com/large/2ead0002773328d930ac
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 2017072916124901000802806850728D
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class MiddleImageBean {
        /**
         * height : 500
         * uri : middle/2ead0002773328d930ac
         * url : http://p3.pstatp.com/middle/2ead0002773328d930ac
         * url_list : [{"url":"http://p3.pstatp.com/middle/2ead0002773328d930ac"},{"url":"http://pb9.pstatp.com/middle/2ead0002773328d930ac"},{"url":"http://pb1.pstatp.com/middle/2ead0002773328d930ac"}]
         * width : 500
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBeanX> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p3.pstatp.com/middle/2ead0002773328d930ac
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
