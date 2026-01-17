package minecraft.elements;

import minecraft.Element;
import minecraft.Elements;
import minecraft.Block;

import java.util.List;
// mud, brick, glass, door, window, gold
public class Air extends Block{
    public Air (){
        super(
                new Element(Elements.AIR, "transparent", 100, true)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.BRICK,Elements.GLASS,Elements.DOOR,Elements.WINDOW,Elements.GOLD
        ));
    }
}
