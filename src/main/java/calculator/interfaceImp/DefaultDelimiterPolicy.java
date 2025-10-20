package calculator.interfaceImp;

import calculator.Parsed;
import calculator.calculatorInterface.DelimeterPolicy;

public class DefaultDelimiterPolicy implements DelimeterPolicy {
    public static final char[] DEFAULT_DELIMITERS = {',', ':'};
    public static final String PREFIX = "//";
    public static final String SUFFIX = "\\n";

    @Override
    public Parsed parse(String input) {
        if (input == null || input.isEmpty()) {
            return new Parsed("", DEFAULT_DELIMITERS);
        }

        if (input.startsWith(PREFIX)) {
            int delimiterEndIndex = input.indexOf(SUFFIX);
            if (delimiterEndIndex < 0 || delimiterEndIndex == PREFIX.length()) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }

            String customDelimiter = input.substring(2, delimiterEndIndex);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
            }

            char custom = customDelimiter.charAt(0);
            char[] customDelimiters = combineDelimiters(custom, DEFAULT_DELIMITERS);

            String valuesPart = input.substring(delimiterEndIndex + SUFFIX.length());
            return new Parsed(valuesPart, customDelimiters);
        }

        return new Parsed(input, DEFAULT_DELIMITERS);

    }

    private char[] combineDelimiters(char custom, char[] defaults) {
        char[] result = new char[defaults.length + 1];
        result[0] = custom;
        System.arraycopy(defaults, 0, result, 1, defaults.length);
        return result;
    }


}
