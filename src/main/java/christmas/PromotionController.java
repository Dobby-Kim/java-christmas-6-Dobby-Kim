package christmas;

import java.util.List;
import java.util.Map;

public class PromotionController {


    private static boolean ordersValidator(Orders orders) {
        return !isOrdersHasInvalidAmount(orders) && !isOrdersHasOnlyBeverage(orders);
    }

    private static boolean isOrdersHasInvalidAmount(Orders orders) {
        return orders.calculateTotalQuantity() > 20;
    }

    private static boolean isOrdersHasOnlyBeverage(Orders orders) {
        return orders.getOrders().stream()
                .allMatch(order -> order.getMenu().getCategory() == MenuCategory.BEVERAGE);
    }

    private static OrderDetailsDTO processOrders(Date date, Orders orders) {
        int totalAmount = orders.calculateTotalAmount();
        Map<String, Integer> discounts = DiscountCalculator.calculateDiscounts(date, orders);
        boolean isChampagneGift = DiscountCalculator.isChampagneGift(totalAmount);
        int totalBenefit = DiscountCalculator.calculateTotalBenefit(discounts);
        int totalDiscount = DiscountCalculator.calculateTotalDiscount(discounts);
        EventBadge eventBadge = BadgeCalculator.calculateEventBadge(totalBenefit);
        List<OrderDTO> orderDTOs = orders.getOrders().stream()
                .map(order -> new OrderDTO(order.getMenu().getName(), order.getQuantity())).toList();

        return new OrderDetailsDTO(
                date, orderDTOs, discounts, totalAmount, totalDiscount, totalBenefit, eventBadge, isChampagneGift
        );
    }

    public void run() {
        boolean isValidOrder = false;
        Date date = DateService.readUserDateInputAndCreateDate();
        Orders orders = null;
        while (!isValidOrder) {
            orders = OrderService.readUserInputAndCreateOrders();
            isValidOrder = ordersValidator(orders);
            if (!isValidOrder) {
                OutputView.printMessage(ErrorMessage.formatErrorMessage("주문"));
            }
        }
        OrderDetailsDTO eventDetails = processOrders(date, orders);
        OutputView.printOrderDetails(eventDetails);
    }


}
