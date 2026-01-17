package minecraft;

public enum Quality {
   ONE(1), TWO(2), THREE(3);

   private int level;

    Quality(int level){
       this.level = level;
   }

public int getLevel(){
       return level;
}
}
