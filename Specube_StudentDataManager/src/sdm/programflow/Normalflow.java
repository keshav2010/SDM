package sdm.programflow;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.border.*;

import sdm.displaywindow.CFrame;
import sdm.displaywindow.CPanel;
public class Normalflow {
	File configF = new File("config.dat"); //file will always exists 
	CFrame normal_frame;
	CPanel sub_normal_frame;
	ArrayList<JButton> buttonlist = new ArrayList<JButton>();

	public void start(){ //entry_point of Normalflow object : first call this method
		initcomponents();//buttons,window etc etc
		
	}
	
	private void initcomponents() // Setup Window : Then adds Buttons
	{	normal_frame=new CFrame("Student Data Manager",800,600,null,false);
		//Main Layout of FRAME 
		//Layout emnd
		normal_frame.getContentPane().setBackground(Color.black.brighter());
		buttonlist.add(new JButton("Add"));
		buttonlist.add(new JButton("View"));
		buttonlist.add(new JButton("Setting"));
		buttonlist.add(new JButton("Exit"));
		sub_normal_frame=new CPanel(50,50,700,500);

		int x=50,y=10,w=150,h=30;
		int index=0;
		for(JButton btn : buttonlist){
			btn.setBounds(x, y, w, h);
			x=x+183;
			btn.setBackground(Color.cyan.darker());
			btn.setForeground(Color.white);
			btn.setBorder(new BevelBorder(0));
			switch(index){
			case 0:	btn.setToolTipText("Add New Student Records");
					btn.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							sub_normal_frame.set_view(1);
						}
					});
					break;//add_button
			case 1:	btn.setToolTipText("View/Change Current Records");
					btn.setName("view_button");
					btn.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0){
							sub_normal_frame.set_view(2);
						}
					});
					break;//view button
			case 2: btn.setToolTipText("Change/Modify Current Records : Advance");
					btn.setName("setting_button");
					btn.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0){
							sub_normal_frame.set_view(3);
						}
					});
					break;//setting button
			case 3: btn.addActionListener(new ActionListener(){
					@Override
						public void actionPerformed(ActionEvent arg0){
							normal_frame.dispose();
							System.exit(0);
						}
					});
					btn.setName("exit_button");
					btn.setToolTipText("Close the Program");
					break;//exit button
			}
			index++;
		}
		/*
		GridBagConstraints c=new GridBagConstraints();//objecting holding properties for LAYOUT of GRIDBAG type
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		*/
		normal_frame.getContentPane().add((JButton)buttonlist.get(0));//btn 1 ADD NEW REC

		normal_frame.getContentPane().add((JButton)buttonlist.get(1));//btn 2 VIEW REC

		normal_frame.getContentPane().add((JButton)buttonlist.get(2));//SETINGS

		normal_frame.getContentPane().add((JButton)buttonlist.get(3));//EXIT

		normal_frame.getContentPane().add(sub_normal_frame);//
		
	}
}