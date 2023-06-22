package classandobjects;

public class Circle {
	public double radius;
	
	public Circle()
	{
		radius=30;
	}
	public Circle(double newRadius)
	{
		radius = newRadius;
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
