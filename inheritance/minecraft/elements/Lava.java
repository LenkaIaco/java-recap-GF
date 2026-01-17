package minecraft.elements;
import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;
import minecraft.Transformative;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lava extends Block implements Transformative {
    Set<Elements> transformed;
    int transformations;
    public Lava(){
        super(
                new Element(Elements.LAVA, "yellow", 170, false)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.BRICK,Elements.GLASS,Elements.AIR,Elements.ICE,Elements.GLOWSTONE
        ));
        transformed = new HashSet<>();
        super.setTransformative(true);
    }

    @Override
    public Block transform(Block another){
        Block result = another;
        if  (another.getElement().getElement().equals(Elements.ICE)){
            transformed.add(Elements.ICE);
            result = new Air();
            transformations++;
        }else if(another.getElement().getElement().equals(Elements.MUD)){
            transformed.add(Elements.MUD);
            result = new Brick();
            transformations++;
        }
        return result;
    }

    @Override
    public String transformStatus(){
        if (transformations == 0 ){return  "Made no transformation";}
        String result = "";
        if(transformed.contains(Elements.AIR)) {
            if (!transformed.contains(Elements.MUD)) {
                result = "Has transformed a block of type ice to air";
            }else {result = "Has transformed a block of type ice to air and type mud to brick";}
        } else{
            result = "Has transformed a block of type mud to brick";
        }
        return result;
    }

    @Override
    public void printStatus(){
        super.printStatus();
        System.out.println(transformStatus());
    }
}
