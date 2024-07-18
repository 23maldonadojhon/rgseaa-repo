package es.aesan.rgseaa.rest.advice;


import es.aesan.rgseaa.model.commom.dto.ErrorDto;
import es.aesan.rgseaa.model.util.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);


    @ExceptionHandler({AppException.class})
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        return processException(ErrorDto.createAppError(ex), ex, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<ErrorDto> processException(final ErrorDto dto, Exception ex, HttpStatus status) {
        logger.error("Error {0}", ex);
        return ResponseEntity.status(status).body(dto);
    }
}
