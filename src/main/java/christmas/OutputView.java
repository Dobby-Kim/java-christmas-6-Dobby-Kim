package christmas;

import java.util.List;
import java.util.Map;

public class OutputView {

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
        printMessage("12월 " + date.getDay() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printParseLine();
    }

    private static void printOrders(List<OrderDTO> orderDTOs) {
        printMessage("<주문 메뉴>");
        for (OrderDTO order : orderDTOs) {
            printMessage(order.getMenuName() + " " + order.getQuantity() + "개");
        }
        printParseLine();
    }

    private static void printTotalAmountBeforeDiscount(int totalAmount) {
        printMessage("<할인 전 총주문 금액>");
        printMessage(totalAmount + "원");
        printParseLine();

    }

    private static void printGift(boolean isChampagneGiftIncluded) {
        printMessage("<증정 메뉴>");
        if (isChampagneGiftIncluded) {
            printMessage("샴페인 1개");
        }
        if (!isChampagneGiftIncluded) {
            printMessage("없음");
        }
        printParseLine();

    }

    private static void printDiscountDetails(Map<String, Integer> discountDetails) {
        printMessage("<혜택 내역>");
        boolean isDiscountNone = true;
        for (Map.Entry<String, Integer> entry : discountDetails.entrySet()) {
            if (entry.getValue() != 0) {
                printMessage(entry.getKey() + ": " + -1 * entry.getValue() + "원");
                isDiscountNone = false;
            }
        }
        if (isDiscountNone) {
            printMessage("없음");
        }
        printParseLine();

    }

    private static void printTotalBenefitAmount(int totalDiscount) {
        printMessage("<총혜택 금액>");

        printMessage(-1 * totalDiscount + "원");
        printParseLine();
    }

    private static void printFinalAmount(int finalAmount) {
        printMessage("<할인 후 예상 결제 금액>");
        printMessage(finalAmount + "원");
        printParseLine();

    }

    private static void printEventBadge(EventBadge eventBadge) {
        printMessage("<12월 이벤트 배지>");
        printMessage(eventBadge.getBadgeName());
    }

}
