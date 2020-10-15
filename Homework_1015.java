package homework;
import java.util.*;

public class Homework_1015 {
	/* Homework 6.4
	 * Get a number from user and give the reversed number
	 * eg. input:3456 output:6543
	 */
	public static void reverse(int number) {
		String nums = number + "";
		int length = nums.length();
		int newNum = 0;
		for (int i = length -1; i >= 0; i--) {
			int pos = number % 10;
			newNum += pos*Math.pow(10, i);
			number /= 10;
		}
		System.out.println(newNum);
	}
	
	/* Homework 6.17
	 * Generate a n-order matrix
	 * in which n is got from user 
	 * and the elements are randomly generated 0 and 1
	 */
	public static void printMatrix(int n) {
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(Math.round(Math.random()) + "\t");
			}
			System.out.print("\n");
		}
	}
	
	/* Homework 7.7
	 * Generate 100 integers between 0-9
	 * count each number's frequency
	 */
	public static void countNums() {
		int[] nums = new int[100];
		int[] count = new int[10];
		for(int i = 0; i<100; i++) {
			nums[i] = (int)(Math.random() * 10);
			count[nums[i]] += 1;
		}
		System.out.println(Arrays.toString(nums));
		System.out.println("number\tfrequency");
		for (int j = 0; j < 10; j++) {
			System.out.println(j+"\t"+count[j]);
		}
	}
	
	/* Homework 7.10
	 * For a given list, return the index of the minimum
	 */
	public static int indexOfSmallestElement(double[] array) {
		double min = array[0];
		int index = 0;
		for(int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				index = i;
			}else {
			}
		}
		return index;
	}
	
	/* 8.2
	 * Input a 4-ordered matrix, calculate the summary of diagonal elements
	 */
	public static double sumMajorDiagonal(double[][] m) {
		double sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += m[i][i];
		}
		return sum;
	}
	
	/* main function
	 * Set a 'switch' structure, input the number of the task to run the corresponding program
	 */
	public static void main(String arg[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input task number(seperated by ENTER): ");
		int choose_1 = input.nextInt();
		int choose_2 = input.nextInt();
		switch (choose_1) {
			case 6:
				switch (choose_2) {
					case 4:
						// 6.4
						System.out.print("Please input an Integer: ");
						int received_4 = input.nextInt();
						reverse(received_4);
						break;
					case 17:
						// 6.17
						System.out.print("Please input an Integer: ");
						int received_17 = input.nextInt();
						printMatrix(received_17);
						break;
					default:
						System.out.println("No such task!");
						break;
				}
				break;
			case 7:
				switch (choose_2) {
					case 7:
						// 7.7
						countNums();
						break;
					case 10:
						// 7.10
						double[] array = new double [10];
						for(int i = 0; i < 10; i++) {
							System.out.print("Please input a number:(" + (10-i) +" left) ");
							double num = input.nextDouble();
							array[i] = num;
						}
						int index = indexOfSmallestElement(array);
						System.out.println("The index of the minimum number is: " + index);
						break;
					default:
						System.out.println("No such task!");
						break;
				}
				break;
			case 8:
				// 8.2
				double[][] m = new double[4][4];
				System.out.println("Enter a 4-by-4 matrix row by row: ");
				String clear = input.nextLine();
				for(int i = 0; i < 4; i++) {
					String inputString = input.nextLine();
					String[] line = (inputString).split(" ");
					for (int j = 0; j < 4; j++) {
						m[i][j] = Double.parseDouble(line[j]);
					}
				}
				System.out.println("Sum of the elements in the major diagnol is "+ sumMajorDiagonal(m)); 
				break;
			default:
				System.out.println("No such task!");
				break;
		}
	}

}
