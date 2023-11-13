package christmas;

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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
