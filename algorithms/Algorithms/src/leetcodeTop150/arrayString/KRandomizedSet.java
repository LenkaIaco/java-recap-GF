package leetcodeTop150.arrayString;
import java.util.*;

public class KRandomizedSet {
    Set<Integer> set;

    public KRandomizedSet(){
        set = new HashSet<>();
    }


    public boolean insert(int val) {
        if (!set.contains(val)){set.add(val); return true;}
        else {return false;}
    }

    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        } else {return false;}
    }

    public int getRandom() {
        int random = (int) (Math.random()*set.size());
        int counter = 0;
        Integer igr = null;
        for (Integer i : set){
            if (counter==random){
                return i;
            }
            else{counter++;}
        }
        return igr;
    }
}
