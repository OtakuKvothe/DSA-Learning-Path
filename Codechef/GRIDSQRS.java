import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.awt.Point;

public class GRIDSQRS {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		try {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				char[][] grid = new char[n][n];
				int totalFrames = n*(n+1)*(2*n+1)/6;
				ArrayList<Point> zeroes = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					grid[i] = sc.next().toCharArray();
					for (int j = 0; j < grid[i].length; j++) {
						if (grid[i][j] == '0') {
							zeroes.add(new Point(i, j));
						}
					}
				}
				HashSet<Frame> notFrames = new HashSet<>();
				for (Point zero : zeroes) {
					int i = zero.x;
					int j = zero.y;
					notFrames.add(new Frame(zero, 1));
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

class Frame{
	Point p;
	int size;

	public Frame(int x, int y, int size){
		this.p = new Point(x, y);
	}

	public Frame(Point p, int size){
		this(p.x, p.y, size);
	}
}