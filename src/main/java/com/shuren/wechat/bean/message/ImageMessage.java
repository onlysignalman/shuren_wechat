package com.shuren.wechat.bean.message;

/**
 * 董帮辉 2017-3-10.
 * 图片消息
 */
public class ImageMessage extends BaseMessage {

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
