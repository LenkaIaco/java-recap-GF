package minecraft.elements;

import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;

import java.util.List;
public class Glass extends Block {
    public Glass(){
        super(
                new Element(Elements.GLASS, "transparent", 99, false)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.BRICK,Elements.ICE,Elements.AIR,Elements.GLOWSTONE,Elements.DOOR
        ));
    }

    public Glass(String color, int transmission){
        super(
                new Element(Elements.GLASS, color, transmission, false)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.BRICK,Elements.ICE,Elements.AIR,Elements.GLOWSTONE,Elements.DOOR
        ));
    }

}
