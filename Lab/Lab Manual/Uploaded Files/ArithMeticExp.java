package handlingexception;
import java.util.Scanner;
public class ArithMeticExp {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter the numerator and denominator to divide");
		int numer = sc.nextInt();
		int denom = sc.nextInt();
		try {
		int quotient = numer/denom;
		System.out.println("the quotient is: "+ quotient);
		}
		catch(ArithmeticException anything)
		{
			System.out.println("You can not divide a number by zero");
		}
		finally //optional
		{
			System.out.println("this statement will excute whatever happens");
		}
		System.out.println("rest of the program");
		
		/*
		 * arrayindexoutofbound 
		 * class not found 
		 * file not found
		 * illegaltriangle 
		 * inputmismatchexception
		 */
	}

}
