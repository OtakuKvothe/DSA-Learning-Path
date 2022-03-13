//https://leetcode.com/problems/minimum-time-to-complete-trips/
public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] times, int tot) {
        long minTime = 1, maxTime = (long)1e14;
        while(minTime < maxTime){
            long mid = minTime + (maxTime - minTime)/2;
            if(numberOfTripsGivenTime(times, mid) < tot){
                minTime = mid + 1;
            }else{
                maxTime = mid;
            }
        }
        return minTime;
    }
    
    public long numberOfTripsGivenTime(int[] times, long givenTime){
        long trips = 0;
        for(int time: times){
            trips += givenTime/time;
        }
        return trips;
    }
}
