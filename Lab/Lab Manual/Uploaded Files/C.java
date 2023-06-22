package overridding;

public class C extends B{
	public void printing(int n)
	{//this method does not fulfill the overriding condition
		//because it has different methods signature
		n=100;
		System.out.println("this is grandchild "+n+"  C");
	}

}
