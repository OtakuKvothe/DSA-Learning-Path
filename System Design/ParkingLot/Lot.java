package ParkingLot;

import java.util.HashMap;

public class Lot {
    
    private String lotID;
    HashMap<Integer, Floor> floors;
    int n;

    public Lot(int floors, int slots, String id) {
        this.floors = new HashMap<Integer, Floor>();
        for(int i=1; i<=floors; i++) {
            this.floors.put(i, new Floor(slots));
        }
        this.lotID = id;
        this.n = floors;
    }

    
}
