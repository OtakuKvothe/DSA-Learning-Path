package ParkingLot;

import java.util.List;

import ParkingLot.exceptions.FloorFilledException;
import ParkingLot.exceptions.InvalidSlotException;
import ParkingLot.strategy.Strategy;

public class Floor {
    int n;
    Strategy strategy;

    public Floor(int n, Strategy strategy) {
        this.n = n;
        this.strategy = strategy;
    }

    public String park(Type type, String regNo, String color) throws FloorFilledException {
        return strategy.park(type, regNo, color);
    }

    public String unpark(int slot) throws InvalidSlotException {
        return strategy.unpark(slot);
    }

    public List<Integer> freeSlotsForType(Type type) {
        return strategy.freeSlotsForType(type);
    }

    public int freeCountForType(Type type) {
        return strategy.freeCountForType(type);
    }

    public List<Integer> occupiedSlots(Type type) {
        return strategy.occupiedSlots(type);
    }
}
