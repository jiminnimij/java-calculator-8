package calculator.unit;

import camp.nextstep.edu.missionutils.Console;

public class InputUnit {
    public static String input(){
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String input = Console.readLine();

        return input;
    }
}
