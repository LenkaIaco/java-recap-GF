package aircraftCarrier;

import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier {
    private List<Aircraft> aircrafts;
    private int ammoStore;
    private int health;
    int damage;

    public AircraftCarrier(int ammo, int health) {
        aircrafts = new ArrayList<>();
        ammoStore = ammo;
        this.health = health;
    }

    public int getAmmoStore() {return ammoStore;}
    public int getHealth() {return health;}
    public int getDamage() {return damage;}
    public List<Aircraft> getAircrafts(){
        return new ArrayList<Aircraft>(aircrafts);
    }

    public void setAmmoStore(int ammoStore) { this.ammoStore = ammoStore;}
    public void setHealth(int health) { this.health = health;}
    public void setDamage(int damage) {this.damage = damage;}

    public void add(Aircraft aircraft) {
        aircrafts.add(aircraft);
        damage = damage + aircraft.baseDamage;
    }

    public void fill() throws UnsupportedOperationException {
        if (ammoStore==0){throw new UnsupportedOperationException("Filling impossible, 0 ammunition");}
        int totalNeeded = 0;

        for (Aircraft a : aircrafts) {
            totalNeeded = totalNeeded + a.getAmmoSpace();
        }

        if (totalNeeded > ammoStore) {
             refillOnShortage();
        } else { refillOnAbundance(); }

    }

    public void fight(AircraftCarrier another){

          for (int i=0; i<aircrafts.size();i++){
              Aircraft a = aircrafts.get(i);
              if (another.aircrafts.size()-1>=i) {
                  Aircraft a2 = another.aircrafts.get(i);
                  if (another.health > 0) {
                      int damageCaused = a.fight();
                      a.damage = a.damage + damageCaused;
                      damage = damage + damageCaused;
                      another.health = another.health - damageCaused;
                      if (another.health < 0) {
                          another.health = 0;
                          break;
                      }
                  } else {
                      break;
                  }
              } else {break;}
        }
    }

    public String getStatus(){
        String result = "";
        if (health==0){result = "It's dead Jim :( \n" ;
            result =  result + "HP: ".concat(String.valueOf(health)).concat(", Aircraft count: ")
                    .concat(String.valueOf(aircrafts.size())).concat(", Ammo Storage: ")
                    .concat(String.valueOf(ammoStore)).concat(", Total damage: ").concat(String.valueOf(damage))
                    .concat(" Aircrafts:\n");}
        else {
            result = "HP: ".concat(String.valueOf(health)).concat(", Aircraft count: ")
                    .concat(String.valueOf(aircrafts.size())).concat(", Ammo Storage: ")
                    .concat(String.valueOf(ammoStore)).concat(", Total damage: ").concat(String.valueOf(damage))
                    .concat(" Aircrafts:\n");

            for (Aircraft a : aircrafts) {
                result = result.concat(a.getStatus()).concat("\n");
            }
        }
        return result;
    }

    public void refillOnShortage() {
        for (Aircraft a : aircrafts) {
            if (ammoStore > 0) {
                if (a.priority) {
                    ammoStore = a.refillAmmo(ammoStore);
                }
            } else {
                break;
            }
        }
        for (Aircraft a2 : aircrafts) {
            if (ammoStore > 0) {
                if (!a2.priority) {
                    ammoStore = a2.refillAmmo(ammoStore);
                }
            } else{
                break;
            }
        }
    }

    public void refillOnAbundance(){
        for (Aircraft a: aircrafts){
            if (ammoStore>0){
                ammoStore = a.refillAmmo(ammoStore);
            } else{
                break;
            }
        }
    }
}