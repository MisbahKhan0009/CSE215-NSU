package classandobjects;

public class DriverClass {

	public static void main(String[] args) {
		Circle cir1 = new Circle();
		System.out.println("the area of circle of radius "+cir1.radius+" is "+cir1.getArea());
		double circum = cir1.getCircumference();
		System.out.println("the circumference of circle of radius "+cir1.radius+" is "+circum);
		cir1.setRadius(100);
		System.out.println("the area of circle of radius "+cir1.radius+" is "+cir1.getArea());
		circum = cir1.getCircumference();
		System.out.println("the circumference of circle of radius "+cir1.radius+" is "+circum);
		
		Circle cir2 = new Circle(20);
		System.out.println("the area of circle of radius "+cir2.radius+" is "+cir2.getArea());
		circum = cir2.getCircumference();
		System.out.println("the circumference of circle of radius "+cir2.radius+" is "+circum);
	}

}
