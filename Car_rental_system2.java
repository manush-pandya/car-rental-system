import java.util.Scanner;

public class Car_rental_system2 {

	static String[][] User = new String[15][7];
	static String[][] Data = new String[15][6];
	static Scanner sc=new Scanner(System.in);
	static int st_u=0;
	static int u;
	static int st_d=0;
	
	public static void Init()
	{
		Data[0][0]="001";
		Data[1][0]="002";
		Data[2][0]="003";
		User[0][0]="Manush";
		User[1][0]="Arman";
		
		Data[0][1]="Toyota Altis";
		Data[1][1]="Honda Jazz";
		Data[2][1]="Tata Nano";
		User[0][1]="Pandya";
		User[1][1]="Mardhani";
		
		Data[0][2]="GJ01RH1234";
		Data[1][2]="GJ01RH4231";
		Data[2][2]="GJ01RH5678";
		User[0][2]="manushpandya14@gmail.com";
		User[1][2]="Armanmardhani@gmail.com";
		
		Data[0][3]="500";
		Data[1][3]="600";
		Data[2][3]="300";
		User[0][3]="abc";
		User[1][3]="xyz";
		
		Data[0][4]="30";
		Data[1][4]="50";
		Data[2][4]="20";
		User[0][4]="xyz";
		User[1][4]="abc";
		
		Data[0][5]="Available";
		Data[1][5]="Available";
		Data[2][5]="Available";
		User[0][5]="Ahmedabad";
		User[1][5]="Ahmedabad";
		
		User[0][5]="1234";
		User[1][5]="1234";
		
		st_u=2;
		st_d=3;
	}
	
	public static void Display()
	{
		System.out.println("Vehicles available for rent....");
		for(int i=0; i<st_d; i++)
			{
				for(int j=0; j<7; i++)
				{
					System.out.println("ID\t MODEL\t REG_NO\t DEPOSIT\t RATE\t AVAILABLE");
					System.out.println(Data[i][j]+"\t ");
				}
			}
		Select();
	}

	public static void Select()
	{
		System.out.println("Enter id of vehicle you wish to rent: ");
		String id=sc.next();
		int r=1;
		String av="Available";
		for(int i=0; i<7; i++)
		{
			if(Data[i][0].equals(id))
			{
				if(Data[i][5].equals(av))
				Recipt(i);
			}
			else
				r=0;
		}
		if(r==0)
			System.out.println("Vehicle id not found please check id:");
	}
	
	public static void Recipt(int n)
	{
		System.out.println("Enter date of renting: ");
		String sdate=sc.next();
		System.out.println("Enter date of return: ");
		String rdate=sc.next();
		System.out.println("Enter licence number: ");
		String lno=sc.next();
		System.out.println("Confirm booking?(y/n)");
		String confirm=sc.next();
		if(confirm=="y"||confirm=="Y")
		{
			System.out.println("==============================Recipt=========================");
			System.out.println("Name: "+User[u][0]+" "+User[u][1]);
			System.out.println("Vehicle id: "+Data[n][0]);
			System.out.println("model: "+Data[n][1]);
			System.out.println("Reg_no: "+Data[n][2]);
			System.out.println("Deposit: "+Data[n][3]);
			System.out.println("Rate: "+Data[n][4]);
			System.out.println("Pickup date: "+sdate);
			System.out.println("Return date: "+rdate);
			System.out.println("Licence number: "+lno);
			System.out.println("Please pay the deposit while picking up the vehicle from our center. It is mandatory to keep your driving license in hand while picking up and driving the vehicle."
					+ "\n Thank you for renting car using our software, we look forward to see you again. - group 4");
			Data[n][5]="not Available";
		}
		
		
	}
	
	public static void Uregistration()
	{
		System.out.println("----------------NEW USER REGISTRATION--------------");
			System.out.println("Enter First name: ");
			User[st_u][0]=sc.nextLine();
			System.out.println("Enter Last name: ");
			User[st_u][1]=sc.nextLine();
			System.out.println("Enter email id: ");
			User[st_u][2]=sc.nextLine();
			System.out.println("Address line 1: ");
			User[st_u][3]=sc.nextLine();
			System.out.println("Area: ");
			User[st_u][4]=sc.nextLine();
			System.out.println("City: ");
			User[st_u][5]=sc.nextLine();
			System.out.println("Password: ");
			User[st_u][6]=sc.nextLine();
			st_u++;
			Display();
	}
	
	public static void Menu()
	{
		System.out.println("---------------MENU---------------");
		System.out.println("1: Login\n2: Register");
		int a=sc.nextInt();
		switch(a)
		{
		case 1: Login();
				break;
		case 2: Uregistration();
				break;
		default: System.out.println("Error!! Check choice again..");
		}
	}
	
	public static void InsertData()
	{
		System.out.println("---------------Enter new vehicle data-------------");
		System.out.println("Vehicle id: ");
		Data[st_d][0]=sc.next();
		System.out.println("Vehicle model: ");
		Data[st_d][1]=sc.next();
		System.out.println("Vehicle Reg_no: ");
		Data[st_d][2]=sc.next();
		System.out.println("Deposit amount: ");
		Data[st_d][3]=sc.next();
		System.out.println("Rate: ");
		Data[st_d][4]=sc.next();
		Data[st_d][5]="Available";
		st_d++;
		Display();
	}
	
	public static void DeleteData()
	{
		System.out.println("-------------------Delete Vehicle data------------");
		System.out.println("Enter id of vehicle whos data is to be deleted: ");
		String id=sc.next();
		int r=1;
		for(int i=0; i<st_d; i++)
		{
			if(id.equals(User[i][0]))
			{
				for(int j=0; j<7; j++)
				{
					User[i][j]=null;
				}
			}
			else 
				r=0;
		}
		if(r==0)
		{
			System.out.println("Vehicle data not found please check if you have entered correct id... ");
			System.out.println("Do you wish to retry?(y/n)");
			String confirm=sc.next();
			if(confirm=="y"||confirm=="Y")
				DeleteData();
		}
	}
	
	public static void Root()
	{
		Display();
		System.out.println("1: Insert vehicle data \n2: Delete vehicle data \n3: Exit");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1: InsertData();
				break;
		case 2: DeleteData();
				break;
		case 3: break;
		default: System.out.println("Incorrect choice please try again!!");
				Root();
		}
	}
	
	public static void Guest(String user,String pass)
	{
		int r=1;
		for(int i=0; i<st_u; i++)
		{
			if(User[i][2].equals(user)&&User[i][5].equals(pass))
			{
				System.out.println("Login succesful!!");
				Display();
				r=0;
			}
		}
		if(r==1)
		{
			System.out.println("ERROR: Incorrect username or password!!");
			System.out.println("Do you wish to retry?(y/n)");
			String confirm=sc.next();
			if(confirm=="y"||confirm=="Y")
				Login();
		}
	}
	
	public static void Login()
	{
		System.out.println("--------------LOGIN-----------------");
		System.out.println("Email id: ");
		String user=sc.next();
		System.out.println("Password: ");
		String pass=sc.next();
		if(user.equals("root")&&pass.equals("root"))
			Root();
		else
			Guest(user,pass);
		
	}
	
	public static void main(String[] args) {
		Init();
		String choice;
		do {
			Menu();
			System.out.println("Do you wish to rent more vehicles?");
			choice=sc.next();
		}while(choice=="y"||choice=="Y");
		
	}

}
