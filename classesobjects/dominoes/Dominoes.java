package dominoes;

import java.util.ArrayList;
import java.util.List;

public class Dominoes {
    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        return dominoes;
    }

    public static void main(String args[]) {
        List<Domino> dominoes = initializeDominoes();
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...
        List<Domino> ordered = orderDominoes(dominoes);

        for (Domino d: ordered){
            System.out.println(d);
        }

    }

    public static List<Domino> orderDominoes (List<Domino> dominoes) {
        int starter = -1;
        //determine if any has a start that does not pair with any end. If yes, save index as starter.
        for (int i = 0; i < dominoes.size(); i++) {
            Domino current = dominoes.get(i);
            boolean pairs = false;
            for (int y = 0; y< dominoes.size(); y++){
                if (y!=i){
                    if (dominoes.get(i).getRightSide()==dominoes.get(y).getLeftSide()){
                        pairs = true;
                        starter = y;
                        break;
                    }
                }
            }
            if (pairs == false){
                starter = i;
                break;
            }
        }
        starter = starter == -1 ? 0 : starter;
        int current = starter;

    List<Domino> ordered = new ArrayList<>();
        ordered.add(dominoes.get(starter));

        while(ordered.size()!=dominoes.size()) {
            for (int i = 0; i < dominoes.size(); i++) {
                if (!ordered.contains(dominoes.get(i))) {
                    int linkInteger = ordered.get(ordered.size() - 1).getRightSide();
                    int candidate = dominoes.get(i).getLeftSide();
                    if (linkInteger == candidate) {
                        ordered.add(dominoes.get(i));
                    }
                }
            }
        }
        return ordered;
    }
}
