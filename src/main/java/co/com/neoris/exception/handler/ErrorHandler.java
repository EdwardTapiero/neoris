package co.com.neoris.exception.handler;

import co.com.neoris.exception.NeorisException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ErrorHandler {


    @ExceptionHandler(NeorisException.class)
    public ResponseEntity<ErrorResponse> cardlessWithdrawalException(NeorisException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ex.getCode().toString());
        errorResponse.setMessage(ex.getMessage());

        return ResponseEntity.status(ex.getCode()).body(errorResponse);
    }

}
