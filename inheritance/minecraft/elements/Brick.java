package minecraft.elements;

import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;

import java.util.List;

public class Brick extends Block {
    public Brick(){
        super(
                new Element(Elements.BRICK, "brown", 0, false)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.GLASS,Elements.AIR,Elements.DOOR,Elements.WINDOW
        ));
    }

    public Brick(String color){
        super(
                new Element(Elements.BRICK, color, 0, false)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.GLASS,Elements.AIR,Elements.DOOR,Elements.WINDOW
        ));
    }
}
