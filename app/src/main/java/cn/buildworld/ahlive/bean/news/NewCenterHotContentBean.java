package cn.buildworld.ahlive.bean.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 作者：MiChong on 2017/7/27 0027 20:24
 * 邮箱：1564666023@qq.com
 */
public class NewCenterHotContentBean {

    /**
     * log_pb : {"impr_id":"20170727152247010011018141972D9F"}
     * read_count : 84529
     * media_name : 山间小农民
     * ban_comment : 0
     * abstract : 生活在农村的朋友都知道，这几年国家政策越来越向农村倾斜，农民生活水平得到了很大提高。日子好了，也越来越注意保护环境了，这几项政策，农民朋友积极参与，都能领到补贴，总共近万元，错过可惜。首先，北方的朋友们有福了。
     * image_list : [{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp","width":1280,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb9.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb1.pstatp.com/list/300x196/31bd0000ed223da33601.webp"}],"uri":"list/31bd0000ed223da33601","height":720},{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed8c2adf86ca.webp","width":1280,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed8c2adf86ca.webp"},{"url":"http://pb9.pstatp.com/list/300x196/31bd0000ed8c2adf86ca.webp"},{"url":"http://pb1.pstatp.com/list/300x196/31bd0000ed8c2adf86ca.webp"}],"uri":"list/31bd0000ed8c2adf86ca","height":720},{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed645361e1d0.webp","width":1280,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed645361e1d0.webp"},{"url":"http://pb9.pstatp.com/list/300x196/31bd0000ed645361e1d0.webp"},{"url":"http://pb1.pstatp.com/list/300x196/31bd0000ed645361e1d0.webp"}],"uri":"list/31bd0000ed645361e1d0","height":720}]
     * ugc_recommend : {"reason":"","activity":""}
     * article_type : 0
     * tag : news_agriculture
     * forward_info : {"forward_count":1}
     * has_m3u8_video : 0
     * keywords : 天然气,小农民,空气污染,农民朋友,农村
     * rid : 20170727152247010011018141972D9F
     * show_portrait_article : false
     * user_verified : 0
     * aggr_type : 1
     * cell_type : 0
     * article_sub_type : 0
     * bury_count : 1
     * title : 农民朋友注意了，这三项补贴近万元，人人有份错过可惜！
     * ignore_web_transform : 1
     * source_icon_style : 5
     * tip : 0
     * hot : 0
     * share_url : http://toutiao.com/a6447304960120471822/?iid=0&app=news_article
     * has_mp4_video : 0
     * source : 山间小农民
     * comment_count : 217
     * article_url : http://toutiao.com/group/6447304960120471822/
     * filter_words : [{"id":"8:0","name":"看过了","is_selected":false},{"id":"9:1","name":"内容太水","is_selected":false},{"id":"5:1266141208","name":"拉黑作者:山间小农民","is_selected":false},{"id":"3:306446079","name":"不想看:能源","is_selected":false}]
     * share_count : 575
     * publish_time : 1501130562
     * action_list : [{"action":1,"extra":{},"desc":""},{"action":3,"extra":{},"desc":""},{"action":7,"extra":{},"desc":""},{"action":9,"extra":{},"desc":""}]
     * gallary_image_count : 3
     * cell_layout_style : 1
     * tag_id : 6447304960120471822
     * video_style : 0
     * verified_content :
     * display_url : http://toutiao.com/group/6447304960120471822/
     * large_image_list : []
     * media_info : {"user_id":62376627050,"verified_content":"","avatar_url":"http://p3.pstatp.com/large/249c0017a6df08ef9f9c","media_id":1570911824905217,"name":"山间小农民","recommend_type":0,"follow":false,"recommend_reason":"","is_star_user":false,"user_verified":false}
     * item_id : 6447306670467973646
     * is_subject : false
     * show_portrait : false
     * repin_count : 625
     * cell_flag : 11
     * user_info : {"verified_content":"","avatar_url":"http://p3.pstatp.com/thumb/249c0017a6df08ef9f9c","user_id":62376627050,"name":"山间小农民","follower_count":0,"follow":false,"user_auth_info":"","user_verified":false,"description":"专业的三农领域自媒体撰稿人"}
     * source_open_url : sslocal://profile?uid=62376627050
     * level : 0
     * digg_count : 0
     * behot_time : 1501137467
     * cursor : 1501137467999
     * url : http://toutiao.com/group/6447304960120471822/
     * preload_web : 0
     * user_repin : 0
     * has_image : true
     * item_version : 0
     * has_video : false
     * group_id : 6447304960120471822
     * middle_image : {"url":"http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp","width":1280,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb9.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb1.pstatp.com/list/300x196/31bd0000ed223da33601.webp"}],"uri":"list/31bd0000ed223da33601","height":720}
     */

