package pl.coderstrust.task_6_pull_requests;

public class LeapYearCalculator {
    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
    }

    private static boolean isLeapYear(int year) {
        if ((year < 9999) && (year > 1)) {
            if (((year % 4 == 0) && (year % 100 > 0)) || (year % 400 == 0)) {
                return true;
            }
        }
        return false;
    }
}