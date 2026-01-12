package petrolstation;

public class Cr {
   private int gasAmount;
   private int capacity;

   public Cr(){
       gasAmount = 0;
       capacity = 100;
   }

   public int getGasAmount(){
     return gasAmount;
   }
   public int getCapacity(){
       return capacity;
   }
   public void setGasAmount(int amt){
       gasAmount=+amt;
       if (gasAmount>capacity){
           gasAmount = capacity;
       }
   }
}
