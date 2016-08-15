package ccg.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UnitBuild
{
   public static void main(String[] args)
   {
      JTabbedPane mytb = new JTabbedPane((int)JTabbedPane.TOP);
      mytb.setSize(600, 700);
   	
      JPanel nameHasPnl = new JPanel(new GridLayout(2,1));
      
      nameHasPnl.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY,
         Color.WHITE), ""));
      
      JLabel clssLbl = new JLabel("Class Name:");
      JTextField clssName = new JTextField(10);
      nameHasPnl.add(clssLbl);nameHasPnl.add(clssName);
      
      
      /*has-properties*/
      JPanel hasGroup = new JPanel(new FlowLayout());
      
         /*class has toggle bttns*/
      JToggleButton superTgglBtn = new JToggleButton("Super");
      superTgglBtn.setSize(new Dimension(20,20));
      JToggleButton constantsTgglBtn = new JToggleButton("Constants");
      constantsTgglBtn.setSize(new Dimension(20,20));
      JToggleButton toStringTgglBtn = new JToggleButton("toString");
      toStringTgglBtn.setSize(new Dimension(20,20));
      JToggleButton instVarTgglBtn = new JToggleButton("Instance Vars.");
      instVarTgglBtn.setSize(new Dimension(20,20));
      JToggleButton methodsTgglBtn = new JToggleButton("Methods");
      methodsTgglBtn.setSize(new Dimension(20,20));
      
      hasGroup.add(superTgglBtn);hasGroup.add(constantsTgglBtn);
      hasGroup.add(toStringTgglBtn);
      hasGroup.add(instVarTgglBtn);hasGroup.add(methodsTgglBtn);
      
      hasGroup.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY,
         Color.WHITE), "Class Has"));
      
      
      /*class 'is' details*/
      JPanel isGroup = new JPanel(new GridLayout(3,1));
      isGroup.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY,
         Color.WHITE), "Class Is"));
      
         /*class 'is' toggle bttns*/
      JToggleButton dataDefTgglBtn = new JToggleButton("Defines Data");
      dataDefTgglBtn.setSize(new Dimension(20,20));
      JRadioButton abstractRdBtn = new JRadioButton("Abstract");
      JRadioButton finalRdBtn = new JRadioButton("Final");
      ButtonGroup group = new ButtonGroup();
      group.add(abstractRdBtn);group.add(finalRdBtn);
      isGroup.add(abstractRdBtn);isGroup.add(finalRdBtn);isGroup.add(dataDefTgglBtn);
      
      
      /*jslider inst var*/
      final int beginVal = 0;
      int maxVal = 30;
      JSlider instVarSldr = new JSlider(JSlider.HORIZONTAL, beginVal, maxVal, beginVal);
      instVarSldr.setPaintTicks(true);
      instVarSldr.setPaintLabels(true);
      instVarSldr.setMajorTickSpacing(10);
      instVarSldr.setMinorTickSpacing(5);
      instVarSldr.setSnapToTicks(true);
      instVarSldr.setVisible(false);
      
      /*FIXME finish*/
      JTable instVarTbl = new JTable();
      instVarTbl.setVisible(false);
      /*TODO set col. count to 3*/
      
      instVarTgglBtn.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent ev){
               if(instVarTgglBtn.isSelected())
               {instVarSldr.setVisible(true);instVarTbl.setVisible(true);}
               else if(instVarTgglBtn.isSelected() == false)
               {instVarSldr.setVisible(false);instVarTbl.setVisible(false);}
            }
         });
      
      
      
      /*methods counter JSlider*/
      JSlider methodsSldr = new JSlider(JSlider.HORIZONTAL, beginVal, maxVal, beginVal);
      methodsSldr.setPaintTicks(true);
      methodsSldr.setPaintLabels(true);
      methodsSldr.setMajorTickSpacing(10);
      methodsSldr.setMinorTickSpacing(5);
      methodsSldr.setSnapToTicks(true);
      methodsSldr.setVisible(false);
      
      /*FIXME finish*/
      JTable methodsTbl = new JTable();
      methodsTbl.setVisible(false);
      /*TODO set col. count to 3*/
      methodsTgglBtn.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent ev){
               if(methodsTgglBtn.isSelected())
               {methodsSldr.setVisible(true);methodsTbl.setVisible(true);}
               else if(methodsTgglBtn.isSelected() == false)
               {methodsSldr.setVisible(false);methodsTbl.setVisible(false);}
            }
         });
      
      JPanel sldrs = new JPanel(new GridLayout(1,2));
      sldrs.add(instVarSldr);sldrs.add(methodsSldr);
      JPanel tbls = new JPanel(new GridLayout(1,2));
      tbls.add(instVarTbl);tbls.add(methodsTbl);
      hasGroup.add(sldrs);hasGroup.add(tbls);
      
      
      //------------------------------------------------------
      
      JPanel m = new JPanel(new FlowLayout());
      
      m.add(nameHasPnl);m.add(hasGroup);m.add(isGroup);
   	
      mytb.addTab("Class", m);
      
      JPanel intfcPnl = new JPanel();//intfcPnl.setSize(200, 200);
      
      /*interface section*/
      mytb.addTab("Interface", intfcPnl);
      mytb.setVisible(true);
      
      
      /*output section*/
      JPanel outputPnl = new JPanel();
      JButton resetBtn = new JButton("Reset");
      JButton getBtn = new JButton("Generate");
      JTextArea outTxt = new JTextArea(35,38);
      outTxt.setLineWrap(true);
      resetBtn.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent ev)
            {outTxt.setText("");}
         });
      outputPnl.add(getBtn);outputPnl.add(resetBtn);outputPnl.add(outTxt);
      outputPnl.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY,
         Color.WHITE), "Output"));
      
      /*finishing touches*/
      finishBuildAdd(mytb, outputPnl);
   }
   
   private static void finishBuildAdd(JTabbedPane myTabs, JPanel myOutputPanel)
   {
      JFrame f = new JFrame("Class Code Generator Tool");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //JSplitPane tabsOut = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, mytb, outTxt);
      
      JPanel masterPnl = new JPanel();
      masterPnl.add(myTabs);masterPnl.add(myOutputPanel);//masterPnl.add(resetBtn);masterPnl.add(getBtn);
      
      /*FIXME make window/monitor max size*/
      f.setSize(1680,950);
      f.add(masterPnl);//f.add(outTxt);
      f.setVisible(true);
   }

}
