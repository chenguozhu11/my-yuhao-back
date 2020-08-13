package com.yuhao.core.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Map;


public class ResponseUtil {
    public enum ResponseRet {

        ERROR("0"), NORMAL("1"), WARN("-1"), NOLOGIN("-2");

        private String value;

        private ResponseRet(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return this.value;
        }
    }

    /**
     * 状态代码 全称：return code 1：成功, 0：错误,-1：警告（部分成功）,-2未登录
     */
    protected ResponseRet code;

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 返回数据
     */
    protected Object data = null;

    /**
     * 错误列表
     */
    protected List<Map<String, Object>> errList = null;


    public ResponseUtil(ResponseRet code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }


    public ResponseUtil(ResponseRet code, List<Map<String, Object>> errList) {
        super();
        this.code = code;
        this.errList = errList;
    }

    public ResponseUtil(ResponseRet code, String msg, Object obj) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public ResponseRet getCode() {
        return code;
    }

    public void setCode(ResponseRet code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Map<String, Object>> getErrList() {
        return errList;
    }

    public void setErrList(List<Map<String, Object>> errList) {
        this.errList = errList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
