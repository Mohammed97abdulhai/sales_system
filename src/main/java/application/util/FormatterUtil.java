package application.util;

import java.util.HashMap;

public class FormatterUtil {

    public static Object toMap(String name, Object value) {
        HashMap<Object, Object> model = new HashMap<>();
        model.put(name, value);
        return model;
    }
}
