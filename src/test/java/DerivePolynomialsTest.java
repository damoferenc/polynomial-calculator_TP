import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DerivePolynomialsTest {

    @Test
    public void derivateTest(){
        assertTrue(Operations.derivatePolynomial(new Polynomial("3*x^4+5*x^3+1")).toString().equals("12.0*x^3+15.0*x^2"));

    }
    @Test
    public void derivateTest2(){
        assertTrue(Operations.derivatePolynomial(new Polynomial("x^2+3*x-2")).toString().equals("2.0*x+3.0"));

    }

    @Test
    public void derivateTest3(){
        assertTrue(Operations.derivatePolynomial(new Polynomial("1")).toString().equals("0"));

    }

    @Test
    public void derivateTest4(){
        assertTrue(Operations.derivatePolynomial(new Polynomial("x^7")).toString().equals("7.0*x^6"));

    }

}
