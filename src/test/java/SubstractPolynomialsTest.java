import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubstractPolynomialsTest {

    @Test
    public void substractTest(){
        assertTrue(Operations.substractPolynomials(new Polynomial("x^2+6*x-5"),
                new Polynomial("6*x^3-x+1")).toString().equals("6.0*x^3-x^2-7.0*x+6.0"));

    }
    @Test
    public void substractTest2(){
        assertTrue(Operations.substractPolynomials(new Polynomial("6*x^2+6*x-5"),
                new Polynomial("6*x^3-5*x+1")).toString().equals("6.0*x^3-6.0*x^2-11.0*x+6.0"));

    }

    @Test
    public void substractTest3(){
        assertTrue(Operations.substractPolynomials(new Polynomial("-1"),
                new Polynomial("x^62")).toString().equals("x^62+1.0"));

    }

    @Test
    public void substractTest4(){
        assertTrue(Operations.substractPolynomials(new Polynomial("x^2-x-1"),
                new Polynomial("x^2-x-1")).toString().equals("0"));

    }

}
