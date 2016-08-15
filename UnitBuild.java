package ccg.cmmdLine;

import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class UnitBuild implements Runnable
{
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		try
		{
			UnitBuild un = new UnitBuild();
			un.run();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Could not run or start the environment for: CCG");
		}
		
	}

	public void run()
	{
		CmmdEnvironment cmdline = new CmmdEnvironment();
		System.out.println("(C) 2016 class code generator - command line started\n\nPress 'help' or '/?' for help");
		String input = sc.next();
		if(Pattern.matches("[hH][eE][lL][pP]", input) || input.equals("/?"))
		{
			System.out.println(cmdline.help());
		}
	}
}
