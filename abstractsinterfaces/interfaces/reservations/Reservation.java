package interfaces.reservations;

public class Reservation implements Reservable{
    private String code;
   private DOW dow;

    public Reservation(){}

    public Reservation(DOW day){
        this.dow = day;
        this.code = generateCode();
    }
    @Override
    public String getBookingDow(){
        return dow.toString();
    }
    @Override
    public String getBookingCode(){
        return code;
    }

    private String generateCode(){
        char[] digits = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z', '1','2','3','4','5','6','7','8','9'};
        int codelength = 8;
        char [] codeArr = new char[codelength];
        for (int i=0; i<codelength; i++) {
            int random = (int) (Math.random() * digits.length);
            codeArr[i]=digits[random];
        }

        return new String(codeArr);

    }

    @Override
    public String toString(){
        return "Booking# ".concat(code).concat(" for ").concat(dow.toString());
    }
}
