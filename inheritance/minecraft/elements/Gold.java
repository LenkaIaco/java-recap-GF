package minecraft.elements;

import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;

import java.util.List;

public class Gold extends Block{
    public Gold(int transmission){
        super(
                new Element(Elements.GOLD, "gold", transmission, false)
        );

        super.getElement().addElements(List.of(
                Elements.GLOWSTONE, Elements.GLASS
        ));
    }


}
