package homework06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumInMillimeters {
    /*
     * Pattern explained
     * (\\+|\\-)      -> plus or minus character (\\ escapes the character => it refers to the actual character not the regex operator)
     * (\\+|\\-)?     -> repeats 0 or 1 times
     * ( +)           -> character space " " repeats 0 or more times
     * (\\d+)         -> there's a digit that repeats 1 or more times
     * (mm|cm|...|m)  -> one of the following sets of characters mm or cm or dm or km or m
     */
    private static String PATTERN_REGEX = "(\\+|\\-)?( *)(\\d+)( *)(mm|cm|dm|km|m)";
    public int sum(String string) {

        Pattern pattern = Pattern.compile(PATTERN_REGEX);
        Matcher matcher = pattern.matcher(string);

        int expressionValue = 0;
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println("current group:\"" + group + " \"");

            String unitOfMeasure = extractFromString(group, "(mm|cm|dm|km|m)");
            System.out.println("unit: " + unitOfMeasure);

            String number = extractFromString(group, "(\\d+)");
            System.out.println("number: " + number);

            String sign = extractFromString(group, "(\\+|\\-)?");
            if (sign == null) {
                sign = "+";
            }
            System.out.println("sign: " + sign);

            System.out.println("distance in millimeters is:" + transformToMillimeters(unitOfMeasure, number));

            expressionValue = getExpressionValue(expressionValue, unitOfMeasure, number, sign);
            System.out.println("temp sum: " + expressionValue);
        }
        System.out.println("Sum: " + expressionValue + " mm");
        return expressionValue;
    }

    private int getExpressionValue(int expressionValue, String unitOfMeasure, String number, String sign) {
        int distance = transformToMillimeters(unitOfMeasure, number);
        if (sign.equals("-")) {
            expressionValue = expressionValue - distance;
        } else {
            expressionValue = expressionValue + distance;
        }
        return expressionValue;
    }

    private String extractFromString(String stringToBeSearched, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher unitMatcher = pattern.matcher(stringToBeSearched);
        unitMatcher.find();
        return unitMatcher.group(1);
    }

    private int transformToMillimeters(String unitOfMeasure, String number) {
        int distance = Integer.parseInt(number);
        if (unitOfMeasure.equals("km")) {
            distance = distance * 1000000;
        } else if (unitOfMeasure.equals("m")) {
            distance = distance * 1000;
        } else if (unitOfMeasure.equals("dm")) {
            distance = distance * 100;
        } else if (unitOfMeasure.equals("cm")) {
            distance = distance * 10;
        }
        return distance;
    } 
    

}
