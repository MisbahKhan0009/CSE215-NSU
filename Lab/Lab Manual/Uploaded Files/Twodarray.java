package twodaaray;
import java.util.Scanner;

public class Twodarray {

	public static void main(String[] args) {
		int amar2Darray [][] = new int[3][3]; 
		Scanner sc_in = new Scanner(System.in);
		System.out.println("Please enter the elements of the array");
		for(int row=0;row<3;row++)
		{
			for(int col=0;col<3;col++)
			{
				System.out.println("amar2darray["+row+"]["+col+"]: ");
				amar2Darray[row][col]= sc_in.nextInt();
			}
		}
		for(int row=0;row<amar2Darray.length;row++)
		{
			for(int col=0;col<amar2Darray[0].length;col++)
			{
				System.out.print(amar2Darray[row][col]+" ");
				
			}
			System.out.println();
		}

	}

}
