package abstraction;

public abstract class Animal {
	protected Animal()
	{
		System.out.println("this is abstract class");
	}
	public abstract void numberOfLegs();
	public abstract void sound();

}
