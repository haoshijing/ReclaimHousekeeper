package com.duyun.huihsou.housekepper.admin.exception;


import com.duyun.huishou.housekeeper.constants.RetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationException extends RuntimeException {

    private Integer errorId;

    private Logger logger = LoggerFactory.getLogger(ApplicationException.class);


    public ApplicationException(String message) {
        super(message);
        this.errorId = RetCode.SERVICE_ERROR;
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.errorId = RetCode.SERVICE_ERROR;
        logger.error("### error ###:: " + message, cause);
    }

    public ApplicationException(Integer errorId, String message, Throwable cause) {
        super(message, cause);
        this.errorId = errorId;
    }

    public ApplicationException(Integer errorId) {
        this.errorId = errorId;
    }

    public Integer getErrorId() {
        return errorId;
    }

}