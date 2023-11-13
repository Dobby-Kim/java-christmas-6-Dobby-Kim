package christmas;

import java.util.Arrays;

public enum DayOfWeek {
    FRI(1),
    SAT(2),
    SUN(3),
    MON(4),
    TUE(5),
    WED(6),
    THU(7);

    private final int dayValue;

    DayOfWeek(int dayValue) {
        this.dayValue = dayValue;
    }

    public static DayOfWeek calculateDayOfWeek(int day) {
        int index = (day - 1) % 7; // 1부터 시작하므로 day - 1
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.dayValue == index + 1)
                .findFirst()
                .orElse(null);
    }
}

