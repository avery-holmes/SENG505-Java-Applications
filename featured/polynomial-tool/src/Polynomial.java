/*
 * Author: Avery Holmes
 * Course: SENG 505 – Programming Applications with Java
 * Assignment: Program Set 2 – Part A (Working with Polynomials)
 * File: Polynomial.java
 * Description: Polynomial stored as an ordered LinkedList of terms.
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

    private LinkedList<Term> terms;

    public Polynomial() {
        terms = new LinkedList<Term>();
    }

    public void addTerm(double coefficient, int degree) {
        if (coefficient == 0.0) {
            return;
        }

        Term newTerm = new Term(coefficient, degree);
        ListIterator<Term> it = terms.listIterator();

        while (it.hasNext()) {
            Term current = it.next();

            if (current.getDegree() == degree) {
                double newCoefficient = current.getCoefficient() + coefficient;
                current.setCoefficient(newCoefficient);
                return;
            }

            if (degree > current.getDegree()) {
                it.previous();
                it.add(newTerm);
                return;
            }
        }

        terms.add(newTerm);
    }

    public double evaluate(double x) {
        double result = 0.0;

        for (Term t : terms) {
            double a = t.getCoefficient();
            int d = t.getDegree();
            result += a * Math.pow(x, d);
        }
        return result;
    }

    public Polynomial add(Polynomial other) {
        Polynomial sum = new Polynomial();

        for (Term t : this.terms) {
            sum.addTerm(t.getCoefficient(), t.getDegree());
        }

        for (Term t : other.terms) {
            sum.addTerm(t.getCoefficient(), t.getDegree());
        }
        return sum;
    }

    @Override
    public String toString() {
        if (terms.isEmpty()) {
            return "0";
        }

        String result = "";
        boolean first = true;

        for (Term t : terms) {
            if (first) {
                result = t.toString();
                first = false;
            } else {
                result = result + " + " + t.toString();
            }
        }
        return result;
    }
}
