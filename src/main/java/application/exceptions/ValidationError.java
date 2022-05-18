package application.exceptions;

import application.util.ErrorsResponse;
import org.springframework.validation.BindingResult;

public class ValidationError extends RuntimeException{

    private BindingResult bindingResult;
    private String message;
    public ValidationError(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public ValidationError(String message) {
        this.message = message;
    }

    public ErrorsResponse getErrors() {
        return (bindingResult != null) ? ErrorsResponse.of(bindingResult) : ErrorsResponse.of(message);
    }

}
