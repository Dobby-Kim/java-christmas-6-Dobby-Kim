package christmas.util;

import christmas.enums.EventBadge;

import java.util.Arrays;

public class BadgeCalculatorUtil {

    public static EventBadge calculateEventBadge(int totalDiscountAmount) {
        return Arrays.stream(EventBadge.values())
                .filter(badge -> totalDiscountAmount >= badge.getBadgeStandard())
                .findFirst()
                .orElse(EventBadge.NONE);
    }
}
