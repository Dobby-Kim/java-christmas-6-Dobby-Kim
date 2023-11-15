package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public static int readDate() {
        OutputView.printMessage(UserMessage.INPUT_DATE_PROMPT);
        while (true) {
            try {
                String inputDate = Console.readLine().trim();
                InputValidator.validateDateInput(inputDate);
                return Integer.parseInt(inputDate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static String[] readOrderInputs() {
        OutputView.printMessage(UserMessage.INPUT_ORDER_PROMPT);
        while (true) {
            try {
                String[] orderInputs = Console.readLine().split(",");
                InputValidator.validateOrderInputs(orderInputs);
                return orderInputs;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
