package christmas.view;

public class ErrorMessage {

    public static final String ERROR_MESSAGE_FORMAT = "[ERROR] 유효하지 않은 {}입니다. 다시 입력해 주세요.";

    public static String formatErrorMessage(String errorType) {
        return ERROR_MESSAGE_FORMAT.replace("{}", errorType);
    }
}
