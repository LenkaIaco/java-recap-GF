package minecraft;

import minecraft.elements.*;

/*
Air: created with no parameters
Brick: created with dark-gray color
Door: created with quality 2, producer 'Mordor', color black and light transmission 60
Glass: light transmission 80
GlowStone: no parameters
Window: quality 1, producer 'Liliput', color white, light transmission 70, can be crossed: true
Window: quality 2, producer 'Asgard', color light-gray, light transmission 90, can be crossed: true
Mud: no parameters
Gold: light transmission 50
Lava: no parameters
GlowStone: no parameters
Ice: no parameters
Lava: no parameters
Gold: light transmission 30
Ice: no parameters
 */
/*
Add the following new blocks to the wall using the placeBlock() method
Calculate and print the light transmission of the wall
Print the status of the wall
Expected print result ...
 */
public class Main {
    public static void main(String[] args) {
        Wall wall = new Wall();

        Air air = new Air();
        wall.placeBlock(air);
        Brick brick = new Brick("dark-gray");
        wall.placeBlock(brick);
        Door door = new Door("black",60,"Mordor",Quality.TWO);
        wall.placeBlock(door);
        Glass glass = new Glass();
        glass.getElement().setLightTransmission(80);
        wall.placeBlock(glass);
        Glowstone glowstone1 = new Glowstone();
        wall.placeBlock(glowstone1);
        Window window1 = new Window("white",70,true,"Liliput",Quality.ONE);
        wall.placeBlock(window1);
        Window window2 = new Window("light-gray",90,true,"Asgard",Quality.TWO);
        wall.placeBlock(window2);
        Mud mud = new Mud();
        wall.placeBlock(mud);
        Gold gold1 = new Gold(50);
        wall.placeBlock(gold1);
        Lava lava1 = new Lava();
        wall.placeBlock(lava1);
        Glowstone glowstone2 = new Glowstone();
        wall.placeBlock(glowstone2);
        Ice ice1 = new Ice();
        wall.placeBlock(ice1);
        Lava lava2 = new Lava();
        wall.placeBlock(lava2);
        Gold gold2 = new Gold(30);
        wall.placeBlock(gold2);
        Ice ice2 = new Ice();
        wall.placeBlock(ice2);

        System.out.println("Light transmitted: ".concat(String.valueOf(wall.calculateLightTransmission())));
        wall.printStatus();
    }
}
