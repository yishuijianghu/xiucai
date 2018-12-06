package goods.house.test.common.constant;

/**
 * @Auther: lvlj
 * @Date: 2018/12/6/0006 16:42
 * @Description:
 */
public enum GoodsHousError {
    SYSTEM_ERROR(1001,"系统错误");

    private Integer code;
    private String mes;

    GoodsHousError() {
    }

    GoodsHousError(Integer code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
