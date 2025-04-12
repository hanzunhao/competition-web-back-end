package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Result", description = "标准API响应格式")
public class Result {
    //响应码，1成功，0失败
    private Integer code;
    //提示信息
    private String msg;
    //返回的数据
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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


    //若干用于快速构建Result对象的静态方法
    public static Result success(Object data) {
        return new Result(1, "success", data);//传递响应数据
    }

    public static Result success() {
        return new Result(1, "success", null);//仅传递成功标识
    }

    public static Result error(String msg) {
        return new Result(0, msg, null);//传递失败标识
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
