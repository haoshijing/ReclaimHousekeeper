package com.duyun.huishou.housekeeper.exception;

import com.duyun.huishou.housekeeper.constants.RetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {
    private Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);


    /**
     * 业务级异常的捕获
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ApplicationException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ExceptionOutput applicationErrorHandler(ApplicationException e) throws Exception {
        e.printStackTrace();
        LOGGER.error("异常信息为：{}", e.getMessage());
        return new ExceptionOutput(e.getErrorId(), e.getMessage());
    }


    /**
     * get请求参数的验证
     *
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExceptionOutput errorResponse(MissingServletRequestParameterException e) {
        e.printStackTrace();
        LOGGER.warn("异常信息为：{}", e.getMessage());
        return new ExceptionOutput(RetCode.ERROR_PARAMS, "get参数校验失败！");
    }

    /**
     * post请求参数的验证 表单提交校验时会报这个错
     *
     * @return 返回具体vo注解上的message
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExceptionOutput errorResponse(BindException e) {
        e.printStackTrace();
        LOGGER.warn("异常信息为：{}", e.getMessage());
        return new ExceptionOutput(RetCode.ERROR_PARAMS, "post form提交参数校验失败！");
    }

    /**
     * post请求参数的验证 json方式提交校验时会报这个错
     *
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExceptionOutput errorResponse(MethodArgumentNotValidException e) {
        e.printStackTrace();
        LOGGER.warn("异常信息为：{}", e.getMessage());
        return new ExceptionOutput(RetCode.ERROR_PARAMS, "post json提交参数校验失败！");
    }

    /**
     * exception 异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExceptionOutput errorResponse(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return new ExceptionOutput(RetCode.SERVICE_ERROR, "服务器内部异常，请稍后再试！");
    }

}