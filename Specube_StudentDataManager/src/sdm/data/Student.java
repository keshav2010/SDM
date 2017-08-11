package sdm.data;

import java.io.Serializable;
/*
 * THIS IS THE STUDENT OBJECT, STILL UNDER WORK AND IS NOT WORKING AT THE MOMENT SO IGNORE IT
 * log: 30 - dec - 2016
 */
public class Student implements Serializable,Comparable<Student>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	public String name;	
	public String address;
	public String subject;
	public String fathername;
	public String mothername;
	public String fathermobile;
	public String mothermobile;
	public String id;
	public String age;
	public char gender;
	public int standard;//standard=class in which student studies
	
	//data for attendence
	private int total_classes;
	private int attended_classes;
	private float attendence;
	//-------------------
	
	//class | name | id | fathername |mothername | fathermobile |mothermobile 
	public String batch; //NEW ENTRY : 14/07/2017 | Friday 
	public Student(int std){
		name=null;
		address=null;
		subject=null;
		fathername=null;
		mothername=null;
		fathermobile=null;
		mothermobile=null;
		id=null;
		age=null;
		gender=' ';
		standard=std;
		batch=new String("A"); //TOTAL AVAILABLE BATCHES : 4 ( A,B,C,D)
		total_classes=0;
		attended_classes=0;
		attendence=0;
	}
	public Student(Student std) {
		name=new String(std.name);
		address=new String(std.address);
		subject=new String(std.subject);
		fathername=new String(std.fathername);
		mothername=new String(std.mothername);
		fathermobile=new String(std.fathermobile);
		mothermobile=new String(std.mothermobile);
		id=new String(std.id);
		age=new String(std.age);
		gender=std.gender;
		standard=std.standard;
		batch=new String(std.batch);
		total_classes=std.total_classes;
		attended_classes=std.attended_classes;
		attendence=std.attendence;
	}
	@Override //check if id is same. return 0, else check for > and < 
	public int compareTo(Student std) { 
		/*
		 * either id's should be equal , if not equal then name,address,subject,fathername,mothername,fathermobile,mothermobile,age,and gender must be equal 
		 */
		//long if statement, checks if id is same or not, if not, then checks if rest of fields are same or not
		if(id.equals(std.id) || (name.equals(std.name) && address.equals(std.address) && subject.equals(std.subject)&&fathername.equals(std.fathername)&&mothername.equals(std.mothername)&&fathermobile.equals(std.fathermobile)&&mothermobile.equals(std.mothermobile)&&age.equals(std.age)&&gender==std.gender))
			return 0; //objects are equal if either id is same or id is different but all other values are same
		return name.compareTo(std.name);//this helps arrange records according to 
	}

	public void markPresent(){
		attended_classes++;
		total_classes++;
		System.out.println("MarkedPresent, attended classes = "+attended_classes+" tc = "+total_classes);
	}
	public void markAbsent(){
		total_classes++;
		System.out.println("MarkedAbsent, attended classes = "+attended_classes+" tc = "+total_classes);
	}
	public float getAttendencePercentage(){
		if(total_classes>0)
			attendence = ((float)attended_classes/total_classes) * 100.0f;
		else return 0;
		return attendence;
		
	}
}
