package calculator;

public record Parsed(String values, char[] delimiters) {
    public String[] splitValues() {
        return values.split(buildSplitRegex(delimiters), -1);
    }

    private String buildSplitRegex(char[] delimiters) {
        StringBuilder regex = new StringBuilder("[");
        for (char d : delimiters) {
            if ("\\.^$|?*+()[]{}".indexOf(d) >= 0) {
                regex.append("\\\\");
            }
            regex.append(d);
        }
        regex.append("]");
        return regex.toString();
    }
}
