import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DividePolynomialsTest {

    @Test
    public void divideTest(){
        assertTrue(Operations.dividePolynomials(new Polynomial("3*x^4+5*x^3+1"),
                new Polynomial("x^3+x^2+x+2")).get(0).toString().equals("3.0*x+2.0")
        &&Operations.dividePolynomials(new Polynomial("3*x^4+5*x^3+1"),
                new Polynomial("x^3+x^2+x+2")).get(1).toString().equals("-5.0*x^2-8.0*x-3.0"));

    }
    @Test
    public void divideTest2(){
        assertTrue(Operations.dividePolynomials(new Polynomial("x^3-2*x^2+6*x-5"),
                new Polynomial("x^2-1")).get(0).toString().equals("x-2.0")
                &&Operations.dividePolynomials(new Polynomial("x^3-2*x^2+6*x-5"),
                new Polynomial("x^2-1")).get(1).toString().equals("7.0*x-7.0"));

    }

    @Test
    public void divideTest3(){
        assertTrue(Operations.dividePolynomials(new Polynomial("x^3-2*x^2+6*x-5"),
                new Polynomial("x")).get(0).toString().equals("x^2-2.0*x+6.0")
                &&Operations.dividePolynomials(new Polynomial("x^3-2*x^2+6*x-5"),
                new Polynomial("x")).get(1).toString().equals("-5.0"));

    }

    @Test
    public void divideTest4(){
        assertTrue(Operations.dividePolynomials(new Polynomial("3*x^2-6*x+1"),
                new Polynomial("x+3")).get(0).toString().equals("3.0*x-15.0")
                &&Operations.dividePolynomials(new Polynomial("3*x^2-6*x+1"),
                new Polynomial("x+3")).get(1).toString().equals("46.0"));

    }

}
