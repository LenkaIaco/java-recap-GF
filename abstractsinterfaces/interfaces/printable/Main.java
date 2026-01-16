package interfaces.printable;

import interfaces.comparable.Domino;
import interfaces.printable.Todo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Domino> dominoes = new ArrayList<>();
        ArrayList<Todo> todos = new ArrayList<>();

        dominoes.add(new Domino(1, 2));
        dominoes.add(new Domino(2, 3));
        dominoes.add(new Domino(3, 4));
        dominoes.add(new Domino(4, 5));

        todos.add(new Todo("Prepare food", "high", true));
        todos.add(new Todo("Do dishes", "medium", false));
        todos.add(new Todo("Water plants", "low", false));

        for (Domino domino : dominoes) {
            domino.printAllFields();
        }

        System.out.println();
        System.out.println();

        for (Todo todo : todos) {
            todo.printAllFields();
        }
    }
}

