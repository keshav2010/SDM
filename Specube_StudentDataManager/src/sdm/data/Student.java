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
	//class | name | id | fathername |mothername | fathermobile |mothermobile 
	//public char batch;
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
		// TODO Auto-generated constructor stub
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
}
