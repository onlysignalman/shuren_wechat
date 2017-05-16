package com.shuren.wechat.bean.message;

/**
 * 董帮辉 2017-3-10
 * 视频消息
 */
public class VideoMessage extends BaseMessage {

    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
