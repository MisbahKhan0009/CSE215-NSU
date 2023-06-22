package userdefined;

public class Circle {
	double radius;
	Circle(double r)
	{
		radius = r;
	}
	public void printArea() throws InvalidRadius
	{
		if(radius>=0)
		{
			System.out.println("the area is: "+ Math.PI*radius*radius);
		}
		else
		{
			throw new InvalidRadius();
		}
	}

}
