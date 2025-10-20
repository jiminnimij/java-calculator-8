package calculator;

public record Parsed(String values, String delimiters) {
    public String[] splitValues() {
        return values.split(delimiters, -1);
    }

}
