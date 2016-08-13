package ccg.gui;

import javax.swing.table.DefaultTableModel;

public class InstVarTableModel extends DefaultTableModel
{
	private static final long serialVersionUID = -3280722054244781624L;
	//private String[][] data;

	public InstVarTableModel(int rows){super(UnitOne.tblHeader,rows);}
	
//	public boolean isCellEditable(boolean setTableEditable, int row, int col)
//	{
//		if(setTableEditable){return true;}
//		else{return false;}
//	}
	
	/*
	 * O(n) - inefficient filling instead of by pointer
	 * */
	/*public boolean setData(String[][] someData)
	{
		for(int r = 0; r < someData.length; r++)
		{
			for (int c = 0; c < someData.length; c++)
			{
				data[r][c] = someData[r][c];
			}
		}
		
		return true;
	}*/
	
}
