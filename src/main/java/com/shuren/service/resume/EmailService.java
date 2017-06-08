package com.shuren.service.resume;

/**
 * Created by 董帮辉 on 2017-6-8.
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param sendTo 收件人邮箱地址
     * @param filePath 附件的磁盘路径
     * @return
     */
    Boolean SendAttachMail(String sendTo,String filePath);
}
