import java.util.Scanner;

public class Welcome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	        System.out.print("Enter your first name: ");
        	String fName = sc.nextLine();
		System.out.print("Enter your last name: ");
		String lName = sc.nextLine();
        	System.out.println("Welcome to the Second Year, " + fName + " " + lName);
	}
}