package fleetofthings;

public class Thing {
    private String name;
    private boolean completed;

    public Thing(String name){
        this.name = name;
    }

    public void complete(){
        completed = true;
    }

    @Override
    public String toString(){
        String status = completed ? "[x]" : "[ ]";
        String s = "";
    return  s.concat(status).concat(" ").concat(name);
    }

}
