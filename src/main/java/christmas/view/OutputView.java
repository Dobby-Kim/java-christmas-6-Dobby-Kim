package christmas.view;

import christmas.dto.OrderDTO;
import christmas.dto.OrderDetailsDTO;
import christmas.enums.EventBadge;
import christmas.model.Date;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final DecimalFormat currencyFormat = new DecimalFormat("#,###");

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printParseLine() {
        System.out.println();
    }

    public static void printOrderDetails(OrderDetailsDTO details) {
        printIntroduction(details.getDate());
        printOrders(details.getOrderDTOs());
        printTotalAmountBeforeDiscount(details.getTotalAmount());
        printGift(details.isChampagneGiftIncluded());
        printDiscountDetails(details.getDiscountDetails());
        printTotalBenefitAmount(details.getTotalBenefit());
        printFinalAmount(details.getFinalAmount());
        printEventBadge(details.getEventBadge());
    }

    private static void printIntroduction(Date date) {
        printMessage(OutputMessage.INTRODUCTION_PREFIX + date.getDay() + OutputMessage.INTRODUCTION_SUFFIX);
        printParseLine();
    }

    private static void printOrders(List<OrderDTO> orderDTOs) {
        printMessage(OutputMessage.ORDER_HEADER);
        for (OrderDTO order : orderDTOs) {
            printMessage(order.getMenuName() + " " + order.getQuantity() + OutputMessage.COUNT_UNIT);
        }
        printParseLine();
    }

    private static void printTotalAmountBeforeDiscount(int totalAmount) {
        printMessage(OutputMessage.TOTAL_AMOUNT_BEFORE_DISCOUNT);
        printMessage(formatCurrency(totalAmount) + OutputMessage.WON_UNIT);
        printParseLine();
    }

    private static void printGift(boolean isChampagneGiftIncluded) {
        printMessage(OutputMessage.GIFT_HEADER);
        if (isChampagneGiftIncluded) {
            printMessage(OutputMessage.CHAMPAGNE_GIFT);
        } else {
            printMessage(OutputMessage.NO_GIFT);
        }
        printParseLine();
    }

    private static void printDiscountDetails(Map<String, Integer> discountDetails) {
        printMessage(OutputMessage.DISCOUNT_DETAILS_HEADER);
        boolean isDiscountNone = true;
        for (Map.Entry<String, Integer> entry : discountDetails.entrySet()) {
            if (entry.getValue() != 0) {
                printMessage(entry.getKey() + ": " + formatCurrency(-1 * entry.getValue()) + OutputMessage.WON_UNIT);
                isDiscountNone = false;
            }
        }
        if (isDiscountNone) {
            printMessage(OutputMessage.NO_DISCOUNT);
        }
        printParseLine();
    }

    private static void printTotalBenefitAmount(int totalDiscount) {
        printMessage(OutputMessage.TOTAL_BENEFIT_AMOUNT);
        printMessage(formatCurrency(-1 * totalDiscount) + OutputMessage.WON_UNIT);
        printParseLine();
    }

    private static void printFinalAmount(int finalAmount) {
        printMessage(OutputMessage.FINAL_AMOUNT);
        printMessage(formatCurrency(finalAmount) + OutputMessage.WON_UNIT);
        printParseLine();
    }

    private static void printEventBadge(EventBadge eventBadge) {
        printMessage(OutputMessage.EVENT_BADGE_HEADER);
        printMessage(eventBadge.getBadgeName());
        printParseLine();
    }

    private static String formatCurrency(int amount) {
        return currencyFormat.format(amount);
    }
}
