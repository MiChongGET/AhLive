package cn.buildworld.ahlive.bean;


import java.util.List;

/**
 * 作者：MiChong on 2017/7/26 0026 10:55
 * 邮箱：1564666023@qq.com
 */
public class FunVideoBean {

    private String message;
    private DataBeanX data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FunVideoBean{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBeanX {

        private double max_time;
        private int min_time;
        private List<DataBean> data;


        public double getMax_time() {
            return max_time;
        }

        public void setMax_time(double max_time) {
            this.max_time = max_time;
        }

        public int getMin_time() {
            return min_time;
        }

        public void setMin_time(int min_time) {
            this.min_time = min_time;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {

            private GroupBean group;
            private int type;
            private int display_time;
            private int online_time;

            public GroupBean getGroup() {
                return group;
            }

            public void setGroup(GroupBean group) {
                this.group = group;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getDisplay_time() {
                return display_time;
            }

            public void setDisplay_time(int display_time) {
                this.display_time = display_time;
            }

            public int getOnline_time() {
                return online_time;
            }

            public void setOnline_time(int online_time) {
                this.online_time = online_time;
            }


            public static class GroupBean {

                private String video_id;
                private String mp4_url;
                private String text;
                private int digg_count;
                private int create_time;
                private String share_url;
                private int go_detail_count;
                private String keywords;
                private long id;
                private int favorite_count;
                private DanmakuAttrsBean danmaku_attrs;
                private String m3u8_url;
                private LargeCoverBean large_cover;
                private int user_favorite;
                private int share_type;
                private String title;
                private UserBean user;
                private int is_can_share;
                private int category_type;
                private String download_url;
                private int label;
                private String content;
                private int video_height;
                private int comment_count;
                private String cover_image_uri;
                private String id_str;
                private int media_type;
                private int share_count;
                private int type;
                private int category_id;
                private int status;
                private int has_comments;
                private String publish_time;
                private int user_bury;
                private ActivityBean activity;
                private String status_desc;
                private String neihan_hot_start_time;
                private int play_count;
                private int user_repin;
                private boolean quick_comment;
                private MediumCoverBean medium_cover;
                private String neihan_hot_end_time;
                private int user_digg;
                private int video_width;
                private int online_time;
                private String category_name;
                private String flash_url;
                private boolean category_visible;
                private int bury_count;
                private boolean is_anonymous;
                private int repin_count;
                private boolean is_neihan_hot;
                private String uri;
                private int is_public_url;
                private int has_hot_comments;
                private boolean allow_dislike;
                private OriginVideoBean origin_video;
                private String cover_image_url;
                private NeihanHotLinkBean neihan_hot_link;
                private long group_id;
                private int is_video;
                private int display_type;
                private List<DislikeReasonBean> dislike_reason;

                public String getVideo_id() {
                    return video_id;
                }

                public void setVideo_id(String video_id) {
                    this.video_id = video_id;
                }

                public String getMp4_url() {
                    return mp4_url;
                }

                public void setMp4_url(String mp4_url) {
                    this.mp4_url = mp4_url;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }


                public int getDigg_count() {
                    return digg_count;
                }

                public void setDigg_count(int digg_count) {
                    this.digg_count = digg_count;
                }


                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
                }

                public int getGo_detail_count() {
                    return go_detail_count;
                }

                public void setGo_detail_count(int go_detail_count) {
                    this.go_detail_count = go_detail_count;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getFavorite_count() {
                    return favorite_count;
                }

                public void setFavorite_count(int favorite_count) {
                    this.favorite_count = favorite_count;
                }

                public DanmakuAttrsBean getDanmaku_attrs() {
                    return danmaku_attrs;
                }

                public void setDanmaku_attrs(DanmakuAttrsBean danmaku_attrs) {
                    this.danmaku_attrs = danmaku_attrs;
                }

                public String getM3u8_url() {
                    return m3u8_url;
                }

                public void setM3u8_url(String m3u8_url) {
                    this.m3u8_url = m3u8_url;
                }

                public LargeCoverBean getLarge_cover() {
                    return large_cover;
                }

                public void setLarge_cover(LargeCoverBean large_cover) {
                    this.large_cover = large_cover;
                }

                public int getUser_favorite() {
                    return user_favorite;
                }

                public void setUser_favorite(int user_favorite) {
                    this.user_favorite = user_favorite;
                }

                public int getShare_type() {
                    return share_type;
                }

                public void setShare_type(int share_type) {
                    this.share_type = share_type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public int getIs_can_share() {
                    return is_can_share;
                }

                public void setIs_can_share(int is_can_share) {
                    this.is_can_share = is_can_share;
                }

                public int getCategory_type() {
                    return category_type;
                }

                public void setCategory_type(int category_type) {
                    this.category_type = category_type;
                }

                public String getDownload_url() {
                    return download_url;
                }

                public void setDownload_url(String download_url) {
                    this.download_url = download_url;
                }

                public int getLabel() {
                    return label;
                }

                public void setLabel(int label) {
                    this.label = label;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getVideo_height() {
                    return video_height;
                }

                public void setVideo_height(int video_height) {
                    this.video_height = video_height;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public String getCover_image_uri() {
                    return cover_image_uri;
                }

                public void setCover_image_uri(String cover_image_uri) {
                    this.cover_image_uri = cover_image_uri;
                }

                public String getId_str() {
                    return id_str;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }

                public int getMedia_type() {
                    return media_type;
                }

                public void setMedia_type(int media_type) {
                    this.media_type = media_type;
                }

                public int getShare_count() {
                    return share_count;
                }

                public void setShare_count(int share_count) {
                    this.share_count = share_count;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getHas_comments() {
                    return has_comments;
                }

                public void setHas_comments(int has_comments) {
                    this.has_comments = has_comments;
                }

                public String getPublish_time() {
                    return publish_time;
                }

                public void setPublish_time(String publish_time) {
                    this.publish_time = publish_time;
                }

                public int getUser_bury() {
                    return user_bury;
                }

                public void setUser_bury(int user_bury) {
                    this.user_bury = user_bury;
                }

                public ActivityBean getActivity() {
                    return activity;
                }

                public void setActivity(ActivityBean activity) {
                    this.activity = activity;
                }

                public String getStatus_desc() {
                    return status_desc;
                }

                public void setStatus_desc(String status_desc) {
                    this.status_desc = status_desc;
                }

                public String getNeihan_hot_start_time() {
                    return neihan_hot_start_time;
                }

                public void setNeihan_hot_start_time(String neihan_hot_start_time) {
                    this.neihan_hot_start_time = neihan_hot_start_time;
                }

                public int getPlay_count() {
                    return play_count;
                }

                public void setPlay_count(int play_count) {
                    this.play_count = play_count;
                }

                public int getUser_repin() {
                    return user_repin;
                }

                public void setUser_repin(int user_repin) {
                    this.user_repin = user_repin;
                }

                public boolean isQuick_comment() {
                    return quick_comment;
                }

                public void setQuick_comment(boolean quick_comment) {
                    this.quick_comment = quick_comment;
                }

                public MediumCoverBean getMedium_cover() {
                    return medium_cover;
                }

                public void setMedium_cover(MediumCoverBean medium_cover) {
                    this.medium_cover = medium_cover;
                }

                public String getNeihan_hot_end_time() {
                    return neihan_hot_end_time;
                }

                public void setNeihan_hot_end_time(String neihan_hot_end_time) {
                    this.neihan_hot_end_time = neihan_hot_end_time;
                }

                public int getUser_digg() {
                    return user_digg;
                }

                public void setUser_digg(int user_digg) {
                    this.user_digg = user_digg;
                }

                public int getVideo_width() {
                    return video_width;
                }

                public void setVideo_width(int video_width) {
                    this.video_width = video_width;
                }

                public int getOnline_time() {
                    return online_time;
                }

                public void setOnline_time(int online_time) {
                    this.online_time = online_time;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getFlash_url() {
                    return flash_url;
                }

                public void setFlash_url(String flash_url) {
                    this.flash_url = flash_url;
                }

                public boolean isCategory_visible() {
                    return category_visible;
                }

                public void setCategory_visible(boolean category_visible) {
                    this.category_visible = category_visible;
                }

                public int getBury_count() {
                    return bury_count;
                }

                public void setBury_count(int bury_count) {
                    this.bury_count = bury_count;
                }

                public boolean isIs_anonymous() {
                    return is_anonymous;
                }

                public void setIs_anonymous(boolean is_anonymous) {
                    this.is_anonymous = is_anonymous;
                }

                public int getRepin_count() {
                    return repin_count;
                }

                public void setRepin_count(int repin_count) {
                    this.repin_count = repin_count;
                }

                public boolean isIs_neihan_hot() {
                    return is_neihan_hot;
                }

                public void setIs_neihan_hot(boolean is_neihan_hot) {
                    this.is_neihan_hot = is_neihan_hot;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public int getIs_public_url() {
                    return is_public_url;
                }

                public void setIs_public_url(int is_public_url) {
                    this.is_public_url = is_public_url;
                }

                public int getHas_hot_comments() {
                    return has_hot_comments;
                }

                public void setHas_hot_comments(int has_hot_comments) {
                    this.has_hot_comments = has_hot_comments;
                }

                public boolean isAllow_dislike() {
                    return allow_dislike;
                }

                public void setAllow_dislike(boolean allow_dislike) {
                    this.allow_dislike = allow_dislike;
                }

                public OriginVideoBean getOrigin_video() {
                    return origin_video;
                }

                public void setOrigin_video(OriginVideoBean origin_video) {
                    this.origin_video = origin_video;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public NeihanHotLinkBean getNeihan_hot_link() {
                    return neihan_hot_link;
                }

                public void setNeihan_hot_link(NeihanHotLinkBean neihan_hot_link) {
                    this.neihan_hot_link = neihan_hot_link;
                }

                public long getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(long group_id) {
                    this.group_id = group_id;
                }

                public int getIs_video() {
                    return is_video;
                }

                public void setIs_video(int is_video) {
                    this.is_video = is_video;
                }

                public int getDisplay_type() {
                    return display_type;
                }

                public void setDisplay_type(int display_type) {
                    this.display_type = display_type;
                }

                public List<DislikeReasonBean> getDislike_reason() {
                    return dislike_reason;
                }

                public void setDislike_reason(List<DislikeReasonBean> dislike_reason) {
                    this.dislike_reason = dislike_reason;
                }

                public static class _$360pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=360p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=360p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 360p/f473b92bbf4a413cad2ad047c2bff213
                     * height : 640
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBean> url_list;

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
                         * url : http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=360p&line=0&is_gif=0&device_platform=android
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

                public static class _$720pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=720p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=720p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 720p/f473b92bbf4a413cad2ad047c2bff213
                     * height : 640
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBeanX> url_list;

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
                         * url : http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=720p&line=0&is_gif=0&device_platform=android
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

                public static class _$480pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=480p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=480p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 480p/f473b92bbf4a413cad2ad047c2bff213
                     * height : 640
                     */

                    private int width;
                    private String uri;
                    private int height;
                    private List<UrlListBeanXX> url_list;

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

                    public List<UrlListBeanXX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanXX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanXX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1501033384.71/?video_id=f473b92bbf4a413cad2ad047c2bff213&quality=480p&line=0&is_gif=0&device_platform=android
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

                public static class DanmakuAttrsBean {
                    /**
                     * allow_show_danmaku : 1
                     * allow_send_danmaku : 1
                     */

                    private int allow_show_danmaku;
                    private int allow_send_danmaku;

                    public int getAllow_show_danmaku() {
                        return allow_show_danmaku;
                    }

                    public void setAllow_show_danmaku(int allow_show_danmaku) {
                        this.allow_show_danmaku = allow_show_danmaku;
                    }

                    public int getAllow_send_danmaku() {
                        return allow_send_danmaku;
                    }

                    public void setAllow_send_danmaku(int allow_send_danmaku) {
                        this.allow_send_danmaku = allow_send_danmaku;
                    }
                }

                public static class LargeCoverBean {
                    /**
                     * url_list : [{"url":"http://p3.pstatp.com/large/2aff000d187cb3d8eb5f.webp"},{"url":"http://pb9.pstatp.com/large/2aff000d187cb3d8eb5f.webp"},{"url":"http://pb1.pstatp.com/large/2aff000d187cb3d8eb5f.webp"}]
                     * uri : large/2aff000d187cb3d8eb5f
                     */

                    private String uri;
                    private List<UrlListBeanXXX> url_list;

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public List<UrlListBeanXXX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanXXX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanXXX {
                        /**
                         * url : http://p3.pstatp.com/large/2aff000d187cb3d8eb5f.webp
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

                public static class UserBean {

                    private String avatar_url;
                    private String name;

                    public String getAvatar_url() {
                        return avatar_url;
                    }

                    public void setAvatar_url(String avatar_url) {
                        this.avatar_url = avatar_url;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class ActivityBean {
                }

                public static class MediumCoverBean {
                    /**
                     * url_list : [{"url":"http://p3.pstatp.com/w202/2aff000d187cb3d8eb5f.webp"},{"url":"http://pb9.pstatp.com/w202/2aff000d187cb3d8eb5f.webp"},{"url":"http://pb1.pstatp.com/w202/2aff000d187cb3d8eb5f.webp"}]
                     * uri : medium/2aff000d187cb3d8eb5f
                     */

                    private String uri;
                    private List<UrlListBeanXXXX> url_list;

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public List<UrlListBeanXXXX> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<UrlListBeanXXXX> url_list) {
                        this.url_list = url_list;
                    }

                    public static class UrlListBeanXXXX {
                        /**
                         * url : http://p3.pstatp.com/w202/2aff000d187cb3d8eb5f.webp
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

                public static class OriginVideoBean {
                    public static class UrlListBeanXXXXX {
                    }
                }

                public static class NeihanHotLinkBean {
                }

                public static class DislikeReasonBean {
                    /**
                     * type : 2
                     * id : 59
                     * title : 吧:突然觉得哪里不对
                     */

                    private int type;
                    private int id;
                    private String title;

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }
            }

        }
    }
}
