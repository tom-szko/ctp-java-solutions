package pl.coderstrust.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class IPCheckerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
        printExecutionTime(startTime, endTime);
    }

    private void printExecutionTime(long startTime, long endTime) {
        long processTimeInSeconds = (endTime - startTime) / 1000;
        long minutes = processTimeInSeconds / 60;
        long seconds = processTimeInSeconds % 60;
        System.out.printf("%dm %ds", minutes, seconds);
    }

    @Test
    @Parameters({"%d.1.1.1", "1.%d.1.1", "1.1.%d.1", "1.1.1.%d"})
    public void smartTestForValidIpAddresses(String ipAddressTemplate) {
        for (int i = 0; i < 256; i++) {
            // given
            String ipAddress = String.format(ipAddressTemplate, i);

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

    @Test
    public void testNullAsIpAddress() {
        // given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("IP address cannot be null.");

        // when
        IPChecker.isIpAddress(null);
    }
}
