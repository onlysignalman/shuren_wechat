package com.shuren.wechat.bean.message;

/**
 * 董帮辉 2017-3-10.
 * 语音消息
 */
public class VoiceMessage extends BaseMessage {

    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
