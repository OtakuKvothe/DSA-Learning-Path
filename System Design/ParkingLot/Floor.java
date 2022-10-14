package ParkingLot;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.TreeSet;

import ParkingLot.exceptions.FloorFilledException;
import ParkingLot.exceptions.InvalidSlotException;

public class Floor {
    
    private EnumMap<Type, TreeSet<Integer>> slots;
    Vehicle[] vehicles;
    private int n;

    public Floor(int n) {
        this.n = n;
        slots = new EnumMap<>(Type.class);
        TreeSet<Integer> cars = new TreeSet<>();
        for(int i=4; i<=n; i++) {
            cars.add(i);
        }
        TreeSet<Integer> bikes = new TreeSet<>();
        for(int i=2; i<=Math.min(3, n); i++) {
            bikes.add(i);
        }
        TreeSet<Integer> trucks = new TreeSet<>();
        if(n>0) trucks.add(1);
        slots.put(Type.CAR, cars);
        slots.put(Type.BIKE, bikes);
        slots.put(Type.TRUCK, trucks);

        this.vehicles = new Vehicle[n];
    }

    public String park(Type type, String regNo, String color) throws FloorFilledException {
        if(slots.get(type).isEmpty()) throw new FloorFilledException();
        int slot = slots.get(type).first();
        slots.get(type).remove(slot);
        vehicles[slot-1] = new Vehicle(regNo, color);
        return ""+slot;
    }

    public String unpark(int slot) throws InvalidSlotException {
        if(slot < 1 || slot > n || vehicles[slot-1] == null) throw new InvalidSlotException();
        if(slot == 1) {
            slots.get(Type.TRUCK).add(1);
        } else if(slot <= 3) {
            slots.get(Type.BIKE).add(slot);
        } else {
            slots.get(Type.CAR).add(slot);
        }
        String vehicle = "Registration Number: "+vehicles[slot-1].regNo+" and Color: "+vehicles[slot-1].color;
        vehicles[slot-1] = null;
        return vehicle;
    }

    public List<Integer> freeSlotsForType(Type type) {
        List<Integer> res = new ArrayList<>();
        for(Integer slot: slots.get(type)) {
            res.add(slot);
        }
        return res;
    }

    public int freeCountForType(Type type) {
        return slots.get(type).size();
    }

    public List<Integer> occupiedSlots(Type type) {
        List<Integer> res = new ArrayList<>();
        if(type == Type.TRUCK) {
            if(vehicles[0] != null) res.add(1);
        } else if(type == Type.BIKE) {
            for(int i=1; i<=2; i++) {
                if(vehicles[i] != null) res.add(i+1);
            }
        } else {
            for(int i=3; i<n; i++) {
                if(vehicles[i] != null) res.add(i+1);
            }
        }
        return res;
    }
}
