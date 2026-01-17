package minecraft.elements;

import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;
import minecraft.Transformative;

import java.util.List;
public class Ice extends Block implements Transformative {
    private int transformations;
    public Ice(){
        super(
                new Element(Elements.ICE,"transparent",97, false)
        );

        super.getElement().addElements(
                List.of(Elements.MUD, Elements.BRICK, Elements.GLASS, Elements.LAVA, Elements.AIR, Elements.GLOWSTONE)
        );

        super.setTransformative(true);
    }

    @Override
    public Block transform(Block another){
        Block result = another;
        if  (another.getElement().getElement().equals(Elements.LAVA)){
            result = new Glass();
            transformations++;
        }
        return result;
    }
    @Override
    public String transformStatus(){
       return transformations>0 ?
                "Has transformed a block of type lava to glass" : "Made no transformation";
    }

    @Override
    public void printStatus(){
       super.printStatus();
        System.out.println(transformStatus());
    }

}
