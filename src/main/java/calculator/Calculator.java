package calculator;

import calculator.unit.CalculatorUnit;
import calculator.unit.InputUnit;
import calculator.unit.OutputUnit;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public void run() {
        // 입력
        String input = InputUnit.input();

        // 계산
        int sum = CalculatorUnit.calculate(input);

        // 출력
        OutputUnit.printResult(sum);

    }







}
