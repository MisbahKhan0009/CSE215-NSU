package allaboutinterface;

public class DriverInterface {

	public static void main(String[] args) {
		//Hello h = new Hello(); //invalid
		ExtraordinaryClass ec = new ExtraordinaryClass();
		System.out.println(ec.strangemethod());
		ec.captainMethod();
	}

}
