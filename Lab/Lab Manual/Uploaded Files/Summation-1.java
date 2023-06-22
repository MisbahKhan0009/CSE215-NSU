package methodoverload;

public class Summation {
	int sum(int n1, int n2)
	{
		return n1+n2;
	}	
	int sum(int n1, int n2, int n3)
	{
		return n1+n2+n3;
	}
	int sum(int n1, int n2, int n3, int n4)
	{
		return n1+n2+n3+n4;
	}
	
	void sumArr(int []arr)
	{
		int sum=0;
		for(int count=0; count<arr.length; count++)
		{
			sum = sum+ arr[count];
		}
		System.out.println("the summation of the elements are: "+sum);
	}

}
