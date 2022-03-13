import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplyPolynomialsTest {

    @Test
    public void multiplyTest(){
        assertTrue(Operations.multiplyPolynomials(new Polynomial("x^2+6*x-5"),
                new Polynomial("6*x^3-x+1")).toString().equals("6.0*x^5+36.0*x^4-31.0*x^3-5.0*x^2+11.0*x-5.0"));

    }
    @Test
    public void multiplyTest2(){
        assertTrue(Operations.multiplyPolynomials(new Polynomial("6*x^2+6*x-5"),
                new Polynomial("6*x^3-5*x+1")).toString().equals("36.0*x^5+36.0*x^4-60.0*x^3-24.0*x^2+31.0*x-5.0"));

    }

    @Test
    public void multiplyTest3(){
        assertTrue(Operations.multiplyPolynomials(new Polynomial("-1"),
                new Polynomial("x^62")).toString().equals("-x^62"));

    }

    @Test
    public void multiplyTest4(){
        assertTrue(Operations.multiplyPolynomials(new Polynomial("x^2-x+1"),
                new Polynomial("x^2-x-1")).toString().equals("x^4-2.0*x^3+x^2-1.0"));

    }

}
