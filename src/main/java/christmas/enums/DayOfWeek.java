package christmas.enums;

import christmas.util.Constant;

import java.util.Arrays;

public enum DayOfWeek {
    FRI(1, true, false),
    SAT(2, true, false),
    SUN(3, false, true),
    MON(4, false, false),
    TUE(5, false, false),
    WED(6, false, false),
    THU(7, false, false);

    private static final int DAYS_OF_WEEK = 7;

    private static final int INDEX_FORMATTER = 1;
    private final int dayValue;
    private final boolean weekend;
    private final boolean specialEvent;

    DayOfWeek(int dayValue, boolean weekend, boolean specialEvent) {
        this.dayValue = dayValue;
        this.weekend = weekend;
        this.specialEvent = specialEvent;
    }

    public static DayOfWeek calculateDayOfWeek(int day) {
        int index = (day - INDEX_FORMATTER) % DAYS_OF_WEEK; // 1부터 시작하므로 day - 1
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.dayValue == index + INDEX_FORMATTER)
                .findFirst()
                .orElse(null);
    }

    public boolean isWeekend() {
        return weekend;
    }

    public boolean isSpecialEvent() {
        if (dayValue == Constant.CHRISTMAS_DATE) {
            return true;
        }
        return specialEvent;
    }
}

