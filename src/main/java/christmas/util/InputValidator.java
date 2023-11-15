package christmas.util;

import christmas.enums.Menu;
import christmas.view.ErrorMessage;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateDateInput(String date) {
        if (isValidNumberInput(date)) {
            throw new IllegalArgumentException(ErrorMessage.formatErrorMessage(Constant.DATE));
        }
        if (!isValidDateInput(date)) {
            throw new IllegalArgumentException(ErrorMessage.formatErrorMessage(Constant.DATE));
        }
    }

    public static void validateOrderInputs(String[] orderInputs) {
        Set<String> menuSet = new HashSet<>();

        for (String input : orderInputs) {
            String[] parts = input.trim().split(Constant.MENU_AMOUNT_PARSER);
            if (parts.length != 2 || !isValidMenu(parts[0].trim()) || isValidNumberInput(parts[1].trim())) {
                throw new IllegalArgumentException(ErrorMessage.formatErrorMessage(Constant.ORDER));
            }
            if (!menuSet.add(parts[0].trim())) {
                throw new IllegalArgumentException(ErrorMessage.formatErrorMessage(Constant.ORDER));
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
            return quantity < Constant.MIN_TOTAL_AMOUNT;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isValidDateInput(String quantityStr) {
        int quantity = Integer.parseInt(quantityStr);
        return Constant.MIN_DATE <= quantity && quantity <= Constant.MAX_DATE;
    }
}
