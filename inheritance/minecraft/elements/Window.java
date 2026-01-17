package minecraft.elements;
import minecraft.Block;
import minecraft.Element;
import minecraft.Elements;
import minecraft.Quality;

import java.util.List;

/*
quality: must be defined at creation (1, 2 or 3)
producer name: must be defined at creation
color: must be defined at creation
light transmission: must be defined at creation
can be crossed: must be defined at creation
 */
public class Window extends Block{
    private String producer;
    private Quality quality;
    public Window(String color, int transmission, boolean crossable, String producer, Quality quality){
        super(
                new Element(Elements.WINDOW, color, transmission, crossable)
        );

        super.getElement().addElements(List.of(
                Elements.MUD, Elements.BRICK,Elements.AIR,Elements.DOOR,Elements.GLOWSTONE
        ));

        this.producer = producer;
        this.quality = quality;
    }

    public Quality getQuality(){return quality;}
    public String getProducer(){return producer;}

    @Override
    public void printStatus(){
        super.printStatus();
      String  result = " Manufactured by: ".concat(producer)
                .concat(" on quality level ").concat(String.valueOf(quality.getLevel()));
        System.out.println(result);
    }
}
