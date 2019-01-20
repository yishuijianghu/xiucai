package goods.house.test.domain.controller.client;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lvxiucai
 * @CreateDate: 2019/1/20$ 18:42$
 */
@Data
public class SubmitInfoRequest implements Serializable{

    private String name;
    private String email;
    private String message;
    private String number;


}
