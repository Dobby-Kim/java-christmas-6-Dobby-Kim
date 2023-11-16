package christmas;

import christmas.enums.EventBadge;
import christmas.util.BadgeCalculatorUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BadgeCalculatorUtilTest {

    @Test
    @DisplayName("할인 금액이 기준에 미달할 때: 배지 없음")
    void testCalculateEventBadgeNone() {
        int discountAmount = 1000; // 예시: 기준에 미달하는 할인 금액
        assertEquals(EventBadge.NONE, BadgeCalculatorUtil.calculateEventBadge(discountAmount));
    }

    @Test
    @DisplayName("할인 금액이 특정 배지 기준을 충족할 때: 스타 배지 반환")
    void testCalculateEventBadgeStar() {
        int discountAmount = 5000;
        assertEquals(EventBadge.STAR, BadgeCalculatorUtil.calculateEventBadge(discountAmount));
    }

    @Test
    @DisplayName("할인 금액이 특정 배지 기준을 충족할 때: 트리 배지 반환")
    void testCalculateEventBadgeTree() {
        int discountAmount = 10000;
        assertEquals(EventBadge.TREE, BadgeCalculatorUtil.calculateEventBadge(discountAmount));
    }

    @Test
    @DisplayName("할인 금액이 특정 배지 기준을 충족할 때: 산타 배지 반환")
    void testCalculateEventBadgeSanta() {
        int discountAmount = 20000;
        assertEquals(EventBadge.SANTA, BadgeCalculatorUtil.calculateEventBadge(discountAmount));
    }

}