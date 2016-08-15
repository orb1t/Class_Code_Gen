package ccg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


public class CCGunitBuild extends JFrame
{
   private static final long serialVersionUID = 1L;
   private JPanel masterPanel;
   private static String genOut;
   private JTextField clssNameTxtFld;
   private JLabel clssLbl;
   private JPanel hasGroup, isGroup;
   private JToggleButton superTgglBtn;
   private JToggleButton constantsTgglBtn;
   private JToggleButton toStringTgglBtn;
   private JToggleButton instVarTgglBtn;
   private JToggleButton methodsTgglBtn;
   private JToggleButton dataDefTgglBtn;
   private JRadioButton abstractRdBtn, finalRdBtn;
   private ButtonGroup group;
	

   public static void main(String[] args) {
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               try {
                  CCGunitBuild frame = new CCGunitBuild();
                  frame.setVisible(true);
               } 
               catch (Exception e) {
                  e.printStackTrace();
               }
            }
         });
   }

   public CCGunitBuild()
   {
   	/*general form op's*/
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 900, 500);
      masterPanel = new JPanel();
      masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      masterPanel.setLayout(new BorderLayout(0, 0));
      setContentPane(masterPanel);
   	
   	
   	//JPanel panel = new JPanel();
   	//masterPanel.add(panel, BorderLayout.CENTER);
   	
      final JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
   	//tabs.setSize(400,400);
   	
   	/*Class Specs for Tab 1*/
      JPanel clssPnl = new JPanel();
   	
      clssLbl = new JLabel("Class Name:");
      clssNameTxtFld = new JTextField(10);
   	
   	/*class has toggle bttns*/
      workClassHas();
   	
   	
   	/*class 'is' details*/
   	
   	
   	/*class 'is' toggle bttns*/
      dataDefTgglBtn = new JToggleButton("Defines Data");
      dataDefTgglBtn.setSize(new Dimension(20,20));
      abstractRdBtn = new JRadioButton("Abstract");
      finalRdBtn = new JRadioButton("Final");
      group = new ButtonGroup();
       
       
       
      isGroup = new JPanel(new GridLayout(3,1));
      group.add(abstractRdBtn);group.add(finalRdBtn);
      isGroup.add(abstractRdBtn);isGroup.add(finalRdBtn);
      isGroup.add(dataDefTgglBtn);
       
      isGroup.setBorder(BorderFactory.createTitledBorder(
         	BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
         			Color.GRAY, Color.WHITE), "Class Is"));
       
       //clssPnl.add(isGroup);
   	
   	
      clssPnl.setSize(250, 250);
      tabs.addTab("Class", clssPnl);
   	
      GroupLayout gl_clssPnl = new GroupLayout(clssPnl);
      gl_clssPnl.setHorizontalGroup(
         gl_clssPnl.createParallelGroup(Alignment.LEADING)
         	.addGroup(gl_clssPnl.createSequentialGroup()
         		.addGroup(gl_clssPnl.createParallelGroup(Alignment.LEADING)
         			.addGroup(gl_clssPnl.createSequentialGroup()
         				.addGap(5)
         				.addComponent(clssLbl)
         				.addGap(5)
         				.addComponent(clssNameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         			.addGroup(gl_clssPnl.createSequentialGroup()
         				.addContainerGap()
         				.addComponent(hasGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
         		.addContainerGap(158, Short.MAX_VALUE))
         );
      gl_clssPnl.setVerticalGroup(
         gl_clssPnl.createParallelGroup(Alignment.LEADING)
         	.addGroup(gl_clssPnl.createSequentialGroup()
         		.addGroup(gl_clssPnl.createParallelGroup(Alignment.LEADING)
         			.addGroup(gl_clssPnl.createSequentialGroup()
         				.addGap(71)
         				.addComponent(clssLbl))
         			.addGroup(gl_clssPnl.createSequentialGroup()
         				.addGap(69)
         				.addComponent(clssNameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
         		.addGap(18)
         		.addComponent(hasGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         		.addContainerGap(157, Short.MAX_VALUE))
         );
      clssPnl.setLayout(gl_clssPnl);
   	
   	
   	
   	/*interface work*/
      JPanel intfcPnl = new JPanel();
      intfcPnl.add(new JButton("rawr"));
      intfcPnl.setSize(200, 200);
      tabs.addTab("Interface", intfcPnl);
   	
   	
   	/*output textfield and other mechanics*/
      GroupLayout gl_panel = new GroupLayout(masterPanel);
      workerOutput(tabs, gl_panel, masterPanel);
   	
   	
   	
   	
   }
	
	/**
	 * TODO
	 * */
   private void workClassHas()
   {
      superTgglBtn = new JToggleButton("Super");
      superTgglBtn.setSize(new Dimension(20,20));
      constantsTgglBtn = new JToggleButton("Constants");
      constantsTgglBtn.setSize(new Dimension(20,20));
      toStringTgglBtn = new JToggleButton("toString");
      toStringTgglBtn.setSize(new Dimension(20,20));
      instVarTgglBtn = new JToggleButton("Instance Vars.");
      instVarTgglBtn.setSize(new Dimension(20,20));
      methodsTgglBtn = new JToggleButton("Methods");
      methodsTgglBtn.setSize(new Dimension(20,20));
       
      hasGroup = new JPanel(new GridLayout(5,1));
      hasGroup.add(superTgglBtn);hasGroup.add(constantsTgglBtn);
      hasGroup.add(toStringTgglBtn);
      hasGroup.add(instVarTgglBtn);hasGroup.add(methodsTgglBtn);
         
      hasGroup.setBorder(BorderFactory.createTitledBorder(
         	BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY,
         			Color.WHITE), "Class Has"));
   }
	

	/**
	 * Worker method that will make and manage the output textfield and bttns.
	 *    
	 * */
   private void workerOutput(final JTabbedPane myTabs, GroupLayout gm, JPanel myPnl)
   {
      final JTextArea generatedOutput = new JTextArea();
   	
      JLabel outputLbl = new JLabel("Output");
   	
      JButton getBttn = new JButton("Get");
      genOut = new String("public ");
   	
      getBttn.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent arg0)
            {
               if(myTabs.getSelectedIndex() == 0)
               {
                  genOut = "public class ";
                  genOut = form(clssNameTxtFld);
               }
               else if(myTabs.getSelectedIndex() == 1)
               {
                  genOut = "public interface";
               }
            
               generatedOutput.setText(genOut.toString());
            }
         });
   	
   	/*reset the var value and update the output textfield*/
      JButton resetBttn = new JButton("Reset");
      resetBttn.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent arg0){generatedOutput.setText("");genOut = "";}
         });
   	
      gm.setHorizontalGroup(gm.createParallelGroup(Alignment.LEADING)
         	.addGroup(gm.createSequentialGroup().addGap(21)
         			.addComponent(myTabs, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
         			.addGroup(gm.createParallelGroup(Alignment.TRAILING)
         					.addGroup(gm.createSequentialGroup()
         					.addGroup(gm.createParallelGroup(Alignment.TRAILING)
         						.addComponent(getBttn).addComponent(outputLbl))
         					.addGap(22))
         				.addGroup(gm.createSequentialGroup().addComponent(resetBttn)
         					.addPreferredGap(ComponentPlacement.UNRELATED)))
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(generatedOutput, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
         			.addGap(39)));
      gm.setVerticalGroup(gm.createParallelGroup(Alignment.TRAILING)
         		.addGroup(gm.createSequentialGroup()
         			.addGroup(gm.createParallelGroup(Alignment.LEADING)
         				.addGroup(Alignment.TRAILING, gm.createSequentialGroup()
         					.addContainerGap()
         					.addComponent(myTabs, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
         				.addGroup(gm.createSequentialGroup()
         					.addGap(43)
         					.addGroup(gm.createParallelGroup(Alignment.BASELINE)
         						.addGroup(gm.createSequentialGroup()
         							.addComponent(outputLbl)
         							.addGap(2)
         							.addComponent(getBttn)
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addComponent(resetBttn))
         						.addComponent(generatedOutput, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))))
         			.addContainerGap())
         );
      myPnl.setLayout(gm);
   	
      gm.setHorizontalGroup(
         	gm.createParallelGroup(Alignment.LEADING)
         		.addGroup(gm.createSequentialGroup()
         			.addGap(21)
         			.addComponent(myTabs, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
         			.addGroup(gm.createParallelGroup(Alignment.TRAILING)
         				.addGroup(gm.createSequentialGroup()
         					.addGroup(gm.createParallelGroup(Alignment.TRAILING)
         						.addComponent(getBttn)
         						.addComponent(outputLbl))
         					.addGap(22))
         				.addGroup(gm.createSequentialGroup()
         					.addComponent(resetBttn)
         					.addPreferredGap(ComponentPlacement.UNRELATED)))
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(generatedOutput, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
         			.addGap(39))
         );
      gm.setVerticalGroup(
         	gm.createParallelGroup(Alignment.TRAILING)
         		.addGroup(gm.createSequentialGroup()
         			.addGroup(gm.createParallelGroup(Alignment.LEADING)
         				.addGroup(Alignment.TRAILING, gm.createSequentialGroup()
         					.addContainerGap()
         					.addComponent(myTabs, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
         				.addGroup(gm.createSequentialGroup()
         					.addGap(43)
         					.addGroup(gm.createParallelGroup(Alignment.BASELINE)
         						.addGroup(gm.createSequentialGroup()
         							.addComponent(outputLbl)
         							.addGap(2)
         							.addComponent(getBttn)
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addComponent(resetBttn))
         						.addComponent(generatedOutput, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))))
         			.addContainerGap())
         );
      myPnl.setLayout(gm);
   }

   private static String form(JTextField clssNameTxtFld)
   {
      String out = genOut + clssNameTxtFld.getText();
      return out;
   }
}
