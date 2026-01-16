package interfaces.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));

        Collections.sort(dominoes);
        System.out.println(dominoes);

        Todo todo1 = new Todo("Have breakfast", "high", true);
        Todo todo2 = new Todo("Have lunch", "high", true);

//        int areEqual = todo1.compareTo(todo2);
        int areEqual = 0;
        String result = "";
        switch(areEqual){
            case 1 : result = "todos are equal"; break;
            case 0 : result = "todos are not equal"; break;
            default : result = "inconclusive";
        }

        System.out.println(todo1);
        System.out.println(todo2);
        System.out.println(result);

    }
}
