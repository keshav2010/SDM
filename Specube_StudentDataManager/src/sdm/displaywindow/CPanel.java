package sdm.displaywindow;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import sdm.data.Student;
import sdm.data.StudentDataChecker;

public class CPanel extends JPanel{
	
	private JTable table;
	private static final long serialVersionUID = 1L;//ignore this
	public CPanel(int x,int y,int w,int h){
		this.setBorder(new TitledBorder(new BevelBorder(2),"No Action", 2,0));
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(x,y,w,h);
		this.setBackground(Color.DARK_GRAY.brighter().brighter());
	}
	public void set_view(int ch){ 
		if(ch==1){ //setup ADD RECORD : SCREEN
			this.removeAll();
			this.updateUI();
			this.setLayout(new GridLayout(3,3,4,4)); //GridLayout(int rows, int cols, int hgap, int vgap)
			this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			this.setBorder(new TitledBorder(new BevelBorder(2),"Add Record", 2,1));
			show_files(1); //displays all files on sub-screen after reading config.dat file
		}
		else if(ch==2){
			this.removeAll();
			this.updateUI();
			this.setLayout(new GridLayout(3,3,4,4));
			this.setBorder(new TitledBorder(new BevelBorder(2),"View/Change Record", 2,1));
			this.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			show_files(2);
		}
		else if(ch==3){
			this.removeAll();
			this.updateUI();
			this.setBorder(new TitledBorder(new BevelBorder(2),"Advance User Settings", 2,1));
			this.setLayout(new GridLayout(3,3,4,4));
			this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			show_choice();	
		}
	}
	private void show_choice(){
		JButton btn_attendence=new JButton("Attendence");
		JButton btn_shiftRecords=new JButton("Shift Records");
		btn_attendence.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				show_files(3);
			}
			
		});
		this.add(btn_attendence);
		this.add(btn_shiftRecords);
	}
			/*
	 * show_files(int entrypoint) 
	 * > Function which displays all buttons related to classes 
	 * > Then checks what action user want to perform through entrypoint variable
	 * >>>Entrypoints codes
	 * >> entrypoint = 1 mean user want to ADD RECORD
	 * >> entrypoint = 2 mean user want to VIEW RECORD
	 * >> entrypoint = 3 <not  yet decided this>
	 */
	private void show_files(int entrypoint){  
		this.removeAll();
		this.updateUI();

		ArrayList<JButton> fileButtons = new ArrayList<JButton>();
		
		int x;
		try{
			FileInputStream fin=new FileInputStream("config.dat");
			do{	
				x=fin.read();
				//System.out.println(x);
				switch(x){
				case 6:
					fileButtons.add(new JButton("Class 6"));
					break;
				case 7:
					fileButtons.add(new JButton("Class 7"));
					break;
				case 8:
					fileButtons.add(new JButton("Class 8"));
					break;
				case 9:
					fileButtons.add(new JButton("Class 9"));
					break;
				case 10:
					fileButtons.add(new JButton("Class 10"));
					break;
				case 11:
					fileButtons.add(new JButton("Class 11"));
					break;
				case 12:
					fileButtons.add(new JButton("Class 12"));
					break;	
				}//end of switch
			}while(x!=-1);//end of while
			fin.close();
			for(JButton btn:fileButtons)
			{ //A LOOP TO READ EACH BUTTON stored in array 
				if(entrypoint==1){ //entrypoint 1 : ADD DATA
					btn.setBackground(Color.darkGray);
					btn.setForeground(Color.yellow);
					btn.addActionListener(new ActionListener(){
					
						public void actionPerformed(ActionEvent e) {
							//System.out.println(((JButton)e.getSource()).getText() + " Pressed");		
								switch(((JButton)e.getSource()).getText()){
								case "Class 6":
									//System.out.println("Class 6 Selected");
									set_view_addRecord(6);
									break;
								case "Class 7":
									//System.out.println("Class 7 Selected");
									set_view_addRecord(7);
									break;
								case "Class 8":
									//System.out.println("Class 8 Selected");
									set_view_addRecord(8);
									break;
								case "Class 9":
									//System.out.println("Class 9 Selected");
									set_view_addRecord(9);
									break;
								case "Class 10":
									//System.out.println("Class 10 Selected");
									set_view_addRecord(10);
									break;
								case "Class 11":
									//System.out.println("Class 11 Selected");
									set_view_addRecord(11);
									break;
								case "Class 12":
									//System.out.println("Class 12 Selected");
									set_view_addRecord(12);
									break;
							}
						}
						
					});
					
				} 
				else if(entrypoint==2)
				{// view data CLICKED
					btn.setBackground(Color.darkGray);
					btn.setForeground(Color.green);
					btn.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent e) {
							//System.out.println(((JButton)e.getSource()).getText() + " Pressed");		
								switch(((JButton)e.getSource()).getText()){
								case "Class 6":
									//System.out.println("Class 6 Selected");
									set_view_viewRecord(6);
									break;
								case "Class 7":
									//System.out.println("Class 7 Selected");
									set_view_viewRecord(7);
									break;
								case "Class 8":
									//System.out.println("Class 8 Selected");
									set_view_viewRecord(8);
									break;
								case "Class 9":
									//System.out.println("Class 9 Selected");
									set_view_viewRecord(9);
									break;
								case "Class 10":
									//System.out.println("Class 10 Selected");
									set_view_viewRecord(10);
									break;
								case "Class 11":
									//System.out.println("Class 11 Selected");
									set_view_viewRecord(11);
									break;
								case "Class 12":
									//System.out.println("Class 12 Selected");
									set_view_viewRecord(12);
									break;
							}
						}
						
					});//end of btn.addaction stuff
				}
				else if(entrypoint==3)
				{	System.out.print("ep3");
					btn.setBackground(Color.white);
					btn.setForeground(Color.black);
					btn.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent e) {
							//System.out.println(((JButton)e.getSource()).getText() + " Pressed");		
								switch(((JButton)e.getSource()).getText()){
								case "Class 6":
									//System.out.println("Class 6 Selected");
									set_view_attendence(6);
									break;
								case "Class 7":
									//System.out.println("Class 7 Selected");
									set_view_attendence(7);
									break;
								case "Class 8":
									//System.out.println("Class 8 Selected");
									set_view_attendence(8);
									break;
								case "Class 9":
									//System.out.println("Class 9 Selected");
									set_view_attendence(9);
									break;
								case "Class 10":
									//System.out.println("Class 10 Selected");
									set_view_attendence(10);
									break;
								case "Class 11":
									//System.out.println("Class 11 Selected");
									set_view_attendence(11);
									break;
								case "Class 12":
									//System.out.println("Class 12 Selected");
									set_view_attendence(12);
									break;
							}
						}
					
					});//end of btn.addaction stuff				

				}
				this.add(btn);
			}
		}catch (IOException e) { 
			System.out.println("IOEXCEPTION ");
			System.exit(ABORT);
		}
		
	}//end of function show_files(int entrypoint)
		
	public void set_view_addRecord(int ch){ //function to ADD NEW RECORD into file, ch represent classes file where data is to be added TODO set_view_addrecord
		this.removeAll();
		this.updateUI();//refresh screen to make sure everything works fine
		show_form_addRecord(ch);
	}
	private void show_form_addRecord(int choice){ //fxn creates complete form-Window for adding DATA to a file //TODO : show_form_addRecord
		
		final int total_textlabels = 11;//10;
		final int total_textfields = 9;//10-1 (gender uses radio buttons)
		ArrayList<JLabel>textLabels = new ArrayList<JLabel>(); //set ups the form GUI 
		ArrayList<JTextField>textFields = new ArrayList<JTextField>();//set ups
		
		JRadioButton rb_male = new JRadioButton("Male"),rb_female=new JRadioButton("Female");//gender selection buttons
		ButtonGroup btn_grp = new ButtonGroup();
		btn_grp.add(rb_male);btn_grp.add(rb_female);
		
		String[] batchStrings = {"A","B","C","D"};
		JComboBox<String> batchList = new JComboBox<String>(batchStrings);
		
		JButton btn_submit = new JButton("Submit");
		JLabel label_class=new JLabel("ADDITION OF RECORDS FOR CLASS "+Integer.toString(choice));
		
		for(int items=0;items<total_textlabels;items++){		
			JLabel temp=new JLabel();
			temp.setForeground(Color.WHITE);
			switch(items){
			case 0:
				temp.setText("Student Name");
				break;
			case 1:
				temp.setText("Student ID");
				temp.setToolTipText("ID must be UNIQUE");
				break;
			case 2:
				temp.setText("Father Name");
				break;
			case 3:
				temp.setText("Mother Name");
				break;
			case 4:
				temp.setText("Father's Mobile No.");
				break;
			case 5:
				temp.setText("Mother's Mobile No.");
				break;
			case 6:
				temp.setText("Resident Address");
				break;
			case 7:
				temp.setText("Enrolled Subjects");
				break;
			case 8:
				temp.setText("Student Age");
				break;
			case 9:
				temp.setText("Gender"); //does not need a textField , instead RADIOBUTTONS as input 
				break;
			case 10:
				temp.setText("Batch");
				break;
			}//end of switch
			textLabels.add(temp);
	
		}//end of for : textlabels
		for(int items=0;items<total_textfields;items++){		
			JTextField temp=new JTextField();
			switch(items){
			case 0:
				temp.setToolTipText("No Numbers/Special Symbols allowed. Only Alphabets Allowed");//student name
				break;
			case 1:
				temp.setToolTipText("Make sure ID is Unique and easy to recall");//id
				break;
			case 2:
				temp.setToolTipText("No Numbers/Special Symbols allowed. Only Alphabets Allowed");//fathername
				break;
			case 3:
				temp.setToolTipText("No Numbers/Special Symbols allowed. Only Alphabets Allowed");//mothername
				break;
			case 4:
				temp.setToolTipText("Only Numbers Allowed");//father number
				break;
			case 5:
				temp.setToolTipText("Only Numbers Allowed");//mother number
				break;
			case 6:
				temp.setToolTipText("Address of Student can be Alphabetical and Numerical");//address
				break;
			case 7:
				temp.setToolTipText("Example : Physics, Maths (Numbers and Alphabets Allowed)");//subject
				break;
			case 8:
				temp.setToolTipText("Only Numbers Allowed. Avoid SPACES or Alphabets or any other symbol");//address
				break;
			}//end of switch
			textFields.add(temp);
	
		}//end of for : textfields
		label_class.setForeground(Color.cyan);
		//SETTING UP ELEMENTS FOR DISPLAYING THE FORM
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints layout_property = new GridBagConstraints();
		
		layout_property.ipadx=100;
		layout_property.ipady=10;
		layout_property.insets=new Insets(2,2,2,2);
		layout_property.fill=GridBagConstraints.BOTH;
		layout_property.gridwidth=3;
		layout_property.gridy=0;
		layout_property.gridx=0;
		this.add(label_class, layout_property);
		int row=1;
		for(int i=0;i<total_textfields;i++){
			layout_property.gridy=row; 
			layout_property.gridx=0;
			layout_property.gridwidth=1;
			this.add(textLabels.get(i),layout_property); 
			if(i!=(total_textfields-1)){
			layout_property.gridx=1;
			layout_property.gridwidth=2;
			this.add(textFields.get(i), layout_property);
			}else{
				layout_property.gridx=1;
				layout_property.gridwidth=1;
				this.add(textFields.get(i), layout_property);
				
			}
			row++;
		}
		//text : GENDER (label)
		layout_property.gridy=row+1;
		layout_property.gridx=0;
		layout_property.gridwidth=1;
		this.add(textLabels.get(9),layout_property); //GENDER text/label
		
		//checkboxes (2 cb, male and female)
		layout_property.gridx=1;
		this.add(rb_male, layout_property);
		layout_property.gridx=2;
		this.add(rb_female, layout_property);
		
		
		layout_property.gridx=0;
		layout_property.gridwidth=1;
		layout_property.gridy=row+2;
		this.add(textLabels.get(10),layout_property);
		layout_property.gridx=1;
		layout_property.gridwidth=2;
		this.add(batchList, layout_property);
		
		layout_property.gridy=row+3;
		layout_property.gridx=1;
		layout_property.gridwidth=2;
		this.add(btn_submit, layout_property);
		//FORM SUCCESSFULLY DISPLAYED 
		
		
		//--------------EVENT HANDLING FOR "SUBMIT" BUTTON ----------------------

		btn_submit.addActionListener(new ActionListener(){
			
		//REMINDER :>: Consider using StudentDataChecker Class
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=null,id=null,fname=null,mname=null,fmobile=null,mmobile=null,address=null,subject=null,age = null;
				String batch;
				//1. Check if Form filled is Valid in all aspects
				boolean isValid=true;
				if( !(rb_male.isSelected() || rb_female.isSelected())){ //checking if user has not checked any of the gender checkbox
					isValid=false;//invalidate form
					new Dialogbox("Error",false,new Rectangle(200,200,200,100),null,"Gender not selected");
				}    
				batch=batchList.getSelectedItem().toString();
				if(!(batch.equals("A") ||batch.equals("B")||batch.equals("C")||batch.equals("D")))
				{
					isValid=false;
					new Dialogbox("Error",false,new Rectangle(200,200,200,100),null,"Batch Selection Wrong!");
				}
				
				for(int items=0;items<total_textfields;items++){ //now checking each TEXTFIELD one by one 	
					JTextField temp=textFields.get(items);
					switch(items){
					case 0: //STUDENT NAME textfield
						name =temp.getText().trim().toLowerCase();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,name)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Student Name is Required.");
							isValid=false;
						}
						break;
					case 1: //STUDENT ID textfield
						id = new String(temp.getText().trim());
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_ID, id)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,200,100),null,"Student ID is Required");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_ID,id)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,200,100),null,"Student ID is isValid");
							isValid=false;
						}
						break;
					case 2: //FATHER NAME textfield
						fname=temp.getText().trim().toLowerCase();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,fname)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Father Name Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME, fname)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Father Name Invalid!");
							isValid=false;
						}
						break;
					case 3: //mothername TEXTFIELD
						mname=temp.getText().trim().toLowerCase();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,mname)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Mother Name Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,mname)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Mother Name Invalid!");
							isValid=false;
						}
						break;
					case 4: // father mobile number TEXT FIELD
						fmobile=temp.getText().trim();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_MOBILE,fmobile)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Father Number Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_MOBILE, fmobile)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Father Number Invalid!");
							isValid=false;
						}
						break;
					case 5: // mother mobile number text field
						mmobile=temp.getText().trim();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_MOBILE,mmobile)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Mother Number Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_MOBILE, mmobile)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Mother Number Invalid!");
							isValid=false;
						}
						break;
					case 6: //STUDENT ADDRESS TEXT FIELD
						address=temp.getText().trim();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_ADDRESS,address)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Address Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_ADDRESS,address)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Address Invalid");
						}
						break;
					case 7: // STUDENT SUBJECTS TEXT FIELD
						subject=temp.getText().trim();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_SUBJECT,subject)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Subject Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_SUBJECT, subject)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Subject Invalid!");
							isValid=false;
						}
						
						break;
					case 8: // STUDENT  AGE
						age=temp.getText().trim();
						if(StudentDataChecker.isValid(StudentDataChecker.SDC_AGE,age)==0){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Age Required!");
							isValid=false;
						}
						else if(StudentDataChecker.isValid(StudentDataChecker.SDC_AGE,age)==-1){
							new Dialogbox("Error",false,new Rectangle(200,200,220,100),null,"Age Invalid!");
							isValid=false;
						};
						
						break;
					}//end of switch
			
				}//end of for : textfields
				//COLLECTED INFORMATION ABOUT VALIDITY OF FORM
				if(isValid){
					//save data to file 
					/*
					 * ALGORITHM CHANGED A LITTLE BIT 
					 * WE ARE NOW USING JAVA-COLLECTION-FRAMEWORK's CLASS : TreeSet instead of making our own Data-Structure
					 * Our algorithm will work as follow
					 * > First we will read FILE for TreeSet object
					 * > Now, we have TreeSet object which will contain old-data saved in file, we will now add more Student-Data into
					 * 		this TreeSet object
					 * > Once we are done, we will AGAIN SAVE WHOLE TreeSet object back into the file 
					*/
					String file_name = null;
					file_name=new String("std"+choice+".dat"); //
					
					FileOutputStream fout=null;
					FileInputStream fin = null;
					TreeSet<Student> Student_Data = new TreeSet<Student>();
					try {
						fin = new FileInputStream(file_name);
						File f1=new File(file_name);
						System.out.println(file_name+"size = "+f1.length());
						ObjectInputStream ois= new ObjectInputStream(fin);
						Student_Data = (TreeSet<Student>)ois.readObject();
						ois.close();
					} catch (FileNotFoundException e3) {
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					try {
						fout = new FileOutputStream(file_name,false/*true*/);//APPEND is false because we are now storing whole TreeSet once
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
						System.exit(1);

					}
					try {
						ObjectOutputStream oos=new ObjectOutputStream(fout);
						Student student = new Student(choice); //choice == class/standard to which student belong,
						//name,id,fname,mname,fmobile,mmobile,address,subject,age;
						student.name=new String(name);
						student.id=new String(id);
						student.fathername=new String(fname);
						student.mothername=new String(mname);
						student.fathermobile=new String(fmobile);
						student.mothermobile=new String(mmobile);
						student.address=new String(address);
						student.subject=new String(subject);
						student.age=new String(age);
						if(rb_male.isSelected())
							student.gender='M';
						else if(rb_female.isSelected())
							student.gender='F';
						student.batch=new String(batch);
						student.standard=choice;
						boolean isSaved=Student_Data.add(student);
						if(!isSaved){
							new Dialogbox("Duplicate Entry !!!",false,new Rectangle(200,200,200,100),null,"Record Already Exists");
						}
						
						oos.writeObject(Student_Data);
						//fout.close(); isn't necessary as closing oos (parent stream) closes all linked child streams
						oos.close();
						if(isSaved){
						new Dialogbox("Submitted",false,new Rectangle(200,200,200,100),null,"Successfully Registered!");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
						System.exit(1);
					}
				}//end of : if(isValid) statement
				//else {} do nothing 
				
			}//end of fxn : .addActionListener
			
		}); //end of anonymouse inner class 
		
		//--------------END OF EVENT HANDLING------------------------------------
		
	}//end of fxn : show_form_addRecord(int) 
	public void set_view_viewRecord(int ch){
		this.removeAll();
		this.updateUI();
	//	JTable table = null;
		table=new JTable(new CTableModel("std"+ch+".dat"));
		CTableModel.resetValue("std"+ch+".dat");
		
		//table.updateUI();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		JButton btn_ViewRecord = new JButton("View Record");
		JButton btn_ModifyRecord = new JButton("Modify Record");
		JButton btn_DeleteRecord = new JButton("Delete Record");
		JButton btn_FilterRecord = new JButton("Filter Record");
		JButton btn_Refresh = new JButton("Refresh List");
		JButton btn_Submit = new JButton("Submit");
		this.setLayout(new GridBagLayout());
		GridBagConstraints layout_property = new GridBagConstraints();

		table.setFillsViewportHeight(true);
		table.setVisible(true);
		//SCROLL BAR CODE
		JScrollPane js=new JScrollPane(table); 
		js.setPreferredSize(new Dimension(570,400));
		//END OF SCROLL BAR CODE
		layout_property.gridx=0;
		layout_property.gridy=0;
		layout_property.gridheight=6;
		layout_property.gridwidth=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(js,layout_property);//,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=0;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_ViewRecord,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=1;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_ModifyRecord,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=2;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_DeleteRecord,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=3;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_FilterRecord,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=4;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_Refresh,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=6;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_Submit,layout_property);
		
		//EVENT HANDLING FOR BUTTONS
		//VIEW RECORD BUTTON
		btn_ViewRecord.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String selectedID;
				Student selectedData = null;
				//System.out.println(selectedRow);
				//System.out.println(CTableModel.Student_List.size());
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				else{
					//System.out.println(table.getValueAt(selectedRow, 0));
					selectedID = (String) table.getValueAt(selectedRow,0);
					for(Student std: CTableModel.Student_List){
						if(std.id.equals(selectedID)){
							selectedData=new Student(std);
							break;
						}
					}
					//DISPLAY STUDENT DETAIL
					new Dialogbox("Student Detail",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,selectedData,false);
					
				}
			}
			
		});
		//MODIFY RECORD BUTTON
		btn_ModifyRecord.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String selectedID;
				Student selectedData=null;
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				else{
					selectedID = (String) table.getValueAt(selectedRow, 0);
					for(Student std: CTableModel.Student_List){
						if(std.id.equals(selectedID)){
							selectedData=new Student(std);
							break;
						}
					}
					//retrieved Student Object
					new Dialogbox("Student Detail",true,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,selectedData,true);
					table.updateUI();
				}
				
			}
			
		});
		
		//Delete Record Button : Alters content of 2ND LAYER (Student_List) and calls UpdateFile() method to update Data Tree
		btn_DeleteRecord.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String selectedID;
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				else
				{
					selectedID = (String) table.getValueAt(selectedRow,0); //get student ID
					for(Student std: CTableModel.Student_List){
						if(std.id.equals(selectedID)){
							CTableModel.Student_List.remove(selectedRow);
							break;
						}
					}
					
					CTableModel.UpdateFile();//it will re-form the Student_Data TREE-STRUCTURE inside CTableModel, and internally updates file
					new Dialogbox("Deleted",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"deleted record");
					table.removeAll();
					System.out.println(" REFRESHED ");
					table.updateUI();
				}
				
			}
			
		});
		
		//Filter Record Button
		btn_FilterRecord.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				
			}
			
		});
		
		//Refresh List Button
		btn_Refresh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				table.updateUI();
			}
			
		});
		
		//Submit records button
		btn_Submit.addActionListener(new ActionListener(){
			@Override	
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				
			}
			
		});
	}
	public void set_view_attendence(int ch){ //TODO : set_view_attendence()
		this.removeAll();
		this.updateUI();
		//	JTable table = null;
		table=new JTable(new CTableModel("std"+ch+".dat"));
		CTableModel.resetValue("std"+ch+".dat");
		
		//table.updateUI();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		
		final String[] batchStrings={"All","A","B","C","D"};
		JComboBox<String> choice_batchList=new JComboBox<String>(batchStrings);
		JLabel label_batchChoice=new JLabel("Filter Batch");
		label_batchChoice.setForeground(Color.white);
		
		JButton btn_ViewRecord=new JButton("View Record");
		JButton btn_MarkPresent = new JButton("Mark Present");
		JButton btn_MarkAbsent = new JButton("Mark Absent");
		JButton btn_Refresh = new JButton("Refresh List");
		JButton btn_Submit = new JButton("Submit");
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints layout_property = new GridBagConstraints();
		
		table.setFillsViewportHeight(true);
		table.setVisible(true);
		//SCROLL BAR CODE
		JScrollPane js=new JScrollPane(table); 
		js.setPreferredSize(new Dimension(570,400));
		//END OF SCROLL BAR CODE
		layout_property.gridx=0;
		layout_property.gridy=0;
		layout_property.gridheight=1;
		layout_property.gridwidth=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(label_batchChoice,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=0;
		layout_property.gridheight=1;
		layout_property.gridwidth=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(choice_batchList,layout_property);
		
		layout_property.gridx=0;
		layout_property.gridy=1;
		layout_property.gridheight=6;
		layout_property.gridwidth=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(js,layout_property);//,layout_property);
		layout_property.gridx=1;
		layout_property.gridy=1;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_ViewRecord, layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=2;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_MarkPresent,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=3;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_MarkAbsent,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=4;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_Refresh,layout_property);
		
		layout_property.gridx=1;
		layout_property.gridy=5;
		layout_property.gridwidth=1;
		layout_property.gridheight=1;
		layout_property.fill=GridBagConstraints.HORIZONTAL;
		this.add(btn_Submit,layout_property);
		//EVENT HANDLING FOR BUTTONS
		//VIEW RECORD BUTTON
		btn_ViewRecord.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String selectedID;
				Student selectedData = null;
				//System.out.println(selectedRow);
				//System.out.println(CTableModel.Student_List.size());
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				else{
					//System.out.println(table.getValueAt(selectedRow, 0));
					selectedID = (String) table.getValueAt(selectedRow,0);
					for(Student std: CTableModel.Student_List){
						if(std.id.equals(selectedID)){
							selectedData=new Student(std);
							break;
						}
					}
					//DISPLAY STUDENT DETAIL
					new Dialogbox("Student Detail",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,selectedData,false);
					
				}
			}
			
		});
		btn_MarkPresent.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String selectedID;
				//System.out.println(selectedRow);
				//System.out.println(CTableModel.Student_List.size());
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				else{
					//System.out.println(table.getValueAt(selectedRow, 0));
					selectedID = (String) table.getValueAt(selectedRow,0);
					int index=0;
					for(Student std: CTableModel.Student_List)
					{
						if(std.id.equals(selectedID)){
							
							System.out.println("attendence is "+std.getAttendencePercentage());
							break;
						}
						index++;
					}
					CTableModel.Student_List.get(index).markPresent();
					System.out.println("attendence is "+CTableModel.Student_List.get(index).getAttendencePercentage());
					//DISPLAY STUDENT DETAIL
				}
			}
		});
	//MODIFY RECORD BUTTON
		btn_MarkAbsent.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String selectedID;
				//System.out.println(selectedRow);
				//System.out.println(CTableModel.Student_List.size());
				if(table.getRowCount()==0){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
				}
				else if(selectedRow==-1){
					new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
				}
				else{
					//System.out.println(table.getValueAt(selectedRow, 0));
					selectedID = (String) table.getValueAt(selectedRow,0);
					int index=0;
					for(Student std: CTableModel.Student_List)
					{
						if(std.id.equals(selectedID)){
							
							System.out.println("attendence is "+std.getAttendencePercentage());
							break;
						}
						index++;
					}
					CTableModel.Student_List.get(index).markAbsent();
					System.out.println("attendence is "+CTableModel.Student_List.get(index).getAttendencePercentage());
					//DISPLAY STUDENT DETAIL
				}
			}
		});
		//TODO : Rfresh
			//Refresh List Button in ATTENDENCE VIEW
		btn_Refresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				CTableModel.set_batchToRender(new String( (String)choice_batchList.getSelectedItem() ));

				table.updateUI();
			}	
		
		});
		
		//Submit records button
		btn_Submit.addActionListener(new ActionListener(){
			@Override	
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
					if(table.getRowCount()==0){
						new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"Table is Empty!");
					}
					else if(selectedRow==-1){
						new Dialogbox("Error!",false,new Rectangle(table.getLocationOnScreen().getLocation().x+200,table.getLocationOnScreen().getLocation().y+50,100,100),null,"No Row Selected!");
					}
					else
					{
						CTableModel.UpdateFile();
					}
					
				}
			
			});
		}
	}
