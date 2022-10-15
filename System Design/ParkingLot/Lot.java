package ParkingLot;

import java.util.HashMap;

import ParkingLot.strategy.EconomicalStrategy;
import ParkingLot.strategy.Strategy;

public class Lot {
    
    private String lotID;
    HashMap<Integer, Floor> floors;
    int n;

    public Lot(int floors, int slots, String id) {
        
        this.floors = new HashMap<Integer, Floor>();
        for(int i=1; i<=floors; i++) {
            Strategy strategy = new EconomicalStrategy(slots);
            this.floors.put(i, new Floor(slots, strategy));
        }
        this.lotID = id;
        this.n = floors;
    }

    
}
