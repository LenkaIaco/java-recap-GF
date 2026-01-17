package minecraft;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    List<Block> blocks;

    public Wall() {
        blocks = new ArrayList<>();
    }

    public void placeBlock(Block b) {
        if (blocks.size() == 0) {
            blocks.add(b);
        } else {
            Block previous = blocks.get(blocks.size() - 1);
            if (b.canPlaceAfter(previous)) {
                blocks.add(b);

                if (b.isTransformative()) {
                    Transformative transformativeB = (Transformative) b;
                    Block result = transformativeB.transform(previous);
                    blocks.set(blocks.size() - 1 - 1, result);
                }
            }
        }
    }


    public int calculateLightTransmission(){
        int transmissionTotal = 0;
        for (Block b: blocks){
            transmissionTotal += b.getTransmission();
        }
        int average = transmissionTotal/blocks.size();
        return average;
    }

    public void printStatus() {
        if (blocks.size() != 0) {
            for (Block b : blocks) {
                b.printStatus();
                System.out.println();
            }
        }
    }

}
