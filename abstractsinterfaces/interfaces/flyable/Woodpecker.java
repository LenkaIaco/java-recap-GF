package interfaces.flyable;

import com.gfa.animals.Bird;

public class Woodpecker extends Bird implements Flyable {

public Woodpecker(){
    super("Woodpecker");
}
    @Override
    public String land(){
        return "Landing";
    }
    @Override
    public String fly(){
        return "Flying";
    }
    @Override
    public String takeoff(){
        return "Taking off";
    }

}