    private LogPbBean log_pb;
    private int read_count;
    private String media_name;
    private int ban_comment;
    @SerializedName("abstract")
    private String abstractX;
    private UgcRecommendBean ugc_recommend;
    private int article_type;
    private String tag;
    private ForwardInfoBean forward_info;
    private int has_m3u8_video;
    private String keywords;
    private String rid;
    private boolean show_portrait_article;
    private int user_verified;
    private int aggr_type;
    private int cell_type;
    private int article_sub_type;
    private int bury_count;
    private String title;
    private int ignore_web_transform;
    private int source_icon_style;
    private int tip;
    private int hot;
    private String share_url;
    private int has_mp4_video;
    private String source;
    private int comment_count;
    private String article_url;
    private int share_count;
    private int publish_time;
    private int gallary_image_count;
    private int cell_layout_style;
    private long tag_id;
    private int video_style;
    private String verified_content;
    private String display_url;
    private MediaInfoBean media_info;
    private long item_id;
    private boolean is_subject;
    private boolean show_portrait;
    private int repin_count;
    private int cell_flag;
    private UserInfoBean user_info;
    private String source_open_url;
    private int level;
    private int digg_count;
    private int behot_time;
    private long cursor;
    private String url;
    private int preload_web;
    private int user_repin;
    private boolean has_image;
    private int item_version;
    private boolean has_video;
    private long group_id;
    private MiddleImageBean middle_image;
    private List<ImageListBean> image_list;
    private List<FilterWordsBean> filter_words;
    private List<ActionListBean> action_list;
    private List<?> large_image_list;

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public int getHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(int has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPreload_web() {
        return preload_web;
    }

    public void setPreload_web(int preload_web) {
        this.preload_web = preload_web;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public List<ImageListBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
        this.image_list = image_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<?> getLarge_image_list() {
        return large_image_list;
    }

    public void setLarge_image_list(List<?> large_image_list) {
        this.large_image_list = large_image_list;
    }

    public static class LogPbBean {
        /**
         * impr_id : 20170727152247010011018141972D9F
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class UgcRecommendBean {
        /**
         * reason :
         * activity :
         */

        private String reason;
        private String activity;

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }
    }

    public static class ForwardInfoBean {
        /**
         * forward_count : 1
         */

        private int forward_count;

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class MediaInfoBean {
        /**
         * user_id : 62376627050
         * verified_content :
         * avatar_url : http://p3.pstatp.com/large/249c0017a6df08ef9f9c
         * media_id : 1570911824905217
         * name : 山间小农民
         * recommend_type : 0
         * follow : false
         * recommend_reason :
         * is_star_user : false
         * user_verified : false
         */

        private long user_id;
        private String verified_content;
        private String avatar_url;
        private long media_id;
        private String name;
        private int recommend_type;
        private boolean follow;
        private String recommend_reason;
        private boolean is_star_user;
        private boolean user_verified;

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }
    }

    public static class UserInfoBean {
        /**
         * verified_content :
         * avatar_url : http://p3.pstatp.com/thumb/249c0017a6df08ef9f9c
         * user_id : 62376627050
         * name : 山间小农民
         * follower_count : 0
         * follow : false
         * user_auth_info :
         * user_verified : false
         * description : 专业的三农领域自媒体撰稿人
         */

        private String verified_content;
        private String avatar_url;
        private long user_id;
        private String name;
        private int follower_count;
        private boolean follow;
        private String user_auth_info;
        private boolean user_verified;
        private String description;

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class MiddleImageBean {
        /**
         * url : http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp
         * width : 1280
         * url_list : [{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb9.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb1.pstatp.com/list/300x196/31bd0000ed223da33601.webp"}]
         * uri : list/31bd0000ed223da33601
         * height : 720
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp
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

    public static class ImageListBean {
        /**
         * url : http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp
         * width : 1280
         * url_list : [{"url":"http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb9.pstatp.com/list/300x196/31bd0000ed223da33601.webp"},{"url":"http://pb1.pstatp.com/list/300x196/31bd0000ed223da33601.webp"}]
         * uri : list/31bd0000ed223da33601
         * height : 720
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBeanX> url_list;

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p3.pstatp.com/list/300x196/31bd0000ed223da33601.webp
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

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * name : 看过了
         * is_selected : false
         */

        private String id;
        private String name;
        private boolean is_selected;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * extra : {}
         * desc :
         */

        private int action;
        private ExtraBean extra;
        private String desc;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public static class ExtraBean {
        }
    }
}
