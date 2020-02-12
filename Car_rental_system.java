import java.util.*;
import java.sql.*;

class Car {
	private String make;
	private String model;
	private String regNo;
	private int deposit;
	private int rate;

	public Car(String newMake, String newModel, String newRegNo,
			int newDeposit, int newRate) {
		make = newMake;
		model = newModel;
		regNo = newRegNo;
		deposit = newDeposit;
		rate = newRate;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getRegNo() {
		return regNo;
	}

	public int getDeposit() {
		return deposit;
	}

	public int getRate() {
		return rate;
	}
}

class Car_rental_system
{
	static void Registration()
	{
		/*
		Scanner sc=new Scanner(System.in);
		System.out.println("----------------NEW USER REGISTRATION--------------");
		System.out.println("Enter First name: ");
		String fname=sc.nextLine();
		System.out.println("Enter Last name: ");
		String lname=sc.nextLine();
		System.out.println("Enter email id: ");
		String email=sc.nextLine();
		System.out.println("Address line 1: ");
		String add1=sc.nextLine();
		System.out.println("Area: ");
		String area=sc.nextLine();
		System.out.println("City: ");
		String city=sc.nextLine();
		System.out.println("Password: ");
		String pwd=sc.nextLine();
		*/
		System.out.println("_____________________________SORRY THIS FEATURE IS NOT AVAILABLE CURRENTLY!!!!!!____________________");
	}
	
	static void Enter_data()
	{
		System.out.println("_____________________________SORRY THIS FEATURE IS NOT AVAILABLE CURRENTLY!!!!!!____________________");
	}
	
	static void Delete_data()
	{
		System.out.println("_____________________________SORRY THIS FEATURE IS NOT AVAILABLE CURRENTLY!!!!!!____________________");
	}
	
	static void Login()
	{
		Scanner keyboard = new Scanner (System.in);
		System.out.println("--------------------------LOGIN-------------------------");
		System.out.println("Enter username: ");
		String checkuser=keyboard.nextLine();
		System.out.println("Enter password: ");
		String checkpwd=keyboard.nextLine();
		if (checkuser.equals("root") && checkpwd.equals("root")) 
		{
			System.out.print("Login successful!!");
			root();
		}
		else if (checkuser.equals("guest") && checkpwd.equals("guest"))
		{
			System.out.println("Login successful!!");
			guest();
		}
		else 
		{
			System.out.println("incorrect username or password");
		}
	}
	
	static void root()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n\nEnter choice: \n1)Enter data \n2)Delete data" );
		int a=sc.nextInt();
		switch(a)
		{
		case 1: Enter_data();
				break;
		case 2: Delete_data();
				break;
		default: System.out.println("Error!! Please enter appropriate chocie.");
		}
	}
	
	static void guest()
	{
		List<Car> carlist = new ArrayList<Car>();
		carlist.add(new Car("Toyota", "Altis", "SJC2456X", 100, 60));
		carlist.add(new Car("Toyota", "Vios", "SJG9523B", 100, 50));
		carlist.add(new Car("Nissan", "Latio", "SJB7412B", 100, 50));
		carlist.add(new Car("Murano", "SJC8761M", "Nissan", 300, 150));
		carlist.add(new Car("Honda", "Jazz", "SJB4875N", 100, 60));
		carlist.add(new Car("Honda", "Civic", "SJD73269C", 120, 70));
		carlist.add(new Car("Honda", "Stream", "SJL5169J", 120, 70));
		carlist.add(new Car("Honda", "Odyssey", "SJB3468E", 200, 150));
		carlist.add(new Car("Subaru", "WRX", "SJB8234L", 300, 200));
		carlist.add(new Car("Subaru", "Imprezza", "SJE8234K", 150, 80));
		Scanner input = new Scanner(System.in);
		System.out.print("Enter model to rent: ");
		String model = input.nextLine();
		for (Car s : carlist) 
		{
		if (model.equals(s.getModel())) 
			{
				System.out.println("Model " + model + " is available");
				System.out.print("Enter number of days: ");
				int days = input.nextInt();
				System.out.println("***************Details*****************");
				int cost = (days * s.getRate()) + s.getDeposit();
				System.out.println("Deposit  DailyRate  Duration  TotalCost");
				System.out.println(s.getDeposit() + "       " + s.getRate()+ "            " + days + "        " + cost);
				System.out.print("Proceed to rent?( y/n ): ");
				String dec = input.next();
				if (dec.equals("y")) {
				System.out.println("Enter Customer Name: ");
				String name = input.next();
				System.out.println("Enter IC Number: ");
				int num = input.nextInt();
					System.out.println("************Receipt*************");
				System.out.println("Name   ICNo   Car  RegNo Duration   TCost");
				System.out.println(name + "   " + num + "   " + model
				+ "   " + s.getRegNo() + "   " + days + "   "+cost);
				System.out.println("Serving Next Customer ");
			} 
		else if (dec.equals("n")) 
			{
				System.out.println("Serving Next Customer: ");
			}
		}
	}
}
	
	
	public static void main(String args[])
	{
		Login();
		
	}
}
