#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.exception;

import ${package}.model.exception.ItemNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Validation Failed");
        pd.setDetail("One or more fields are invalid.");
        pd.setType(URI.create("https://example.com/problems/validation-error"));
        pd.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(pd);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, HttpHeaders headers, WebRequest request) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle(ex.getMessage());
        pd.setDetail(String.join(",", ex.getErrors()));
        pd.setType(URI.create("https://example.com/problems/validation-error"));
        pd.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(pd);
    }
}
