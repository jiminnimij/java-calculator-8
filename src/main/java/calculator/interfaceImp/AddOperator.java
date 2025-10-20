package calculator.interfaceImp;

import calculator.calculatorInterface.Operator;

public class AddOperator implements Operator {
    @Override
    public int operate(String[] tokens) {
        int result = 0;
        for (String t : tokens) {
            result += Integer.parseInt(t);
        }

        if(result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("정수 범위 초과");
        }

        return result;
    }
}
