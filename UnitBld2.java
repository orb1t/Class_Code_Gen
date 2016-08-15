package ccg.cmmdLine;

public final class UnitBld2
{
	public static void main(String[] args)
	{
		String myRegEx = "[A-Za-z]+\\s+";
		//Pattern prac = Pattern.compile(myRegEx);
		
		String[] userInput = "add -cl HelloWorld".split("\\s+");
		
		for (int i = 0; i < userInput.length; i++)
		{
			System.out.print(userInput[i] + ", ");
			
		}
		//System.out.println(userInput);
	}

}