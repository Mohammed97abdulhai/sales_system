package application.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorsResponse {
    public Map<String, List<String>> errors = new HashMap<>();

    public static ErrorsResponse of(BindingResult error) {
        ErrorsResponse errorsResponse = new ErrorsResponse();

        if (error.hasGlobalErrors())
            errorsResponse.addError("global_error", error.getGlobalError().getDefaultMessage());

        if (error.hasFieldErrors())
            errorsResponse.getFieldError(error);
        return errorsResponse;
    }

    public static ErrorsResponse of(String message) {
        ErrorsResponse errorsResponse = new ErrorsResponse();
        errorsResponse.addError("global_error", message);
        return errorsResponse;
    }

    private void getFieldError(BindingResult error) {
        for (FieldError e : error.getFieldErrors())
            addError(e.getField(), e.getDefaultMessage());
    }

    private void addError(String name, String message) {
        errors.computeIfAbsent(toSnakeCase(name), s -> new ArrayList<>()).add(message);
    }

    private String toSnakeCase(String name) {
        return name.replaceAll("([A-Z])", "_$1").toLowerCase();
    }

    public Object toMap() {
        HashMap<Object, Object> model = new HashMap<>();
        model.put("errors", this);
        return model;
    }

    public static class Field {
        public String name;
        public String message;
    }
}
