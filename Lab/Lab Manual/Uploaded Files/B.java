package overridding;

public class B extends A{
	public void printing()
	{//this method overrides the method of 
		//class A because class B is child class
		//of class A. Then printing() method
		// have same method signature
		System.out.println("Hello, I am child class");
		System.out.println("I am class B");
	}

}
