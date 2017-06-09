package sdm.displaywindow;

import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sdm.data.Student;
import sdm.data.StudentDataChecker;
 

/* REMINDER
 * 1. > Replace Gender TEXTFIELD to RADIO-BUTTONS
 */
public class StudentDataViewer extends JPanel{
	/*
	 * 	public String name;	//d
	public String address; //d
	public String subject;//d
	public String fathername;//d
	public String mothername;//d
	public String fathermobile;//d
	public String mothermobile;//d
	public String id;//d
	public String age;//d
	public char gender;//d 
	public int standard;//d
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel>label_list=new ArrayList<JLabel>();
	private ArrayList<JTextField>info_list=new ArrayList<JTextField>();
	private int std_class=-1;
	JRadioButton rb_male = new JRadioButton("Male");
	JRadioButton rb_female=new JRadioButton("Female");//gender selection buttons
	ButtonGroup btn_grp = new ButtonGroup();
	private JButton btn_UpdateRecord=new JButton("Update Record");
	private GridBagConstraints c;
	private boolean Modification=false;//by-default viewer is set to VIEW-ONLY Mode
	
	final private Student student;
	
	public StudentDataViewer(Student student_data,boolean Modify)
	{
		btn_grp.add(rb_male);btn_grp.add(rb_female);
		student=new Student(student_data);
		
		std_class=student.standard;
		//std_class=student_data.standard;
		Modification=Modify;
		label_list.add(new JLabel("Student Name:"));
		label_list.add(new JLabel("Standard:"));
		label_list.add(new JLabel("Father Name:"));
		label_list.add(new JLabel("Mother Name:"));
		label_list.add(new JLabel("Father Mobile:"));
		label_list.add(new JLabel("Mother Mobile:"));
		label_list.add(new JLabel("Student Age:"));
		label_list.add(new JLabel("Gender:"));
		label_list.add(new JLabel("Subjects:"));
		label_list.add(new JLabel("Address:"));
		label_list.add(new JLabel("Student ID:"));
		
		info_list.add(new JTextField(student.name));
		switch(student.standard){
		case 6:info_list.add(new JTextField("6th"));break;
		case 7:info_list.add(new JTextField("7th"));break;
		case 8:info_list.add(new JTextField("8th"));break;
		case 9:info_list.add(new JTextField("9th"));break;
		case 10:info_list.add(new JTextField("10th"));break;
		case 11:info_list.add(new JTextField("11th"));break;
		case 12:info_list.add(new JTextField("12th"));break;
		}
		
		info_list.add(new JTextField(student.fathername));
		info_list.add(new JTextField(student.mothername));
		info_list.add(new JTextField(student.fathermobile));
		info_list.add(new JTextField(student.mothermobile));
		info_list.add(new JTextField(student.age));
		
		if(student.gender=='M'){
			btn_grp.setSelected(rb_male.getModel(), true);
		}
		else{
			btn_grp.setSelected(rb_female.getModel(),true);
		}
		if(!Modify){
			rb_male.setEnabled(false);
			rb_female.setEnabled(false);
		}
		/*
		if(student.gender=='F')
			info_list.add(new JTextField("FEMALE"));
		else info_list.add(new JTextField("MALE"));
		*/
		info_list.add(new JTextField(student.subject));
		info_list.add(new JTextField(student.address));
		info_list.add(new JTextField(student.id));
		this.setLayout(new GridBagLayout());

