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
        Parsed parsedInput = delimeterPolicy.parse(input);

        if (parsedInput.values().isEmpty()) {
            return 0;
        }

        String[] values = parsedInput.splitValues();
        tokenValidator.validate(values);
        return operator.operate(values);
    }
}
