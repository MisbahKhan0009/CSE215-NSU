package fileio;
import java.io.*;
public class ReadingFile {

	public static void main(String[] args) {
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader("textfile.txt"));
			System.out.println("reading with readLine() method");
			
			String str = br1.readLine();
			while(str!=null)
			{
				System.out.println(str);
				str = br1.readLine();
			}
			
			System.out.println("reading with read() method");
			BufferedReader br2 = new BufferedReader(new FileReader("textfile.txt"));
			char ch;
			int num;
			
			while((num= br2.read())!=-1)
			{
			ch = (char)num;
			System.out.print(ch);
			}	
			
			
		}
		catch(IOException iooo)
		{
			System.out.println("problem in reading file");
		}
		

	}

}
