package pl.coderstrust.task_6_pull_requests;

public class SecondsAndMinutes {
    public static void main(String[] args) {
        System.out.println(getDurationString(122, 39));
        System.out.println(getDurationString(68));
    }

    private static String getDurationString(int minutes, int seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return "Invalid value";
        }
        int hours = minutes / 60;
        minutes = minutes % 60;
        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
    }

    private static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid value";
        }
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;
        return getDurationString(minutes, seconds);
    }
}
