package fileio;
import java.io.*;
public class WritingFile {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		try
		{
			FileWriter mywriter = new FileWriter("textfile.txt");
			mywriter.append(c1.getArea());
			mywriter.append("\n File in java is tricky but it is fun");
			mywriter.append(c1.getArea());
			mywriter.append("\n this is another line");
			mywriter.close();
		}
		catch(IOException iooo)
		{
			System.out.println("file related error");
		}

	}

}
