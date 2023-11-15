package christmas;

import java.util.Arrays;

public class BadgeCalculator {

    public static EventBadge calculateEventBadge(int totalDiscountAmount) {
        return Arrays.stream(EventBadge.values())
                .filter(badge -> totalDiscountAmount >= badge.getBadgeStandard())
                .findFirst()
                .orElse(EventBadge.NONE);
    }
}
