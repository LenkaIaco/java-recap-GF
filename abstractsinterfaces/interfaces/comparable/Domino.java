package interfaces.comparable;

import interfaces.printable.Printable;

import java.util.Arrays;

/*
alternatively:

Domino implements Comparable{
   int compareTo(Object otherd){
       Domino otherCast = (Domino) otherd;
       ...
       }

 */
public class Domino implements Comparable<Domino>, Printable {
    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Domino other) {
        Domino otherCast = (Domino) other;
        int myLeft = left;
        int otherLeft = otherCast.getLeftSide();
        int result  = 0;

        if (myLeft>otherLeft){result = 1;}
        else if (myLeft==otherLeft){result = 0;}
        else {result = -1;}

        return result;
    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

    @Override
    public void printAllFields(){
        System.out.println("Left side: "+left+", right side: "+right);
    }
}
