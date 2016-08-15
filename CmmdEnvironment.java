package ccg.cmmdLine;

import java.util.ArrayList;
import java.util.List;

import ccg.cmmdLine.Cmmd;
import ccg.cmmdLine.Flag;

public final class CmmdEnvironment
{
	private final List<Cmmd> cmds;
	public static final int MAX_CMMDS = 12;
	private boolean echoState;
	private boolean confirmState;
	
	/**
	 * default constructor important for initializing echo and confirm statements
	 * */
	public CmmdEnvironment()
	{
		cmds = new ArrayList<>();
		echoState = false;
		confirmState = false;
		createCmmds();
	}
	
	/**worker methods*/
	private void createCmmds()
	{
		/*overlapping flags*/
		Flag clss = new Flag("cl", "various manipulations can be performed for any generic class");
		
		
		/*build the 'add' cmmd*/
		Cmmd addCmd = new Cmmd("add");
		addCmd.addFlag(clss);
		this.cmds.add(addCmd);
		
		Cmmd remvCmd = new Cmmd("remv");
		Cmmd modfCmd = new Cmmd("modf");
		Cmmd useCmd = new Cmmd("use");
		Cmmd buildCmd = new Cmmd("build");
	}
	
	/**
	 * Using the confirm feature of the env., the user can find out every time
	 * post-execution if their input was valid and successfully executed or not
	 * */
	public boolean confirm()
	{
		/*alternate the confirm state depending on current state*/
		if(this.confirmState){this.confirmState = false;return true;}
		else if(this.confirmState == false){this.confirmState = true;return true;}
		else{return false;}
	}
	
	/**
	 * The echo feature of the env. enables the user to see exactly
	 * what they input "to the T".
	 * <p>
	 * Combined with the confirmation feature, these two features of the
	 * command line environment will inform the user each time for statement evaluation.
	 * */
	public boolean echo()
	{
		/*alternate the echo state depending on current state*/
		if(this.echoState){this.echoState = false;return true;}
		else if(this.echoState == false){this.echoState = true;return true;}
		else{return false;}
	}
	
	public String help()
	{
		String output = "  Valid Commands\t\tDescription\n---------------------------------------------";
		
		return output;
	}
}
