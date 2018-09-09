package pl.coderstrust.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class IPCheckerTest {

    @Ignore("3h 46m 27s on 2,9 GHz Intel Core i5")
    @Test
    public void testAllCombinationsSlow() {
        // given
        String ip;
        boolean isValidIp;
        long startTime = System.currentTimeMillis();

        // when
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 255; j++) {
                for (int k = 0; k <= 255; k++) {
                    for (int l = 0; l <= 255; l++) {
                        ip = i + "." + j + "." + k + "." + l;
                        isValidIp = IPChecker.isIpAddress(ip);
                        assertTrue(isValidIp);
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long processTimeInSeconds = (endTime - startTime) / 1000;
        System.out.println(processTimeInSeconds / 60 + "m " + processTimeInSeconds % 60 + "s");
    }

    @Test
    @Parameters(method = "ipGroupNumbersParameters")
    public void testIpGroupsOfNumbers(String number) {
        // given
        String ip1 = number + ".1.1.1";
        String ip2 = "1." + number + ".1.1";
        String ip3 = "1.1." + number + ".1";
        String ip4 = "1.1.1." + number;

        // when
        boolean isValidIp1 = IPChecker.isIpAddress(ip1);
        boolean isValidIp2 = IPChecker.isIpAddress(ip2);
        boolean isValidIp3 = IPChecker.isIpAddress(ip3);
        boolean isValidIp4 = IPChecker.isIpAddress(ip4);

        // then
        assertTrue(isValidIp1);
        assertTrue(isValidIp2);
        assertTrue(isValidIp3);
        assertTrue(isValidIp4);
    }

    private Object[] ipGroupNumbersParameters() {
        return new Object[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
                "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75",
                "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
                "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104",
                "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117",
                "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130",
                "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143",
                "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156",
                "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169",
                "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182",
                "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195",
                "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208",
                "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221",
                "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234",
                "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247",
                "248", "249", "250", "251", "252", "253", "254", "255"
        };
    }

    @Test
    @Parameters(method = "invalidIpParameters")
    public void testInvalidIp(String ip) {
        // when
        boolean isValidIp = IPChecker.isIpAddress(ip);

        // then
        assertFalse(isValidIp);
    }

    private Object[] invalidIpParameters() {
        return new Object[]{
                "257.1.1.1",
                "2.2.2.670",
                "-1.0.0.0",
                "12.12-12.12",
                "00.01.02.233",
                "000.001.002.233",
                "a.b.c.d",
                "0/2/3/3"
        };
    }
}
