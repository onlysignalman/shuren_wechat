package com.shuren.resume.pojo;

/**
 * Created by dbh on 2017/5/17.
 * 语言能力
 */
public class LanguageCapacity {

    private Integer id;

    //用户Id
    private Integer userId;

    //语种
    private String language;

    //读写能力
    private String readAndWrite;

    //听说能力
    private String listenAndSpeak;

    //掌握的第几种语言
    private Integer index;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReadAndWrite() {
        return readAndWrite;
    }

    public void setReadAndWrite(String readAndWrite) {
        this.readAndWrite = readAndWrite;
    }

    public String getListenAndSpeak() {
        return listenAndSpeak;
    }

    public void setListenAndSpeak(String listenAndSpeak) {
        this.listenAndSpeak = listenAndSpeak;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
