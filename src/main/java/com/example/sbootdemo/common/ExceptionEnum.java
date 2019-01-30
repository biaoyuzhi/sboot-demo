package com.example.sbootdemo.common;

/**
 * 异常枚举样例，以30起头
 */
public enum ExceptionEnum {
    /**
     * oss
     */
    UPLOAD_FAIL("oss上传图片失败", 3001),
    /**
     * sts获取临时token失败
     */
    GET_STS_TOKEN_FAIL("获取token异常",3002),

    /**
     * sms
     */
    CELL_NUM_FORMAT_ERROR("手机号码格式错误!", 3003),
    CONTENT_NULL("发送内容不能为空!", 3004),
    SEND_TOO_OFTEN("发送短信过于频繁，请稍后重试!", 3005),
    SEND_FAIL("短信发送失败!", 3006);
    private String msg;
    private int code;
    ExceptionEnum(String msg, int index) {
        this.msg = msg;
        this.code = index;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode(){
        return code;
    }
}
