package aircraftCarrier;


public abstract class Aircraft {
    protected String type;
    protected int maxAmmo;
    protected int baseDamage;
    protected int ammo;
    protected int damage;
    protected boolean priority;

    public Aircraft() {
    }

    public int fight() {
        int damageCaused = baseDamage * ammo;
        ammo = 0;
        damage = damage + damageCaused;
        return damageCaused;
    }

public int refillAmmo(int amt){
        int tryRefill = ammo+amt;
        int unused = 0;
        if (tryRefill>maxAmmo){
            int actuallyUsed = maxAmmo - ammo;
            unused = amt - actuallyUsed;
            tryRefill = maxAmmo;
        }
        ammo = tryRefill;
        return unused;
}

    public int getAmmoSpace(){
        return maxAmmo-ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getAmmo() {
        return ammo;
    }

    public String getType(){ return type; }

    public boolean isPriority(){ return priority; }


    protected void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    protected void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    protected void setAmmo(int ammo) {
        this.ammo = ammo;
    }



    public String getStatus(){
//        Type F35, Ammo: 10, Base Damage: 50, All Damage: 500
        return "Type ".concat(type).concat(", Ammo: ").concat(String.valueOf(ammo)).concat(", BaseDamage: ")
                .concat(String.valueOf(baseDamage)).concat(", All Damage: ").concat(String.valueOf(damage));
    }


}
