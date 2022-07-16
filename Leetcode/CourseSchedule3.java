import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/course-schedule-iii

public class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int currTime = 0;
        for(int[] curr: courses) {
            if(curr[0] + currTime <= curr[1]) {
                currTime += curr[0];
                q.add(curr[0]);
            } else if(!q.isEmpty() && q.peek() > curr[0]) {
                currTime += curr[0] - q.poll();
                q.add(curr[0]);
            } 
        }
        return q.size();
    }
}
