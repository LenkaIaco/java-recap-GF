package counter;

public class Counter {
    private int init;
    private int counter;

    public int getCounter(){
        return counter;
    }
    public int getInit(){
        return init;
    }
    Counter(int i){
        counter = i;
        init = i;
    }

    Counter(){}

    public void add(){
        counter++;
    }
    public void add(int n){
        counter+=n;
    }

    public void reset(){
        counter = init;
    }


}
