package homework;

import java.util.Arrays;

public class Course implements Cloneable{
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents ++;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void dropStudent(String student) {
		students[Arrays.binarySearch(students,student)] = null;
	}
	
	@Override	//重写方法，实现students数据域的深度拷贝
	public String[] clone() {
		return students.clone();
	}
	
	//测试用例
	public static void main(String args[]) {
		Course a = new Course("Java");
		Course b = new Course("Python");
		
		a.addStudent("小明");
		a.addStudent("小刚");
		a.addStudent("小红");
		
		b.students = a.clone();
		System.out.println("Java课原始学生: " + Arrays.toString(a.students));
		System.out.println("Python课原始学生: " + Arrays.toString(b.students));
		
		a.addStudent("小亮");
		b.addStudent("小军");
		System.out.println("Java课增选后的学生: " + Arrays.toString(a.students));
		System.out.println("Python课增选后的学生: " + Arrays.toString(b.students));
	}
}
