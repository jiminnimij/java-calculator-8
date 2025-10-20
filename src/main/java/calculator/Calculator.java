package calculator;

import calculator.interfaceImp.DefaultDelimiterPolicy;
import calculator.interfaceImp.BasicTokenValidator;
import calculator.interfaceImp.AddOperator;

import calculator.calculatorInterface.DelimeterPolicy;
import calculator.calculatorInterface.TokenValidator;
import calculator.calculatorInterface.Operator;

import calculator.unit.CalculatorUnit;
import calculator.unit.InputUnit;
import calculator.unit.OutputUnit;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    DelimeterPolicy delimiter = new DefaultDelimiterPolicy();
    TokenValidator validator = new BasicTokenValidator();
    Operator aggregator = new AddOperator();
    CalculatorUnit calculatorUnit = new CalculatorUnit(delimiter, validator, aggregator);

    public void run() {
        // 입력
        String input = InputUnit.input();

        // 계산
        int result = calculatorUnit.calculate(input);

        // 출력
        OutputUnit.printResult(result);

    }







}
