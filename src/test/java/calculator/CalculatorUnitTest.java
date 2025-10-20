package calculator;

import calculator.unit.CalculatorUnit;

import calculator.calculatorInterface.DelimeterPolicy;
import calculator.calculatorInterface.Operator;
import calculator.calculatorInterface.TokenValidator;
import calculator.interfaceImp.AddOperator;
import calculator.interfaceImp.BasicTokenValidator;
import calculator.interfaceImp.DefaultDelimiterPolicy;
import calculator.unit.CalculatorUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorUnitTest {
    DelimeterPolicy delimiter = new DefaultDelimiterPolicy();
    TokenValidator validator = new BasicTokenValidator();
    Operator aggregator = new AddOperator();
    CalculatorUnit calculatorUnit = new CalculatorUnit(delimiter, validator, aggregator);

    @Test
    @DisplayName("빈 값이 입력된 경우 0을 반환한다.")
    void emptyInputReturnsZero() {
        assertEquals(0, calculatorUnit.calculate(""));
    }

    @Test
    @DisplayName("기본 연산자의 경우 쉼표와 콜론을 구분자로 사용한다.")
    void defaultDelimiters() {
        assertEquals(6, calculatorUnit.calculate("1,2:3"));
    }

    @Test
    @DisplayName("커스텀 연산자의 경우 //와 \\n를 사용해서 지정한다.")
    void customDelimiter() {
        assertEquals(3, calculatorUnit.calculate("//;\\n1;2"));
    }

    @Test
    @DisplayName("커스텀 연산자가 한글자의 문자가 아닌 경우 에러를 발생시킨다.")
    void invalidCustomDelimiter() {
        assertThrows(IllegalArgumentException.class, () -> calculatorUnit.calculate("//;;\\n1;2"));
    }

}

