package sdm.programflow;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import sdm.displaywindow.Dialogbox;

public class Configflow{
	private Dialogbox setup_dialog;
	
	public void start(){ //starts normal flow
		setupWindow1();
	}
	private void setupWindow1(){ //to select classes

		int checkbox_X=10,checkbox_Y=40,checkbox_W=100,checkbox_H=10;
		setup_dialog = new Dialogbox("SDM : Setup Box",false,new Rectangle(250,100,250,250),null);

	
		JLabel infoLabel = new JLabel("Select Classes To Manage");
		JCheckBox c6 = new JCheckBox("Class 6th");
		JCheckBox c7 = new JCheckBox("Class 7nth");
		JCheckBox c8 = new JCheckBox("Class 8th");
		JCheckBox c9 = new JCheckBox("Class 9nth");
		JCheckBox c10= new JCheckBox("Class 10nth");
		JCheckBox c11= new JCheckBox("Class 11nth");
		JCheckBox c12= new JCheckBox("Class 12th");
		
		// TIP : Use List<JCheckBox> for grouping check-boxes 
		
		JButton submitButton = new JButton("Create Package");
		infoLabel.setBounds(checkbox_X,0,200,50);
		c6.setBounds(checkbox_X,checkbox_Y,checkbox_W,checkbox_H);
		c7.setBounds(checkbox_X,checkbox_Y+25,checkbox_W,checkbox_H);
		c8.setBounds(checkbox_X,checkbox_Y+50,checkbox_W,checkbox_H);
		c9.setBounds(checkbox_X,checkbox_Y+75,checkbox_W,checkbox_H);
		c10.setBounds(checkbox_X,checkbox_Y+100,checkbox_W,checkbox_H);
		c11.setBounds(checkbox_X,checkbox_Y+125,checkbox_W,checkbox_H);
		c12.setBounds(checkbox_X,checkbox_Y+150,checkbox_W,checkbox_H);
		submitButton.setBounds(checkbox_X+100,checkbox_Y+135,checkbox_W+25,checkbox_H+20);
		
		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			int number_of_checkedBox=0;
				if(c6.isSelected()){
					try {
						
						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(6);
						fout.close();
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					number_of_checkedBox++;
				}if(c7.isSelected()){
					try {
						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(7);
						fout.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					number_of_checkedBox++;
				}if(c8.isSelected()){
					try {
						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(8);
						fout.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					number_of_checkedBox++;
				}if(c9.isSelected()){
					try {
						//DataOutputStream fout=new DataOutputStream(new FileOutputStream("config.dat",false));
						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(9);
						fout.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					number_of_checkedBox++;
				}if(c10.isSelected()){
					try {
						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(10);
						fout.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(1);
					}
					number_of_checkedBox++;
				}if(c11.isSelected()){
					try {

						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(11);
						fout.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(1);
					}
					number_of_checkedBox++;
				}if(c12.isSelected()){
					try {
				
						FileOutputStream fout=new FileOutputStream("config.dat",true);
						fout.write(12);
						fout.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.exit(1);
					}
					number_of_checkedBox++;
				}
				if(number_of_checkedBox==0){
					new Dialogbox("Error!!!",false,new Rectangle(250,100,200,100),null,"Select Atleast 1 Class").setVisible(true);
				}
				else
				{
					//Save info to file : DONE
					// MOVE ON : 
					//new Normalflow().start();
					setup_dialog.dispose();
					new Normalflow().start();
				}
			}
		});		
		setup_dialog.add(infoLabel);
		setup_dialog.add(c6);
		setup_dialog.add(c7);
		setup_dialog.add(c8);
		setup_dialog.add(c9);
		setup_dialog.add(c10);
		setup_dialog.add(c11);
		setup_dialog.add(c12);
		setup_dialog.add(submitButton);
		setup_dialog.setVisible(true);
	}
}

