// wap to write into a an existing file
// using company specific code and using finally
// try with resources initializing data in try

import java.io.*;

class write_file_tryresources_CS
{
	public static void main(String args[])
	{
		Console c = System.console();
		String filename = c.readLine("enter filename to write into ");
		File f = new File(filename);

		if(f.exists())
		{
			try ( FileWriter fw = new FileWriter(f, true); 
			      BufferedWriter bw = new BufferedWriter(fw);
			      PrintWriter pw = new PrintWriter(bw);)
			{
				String data= c.readLine("enter data to write ");
				pw.println(data);			
			}
			catch(IOException e)
			{
				System.out.println("issue "+ e);
			}
	
		}
		else
		{
			System.out.println(filename + " does not exists ");
		}
	}
}