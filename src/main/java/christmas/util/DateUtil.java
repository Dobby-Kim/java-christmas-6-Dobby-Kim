package christmas.util;

import christmas.model.Date;
import christmas.view.InputView;

public class DateUtil {
    private static Date createDate(int day) {
        return new Date(day);
    }

    public static Date readUserDateInputAndCreateDate() {
        int day = InputView.readDate();
        return createDate(day);
    }
}
