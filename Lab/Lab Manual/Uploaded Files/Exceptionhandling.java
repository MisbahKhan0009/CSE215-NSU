package userdefined;

public class Exceptionhandling {

	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(-5);		
		try {
			c1.printArea();
			c2.printArea();		
		}
		catch(InvalidRadius ir)
		{
			System.out.println("the radius is not valid");
		}		
		System.out.println("the rest of the program continues");
	}

}
