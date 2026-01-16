package usinginterfaces.implementCharSequence;

public class Gnirts implements CharSequence{
    private String value;

    public Gnirts(){value = "";}
    public Gnirts(String value){this.value = value;}

    /* although CharSequence has 4 abstract methods, toString() is implemented by all classes already,
    because it is inherited from Object class. Therefore, no need for @Override here.
     */
    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(length()-1-index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.subSequence(start,end);
    }

    public String getValue(){
        return value;
    }
}
