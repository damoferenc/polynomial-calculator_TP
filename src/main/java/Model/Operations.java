package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operations {

    public static Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        List<Monomial> monomialList = new ArrayList<Monomial>();
        List<Monomial> list1;
        List<Monomial> list2;
        if(polynomial1.getMonomialList().get(0).compareTo(polynomial2.getMonomialList().get(0)) < 0) {
            list1 = polynomial1.getMonomialList();
            list2 = polynomial2.getMonomialList();
        }
        else
        {
            list2 = polynomial1.getMonomialList();
            list1 = polynomial2.getMonomialList();
        }
        int i=0;
        for(Monomial monomial : list1) {

            while(i < list2.size() && monomial.compareTo(list2.get(i)) > 0 ) {
                addMonomialToList(monomialList, list2.get(i).getCoefficient(), list2.get(i).getDegree());
                i++;
            }
            if(i < list2.size() && monomial.compareTo(list2.get(i)) == 0) {
                if(monomial.getCoefficient() + list2.get(i).getCoefficient() != 0) {
                    addMonomialToList(monomialList, monomial.getCoefficient() + list2.get(i).getCoefficient() ,monomial.getDegree() )	;
                }
                i++;
            }
            else {
                addMonomialToList(monomialList, monomial.getCoefficient(), monomial.getDegree());
            }
        }
        while(i < list2.size() ) {
            addMonomialToList(monomialList, list2.get(i).getCoefficient(), list2.get(i).getDegree());
            i++;
        }
        return new Polynomial( monomialList);
    }

    public static Polynomial substractPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        List<Monomial> monomialList = new ArrayList<Monomial>();
        List<Monomial> list1;
        List<Monomial> list2;
        if(polynomial1.getMonomialList().get(0).compareTo(polynomial2.getMonomialList().get(0)) <= 0) {
            list1 = polynomial1.getMonomialList();
            list2 = polynomial2.getMonomialList();
        }
        else
        {
            list2 = polynomial1.getMonomialList();
            list1 = polynomial2.getMonomialList();
        }
        int i=0;
        for(Monomial monomial : list1) {

            while(i < list2.size() && monomial.compareTo(list2.get(i)) > 0 ) {
                addMonomialToList(monomialList,(-1) * list2.get(i).getCoefficient(), list2.get(i).getDegree());
                i++;
            }
            if(i < list2.size() && monomial.compareTo(list2.get(i)) == 0) {
                if(monomial.getCoefficient() - list2.get(i).getCoefficient() != 0) {
                    addMonomialToList(monomialList, monomial.getCoefficient() - list2.get(i).getCoefficient() ,monomial.getDegree() );
                }
                i++;
            }
            else {
                addMonomialToList(monomialList, monomial.getCoefficient(), monomial.getDegree());
            }
        }
        while(i < list2.size() ) {
            addMonomialToList(monomialList,(-1) * list2.get(i).getCoefficient(), list2.get(i).getDegree());
            i++;
        }
        return new Polynomial( monomialList);
    }

    public static void addMonomialToList(List<Monomial> list, double coefficient, int degree) {
        list.add(new Monomial(coefficient, degree));
    }

    public static Polynomial multiplyPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        List<Monomial> monomialList = new ArrayList<Monomial>();
        List<Monomial> list1 = polynomial1.getMonomialList();
        List<Monomial> list2 = polynomial2.getMonomialList();
        for(Monomial monomial1 : list1) {
            for(Monomial monomial2 : list2) {
                addMonomialToList(monomialList, monomial1.getCoefficient() *
                        monomial2.getCoefficient(), monomial1.getDegree() + monomial2.getDegree());
            }
        }
        Collections.sort(monomialList);
        int i = 0;
        while(i < monomialList.size() - 1) {
            if(monomialList.get(i).getDegree() == monomialList.get(i + 1).getDegree()){
                monomialList.get(i).setCoefficient(monomialList.get(i).getCoefficient() + monomialList.get(i + 1).getCoefficient());
                monomialList.remove(i+1);
                if(monomialList.get(i).getCoefficient() == 0){
                    monomialList.remove(i
                    );
                }
            }
            else {
                i++;
            }
        }

        return new Polynomial(monomialList);

    }

    public static List<Polynomial> dividePolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        List<Monomial> quotient = new ArrayList<Monomial>();
        List<Monomial> remainder = new ArrayList<Monomial>();
        List<Monomial> list = new ArrayList<Monomial>();
        Polynomial pol1, pol2;

        if(polynomial1.getMonomialList().get(0).compareTo(polynomial2.getMonomialList().get(0)) > 0) {
            pol1 = new Polynomial(polynomial2.getMonomialList());
            pol2 = new Polynomial(polynomial1.getMonomialList());
        }
        else {
            pol2 = new Polynomial(polynomial2.getMonomialList());
            pol1 = new Polynomial(polynomial1.getMonomialList());
        }
        int i = 0;
        while(pol1.getMonomialList().get(0).compareTo(pol2.getMonomialList().get(0)) <= 0 && i++<6) {
            int degree = pol1.getMonomialList().get(0).getDegree() - pol2.getMonomialList().get(0).getDegree();
            double coefficient = pol1.getMonomialList().get(0).getCoefficient() / pol2.getMonomialList().get(0).getCoefficient();
            Monomial monomial = new Monomial(coefficient, degree);
            list.clear();
            list.add(monomial);
            Polynomial polynomial = new Polynomial(list);
            pol1 = substractPolynomials(pol1, multiplyPolynomials(pol2, polynomial));
            quotient.add(monomial);
        }
        remainder = pol1.getMonomialList();
        List<Polynomial> returnList = new ArrayList<Polynomial>();
        returnList.add(new Polynomial(quotient));
        returnList.add(new Polynomial(remainder));
        return returnList;
    }

    public static Polynomial derivatePolynomial(Polynomial polynomial) {
        List<Monomial> monomialList = new ArrayList<Monomial>();
        for(Monomial monomial : polynomial.getMonomialList()) {
            if(monomial.getDegree() > 0) {
                monomialList.add(new Monomial(monomial.getCoefficient()*monomial.getDegree() , monomial.getDegree() - 1));
            }
        }
        return new Polynomial(monomialList);
    }
    public static Polynomial integratePolynomial(Polynomial polynomial) {
        List<Monomial> monomialList = new ArrayList<Monomial>();
        for(Monomial monomial : polynomial.getMonomialList()) {
            monomialList.add(new Monomial(monomial.getCoefficient()/(monomial.getDegree() + 1) , monomial.getDegree() + 1));
        }
        return new Polynomial(monomialList);
    }
}