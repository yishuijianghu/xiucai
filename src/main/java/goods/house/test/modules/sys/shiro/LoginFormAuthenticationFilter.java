package goods.house.test.modules.sys.shiro;

import com.alibaba.fastjson.JSON;
import goods.house.test.common.YiShuiError;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DongHan
 * @Description:
 * @Date: Created in 18:42 2017/11/25
 */
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        Subject subject = getSubject(request, response);
        String url = WebUtils.getPathWithinApplication(httpRequest);
        if (subject.getPrincipal() == null) {
            if (url.contains("index.html")) {
                saveRequestAndRedirectToLogin(request, response);
            } else {
                httpResponse.setCharacterEncoding("UTF-8");
                httpResponse.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                try {
                    out = httpResponse.getWriter();
                    map.put("code", YiShuiError.SYS_ERROR.getCode());
                    map.put("msg", YiShuiError.SYS_ERROR.getMsg());
                    out.append(JSON.toJSONString(map));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            }
        }
        return false;
    }
}
