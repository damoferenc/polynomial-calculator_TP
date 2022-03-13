package Controller;

import Model.Operations;
import Model.Polynomial;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;

        this.view.addAddButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = view.getFirstPolynomial();
                String polynomialString2 = view.getSecondPolynomial();
                if(Polynomial.checkPolynomials(polynomialString1, polynomialString2)) {
                    view.showResult(Operations.addPolynomials(new Polynomial(polynomialString1), new Polynomial(polynomialString2)).toString());
                    view.setNotDivisionOperation();
                }
                else {
                    view.showResult("INPUT ERROR");
                }
            }

        });

        this.view.addSubstractButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = view.getFirstPolynomial();
                String polynomialString2 = view.getSecondPolynomial();
                if(Polynomial.checkPolynomials(polynomialString1, polynomialString2)) {
                    view.showResult(Operations.substractPolynomials(new Polynomial(polynomialString1), new Polynomial(polynomialString2)).toString());
                    view.setNotDivisionOperation();
                }
                else {
                    view.showResult("INPUT ERROR");
                }
            }

        });

        this.view.addMultiplyButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = view.getFirstPolynomial();
                String polynomialString2 = view.getSecondPolynomial();
                if(Polynomial.checkPolynomials(polynomialString1, polynomialString2)) {
                    view.showResult(Operations.multiplyPolynomials(new Polynomial(polynomialString1), new Polynomial(polynomialString2)).toString());
                    view.setNotDivisionOperation();
                }
                else {
                    view.showResult("INPUT ERROR");
                }
            }

        });

        this.view.addDivideButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = view.getFirstPolynomial();
                String polynomialString2 = view.getSecondPolynomial();
                if(Polynomial.checkPolynomials(polynomialString1, polynomialString2)) {
                    view.showResult("");
                    view.showQuotient(Operations.dividePolynomials(new Polynomial(polynomialString1), new Polynomial(polynomialString2)).get(0).toString());
                    view.showRemainder(Operations.dividePolynomials(new Polynomial(polynomialString1), new Polynomial(polynomialString2)).get(1).toString());
                }
                else {
                    view.showResult("INPUT ERROR");
                }
            }

        });

        this.view.addDerivateButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = view.getFirstPolynomial();
                if(Polynomial.checkPolynomial(polynomialString1)) {
                    view.showResult(Operations.derivatePolynomial(new Polynomial(polynomialString1)).toString());
                    view.setNotDivisionOperation();
                }
                else {
                    view.showResult("INPUT ERROR");
                }
            }

        });

        this.view.addIntegrateButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = view.getFirstPolynomial();
                if(Polynomial.checkPolynomial(polynomialString1)) {
                    view.showResult(Operations.integratePolynomial(new Polynomial(polynomialString1)).toString());
                    view.setNotDivisionOperation();
                }
                else {
                    view.showResult("INPUT ERROR");
                }
            }

        });




    }


}
