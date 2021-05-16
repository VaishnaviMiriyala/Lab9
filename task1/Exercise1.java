package m11.task1;

import java.util.Scanner;

interface Power{
	public double doPower(int x, int y);
}
public class Exercise1 {

	public static void main(String[] args) {
		Exercise1 obj = new Exercise1();
		obj.doPower();
	}
	void doPower() {
		Power p = (x,y) -> Math.pow(x, y);
		System.out.println("Enter the x and y values:");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		double res = p.doPower(x,y);
		System.out.println(res);
		
	}

}
