//https://leetcode.com/problems/count-collisions-on-a-road
public class CountCollisionsOnARoad {
    public int countCollisions(String dir) {
        int r = 0, c = 0, i = 0;
        while (i < dir.length() && dir.charAt(i) == 'L')
            i++;

        for (; i < dir.length(); i++) {
            if (dir.charAt(i) == 'R')
                r++;
            else {
                c += dir.charAt(i) == 'S' ? r : r + 1;
                r = 0;
            }
        }

        return c;
    }
}
