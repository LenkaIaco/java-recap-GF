package designGurus;

import java.util.*;

public class TwoListsSolution {
    List<Integer> l;
    int pointer;

    public TwoListsSolution(List<Integer> l1, List<Integer> l2) {
        l = new ArrayList<>();
        pointer = 0;
        if (l1.size() == 0) {
            l = l2;
        }
        if (l2.size() == 0) {
            l = l1;
        }
        if (l1.size() != 0 && l2.size() != 0) {
            int i = 0;
            int y = 0;
            while (i < l1.size()) {
                l.add(l1.get(i));
                i++;
                if (y < l2.size()) {
                    l.add(l2.get(y));
                    y++;
                }
            }

            while (y < l2.size()) {
                l.add(l2.get(y));
                y++;
            }
        }
    }

    public int next() {
        int curr = l.get(pointer);
        pointer++;

        return curr;
    }

    public boolean hasNext() {
        return pointer < l.size();
    }
}
