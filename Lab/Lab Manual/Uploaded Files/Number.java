package passingObj;

public class Number {
	int number;
	Number(int num)
	{
		number =num;
	}
	int sum (Number n2)
	{
		int sum =this.number +n2.number;
		return sum;
	}
	public String toString()
	{
		return "the number is: "+number;
	}

}
