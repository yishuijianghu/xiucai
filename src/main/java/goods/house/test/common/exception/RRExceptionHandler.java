package goods.house.test.common.exception;

import goods.house.test.common.YiShuiError;
import goods.house.test.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public R handleRRException(RRException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	/**
	 *处理参数类型匹配错误
	 *@author yanglizhong
	 *@create 2017/11/30 10:23
	 */
	/*@ExceptionHandler({NumberFormatException.class,InvalidFormatException.class,MethodArgumentTypeMismatchException.class})
	public R handleNumberFormatException(RRException e){
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.INVALID_REQUEST_PARAMETER.getCode()
				,JuBanErrorCode.INVALID_REQUEST_PARAMETER.getMessage());
	}*/
	/**
	*处理参数类型匹配错误
	*@author yanglizhong
	*@create 2017/11/30 10:23
	*/
	/*@ExceptionHandler({MissingServletRequestParameterException.class})
	public R handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.MISSING_SERVLET_REQUEST_PARAMETER.getCode()
				,JuBanErrorCode.MISSING_SERVLET_REQUEST_PARAMETER.getMessage());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public R handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED.getCode()
				,JuBanErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED.getMessage());
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.DUPLICATE_KEY.getCode()
				,JuBanErrorCode.DUPLICATE_KEY.getMessage());
	}

	@ExceptionHandler(AuthorizationException.class)
	public R handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.AUTHORIZATION.getCode()
				,JuBanErrorCode.AUTHORIZATION.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	public R handleRuntimeException(RuntimeException e) {
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.TASK_NO_SUCH_TASK.getCode(),JuBanErrorCode.TASK_NO_SUCH_TASK.getMessage());
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public R handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
		logger.error(e.getMessage());
		return R.error(JuBanErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getCode()
		,JuBanErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED.getMessage());
	}*/

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		logger.error(e.getMessage(), e);
		return R.error();
	}
}
