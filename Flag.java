package ccg.cmmdLine;

public final class Flag
{
	private String initials;
	private String helpTxt;
	
	/***/
	public Flag()
	{
		this(null,null);
	}
	
	/***/
	public Flag(String inits, String someHelpText)
	{
		this.initials = inits;
		this.helpTxt = someHelpText;
	}

	/***/
	public boolean setFlagInit(String someChars)
	{
		
		
		return false;
	}
	
	/***/
	public boolean setHelpTxt()
	{
		return false;
		
	}
	
	/***/
	public String toString()
	{
		String out = this.initials+"\t"+this.helpTxt;
		
		return out;
	}
}