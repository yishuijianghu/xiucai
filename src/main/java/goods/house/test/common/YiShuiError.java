package goods.house.test.common;

/**
 * @Description:
 * @Author: lvxiucai
 * @CreateDate: 2018/12/16$ 12:52$
 */
public enum YiShuiError {

    SYS_ERROR(1001,"系统错误");
    private Integer code;
    private String msg;

    YiShuiError(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
