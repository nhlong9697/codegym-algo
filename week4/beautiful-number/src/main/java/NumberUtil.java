public class NumberUtil {
    public static boolean isBeautifulNumber(int number) {
        boolean isBeautifulNumber = false;
        String numberString = Integer.toString(number);
        int sumOfNumber = 0;
        for (int i = 0; i < numberString.length(); i++) {
           sumOfNumber += Math.pow(Integer.parseInt(String.valueOf(numberString.charAt(i))),
                   numberString.length());
        }
        if (number == sumOfNumber) {
            isBeautifulNumber = true;
        }
        return isBeautifulNumber;
    }
}
