package fleetofthings;
import java.util.ArrayList;
import java.util.List;
public class Fleet {
private List<Thing> fleet = new ArrayList<>();

public List<Thing> getFleet(){
    List<Thing> fleetCopy = new ArrayList<>();
    if (fleet.size()>0){
      for (int i=0; i<fleet.size(); i++){
        fleetCopy.add(fleet.get(i));
      }
    }
    return fleetCopy;
}

public void add(Thing thing){
    fleet.add(thing);
}

@Override
    public String toString(){
    String result = "";

    for (int i=0; i<fleet.size(); i++){
        String sI = fleet.get(i).toString();
      result = result.concat(sI).concat("\n");
    }
    return result;
}
}
