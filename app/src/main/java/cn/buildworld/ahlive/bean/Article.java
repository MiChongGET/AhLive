package cn.buildworld.ahlive.bean;

/**
 * 作者：MiChong on 2017/7/16 0016 16:39
 * 邮箱：1564666023@qq.com
 */
public class Article {


    public DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * date : {"curr":"20170716","prev":"20170715","next":"20170717"}
         * author : 梁文道
         * title : 一代不如一代
         * digest : 人，固然一代不如一代；原来食物也是，我从未听过有哪一种食材被认为是今天好过以前的。虽然有些东西好像真的比从前美味，例如柳橙；老人却说它变得太
         * content : <p>人，固然一代不如一代；原来食物也是，我从未听过有哪一种食材被认为是今天好过以前的。虽然有些东西好像真的比从前美味，例如柳橙；老人却说它变得太甜没“橙味”。那么苹果呢？富士苹果难道不比“地厘蛇果”香甜吗？啊，它们根本是不同的品种；而且就算是富士苹果，如今大量生产的廉价版又怎及得上当年价比金箔的前辈呢？我一直怀疑这种传说，正如我不相信人的素质会日渐下降一样；直到我亲身体验到愈来愈多的实例，并且发现了合理的解释。</p><p>走一趟自助餐的海鲜桌，取几尾小海虾，拿两片烟熏三文鱼，你会发现它们真有点不对劲。怎么说呢？反正就是没有它们该有的“虾味”和“鱼味”。不是因为小时候尝到它们的机会不多，所以回忆中的味道要比现实好；而是获取这些鱼虾的方法变了。营养学家玛丽昂·内斯特莱（MarionNestle）主张，现在的三文鱼一定要彻底煮熟才能入口，而且绝对不能吃它的皮，因为它的油脂层充满了毒素。至于海虾，全世界最大出产国越南的海洋生物学家也提出了警告，当地的暖水海虾场已经造成了严重的污染，于是连它生产的虾也愈来愈有问题了。</p><p>这种污染不是一般的污染，它的来源是过度的化学饲料，海洋农场（shrimpfarming）的直接后果。我们太喜欢三文鱼，太喜欢小海虾，希望用最低的价钱就能得到无尽的享受，结果得到的不只是对人体有害的食品，甚至还是违反初衷的无味饲料（养人的饲料）。就以三文鱼来说吧，任何有经验的厨师都会告诉你野生三文与养殖三文的分别有多大，后者的肉质松散，油脂呈口水状，几乎不能叫做三文鱼。要是再加上营养学家的建议，皮不能吃，肉要煮熟，最后上桌的东西应该比不上罐头沙丁鱼。既然如此，我们何不干脆用沙丁鱼代替三文鱼呢？难怪今天在一般西餐厅吃鱼，烤沙丁总是比任何一种做法的三文多了一股鲜味。</p><p>另一种人们愈爱吃结果愈是难吃的食物就是鸡肉了。走地鸡的妙处人人都知，即使养鸡，现在的产品也完全不能和四十年前相提并论，尤其是美国鸡。1970年代的鸡场要花十个礼拜才能养大一只鸡，现在那种拥挤黑暗的工厂化环境只用四十天就能把一只刚孵化的小鸡变成一头大肉块了。专家还发明了新名词去形容现代鸡肉：“P.S.E”，意思是“pale，soft，exudative”，简单讲就是又惨白又“流”。肉味不足肉质绵软倒也罢了，这种鸡长得还像一个隆胸失败的怪兽，胸前总是肿大得不成比例，看起来很吓人。这是因为美国人出于健康的考虑，专吃所谓的“白肉”，才让鸡农养出了这么变态的鸡。吊诡的是，为了让这一大块白肉不至于味同嚼蜡，鸡场还会为它注射磷酸盐。所以美国人吃的“白肉”并没有真的令他们变得更健康。</p><p>鸡、虾和三文鱼，都只不过是现代食物生产体系的冰山一角，推动整个体系运转的力量，无非是我们的贪婪。一方面食欲放纵过度，另一方面则不断压低生产的成本。最后，农场和渔夫赚的钱不比以前多很多，我们则吞下了大量有害的疑似食物的食物。</p>
         * wc : 1184
         */

        /**
         date：日期
         curr：今日日期，yyyyMMdd 格式
         prev：昨日日期，yyyyMMdd 格式
         next：明日日期，yyyyMMdd 格式
         author：作者
         titile：标题
         digest：首段
         content：正文内容
         wc：???
         */

        /**
         * 特定某天一文

         url：https://interface.meiriyiwen.com/article/day?dev=1&date= + 日期

         url 示例：https://interface.meiriyiwen.com/article/day?dev=1&date=20170216



         随机一文

         url：https://interface.meiriyiwen.com/article/random?dev=1
         */

        private DateBean date;
        private String author;
        private String title;
        private String digest;
        private String content;
        private int wc;

        public DateBean getDate() {
            return date;
        }

        public void setDate(DateBean date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getWc() {
            return wc;
        }

        public void setWc(int wc) {
            this.wc = wc;
        }

        public static class DateBean {
            /**
             * curr : 20170716
             * prev : 20170715
             * next : 20170717
             */

            private String curr;
            private String prev;
            private String next;

            public String getCurr() {
                return curr;
            }

            public void setCurr(String curr) {
                this.curr = curr;
            }

            public String getPrev() {
                return prev;
            }

            public void setPrev(String prev) {
                this.prev = prev;
            }

            public String getNext() {
                return next;
            }

            public void setNext(String next) {
                this.next = next;
            }

            @Override
            public String toString() {
                return "DateBean{" +
                        "curr='" + curr + '\'' +
                        ", prev='" + prev + '\'' +
                        ", next='" + next + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "date=" + date +
                    ", author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", digest='" + digest + '\'' +
                    ", content='" + content + '\'' +
                    ", wc=" + wc +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Article{" +
                "data=" + data +
                '}';
    }
}
