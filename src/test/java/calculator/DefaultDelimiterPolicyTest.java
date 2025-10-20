package calculator;
import calculator.interfaceImp.DefaultDelimiterPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultDelimiterPolicyTest {
    private final DefaultDelimiterPolicy policy = new DefaultDelimiterPolicy();
    private static final char[] DEFAULTS = DefaultDelimiterPolicy.DEFAULT_DELIMITERS;

    @Test
    @DisplayName("빈 문자열이면 values는 빈 문자열, 기본 구분자 사용")
    void emptyString_returnsDefaults() {
        Parsed parsed = policy.parse("");
        assertEquals("", parsed.values());
        assertArrayEquals(DEFAULTS, parsed.delimiters());
    }

    @Test
    @DisplayName("PREFIX(//)가 없으면 기본 구분자만 사용")
    void noPrefix_usesDefaultDelimiters() {
        Parsed parsed = policy.parse("1,2:3");
        assertEquals("1,2:3", parsed.values());
        assertArrayEquals(DEFAULTS, parsed.delimiters());
    }

    @Test
    @DisplayName("커스텀 구분자 1글자 + 문자열 \"\\n\" 뒤는 values")
    void customDelimiter_oneChar_then_StringBackslashN_then_values() {

        String input = "//;\\n1;2;3";

        Parsed parsed = policy.parse(input);

        assertEquals("1;2;3", parsed.values());

        char[] expected = new char[]{';', ',', ':'};
        assertArrayEquals(expected, parsed.delimiters());
    }

    @Test
    @DisplayName("형식 오류: \"//\" 다음이 곧바로 \"\\n\"이면 커스텀 구분자 비어있음")
    void invalid_when_customDelimiterMissing() {
        String input = "//\\n1;2;3";
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> policy.parse(input));
    }

    @Test
    @DisplayName("형식 오류: \"\\n\"(백슬래시+n) 토큰이 없으면 예외")
    void invalid_when_suffixNotFound() {
        String input = "//;1;2;3";
        assertThrows(IllegalArgumentException.class, () -> policy.parse(input));
    }

    @Test
    @DisplayName("형식 오류: 커스텀 구분자가 2글자 이상이면 예외")
    void invalid_when_customDelimiterLengthGreaterThanOne() {
        String input = "//!!\\n1!!2!!3";
        assertThrows(IllegalArgumentException.class, () -> policy.parse(input));
    }

}
