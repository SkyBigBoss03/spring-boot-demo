package com.chinasoft.springboot.demo.common;

public class Result {
    /**
     * 200 ok ;400 fail
     */
    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(Integer code, String message){
        this.code=code;
        this.message = message;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result ok(String message){
        return  new Result(200,message);
    }
    public static Result buildFail(String message){
        return  new Result(400,message);
    }
    public static Result ok(String message,Object data){
        return  new Result(200,message,data);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
