package minecraft.elements;

import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;
import minecraft.Quality;

import java.util.List;

public class Door extends Block {
    private String producer;
    private Quality quality;

    public Door(String color,  int transmission, String producer, Quality quality){
        super(
                new Element(Elements.DOOR, color, transmission, true)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.BRICK,Elements.AIR,Elements.WINDOW
        ));

        this.producer = producer;
        this.quality = quality;
    }

    @Override
    public void printStatus(){
        super.printStatus();
        String addition = "Manufactured by: ".concat(producer)
                .concat(" on quality level ").concat(String.valueOf(quality.getLevel()));
        System.out.println(addition);
    }
}
