import java.util.Scanner;

public class asn {
	public static void main(String args[])
	{
		System.out.println("Vehicles available for rent....");
		System.out.println("ID\t MODEL\t REG_NO\t DEPOSIT\t RATE\t AVAILABLE");
		System.out.println("001\t Toyota Altis\t GJ01RH1234\t 500\t 30\t Available");
		System.out.println("002\t Honda Jazz\t GJ01RH4231\t 600\t 50\t Available");
		System.out.println("002\t Tata Nano\t GJ01RH5678\t 300\t 20\t Available");
		System.out.println("Enter id of vehicle you wish to rent: ");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		System.out.println("Enter date of renting: ");
		String sdate=sc.next();
		System.out.println("Enter date of return: ");
		String rdate=sc.next();
		System.out.println("Enter licence number: ");
		String lno=sc.next();
		System.out.println("Confirm booking?(y/n)");
		String confirm=sc.next();
		System.out.println("==============================Recipt=========================");
		System.out.println("Name: Manush Pandya");
		System.out.println("Vehicle id:"+id);
		System.out.println("model: Honda Jazz");
		System.out.println("Reg_no: GJ01RH4231");
		System.out.println("Deposit: 600");
		System.out.println("Rate: 50");
		System.out.println("Pickup date: "+sdate);
		System.out.println("Return date: "+rdate);
		System.out.println("Licence number: "+lno);
		System.out.println("Please pay the deposit while picking up the vehicle from our center. It is mandatory to keep your driving license in hand while picking up and driving the vehicle."
				+ "\n Thank you for renting car using our software, we look forward to see you again. - group 4");
		System.out.println("Do you wish to rent more vehicles?");
		String choice=sc.next();
	}

}
