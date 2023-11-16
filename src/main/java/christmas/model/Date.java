package christmas.model;

import christmas.enums.DayOfWeek;
import christmas.util.Constant;
import christmas.view.ErrorMessage;

public class Date {
    private final int day;
    private final DayOfWeek dayOfWeek;

    public Date(int day) {
        dateValidator(day);
        this.day = day;
        this.dayOfWeek = DayOfWeek.calculateDayOfWeek(day);
    }

    private void dateValidator(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(ErrorMessage.formatErrorMessage(Constant.DATE));
        }
    }

    public int getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
