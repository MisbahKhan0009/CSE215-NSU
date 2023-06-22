package methodoverload;

public class DriverSum {

	public static void main(String[] args) {
		Summation s1 = new Summation();
		System.out.println(s1.sum(23, 12));
		System.out.println(s1.sum(23, 12, 20));
		System.out.println(s1.sum(23, 12, 50, 60));
		int array1 []= {10,29,49,38, 76};
		s1.sumArr(array1);
	}

}
