package homework;
import java.util.*;

public class Account {
	private int id = 0;	//为账号定义一个名为id的int类型私有数据域（默认值为0）标识账号
	private double balance = 0.0;	//为账号定义一个名为balance的double类型私有数据域（默认值为0）表示余额
	private static double annualInterestRate = 0.0;	//一个名为annualInterestRate的double类型私有数据域存储当前利率（默认值为0）。假设所有的账户都有相同的利率
	private Date dateCreated = new Date();	//一个名为dataCreated的Data类型的私有数据域，存储账户的开户日期
	
	//一个用于创建默认账户的无参构造方法
	public Account() {
	}
	
	//一个用于创建具有指定id和初始余额的账户的构造方法
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	//id的访问器、修改器方法
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//balance的访问器、修改器方法
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//annualInterestRate的访问器、修改器方法
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	//dateCreated的访问器方法
	public Date getDateCreated() {
		return dateCreated;
	}
	
	//getMonthlyInterestRate()方法，返回月利率
	public double getMonthlyInterestRate() {
		return (this.annualInterestRate)/12;
	}
	
	//getMonthlyInterest()方法，返回月利息
	public double getMonthlyInterest() {
		double mi = (getMonthlyInterestRate()/12)/100;
		return (getMonthlyInterestRate()/100)*(this.balance);
	}
	
	//withDraw方法，从账户提取指定额度
	public boolean withDraw(double wamount) {
		if ((wamount>balance)||(wamount<0)) {
			return false;
		}else {
			this.balance -= wamount;
			return true;
		}
	}
	
	//deposit方法向账户存储指定额度
	public boolean deposit(double damount) {
		if (damount < 0) {
			return false;
		}else {
			this.balance += damount;
			return true;
		}
	}
	
	public static void main(String[] args) {
		//创建一个Account类实例acc，ID为1122，余额为20000
		Account acc = new Account(1122,20000);
		//设置年利率为4.5
		acc.setAnnualInterestRate(4.5);
		
		//取2500，存3000
		acc.withDraw(2500);
		acc.deposit(3000);
		
		//打印余额、月利息、开户日期
		System.out.println("The balance of Account ID " + acc.getId() + " is: " + acc.getBalance());
		System.out.println("The current monthly interest is: " + acc.getMonthlyInterest());
		System.out.println("Account ID " + acc.getId() +" was opened on: " + acc.getDateCreated());
	}

}
