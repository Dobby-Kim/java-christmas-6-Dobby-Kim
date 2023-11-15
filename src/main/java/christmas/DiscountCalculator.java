package christmas;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {

    public static Map<String, Integer> calculateDiscounts(Date date, Orders orders) {
        Map<String, Integer> discounts = new HashMap<>();
        if (isChampagneGift(orders.calculateTotalAmount())) {
            discounts.put("증정 이벤트", 25_000);
        }
        discounts.put("크리스마스 디데이 할인", calculateDdayDiscount(date));
        discounts.put("평일 할인", calculateWeekdayDiscount(date, orders));
        discounts.put("주말 할인", calculateWeekendDiscount(date, orders));
        discounts.put("특별 할인", calculateSpecialDiscount(date));

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
