# Polynomial Tool

A console application for creating, adding, displaying, and evaluating polynomials. Terms are stored in descending degree order in a `LinkedList`.

## Concepts
- object composition (`Polynomial` + `Term`)
- `LinkedList` and `ListIterator`
- ordered insertion
- combining like terms
- `Comparable`
- polynomial evaluation with `Math.pow`

## Run
```bash
cd src
javac *.java
java PolynomialApp
```

## What I learned
The core challenge was maintaining an ordered representation while handling insertion and combining terms with matching degrees. The project also reinforced separation between the data structure (`Polynomial`), the value object (`Term`), and the console driver (`PolynomialApp`).
