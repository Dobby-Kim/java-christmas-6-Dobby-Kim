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

    private OrderDetailsDTO processOrders(Date date, Orders orders) {
        int totalAmount = orders.calculateTotalAmount();
        Map<String, Integer> discounts = calculateDiscounts(date, orders);
        boolean isChampagneGift = isChampagneGift(totalAmount);
        int totalBenefit = calculateTotalBenefit(discounts);
        int totalDiscount = calculateTotalDiscount(discounts);
        EventBadge eventBadge = calculateEventBadge(totalBenefit);
        List<OrderDTO> orderDTOs = createOrderDTOs(orders);

        return new OrderDetailsDTO(
                date, orderDTOs, discounts, totalAmount, totalDiscount, totalBenefit, eventBadge, isChampagneGift
        );
    }

    private Map<String, Integer> calculateDiscounts(Date date, Orders orders) {
        return DiscountCalculator.calculateDiscounts(date, orders);
    }

    private boolean isChampagneGift(int totalAmount) {
        return DiscountCalculator.isChampagneGift(totalAmount);
    }

    private int calculateTotalBenefit(Map<String, Integer> discounts) {
        return DiscountCalculator.calculateTotalBenefit(discounts);
    }

    private int calculateTotalDiscount(Map<String, Integer> discounts) {
        return DiscountCalculator.calculateTotalDiscount(discounts);
    }

    private EventBadge calculateEventBadge(int totalBenefit) {
        return BadgeCalculator.calculateEventBadge(totalBenefit);
    }

    private List<OrderDTO> createOrderDTOs(Orders orders) {
        return orders.getOrders().stream()
                .map(order -> new OrderDTO(order.getMenu().getName(), order.getQuantity()))
                .toList();
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
