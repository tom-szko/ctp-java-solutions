package pl.coderstrust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPChecker {

    private static final String IP_PATTERN = "\\b(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])[.]){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b";
    private static Pattern pattern = Pattern.compile(IP_PATTERN);

    static boolean isIpAddress(String ipAddress) {
        if (ipAddress == null) {
            throw new NullPointerException("IP address cannot be null.");
        }
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
}
