package interfaces.comparable;


public class Todo implements Comparable<Todo> {
   private String task;
   private String priority;
   private boolean done;

   protected Todo(){}

    public Todo(String task, String priority, boolean done) {
        this.task = task;
        this.priority = priority;
        this.done = done;
    }

        @Override
        public int compareTo (Todo other){
           int result = 0;
           if (task.equals(other.getTask())) {result = 1;} else {return result;}
           if (!priority.equals(other.getPriority())) {result = 0; return result;}
           if (!done==other.getDone()){result = 0; return result;}
           return result;
        }


    public String getTask() {
        return task;
    }

    public String getPriority() {
        return priority;
    }

    public boolean getDone() {
        return done;
    }

    @Override
    public String toString(){
        return "Task : ".concat(task).concat(", priority: ").concat(priority).concat(", done? ").concat(String.valueOf(done));
    }
}





