package christmas;

import christmas.enums.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeekTest {

    @Test
    @DisplayName("1~7일까지 요일 계산 검증")
    void testCalculateDayOfWeek() {
        assertEquals(DayOfWeek.FRI, DayOfWeek.calculateDayOfWeek(1));
        assertEquals(DayOfWeek.SAT, DayOfWeek.calculateDayOfWeek(2));
        assertEquals(DayOfWeek.SUN, DayOfWeek.calculateDayOfWeek(3));
        assertEquals(DayOfWeek.MON, DayOfWeek.calculateDayOfWeek(4));
        assertEquals(DayOfWeek.TUE, DayOfWeek.calculateDayOfWeek(5));
        assertEquals(DayOfWeek.WED, DayOfWeek.calculateDayOfWeek(6));
        assertEquals(DayOfWeek.THU, DayOfWeek.calculateDayOfWeek(7));
    }

    @Test
    @DisplayName("12월 2주차 요일 계산 검증")
    void testDayOfWeekCycle() {
        for (int i = 8; i <= 14; i++) {
            assertEquals(DayOfWeek.calculateDayOfWeek(i - 7), DayOfWeek.calculateDayOfWeek(i));
        }
    }
}