package com.example.sbootdemo.common;

import lombok.Data;

/**
 * @author zhwu
 */
@Data
public class WuLiaoResponse {
    private int code;
    private String message;
    private Object data;

    public WuLiaoResponse() {
    }

    public Object getData() {
        return data;
    }

    void setData(Object data) {
        this.data = data;
    }

    public static WuLiaoResponse fail(String message) {
        return WuLiaoResponse.builder().code(400).message(message).build();
    }

    public static WuLiaoResponse success(Object data) {
        return WuLiaoResponse.builder().code(200).message("成功").data(data).build();
    }

    public static WuLiaoResponseBuilder builder() {
        return new WuLiaoResponseBuilder();
    }

    public static final class WuLiaoResponseBuilder {
        private int code;
        private String message;
        private Object data;

        private WuLiaoResponseBuilder() {
        }

        public WuLiaoResponseBuilder code(int code) {
            this.code = code;
            return this;
        }

        public WuLiaoResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public WuLiaoResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public WuLiaoResponse build() {
            WuLiaoResponse respBody = new WuLiaoResponse();
            respBody.code = this.code;
            respBody.message = this.message;
            respBody.setData(data);
            return respBody;
        }
    }

}
