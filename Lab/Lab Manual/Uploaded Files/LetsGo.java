import java.util.Scanner;
public class LetsGo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number from 0 to 10 depending on your mood");
		int mood= input.nextInt();
		if(mood==0)
		{
			System.out.println("Home");
		}
		else if(mood==1)
		{
			System.out.println("Sikim");
		}
		else if(mood==2)
		{
			System.out.println("Bandarban");
		}		
		else if(mood==3)
		{
			System.out.println("Darjeeling");			
		}
		else if(mood==4)
		{
			System.out.println("France");			
		}
		else if(mood==5)
		{
			System.out.println("Srimangal");
		}
		else if(mood==6)
		{
			System.out.println("Amazon");			
		}
		else if(mood==7)
		{
			System.out.println("Bali");			
		}
		else if(mood==8)
		{
			System.out.println("Cox's Bazar");			
		}
		else if(mood==9)
		{
			System.out.println("Mecca");			
		}
		else if(mood==10)
		{
			System.out.println("Meghalaya");			
		}
		else
		{
			System.out.println("invalid input");
		}

	}

}
