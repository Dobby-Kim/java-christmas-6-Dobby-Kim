package christmas;

public class DateService {
    private static Date createDate(int day) {
        return new Date(day);
    }

    public static Date readUserDateInputAndCreateDate() {
        int day = InputView.readDate();
        return createDate(day);
    }
}
