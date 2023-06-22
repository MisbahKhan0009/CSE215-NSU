package abstraction;

public abstract class Reptile extends Animal{
	public abstract void numberOfLegs();
	public abstract void sound();
	public void hibernate()
	{
		System.out.println("we hibernate");
	}

}
