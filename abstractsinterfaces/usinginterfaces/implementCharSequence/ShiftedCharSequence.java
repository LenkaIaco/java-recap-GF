package usinginterfaces.implementCharSequence;

public class ShiftedCharSequence implements CharSequence{
    private String value;
    private int shiftBy;

    protected ShiftedCharSequence(){}
    public ShiftedCharSequence(String value, int shiftBy){
        this.value = value;
        this.shiftBy = shiftBy;
    }

    public String getValue(){
        return value;
    }
    @Override
    public char charAt(int index){
        return value.charAt(index+shiftBy);
    }

    @Override
    public int length(){
        return value.length();
    }

    @Override
    public CharSequence subSequence(int start, int end){
        return value.subSequence(start, end);
    }
}
