package passingObj;

public class DriverNum {

	public static void main(String[] args) {
		Number num1 = new Number(5);
		Number num2 = new Number(15);
		System.out.println("the summation of two number objects: "+num1.sum(num2));
		System.out.println(num2.toString());
	}

}
