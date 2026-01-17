package minecraft.elements;
import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;
import minecraft.Transformative;

import java.util.List;

public class Glowstone extends Block implements Transformative {

    private int transformations;

    public Glowstone(){
        super(
                new Element(Elements.GLOWSTONE, "white", 300, false)
        );

        super.getElement().addElements(List.of(
        Elements.GLASS, Elements.ICE,Elements.AIR,Elements.LAVA
        ));

        super.setTransformative(true);
    }

    @Override
    public Block transform(Block another){
        Block result = another;
      if  (another.getElement().getElement().equals(Elements.GLASS)){
          result = new Gold(160);
          transformations++;
      }
      return result;
    }

    @Override
    public String transformStatus(){
       return transformations>0 ?
                "Has transformed a block of type glass to gold" : "Made no transformation";
    }

    @Override
    public void printStatus(){
        super.printStatus();
        System.out.println(transformStatus());
    }


}
