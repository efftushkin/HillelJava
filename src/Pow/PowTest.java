package Pow;

import GetPow.GetPow;
import org.junit.Assert;
import org.junit.Test;

public class PowTest {
    @Test
    public void pow() {
        Assert.assertEquals(1, Pow.pow(1, 31), 0.00000000001);
        Assert.assertEquals(1, Pow.pow(1, -31), 0.00000000001);

        Assert.assertEquals(1, Pow.pow(0, 0), 0.00000000001);
        Assert.assertEquals(0, Pow.pow(0, 1), 0.00000000001);
        Assert.assertEquals(0, Pow.pow(0, 16), 0.00000000001);

        Assert.assertEquals(2147483648d, Pow.pow(2, 31), 0.00000000001);
        Assert.assertEquals(4294967296d, Pow.pow(2, 32), 0.00000000001);

        Assert.assertEquals(0.00000000047d, Pow.pow(2, -31), 0.00000000001);
        Assert.assertEquals(0.00001525879d, Pow.pow(2, -16), 0.00000000001);
    }
}
