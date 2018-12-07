package goods.house.test.common.constant;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 11:40
 * @Description:
 */
public enum CommonErrorEnum {
    PARAM_ERROR(1001,"参数错误");

    private int code;
    private String errorMsg;

    CommonErrorEnum(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
