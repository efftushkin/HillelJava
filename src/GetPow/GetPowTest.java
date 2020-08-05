package GetPow;

import org.junit.Assert;
import org.junit.Test;

public class GetPowTest {
    @Test
    public void getPow() {
        Assert.assertEquals(2147483648d, GetPow.getPow(2, 31), 0.00000000001);
        Assert.assertEquals(0.00000000047d, GetPow.getPow(2, -31), 0.00000000001);

        Assert.assertEquals(4294967296d, GetPow.getPow(2, 32), 0.00000000001);
    }
}
