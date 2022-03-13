import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegratePolynomialsTest {

    @Test
    public void integrateTest(){
        assertTrue(Operations.integratePolynomial(new Polynomial("3*x^4+5*x^3+1")).toString().equals("0.6*x^5+1.25*x^4+x"));

    }
    @Test
    public void integrateTest2(){
        assertTrue(Operations.integratePolynomial(new Polynomial("3*x^2+3*x-2")).toString().equals("x^3+1.5*x^2-2.0*x"));

    }

    @Test
    public void integrateTest3(){
        assertTrue(Operations.integratePolynomial(new Polynomial("1")).toString().equals("x"));

    }

    @Test
    public void integrateTest4(){
        assertTrue(Operations.integratePolynomial(new Polynomial("x^7")).toString().equals("0.125*x^8"));

    }

}