		if(!Modify){
			this.setBackground(Color.YELLOW);
			for(JTextField temp:info_list){
				temp.setEditable(false);
				temp.setBorder(null);
			}	
			setupDisplay();
			setVisible(true);
		}//end of if not Modifable condition
		else
		{ //IF MODIFICATION OF THE DATA IS ALLOWED
			this.setBackground(Color.cyan);
			
			
			btn_UpdateRecord.addActionListener(new ActionListener(){
				
				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent arg0) {

					String text=null;
					boolean isValid=true;
					//checking validity of new data entered
					for(int i=0;i<10;i++){
						text=new String(info_list.get(i).getText().trim());
						if(text.length()==0){
							new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"No Empty Field Allowed.");
							isValid=false;
							break;//brea
						}
						else{
							switch(i){
							case 0://name 
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Student Name Invalid.");
									isValid=false;
								}
								break;
							case 1://class [NON EDITABLE]
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_CLASS,text)!=1){
									isValid=false;
								}
								break;
							case 2://fname 
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Father Name Invalid.");
									isValid=false;
								}
								break;
							case 3://mname
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_NAME,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Mother Name Invalid.");
									isValid=false;
								}
								break;
							case 4://f-mobile
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_MOBILE,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Father Mobile Invalid.");
									isValid=false;
								}
								break;
							case 5://m-mobile
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_MOBILE,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Mother Mobile Invalid.");
									isValid=false;
								}
								break;
							case 6://age
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_AGE,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Student Age Invalid.");
									isValid=false;
								}
								break;
							case 7://subject
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_SUBJECT,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Student Subject Invalid.");
									isValid=false;
								}
								break;
							case 8://address
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_ADDRESS,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Invalid Address.");
									isValid=false;
								}
								break;
							case 9://id
								if(StudentDataChecker.isValid(StudentDataChecker.SDC_ID,text)!=1){
									new Dialogbox("Error",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"ID is Invalid.");
									isValid=false;
								}
								break;
							}//eo-switch
						}//eo-else
					}//eo-for-loop
					
					if(isValid){ 
						/*
						 * NOTE : student_data is the original data recieved and the new data is stored in info_list and gender checkbox 
						 * 
						 * Open File and load Raw-Data [ Student-Tree ] 
						 * Extract data from TREESET into ArrayList 
						 * Parse ArrayList and over-write the updated data file 
						 * Again Create NEW TREESET from modified ArrayList 
						 * OVER-WRITE the NEW TREESET back into file 
						 * CLOSE FILE after replacing NEW TREESET with old 
						 */
						Student newStudentRecord;
						TreeSet<Student>temp_treeset;
						ArrayList<Student>temp_arraylist;
						FileInputStream temp_fin;
						ObjectInputStream temp_oin;
						FileOutputStream temp_fout;
						ObjectOutputStream temp_oos;
						if(std_class>=6 && std_class<=12)
						{	//System.out.println("std class value in range "+std_class);
							try 
							{
								//-------------------------------
								newStudentRecord=new Student(std_class);
								newStudentRecord.name=new String(info_list.get(0).getText());
								newStudentRecord.id=new String(info_list.get(9).getText());
								newStudentRecord.fathername=new String(info_list.get(2).getText());
								newStudentRecord.mothername=new String(info_list.get(3).getText());
								newStudentRecord.fathermobile=new String(info_list.get(4).getText());
								newStudentRecord.mothermobile=new String(info_list.get(5).getText());
								newStudentRecord.address=new String(info_list.get(8).getText());
								newStudentRecord.subject=new String(info_list.get(7).getText());
								newStudentRecord.age=new String(info_list.get(6).getText());
								
								if(rb_male.isSelected())
								{
									//System.out.println("MALE is Selected");
									newStudentRecord.gender='M';
								}
								else if(rb_female.isSelected())
								{
									//System.out.println("FEMALE is Selected");
									newStudentRecord.gender='F';
								}
								
								newStudentRecord.standard=std_class;
								//-------------------------------
								
								//Check if there is student-record with same parameters
								//we need to avoid checking the to-be-modified object since it has
								//same id as newStudentRecord, so we will skip it and compare only 
								//other records
								for(Student std:CTableModel.Student_List)
								{
									if(std.compareTo(newStudentRecord)==0)
									{
										if(std.id.equals(newStudentRecord.id))
											continue;
										new Dialogbox("Record Modified",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Record Already Exists!");
										//System.out.println("Student Already Exists");
										return;
									}
									/*
									else
									{
										System.out.println("Student Don't Exists");
									}
									*/
								}
								//-------------------------------
								//1. Retrieve old data from file into tree and arraylist
								temp_fin = new FileInputStream("std"+String.valueOf(std_class)+".dat");
								temp_oin=new ObjectInputStream(temp_fin);
								temp_treeset=new TreeSet<Student>( (TreeSet<Student>)temp_oin.readObject());
								temp_oin.close();
								temp_arraylist=new ArrayList<Student>();
						
								for(Student std:temp_treeset){
									temp_arraylist.add(std); 
								}
								//stored data in arraylist and tree
								
								int index=0;
								for(Student std:temp_arraylist){
									//System.out.println("Setting New dATA");
									if(std.id.equals(info_list.get(9).getText()))
									{	
									//	Student s=temp_arraylist.get(index);
									//	System.out.println(s.name+"replacing with");
										temp_arraylist.set(index,newStudentRecord);		
										//System.out.println("NEW DATA SET :"+newStudentRecord.name);
									//	System.out.println("Now at index, name is "+temp_arraylist.get(index).name);
										break;
									}
									index++;
								}
								//re-creating treeset
								temp_treeset.clear();
								for(Student std:temp_arraylist){
									temp_treeset.add(std);
								}
								temp_fout = new FileOutputStream("std"+String.valueOf(std_class)+".dat",false); //by default append is false
								temp_oos=new ObjectOutputStream(temp_fout);
								temp_oos.writeObject(temp_treeset);
								temp_oos.close();		
							//	CTableModel.UpdateFile(); //update the files 
								CTableModel.Student_List=new ArrayList<Student>(temp_arraylist);
								CTableModel.resetValue("std"+String.valueOf(std_class)+".dat");
								new Dialogbox("Record Modified",false,new Rectangle(getLocationOnScreen().getLocation().x,getLocationOnScreen().getLocation().y+50,220,100),null,"Press Refresh to see Changes");
							} 
							catch (FileNotFoundException e) {
								e.printStackTrace();
								//System.out.println("FILE NOT FOUND : error SDV > Update Validity Check");//debug, remove line on release
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							catch (ClassNotFoundException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				}
				
			});
			setupDisplay();
		
			
		}
	} //end of student data viewer constructor
	private void setupDisplay(){
		c=new GridBagConstraints();
		c.gridx=c.gridy=0;
		c.ipadx=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.ipadx=1;
		
		for(JLabel temp:label_list){
			c.gridx=0;
			c.gridwidth=1;
			this.add(temp,c);//add label
			c.gridy++;
		}
		
		c.gridy=0;
		c.gridx++;
		for(JTextField temp:info_list){
			c.gridwidth=2;
			if(c.gridy==7){
				c.gridwidth=1;
				this.add(rb_male, c);
				c.gridx++;
				this.add(rb_female, c);
				c.gridx--;
				c.gridy++;
				this.add(temp, c);
			}
			else this.add(temp, c);
			c.gridy++;
		}
		
		if(Modification)//if the view-mode is "MODIFICATION", then add a button
		{
			info_list.get(1).setEditable(false);
			info_list.get(9).setEditable(false);
			c.gridx=1;
			this.add(btn_UpdateRecord, c);
		}
	}
}
