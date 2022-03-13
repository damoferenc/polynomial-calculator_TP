import Controller.Controller;
import View.View;

import java.util.List;


public class MainClass {

    public static void main(String[] args) {
        View view = new View();

        Controller controller = new Controller(view);

        view.setVisible(true);

        //String inputString1 = "3*x^4+5*x^3+1";
        //String inputString2 = "x^3+x^2+x+2";

        //String inputString1 = "x^3-2*x^2+6*x-5";
        //String inputString2 = "x^2-1";


		/*Polynomial polinom1 = new Polynomial(inputString1);
		Polynomial polinom2 = new Polynomial(inputString2);
		System.out.println(polinom1);
		System.out.println(polinom2);
		Polynomial polinom3 = Operations.addPolynomials(polinom1, polinom2);
		System.out.println(polinom3);
		Polynomial polinom4 = Operations.substractPolynomials(polinom1, polinom2);
		System.out.println(polinom4);
		Polynomial polinom5 = Operations.multiplicatePolynomials(polinom1, polinom2);
		System.out.println(polinom5);
		List<Polynomial> list = Operations.dividePolynomials(polinom1, polinom2);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(Operations.derivatePolynomial(polinom1));
		System.out.println(Operations.integratePolynomial(polinom1));*/
    }


}
