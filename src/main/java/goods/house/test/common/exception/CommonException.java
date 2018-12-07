package goods.house.test.common.exception;

import lombok.Data;

/**
 * @Auther: lvlj
 * @Date: 2018/12/7/0007 11:28
 * @Description:
 */
@Data
public class CommonException extends RuntimeException {

    private Integer code;
    private String msg;

    public CommonException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String message, Integer code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String message, Throwable cause, Integer code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(Throwable cause, Integer code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }
}
