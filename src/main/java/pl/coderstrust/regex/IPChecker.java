package pl.coderstrust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPChecker {

    static boolean isIpAddress(String input) {
        Pattern pattern = Pattern.compile("\\b(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])[.]){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
