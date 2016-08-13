package ccg.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UnitOne
{
	private JFrame mf;
	private JPanel masterPnl, classHas;
	private JTable instVarTbl;
	private JSlider instVarSldr;
	private JToggleButton instVarTgglBtn;
	private JTabbedPane tabs;
	private InstVarTableModel dm;
	private Vector<String> tblData;
	
	public static Vector<String> tblHeader = new Vector<String>();
	
	public static void main(String[] args)
	{
		UnitOne f = new UnitOne();
		f.getFrame().setVisible(true);
	}
	
	public UnitOne()
	{
		mf = new JFrame();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setBounds(50, 50, 850, 700);
		
		masterPnl = new JPanel();
		//GroupLayout masterGroupLayout = new GroupLayout(masterPnl);
		
		classHas = new JPanel();
		
		makeInstVar();
		
		classHas.setBorder(BorderFactory.createTitledBorder(
	         	BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY,
	         			Color.WHITE), "Class Has"));
		masterPnl.add(classHas);
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.addTab("Class", classHas);
		masterPnl.add(tabs);
		mf.add(masterPnl);
	}
	
	private void makeInstVar()
	{
		instVarTgglBtn = new JToggleButton("Instance Vars.");
		instVarTgglBtn.setSize(new Dimension(20,20));
		
		/*===jslider inst var===*/
		final int beginVal = 0;int maxVal = 30;
		instVarSldr = new JSlider(JSlider.HORIZONTAL, beginVal, maxVal, beginVal);
		instVarSldr.setPaintTicks(true);instVarSldr.setPaintLabels(true);
		instVarSldr.setMajorTickSpacing(10);instVarSldr.setMinorTickSpacing(5);
		instVarSldr.setSnapToTicks(false);instVarSldr.setVisible(false);
		
		/*---jtable(r,c)---*/		
		instVarTbl = new JTable();
		instVarTbl.setShowGrid(true);
		instVarTbl.setDragEnabled(false);
		
		for(int i = 0; i < instVarTbl.getColumnModel().getColumnCount(); i++)
		{instVarTbl.getColumnModel().getColumn(i).setResizable(false);}
		
		/*alternate 'show' 'no-show'*/
		instVarTgglBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if(instVarTgglBtn.isSelected())
				{
					instVarSldr.setVisible(true);
				}
				else if(instVarTgglBtn.isSelected() == false)
				{instVarSldr.setVisible(false);}
			}
		});
		tblHeader.add("Access Modfs.");
		tblHeader.add("Static?");
		tblHeader.add("Data Type");
		tblHeader.add("Name");
		
		dm = new InstVarTableModel(instVarSldr.getValue());
		//tblData = dm.getDataVector();
		dm.setDataVector(tblData, tblHeader);
		
		instVarSldr.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				//tblData = dm.getDataVector();
				dm = new InstVarTableModel(instVarSldr.getValue());
				dm.setDataVector(tblData, tblHeader);
				instVarTbl.setModel(dm);
				
			}
		});
		
//		if (dm != null){tblData = dm.getDataVector();}
//		else
//		{
//			dm = new InstVarTableModel(instVarSldr.getValue());
//			
//		}
		
		JButton tblReport = new JButton("Tbl. Report");
		tblReport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, tblData);
			}
		});
		
		classHas.add(instVarTgglBtn);classHas.add(instVarSldr);
		classHas.add(new JScrollPane(instVarTbl));classHas.add(tblReport);
		
	}

	/*get or access methods for the object(s)*/
	public JFrame getFrame(){return mf;}
	public JPanel getMasterPanel(){return masterPnl;}
	public int getInstVarAmt(){return instVarSldr.getValue();}
}