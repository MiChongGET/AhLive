package cn.buildworld.ahlive.bean;

/**
 * 作者：MiChong on 2017/7/12 0012 19:10
 * 邮箱：1564666023@qq.com
 */
public class Data {
    private String temp;
    private String hum;
    private String time;


    public Data(String temp, String hum, String time) {
        this.temp = temp;
        this.hum = hum;
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
