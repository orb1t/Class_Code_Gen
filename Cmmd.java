package ccg.cmmdLine;

import java.util.ArrayList;
import java.util.List;

public final class Cmmd
{
	private String name;
	private List<Flag> actvFlags;
	
	/***/
	private Cmmd()
	{
		actvFlags = new ArrayList<>();
	}
	
	/***/
	public Cmmd(String newName)
	{
		this();
		this.name = newName;
	}
	
	/***/
	public boolean addFlag(Flag someFlag)
	{
		if(someFlag == null){return false;}
		else
		{}
		return false;
	}
	
	/***/
	public void addFlags()
	{
		
	}
}