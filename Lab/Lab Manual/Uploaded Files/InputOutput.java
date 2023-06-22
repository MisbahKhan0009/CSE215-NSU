package basics;
import java.util.Scanner;
public class InputOutput {

	public static void main(String[] args) {
		System.out.println("Welcome to JAVA programming");
		System.out.print("Java is Fun ");
		System.out.println("Java is awesome");
		int num1=10, num2=20;
		int sum = num1+num2;
		System.out.println("the summation of "+num1+" and "+num2 +" is: "+sum);
		/*study the following formatted printing method
		 * System.out.printf();
		 */
		//Creating an object of Scanner Class
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		num1 = in.nextInt();
		System.out.println("Please enter another number: ");
		num2 = in.nextInt();
		sum = num1+num2;
		System.out.println("the summation of "+num1+" and "+num2 +" is: "+sum);

	}

}
