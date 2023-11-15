package christmas;

import christmas.enums.DayOfWeek;
import christmas.model.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    @DisplayName("유효한 날짜 검증")
    void testValidDate() {
        Date validDate = new Date(15);
        assertEquals(15, validDate.getDay());
        assertNotNull(validDate.getDayOfWeek());
    }

    @Test
    @DisplayName("유효하지 않은 날짜 검증")
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(32);
        });
    }

    @Test
    @DisplayName("요일 판별 검증")
    void testDayOfWeekCalculation() {
        Date date = new Date(1);
        assertEquals(DayOfWeek.calculateDayOfWeek(1), date.getDayOfWeek());
    }
}
