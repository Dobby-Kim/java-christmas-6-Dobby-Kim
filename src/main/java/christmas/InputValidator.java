package christmas;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateDateInput(String date) {
        if (!isValidNumberInput(date)) {
            throw new IllegalArgumentException(ErrorMessage.formatErrorMessage("날짜"));
        }
        if (!isValidDateInput(date)) {
            throw new IllegalArgumentException(ErrorMessage.formatErrorMessage("날짜"));
        }
    }

    public static void validateOrderInputs(String[] orderInputs) {
        Set<String> menuSet = new HashSet<>();

        for (String input : orderInputs) {
            String[] parts = input.trim().split("-");
            if (parts.length != 2 || !isValidMenu(parts[0].trim()) || !isValidNumberInput(parts[1].trim())) {
                throw new IllegalArgumentException(ErrorMessage.formatErrorMessage("주문"));
            }
            if (!menuSet.add(parts[0].trim())) {
                throw new IllegalArgumentException(ErrorMessage.formatErrorMessage("주문"));
            }
        }
    }

    private static boolean isValidMenu(String menuName) {
        // 메뉴판에 있는 메뉴인지 검증
        try {
            Menu.fromString(menuName);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean isValidNumberInput(String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            return quantity >= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidDateInput(String quantityStr) {
        int quantity = Integer.parseInt(quantityStr);
        return 1 <= quantity && quantity <= 31;
    }
}
