package calculator;

import calculator.unit.CalculatorUnit;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {
    @DisplayName("빈 값이 입력된 경우 0을 반환한다.")
    void emptyInputReturnsZero() {
        assertEquals(0, CalculatorUnit.calculate(""));
    }

    @DisplayName("기본 연산자의 경우 쉼표와 콜론을 구분자로 사용한다.")
    void defaultDelimiters() {
        assertEquals(6, CalculatorUnit.calculate("1,2:3"));
    }

    @DisplayName("커스텀 연산자의 경우 //와 \\n를 사용해서 지정한다.")
    void customDelimiter() {
        assertEquals(3, CalculatorUnit.calculate("//;\\n1;2"));
    }

    @DisplayName("커스텀 연산자가 한글자의 문자가 아닌 경우 에러를 발생시킨다.")
    void invalidCustomDelimiter() {
        assertThrows(IllegalArgumentException.class, () -> CalculatorUnit.calculate("//;;\\n1;2"));
    }

}

