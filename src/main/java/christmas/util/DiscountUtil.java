package christmas.util;

import christmas.enums.DayOfWeek;
import christmas.enums.MenuCategory;
import christmas.model.Date;
import christmas.model.Orders;

import java.util.HashMap;
import java.util.Map;

public class DiscountUtil {
    private static final String CHRISTMAS_D_DAY_DISCOUNT = "크리스마스 디데이 할인";
    private static final String WEEKDAY_DISCOUNT = "평일 할인";
    private static final String WEEKEND_DISCOUNT = "주말 할인";
    private static final String SPECIAL_DISCOUNT = "특별 할인";
    private static final String GIFT_EVENT = "증정 이벤트";

    public static Map<String, Integer> calculateDiscounts(Date date, Orders orders) {
        Map<String, Integer> discounts = new HashMap<>();
        if (isChampagneGift(orders.calculateTotalAmount())) {
            discounts.put(GIFT_EVENT, 25_000);
        }
        discounts.put(CHRISTMAS_D_DAY_DISCOUNT, calculateDdayDiscount(date));
        discounts.put(WEEKDAY_DISCOUNT, calculateWeekdayDiscount(date, orders));
        discounts.put(WEEKEND_DISCOUNT, calculateWeekendDiscount(date, orders));
        discounts.put(SPECIAL_DISCOUNT, calculateSpecialDiscount(date));

        return discounts;
    }

    public static int calculateTotalBenefit(Map<String, Integer> discounts) {
        return discounts.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int calculateTotalDiscount(Map<String, Integer> discounts) {
        return discounts.entrySet().stream()
                .filter(entry -> !entry.getKey().equals("증정 이벤트"))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    private static int calculateDdayDiscount(Date date) {
        if (date.getDay() <= 25) {
            return 1000 + (date.getDay() - 1) * 100;
        }
        return 0;
    }

    private static int calculateWeekdayDiscount(Date date, Orders orders) {
        if (!DayOfWeek.calculateDayOfWeek(date.getDay()).isWeekend()) {
            return (int) orders.getOrders().stream()
                    .filter(order -> order.getMenu().getCategory() == MenuCategory.DESSERT)
                    .mapToInt(order -> order.getQuantity() * 2023)
                    .sum();
        }
        return 0;
    }

    private static int calculateWeekendDiscount(Date date, Orders orders) {
        if (DayOfWeek.calculateDayOfWeek(date.getDay()).isWeekend()) {
            return (int) orders.getOrders().stream()
                    .filter(order -> order.getMenu().getCategory() == MenuCategory.MAIN)
                    .mapToInt(order -> order.getQuantity() * 2023)
                    .sum();
        }
        return 0;
    }

    private static int calculateSpecialDiscount(Date date) {
        if (date.getDayOfWeek().isSpecialEvent()) {
            return 1000;
        }
        return 0;
    }

    public static boolean isChampagneGift(int totalAmount) {
        return totalAmount >= 120_000;
    }
}
