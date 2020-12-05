package budgetingApp;

import java.io.*;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class TestFile {
	public static void main(String args[])  
	{  
		try  
		{  
			JFileChooser chooser = new JFileChooser();
			if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				//constructor of file class having file as argument  
				FileInputStream fis=new FileInputStream(f);     //opens a connection to an actual file  
				System.out.println("file content: ");  
				int r=0;  
				while((r=fis.read())!=-1)  
				{  
					System.out.print((char)r);      //prints the content of the file  
				}  
			}
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}
}
