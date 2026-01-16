package usinginterfaces.implementCharSequence;

public class Main {
    public static void main(String[] args) {
        Gnirts gnirts = new Gnirts("example");
        System.out.println(gnirts.charAt(1));

        ShiftedCharSequence shifted = new ShiftedCharSequence("example", 2);
        System.out.println(shifted.charAt(0));
    }
}
