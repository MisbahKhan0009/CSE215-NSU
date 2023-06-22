package allaboutinterface;

public class ExtraordinaryClass implements CaptainPanet,DrStrange{
	public void captainMethod()
	{
		System.out.println("this multiple inheritance");
	}
	public int strangemethod()
	{
		return a + DrStrange.c *b -CaptainPanet.c;
	}

}
