package christmas;

import java.util.Arrays;

public enum DayOfWeek {
    FRI(1, true, false),
    SAT(2, true, false),
    SUN(3, false, true),
    MON(4, false, false),
    TUE(5, false, false),
    WED(6, false, false),
    THU(7, false, false);

    private final int dayValue;
    private final boolean weekend;
    private final boolean specialEvent;

    DayOfWeek(int dayValue, boolean weekend, boolean specialEvent) {
        this.dayValue = dayValue;
        this.weekend = weekend;
        this.specialEvent = specialEvent;
    }

    public static DayOfWeek calculateDayOfWeek(int day) {
        int index = (day - 1) % 7; // 1부터 시작하므로 day - 1
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.dayValue == index + 1)
                .findFirst()
                .orElse(null);
    }

    public boolean isWeekend() {
        return weekend;
    }

    public boolean isSpecialEvent() {
        if (dayValue == 25) {
            return true;
        }
        return specialEvent;
    }
}

