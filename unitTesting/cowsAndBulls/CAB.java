package unitTesting.cowsAndBulls;

import java.util.HashMap;
import java.util.Scanner;

public class CAB {
    private String myGuess;
   private HashMap<String, Integer> countCAB;
   private boolean playing;
   private int counter;


    public CAB() {
        countCAB = new HashMap<>();
        myGuess = "";
    }


    public String run(Scanner scanner) {

        setupNewGame();

        loopPlaying(scanner);

        return finalizeGame();

    }

    public void setupNewGame(){
        playing = true;
        myGuess = "";
        for (int i = 0; i<4; i++){
            int digit = (int) (Math.random() * 10);
            myGuess = myGuess.concat(String.valueOf(digit));
        }
        countCAB.put("cow",0);
        countCAB.put("bull",0);
    }    

    public String finalizeGame(){
        String result = "Game result: " + printResult();
        System.out.println(result);
        return result;
    }

    public void loopPlaying(Scanner scanner){
        while (playing) {
            String consent = checkConsent(scanner);

            if (consent.equals("y") || consent.equals("Y")) {
                String number = checkNumber(scanner);
                game(number);
            } else {
                playing = false;
            }
        }
    }
    
    public String checkConsent( Scanner scanner){
        System.out.println("Type 'Y' to start the guessing round. To end playing, press 'N'.");
        String consent = scanner.nextLine();
        consent = consent.trim();

        while (!consent.equals("N") && !consent.equals("Y") && !consent.equals("n") && !consent.equals("y")) {

            System.out.println("Command: '"+consent+"' not valid. Type 'Y' to continue / 'N' to end the game.");
            consent = scanner.nextLine();
            consent = consent.trim();

        }

        return consent;
    }

    public String checkNumber(Scanner scanner){
        System.out.println("Try guessing a 4 digit number. Type in your guess.");
        String number = scanner.nextLine();
        number = number.trim();

        while (number.length()!=4 || !onlyDigits(number)){
            System.out.println("Your input must be a valid 4-digit number. Re-type your guess.");
            number = scanner.nextLine();
            number = number.trim();
        }
        
        return number;
    }
    
    
    public String game(String number) {
        countCAB.put("cow",0);
        countCAB.put("bull",0);
        counter+=1;

        for (int i=0; i<number.length(); i++){
            if (myGuess.charAt(i)==number.charAt(i)){
                int updatedCount = countCAB.get("cow") + 1;
                countCAB.put("cow", updatedCount);
            } else{
                int updatedCount = countCAB.get("bull")+1;
                countCAB.put("bull", updatedCount);
            }
        }

        String result = printResult();
        System.out.println(result);
        return result;
    }






    public boolean onlyDigits(String number){
        boolean onlyDigits = true;
        String digits = "0123456789";
        for(int i=0; i<number.length();i++){
            if(!digits.contains(String.valueOf(number.charAt(i)))){
                onlyDigits = false;
            }
        }
        return onlyDigits;
    }


    public String getMyGuess(){
        return myGuess;
    }

    public HashMap<String, Integer> getCountCAB(){
        return (HashMap<String, Integer>) countCAB.clone();
    }

    public int getCounter(){
        return counter;
    }

    public boolean isPlaying(){return playing;}

    public String printResult() {
        return countCAB.get("cow") + " cow, " + countCAB.get("bull") + " bull";
    }
}
