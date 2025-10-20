package calculator.unit;

import calculator.calculatorInterface.DelimeterPolicy;
import calculator.calculatorInterface.TokenValidator;
import calculator.Parsed;

public class CalculatorUnit {
    private static DelimeterPolicy delimeterPolicy = null;

    public CalculatorUnit(DelimeterPolicy delimeterPolicy, TokenValidator tokenValidator) {
        this.delimeterPolicy = delimeterPolicy;
    }

    public static int calculate(String input) {
        return 0;
    }

    private static Parsed parse(String input) {
        return delimeterPolicy.parse(input);
    }

    private static String[] splitValues(Parsed parsed) {
        return null;
    }

    private static void validate(String[] values) {
    }

    private static int add(String[] values) {
        return 0;
    }
}
