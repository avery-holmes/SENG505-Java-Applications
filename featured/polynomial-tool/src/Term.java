/*
 * Author: Avery Holmes
 * Course: SENG 505 – Programming Applications with Java
 * Assignment: Program Set 2 – Part A (Working with Polynomials)
 * File: Term.java
 * Description: Single term of a polynomial: coefficient * x^degree.
 */

public class Term implements Comparable<Term> {
    private double coefficient;
    private int degree;

    public Term(double coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public int compareTo(Term other) {
        if(this.degree > other.degree) {
            return -1;
        } else if (this.degree < other.degree) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (degree == 0) {
            return "" + coefficient;
        } else if (degree == 1) {
            return coefficient + "x";
        } else {
            return coefficient + "x^" + degree;
        }
    }
}
