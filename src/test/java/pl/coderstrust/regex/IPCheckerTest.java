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

    @Ignore("2h 51m 48s on 2,9 GHz Intel Core i5")
    @Test
    public void testForEveryIpAddress() {
        // given
        String ip;
        long startTime = System.currentTimeMillis();

        // when
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        ip = String.format("%d.%d.%d.%d", i, j, k, l);
                        assertTrue(IPChecker.isIpAddress(ip));
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        getProcessTime(startTime, endTime);
    }

    private void getProcessTime(long startTime, long endTime) {
        long processTimeInSeconds = (endTime - startTime) / 1000;
        System.out.println(processTimeInSeconds / 60 + "m " + processTimeInSeconds % 60 + "s");
    }

    @Test
    public void testFirstNumber() {
        for (int i = 0; i < 256; i++) {
            // given
            String ipAddress = i + ".1.1.1";

            // when
            boolean isValidIp = IPChecker.isIpAddress(ipAddress);

            // then
            assertTrue(isValidIp);
        }
    }

    @Test
    public void testSecondNumber() {
        for (int i = 0; i < 256; i++) {
            // given
            String ipAddress = "1." + i + ".1.1";

            // when
            boolean isValidIp = IPChecker.isIpAddress(ipAddress);

            // then
            assertTrue(isValidIp);
        }
    }

    @Test
    public void testThirdNumber() {
        for (int i = 0; i < 256; i++) {
            // given
            String ipAddress = "1.1." + i + ".1";

            // when
            boolean isValidIp = IPChecker.isIpAddress(ipAddress);

            // then
            assertTrue(isValidIp);
        }
    }

    @Test
    public void testFourthNumber() {
        for (int i = 0; i < 256; i++) {
            // given
            String ipAddress = "1.1.1" + i;

            // when
            boolean isValidIp = IPChecker.isIpAddress(ipAddress);

            // then
            assertTrue(isValidIp);
        }
    }

    @Test
    @Parameters(method = "invalidIpAddresses")
    public void testForInvalidIpAddresses(String ipAddress) {
        // when
        boolean isValidIp = IPChecker.isIpAddress(ipAddress);

        // then
        assertFalse(isValidIp);
    }

    private Object[] invalidIpAddresses() {
        return new Object[]{
                "257.1.1.1",
                "2.2.2.670",
                "-1.0.0.0",
                "12.12-12.12",
                "00.01.02.233",
                "000.001.002.233",
                "a.b.c.d",
                "0/2/3/3",
                "",
                "   "
        };
    }

    @Test(expected = NullPointerException.class)
    public void testNullAsIpAddress() {
        IPChecker.isIpAddress(null);
    }
}
