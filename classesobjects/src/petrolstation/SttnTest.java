package petrolstation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SttnTest {

    Sttn station = new Sttn(100);
    Cr car = new Cr();

    @Test
    public void refillDecreasesGasAmtCorrectly(){
        int carCapacity = car.getCapacity() - car.getGasAmount();
        int stationGasBefore = station.getGasAmount();

        int stationGasFuture = carCapacity > station.getGasAmount() ?
                station.getGasAmount() : station.getGasAmount()-carCapacity;

        station.refillCar(car);

        int stationGasResult = station.getGasAmount();

        assertEquals(stationGasResult, stationGasFuture);
    }

    @Test
    public void refillIncreasesCarAmountByStationCapacity(){
        int stationAmt = 1;
        station.setGasAmount(stationAmt);
        int carGasBefore = car.getGasAmount();
        station.refillCar(car);

        assertEquals(car.getGasAmount(), carGasBefore+stationAmt);

    }


}
