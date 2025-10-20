package calculator.interfaceImp;

import calculator.calculatorInterface.TokenValidator;

public class BasicTokenValidator implements TokenValidator {
    @Override
    public void validate(String[] tokens) {
        for (String t : tokens) {
            if (t.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력: 구분자 연속 사용 또는 마지막에 구분자 사용");
            }
            if (!t.matches("\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 값 포함: " + t);
            }
        }
    }
}
