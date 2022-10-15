package ParkingLot.strategy;

import java.util.List;

import ParkingLot.Type;
import ParkingLot.exceptions.FloorFilledException;
import ParkingLot.exceptions.InvalidSlotException;

public interface Strategy {
    public String park(Type type, String regNo, String color) throws FloorFilledException;
    public String unpark(int slot) throws InvalidSlotException;
    public List<Integer> freeSlotsForType(Type type);
    public int freeCountForType(Type type);
    public List<Integer> occupiedSlots(Type type);
}
