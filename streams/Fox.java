public class Fox {
    private String name;
    private String color;
    private int age;
    public Fox(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return name.concat(": color ").concat(color).concat(", age ").concat(String.valueOf(age));
    }
}
