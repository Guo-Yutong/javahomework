package homework;
import java.util.*;
public class TestDate {
	/*
	Date d1 = new Date(10000);
	Date d2 = new Date(100000);
	Date d3 = new Date(1000000);
	Date d4 = new Date(10000000);
	Date d5 = new Date(100000000);
	Date d6 = new Date(1000000000);
	Date d7 = new Date(10000000000);
	Date d8 = new Date(100000000000);
	*/
	public static void main(String args[]) {
		for(int i = 1; i<=8; i++) {
			long passedTime = (long)Math.pow(10, i+3);
			Date d = new Date(passedTime);
			System.out.println(passedTime + ": " +d.toString());
		}
	}
}
