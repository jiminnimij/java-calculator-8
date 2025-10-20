package calculator.unit;

import calculator.calculatorInterface.DelimeterPolicy;
import calculator.calculatorInterface.Operator;
import calculator.calculatorInterface.TokenValidator;
import calculator.Parsed;

public class CalculatorUnit {
    private final DelimeterPolicy delimeterPolicy;
    private final TokenValidator tokenValidator;
    private final Operator operator;

    public CalculatorUnit(DelimeterPolicy delimeterPolicy, TokenValidator tokenValidator, Operator operator) {
        this.delimeterPolicy = delimeterPolicy;
        this.tokenValidator = tokenValidator;
        this.operator = operator;
    }

    public int calculate(String input) {
        Parsed parsedInput = parse(input);

        if (parsedInput.values().isEmpty()) {
            return 0;
        }

        String[] values = splitValues(parsedInput);
        validate(values);
        return add(values);
    }

    private Parsed parse(String input) {
        return delimeterPolicy.parse(input);
    }

    private String[] splitValues(Parsed parsed) {
        return parsed.splitValues();
    }

    private void validate(String[] values) {
        tokenValidator.validate(values);
    }

    private int add(String[] values) {
        return operator.operate(values);
    }
}
