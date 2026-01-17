package minecraft;

import java.util.ArrayList;
import java.util.List;

public class Element {
    protected Elements element;
    protected String color;
    protected int lightTransmission;
    protected boolean canBeCrossed;
    private List<Elements> adjacent;


    public Element(){}

    public Element(Elements element, String color, int light, boolean crossable){
        this.element = element;
        this.color = color;
        this.lightTransmission = light;
        this.canBeCrossed = crossable;
        adjacent = new ArrayList<>();
    }


    public Elements getElement(){return element;}
    public String getColor(){return color;}
    public int getLightTransmission(){return lightTransmission;}
    public boolean canBeCrossed(){return canBeCrossed;}
    public List<Elements> getAdjacent(){ return new ArrayList<>(adjacent);
    }

    public void setElement(Elements element){ this.element = element;}
    public void setColor(String color){ this.color = color;}
    public void setLightTransmission(int light){ this.lightTransmission = light;}
    public void setCanBeCrossed(boolean crossable){ this.canBeCrossed = crossable;}
    public void addElements(List<Elements> elements){
        adjacent.addAll(elements);
    }

}
