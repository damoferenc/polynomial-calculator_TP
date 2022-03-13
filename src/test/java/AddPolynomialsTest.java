import Model.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddPolynomialsTest {

    @Test
    public void addTest(){
        assertTrue(Operations.addPolynomials(new Polynomial("x^2+6*x-5"),
                new Polynomial("6*x^3-x+1")).toString().equals("6.0*x^3+x^2+5.0*x-4.0"));

    }
    @Test
    public void addTest2(){
        assertTrue(Operations.addPolynomials(new Polynomial("6*x^2+6*x-5"),
                new Polynomial("6*x^3-5*x+1")).toString().equals("6.0*x^3+6.0*x^2+x-4.0"));

    }

    @Test
    public void addTest3(){
        assertTrue(Operations.addPolynomials(new Polynomial("-1"),
                new Polynomial("x^62")).toString().equals("x^62-1.0"));

    }

    @Test
    public void addTest4(){
        assertTrue(Operations.addPolynomials(new Polynomial("x^2-x-1"),
                new Polynomial("-x^2+x+1")).toString().equals("0"));

    }

}
