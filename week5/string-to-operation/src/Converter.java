import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    public static void main(String[] args) {
        String equation = "123-234-3342*4345+50";
        System.out.println(toList(equation));
    }
    public static List<String> toList(String equation) {
//        Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
//        Pattern pattern = Pattern.compile("[-+*%/]|[0-9]+");
        Pattern pattern = Pattern.compile("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        Matcher matcher = pattern.matcher(equation);
        List<String> listOfOperator = new ArrayList<>();
        while (matcher.find()) {
            listOfOperator.add(matcher.group());
        }
        return listOfOperator;
    }
}
