package classandobjects;

public class Circle {
	public double radius;
	public static int count=0;
	
	public Circle()
	{
		radius=30;
		count++;
	}
	public Circle(double newRadius)
	{
		radius = newRadius;
		count++;
	}
	public void setRadius(double newRad)
	{
		radius = newRad;
	}
	public double getArea()
	{
		return Math.PI*radius*radius;
	}
	public double getCircumference()
	{
		return 2*Math.PI*radius;
	}
	

}
