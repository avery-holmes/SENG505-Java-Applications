/** @author Avery Holmes
 * SENG 505 - Right Triangle Assignment
 * Purpose: This program will generate random right triangles and calculate the hypotenuse.
 */

public class RightTriangle {
    public static void main(String[] args){
        double sideA = (int)(Math.random() * 5) + 1;
        double sideB = (int)(Math.random() * 10) + 1;

        sideA = Math.ceil(sideA);
        sideB = Math.ceil(sideB);

        double sideH = Math.sqrt((sideA * sideA) + (sideB * sideB));
        System.out.println("A right triangle where side a=" + sideA + " and b=" + sideB + " has a hypotenuse of " + sideH + ".");
    }
}
