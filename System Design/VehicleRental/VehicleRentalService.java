package VehicleRental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class VehicleRentalService implements RentalService {

    private HashMap<String, Branch> branches;

    public VehicleRentalService() {
        branches = new HashMap<>();
    }
    
    public boolean addBranch(String branchName) {
        if(branches.containsKey(branchName)) return false;
        Branch newBranch = new Branch();
        branches.put(branchName, newBranch);
        return true;
    }

    public boolean allocatePrice(String branchName, String vehicleType, Integer price) {
        VehicleType type = VehicleUtil.vehicleTypeFromString(vehicleType);
        if(type == null || !branches.containsKey(branchName)) return false;

        branches.get(branchName).allocatePrice(type, price);
        return true;
    }

    public boolean addVehicle(String vehicleID, String vehicleType, String branchName) {
        VehicleType type = VehicleUtil.vehicleTypeFromString(vehicleType);
        if(type == null || !branches.containsKey(branchName)) return false;

        branches.get(branchName).addVehicle(type, vehicleID);
        return true;
    }

    public boolean bookVehicle(String vehicleType, Integer startTime, Integer endTime) {
        VehicleType type = VehicleUtil.vehicleTypeFromString(vehicleType);
        if(type == null) return false;

        for(Branch branch: this.getSortedBranchListForType(type)) {
            if(branch.bookVehicle(type, startTime, endTime)) {
                return true;
            }
        }

        return false;
    }

    private List<Branch> getSortedBranchListForType(VehicleType type) {
        PriorityQueue<Branch> pq = new PriorityQueue<>((a, b) -> a.getPriceForType(type) - b.getPriceForType(type));
        for(Branch branch: branches.values()) {
            if(branch.hasVehicleOfType(type) && branch.getPriceForType(type) > 0) {
                pq.add(branch);
            }
        }
        List<Branch> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
}
