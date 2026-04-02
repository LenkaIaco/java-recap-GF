package designGurus;

import java.util.LinkedList;
import java.util.Queue;

public class StackTwQ {
    private Queue<Integer> queue;
    private Queue<Integer> aux;

    public StackTwQ(){
        queue = new LinkedList<>();
        aux = new LinkedList<>();
    }

   public void push(int x){
       queue.add(x);
   }
    public Integer pop(){
        Integer result = 0;
        this.makeAux();
        result = queue.poll();
       refill();
        return result;
    }
    public Integer top(){
        this.makeAux();
        Integer result = queue.peek();
        refill();
        return result;
    }

    public boolean empty(){
        return queue.size() == 0;
    }
    private Queue<Integer> makeAux(){
        while(queue.size()>1){
            aux.add(queue.poll());
        }
        return aux;
    }
    private void refill(){
        while (aux.size()>0){
            queue.add(aux.poll());
        }
    }
}
