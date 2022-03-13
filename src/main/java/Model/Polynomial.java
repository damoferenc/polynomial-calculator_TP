package Model;

import java.util.*;

import java.util.regex.*;

public class Polynomial {
    private List<Monomial> monomialList = new ArrayList<Monomial>();

    public Polynomial(String inputString) {

        String patternString = "(([+-]*)([1-9]*)([//*]*)([x]*)([//^]*)([1-9]*))";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);
        while(matcher.find()) {
            if(!matcher.group(0).equals("")) {
                double coefficient = 1;
                int degree = 0;
                if(matcher.group(2).equals("-")) {
                    coefficient = -1;
                }
                if(!matcher.group(3).equals("")) {
                    coefficient *= (double)Integer.parseInt(matcher.group(3));
                }
                if(matcher.group(5).equals("x")) {
                    degree = 1;
                }
                if(!matcher.group(7).equals("")) {
                    degree = Integer.parseInt(matcher.group(7));
                }
                addMonomial(coefficient, degree);
            }

        }
        Collections.sort(monomialList);
    }

    public Polynomial(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }


    private void addMonomial(double coefficient, int degree) {
        Monomial monomial = new Monomial(coefficient, degree);
        this.monomialList.add(monomial);
    }

    public String toString() {
        String output = "";
        for( Monomial monomial : this.monomialList) {
            output += monomial;
        }
        if(output.equals("")){
            output = "0";
        }
        if(output.substring(0,1).equals("+")) {
            return output.substring(1);
        }
        else {
            return output;
        }

    }


    public List<Monomial> getMonomialList(){
        return this.monomialList;
    }

    public static boolean checkPolynomials(String str1, String str2) {
        String patternString = "(-?[1-9]+\\*x\\^[1-9]+|-?[1-9]+\\*x|-?x\\^[1-9]+|-?x|-?[1-9]+)";
        patternString += "([\\+-][1-9]+\\*x\\^[1-9]+|[\\+-][1-9]+\\*x|[\\+-]x\\^[1-9]+|[\\+-]x|[\\+-][1-9]+)*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher1 = pattern.matcher(str1);
        Matcher matcher2 = pattern.matcher(str2);
        if(str1.equals("") || str2.equals("")) {
            return false;
        }
        return matcher1.matches() && matcher2.matches();
    }

    public static boolean checkPolynomial(String str1) {
        String patternString = "(-?[1-9]+\\*x\\^[1-9]+|-?[1-9]+\\*x|-?x\\^[1-9]+|-?x|-?[1-9]+)";
        patternString += "([\\+-][1-9]+\\*x\\^[1-9]+|[\\+-][1-9]+\\*x|[\\+-]x\\^[1-9]+|[\\+-]x|[\\+-][1-9]+)*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str1);
        if(str1.equals("")) {
            return false;
        }
        return matcher.matches();
    }

}


