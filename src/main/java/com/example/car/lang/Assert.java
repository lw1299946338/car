package com.example.car.lang;

import com.example.car.enums.ResErrMessageEnum;
import com.example.car.expection.BaseException;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 断言类不符合条件的抛出BaseException 入参带断言对象、errMessage
 * @author liwei
 * @date 2019/3/8 2:09 PM
 */
public abstract class Assert {


    /**
     * 断言入参是否为false,
     * 入参是false则抛出BaseException
     * @param expression a boolean expression
     * @param message the exception message to use if the assertion fails
     * @throws BaseException if {@code expression} is {@code false}
     */
    public static void isTrue(boolean expression,String code, String message) {
        if (!expression) {
            throw new BaseException(code,message);
        }
    }

    /**
     * 断言入参是否为false,
     * 入参是false则抛出BaseException
     * @param expression a boolean expression
     * @param errMessage the exception message to use if the assertion fails
     * @throws BaseException if {@code expression} is {@code false}
     */
    public static void isTrue(boolean expression, ResErrMessageEnum errMessage) {
        isTrue(expression,errMessage.getCode(),errMessage.getMessage());
    }

    /**
     * 不为空则抛出异常
     * */
    public static void isNull(@Nullable Object object, String code, String message) {
        if (object != null) {
            throw new BaseException(code,message,object);
        }
    }

    /**
     * 不为空则抛出异常
     * */
    public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
    }

    /**
     * 不为空则抛出异常
     * */
    public static void isNull(@Nullable Object object, ResErrMessageEnum errMessage) {
        isNull(object,errMessage.getCode(),errMessage.getMessage());
    }

    /**
     * 为空则抛出异常
     * */
    public static void notNull(@Nullable Object object, String code, String message) {
        if (object == null) {
            throw new BaseException(code,message,object);
        }
    }

    /**
     * 为空则抛出异常
     * */
    public static void notNull(@Nullable Object object, ResErrMessageEnum errMessage) {
        notNull(object,errMessage.getCode(),errMessage.getMessage());
    }

    /**
     * 字符串为空或长度为0则抛出异常
     * */
    public static void notEmpty(@Nullable String object, ResErrMessageEnum errMessage) {
        notEmpty(object,errMessage.getCode(),errMessage.getMessage());
    }

    /**
     * 字符串为空或长度为0则抛出异常
     * */
    public static void notEmpty(@Nullable String object, String code, String message) {
        if (object == null || object.isEmpty()) {
            throw new BaseException(code,message,object);
        }
    }

    /**
     * 集合为空或长度为0则抛出异常
     * */
    public static void notEmpty(@Nullable List<?> object, String code, String message) {
        if (object == null || object.isEmpty()) {
            throw new BaseException(code,message,object);
        }
    }

    /**
     * 集合为空或长度为0则抛出异常
     * */
    public static void notEmpty(@Nullable List<?> object, ResErrMessageEnum errMessage) {
        notEmpty(object,errMessage.getCode(),errMessage.getMessage());
    }

    /**
     * 集合为空或长度为0则抛出异常
     * */
    public static void notEmpty(@Nullable Map<?,?> object, String code, String message) {
        if (object == null || object.isEmpty()) {
            throw new BaseException(code,message,object);
        }
    }

    /**
     * 集合为空或长度为0则抛出异常
     * */
    public static void notEmpty(@Nullable Map<?,?> object, ResErrMessageEnum errMessage) {
        notEmpty(object,errMessage.getCode(),errMessage.getMessage());
    }


    private static void instanceCheckFailed(Class<?> type, @Nullable Object obj, @Nullable String msg) {
        String className = (obj != null ? obj.getClass().getName() : "null");
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.hasLength(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            }
            else {
                result = messageWithTypeName(msg, className);
                defaultMessage = false;
            }
        }
        if (defaultMessage) {
            result = result + ("Object of class [" + className + "] must be an instance of " + type);
        }
        throw new IllegalArgumentException(result);
    }

    private static void assignableCheckFailed(Class<?> superType, @Nullable Class<?> subType, @Nullable String msg) {
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.hasLength(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            }
            else {
                result = messageWithTypeName(msg, subType);
                defaultMessage = false;
            }
        }
        if (defaultMessage) {
            result = result + (subType + " is not assignable to " + superType);
        }
        throw new IllegalArgumentException(result);
    }

    private static boolean endsWithSeparator(String msg) {
        return (msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith("."));
    }

    private static String messageWithTypeName(String msg, @Nullable Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }

    @Nullable
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
