package homework06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumInMillimetersTest {
    @Test
    public void test_sum_works() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "10 cm + 1 m - 10 mm";
        Assertions.assertEquals(1090, sumInMIllimeters.sum(ex));
    }
    @Test
    public void test_sum_works1() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "10mm+15km+1m-10dm";
        Assertions.assertEquals(15000010, sumInMIllimeters.sum(ex));
    }

    @Test
    public void test_sum_works2() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "  10m + 15mm - 1m + 1dm  ";
        Assertions.assertEquals(9115, sumInMIllimeters.sum(ex));
    }

    @Test
    public void test_sum_works3() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "+10cm +1m +15mm";
        Assertions.assertEquals(1115, sumInMIllimeters.sum(ex));
    }

    @Test
    public void test_sum_works4() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "-10 cm +1 m -10 mm";
        Assertions.assertEquals(890, sumInMIllimeters.sum(ex));
    }


}
