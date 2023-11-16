package christmas;

import christmas.enums.Menu;
import christmas.model.Date;
import christmas.model.Order;
import christmas.model.Orders;
import christmas.util.DiscountUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DiscountUtilTest {

    @Test
    void testCalculateDiscounts() {
        Date date = new Date(25);
        List<Order> orders = new ArrayList<>();

        Menu menu1 = Menu.fromString("바비큐립");
        int quantity1 = 3;
        Menu menu2 = Menu.fromString("아이스크림");
        int quantity2 = 2;

        orders.add(new Order(menu1, quantity1));
        orders.add(new Order(menu2, quantity2));

        Orders testOrders = new Orders(orders);
        Map<String, Integer> discounts = DiscountUtil.calculateDiscounts(date, testOrders);
        assertNotNull(discounts);
        assertTrue(discounts.containsKey("크리스마스 디데이 할인"));
        assertTrue(discounts.containsKey("평일 할인") || discounts.containsKey("주말 할인"));
        assertTrue(discounts.containsKey("특별 할인"));
        if (DiscountUtil.isChampagneGift(testOrders.calculateTotalAmount())) {
            assertTrue(discounts.containsKey("증정 이벤트"));
        }
    }

    @Test
    void testCalculateTotalBenefit() {
        Map<String, Integer> discounts = Map.of(
                "할인1", 1000,
                "할인2", 2000,
                "증정 이벤트", 25000
        );

        int totalBenefit = DiscountUtil.calculateTotalBenefit(discounts);
        assertEquals(28000, totalBenefit);
    }

    @Test
    void testCalculateTotalDiscount() {
        Map<String, Integer> discounts = Map.of(
                "할인1", 1000,
                "할인2", 2000,
                "증정 이벤트", 25000
        );

        int totalDiscount = DiscountUtil.calculateTotalDiscount(discounts);
        assertEquals(3000, totalDiscount);
    }

}
