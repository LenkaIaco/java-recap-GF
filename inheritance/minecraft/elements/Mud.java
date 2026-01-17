package minecraft.elements;

import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;

import java.util.List;

public class Mud extends Block {
    public Mud(){
        super(
                new Element(Elements.MUD,"dark gray",0, false)
        );

       super.getElement().addElements(
               List.of(Elements.BRICK, Elements.AIR, Elements.LAVA, Elements.DOOR, Elements.WINDOW, Elements.GOLD)
       );
    }



}
