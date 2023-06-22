package foreach;
import java.util.Scanner;
public class ForeachLoop {

	public static void main(String[] args) {
		int myArray[]=new int[7];
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the elements of the array");
		for(int count=0;count<=myArray.length-1;count++)
		{
			myArray[count]= in.nextInt();
		}		
		for(int var:myArray)
		{
			System.out.println("first iteration:");
			var= var+1;
			System.out.println(var+1+1);
			System.out.println("elements "+var+1+1);
		}

	}

}
/*
 * for each loop iterates sequentially 
 * we can not manipulate the array
 * it does not track the index of the element
 * */
