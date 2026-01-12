package fleetofthings;

public class FleetOfThings {
    // - Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch
    public static void main(String[] args){
        String unticked = "[ ]";
        String ticked = "[x]";
        Thing milk = new Thing("Get milk");
        Thing obstacles = new Thing("Remove the obstacles");
        Thing up = new Thing("Stand up");
        Thing lunch = new Thing("Eat lunch");

        Fleet fleet = new Fleet();
        fleet.add(milk);
        fleet.add(obstacles);
        fleet.add(up);
        fleet.add(lunch);

        up.complete();
        lunch.complete();

//        for (int i=0; i<fleet.getFleet().size(); i++){
//            Th th = fleet.getFleet().get(i);
//            System.out.println(th.toString());
//        }
        System.out.println(fleet.toString());
    }
}
