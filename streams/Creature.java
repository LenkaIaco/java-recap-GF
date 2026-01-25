public class Creature {

    String name;
    double weight;
    int height;
    String gender;
    double age;

    Creature(String name, double weight, int height, String gender, double age) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return  name.concat(":\nWeight ")
                .concat(String.valueOf(weight).concat(", "))
                .concat("Height ").concat(String.valueOf(height)).concat(", ")
                .concat("Gender ").concat(gender).concat(", ")
                .concat("Age ").concat(String.valueOf(age));
    }

    //getters, setters:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }


}