//TODO : CTableModel 
class CTableModel extends AbstractTableModel{ 
	/**
	 * Data Model Explanation 
	 * > First Entire StudentData TreeSet is read and stored in Student_Data object 
	 * > for each student value in Student_Data, it is now copied into another Array Student_List
	 * 
	 * Student_Data (holds many objects arranged in TreeSet) --> Student_List (puts student objects in array --> PARSED each member of Student
	 *
	 * temp_StudentList is a upper most data storage layer, that only handles data that is shown in Table and have no interaction
	 * with whatever data that is stored in file
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] columnNames = 
		{
				"ID", //index=0
				"Name",//index=1
				"Gender",//index=2
				"Fathername",//index=3
				"Batch"//index=4
		};
	public static ArrayList<Student> Student_List;//=new ArrayList<Student>();
	private static TreeSet<Student> Student_Data;// = new TreeSet<Student>();
	public static ArrayList<Student> temp_StudentList; //upper most layer of data, that has 0 Interaction with file 
	//Student_Data is the object that is read directly from FILE in raw form (tree-structure)
	//Student_List is a organised Data File where Raw_Data is organised in a List
	private static String active_file=null; //added internal parameter to keep track on Active file instead of passing file name around
	
	
	/*batchToRender decides which Data to display,
	 *  if set to "All", All student records are display even if batch are different
	 *  if set to "A", Only student records belonging to batch A will be rendered
	 *  and same goes for "B", "C" And "D"
	 *  
	 *  look for UpdateDataRenderLayer() method, 
	 *  Table renders data stored in temp_StudentList
	 *  Student_List stores the tree-data in a list-format for improved indexing and sorting process
	 *  Student_Data stores the data in its RAW-FORM, the way its stored in the File
	*/
	private static String batchToRender =new String("All"); // All , A,B,C,D : change this variable to render specific batch Data (filter)
	public static void set_batchToRender(String batch_name)
	{
		batchToRender=new String(batch_name);
		updateDataRenderLayer();
	}
	@SuppressWarnings("unchecked")
	public CTableModel(String file_name){ 
		
		Student_List=new ArrayList<Student>(); 
		Student_Data=new TreeSet<Student>();
		active_file=new String(file_name);
		
		//Extracting Data from "active_file"
		FileInputStream fin;
		try 
		{
			System.out.println("file_name : "+file_name+" and active_file : "+active_file);
			fin=new FileInputStream(active_file);
			ObjectInputStream ois= new ObjectInputStream(fin);
			Student_Data.clear();  //clear old data
			Student_List.clear(); //clear old data
			Student_Data = new TreeSet<Student>( (TreeSet<Student>)ois.readObject() );
		//	Student_Data=(TreeSet<Student>)ois.readObject();
			for(Student std:Student_Data){		
				Student_List.add(std);
			}
			temp_StudentList = new ArrayList<Student>(Student_List);
			ois.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("error1 : Line 930 > Cpanel : FNF");
			// 
		//	e.printStackTrace();
			//System.exit(1);
		} 
		catch (IOException e) {
			//
			System.out.println("error2 : line 936 > CPanel : IOException");
			e.printStackTrace();
			System.exit(1);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("error3");
			//
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	//Data Extracted
	
	
	public static void UpdateFile(){ //changes content of Active_File 
		//System.out.println("INSIDE UPDATE METHOD");
		FileOutputStream fout;
		try {
			fout=new FileOutputStream(active_file,false);
			Student_Data.clear();//clears the tree
			
			//RE-FORM THE TREE-STRUCTURE 
			for(Student temp:Student_List){
				Student_Data.add(temp);
				//System.out.println(Student_Data.toString());
			}
			ObjectOutputStream ois=new ObjectOutputStream(fout);
			ois.writeObject(Student_Data);
			ois.close();
			
			updateDataRenderLayer(); //also update RenderLayer (temp_StudentList) since bottom layers can be altered
			
		} catch (FileNotFoundException e) {
			// 
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			//
			e.printStackTrace();
			System.exit(0);
		}
		//new Dialogbox("Record Deleted",false,new Rectangle(100,100,100,100),null,"RECORD DELETED");
	}
	public static void resetValue(String activeFile){
		active_file=activeFile;
		UpdateFile();
	}
	@Override
	public String getColumnName(int col) {
	      return columnNames[col];
	    }
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	//
	@Override
	public int getRowCount() {
		//return Student_List.size();
		return temp_StudentList.size();
	}
	
	
	@Override
	public Object getValueAt(int row, int col) {
		updateDataRenderLayer(); //update temp_StudentList data so as to Render Correct details on the Table
		if(col==0){//ID
			//return Student_List.get(row).id;
			return temp_StudentList.get(row).id;
		}
		else if(col==1){ //NAME
			//return Student_List.get(row).name;
			return temp_StudentList.get(row).name;
		}
		else if(col==2){// Gender
			//return Student_List.get(row).gender;
			return temp_StudentList.get(row).gender;
		}
		else if(col==3){//FatherName
			//return Student_List.get(row).fathername;
			return temp_StudentList.get(row).fathername;
		}
		else if(col==4){//ContactNumber
			//return Student_List.get(row).batch;
			return temp_StudentList.get(row).batch;
		}
		return null;
	}
	private static void updateDataRenderLayer() //refresh temp_StudentList in order to render changes into table
	{
		
		temp_StudentList.clear();//CLEAR Upper Data layer		
		if(batchToRender.equals("All"))
		{
			CTableModel.temp_StudentList = new ArrayList<Student>(CTableModel.Student_List);
			return;
		}
		//create a copy of Student List of current file and store in temp_stdList, 
		//any modification made to temp_stdList will not alter content of file
		//ArrayList<Student> temp_stdList=new ArrayList<Student>();
		
		CTableModel.temp_StudentList = new ArrayList<Student>();
		for(Student std : CTableModel.Student_List  )//TODO : Changed  ((CTableModel)table.getModel()).Student_List 
		{	
			if(std.batch.equals(batchToRender))
			{
				CTableModel.temp_StudentList.add(std);
			}
			
		}
	}
	
}