package minecraft;

public abstract class Block {
    protected Element element;
    protected boolean isTransformative;

    public Block(){}

    public Block(Element type) {
        this.element = type;
    }

    public boolean canPlaceAfter(Block b){
        return element.getAdjacent().contains(b.getElement().getElement());
    }
    public int getTransmission(){return element.getLightTransmission();}
    public Element getElement(){return element;}
    public String getColor(){return element.getColor();}
    public boolean canBeCrossed (){return element.canBeCrossed();}
    public boolean isTransformative() {return isTransformative;}

    public void setTransformative(boolean b){isTransformative = b;}

    public void printStatus(){
        String result = "Block of type: ".concat(element.getElement().toString().toLowerCase()).concat("\nTransmission: ")
                .concat(String.valueOf(getTransmission())).concat("%\n")
                .concat(canBeCrossed() ? "Can be crossed." : "Cannot be crossed.");
        System.out.println(result);
    }
    
}
