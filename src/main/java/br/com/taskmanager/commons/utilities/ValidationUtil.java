package br.com.taskmanager.commons.utilities;

import java.util.List;

public class ValidationUtil {

    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNumberInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
