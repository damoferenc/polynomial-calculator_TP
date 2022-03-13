package Model;

public class Monomial implements Comparable<Monomial> {
    private double coefficient;
    private int degree;

    public Monomial(double coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public String toString() {
        String output = "";
        if(coefficient > 0) {
            output += "+";
        }
        if(coefficient != 1 && coefficient != -1) {
            output += coefficient;
            if(degree != 0) {
                output += "*";
            }
        }
        if(coefficient == -1) {
            output += "-";
        }
        if(degree != 0) {
            output += "x";
        }
        if(degree != 1 && degree != 0)
        {
            output += "^";
            output += degree;
        }
        if(degree == 0 && coefficient*coefficient == 1) {
            output += coefficient*coefficient;
        }
        return output;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return this.coefficient;
    }

    public int compareTo(Monomial otherMonomial) {
        return otherMonomial.getDegree() -  this.degree ;
    }



}
