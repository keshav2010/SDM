package sdm.data;

//A StudentDataChecker Class is responsible for validating the student-data, SDC's task is to ensure every information 
// related to student is valid as such name can't be a numeral and phone number can't be alphabetical etc.
// It receives 2 inputs, a "parameter" and "value", the "parameter" defines the type of data-value 
// based on type of value, it checks validity and returns 0 (empty) , -1 (invalid) and 1 (valid)

//STUDENT-DATA-CHECKER (SDC) Must work separately and should not call any method (like dialogBox) , and should only return values 
//this is done to ensure usability in future code

//SDC is however capable of performing small string manipulations such as trimming (removing extra-spaces)


//CHECK : NAME , CLASS, ID, AGE, ADDRESS, GENDER, SUBJECT, MOBILE.
public class StudentDataChecker {
	
	//FLAGS 
	public static final int SDC_NAME=1,
			SDC_CLASS=2,
			SDC_AGE=3,
			SDC_ID=4,
			SDC_ADDRESS=5,
			SDC_SUBJECT=6,
			SDC_MOBILE=7,
			SDC_GENDER=8; //This might not be required 
	
	public static int isValid(int parameter,String value){
		if(parameter == SDC_NAME){
			value = new String(value.trim()); //
			if(value.length()==0){
				return 0;//not valid, name type can't be left empty
			}
			else{
				for(int i=0;i<value.length();i++){
					if(value.charAt(i)>='a' && value.charAt(i)<='z' || value.charAt(i)==' ')
						continue;
					else
						return -1; //Only Alphabets and Spaces allowed in student name 
				}//end of for loop, now check for spaces count
				
			}
			return 1;
		}
		else if(parameter==SDC_CLASS){
				//CLASS DOES NOT REQUIRE ANY CHECKING AS ITS UN-CHANGABLE THIS TIME 
				return 1;
		}
		else if(parameter==SDC_ID){
			value = new String(value.trim());
			if(value.length()==0){
				return 0;//ID can't be empty 
			}
			return 1;//Return 1 
		}
		else if(parameter==SDC_AGE){
			value=new String(value.trim());
			if(value.length()==0)
				return 0;
			else if(value.length()>=3||value.length()==0){
				return -1;//age can't be in 3 digit or 0 digit
			}
			else{
				for(int i=0;i<value.length();i++){
					if(value.charAt(i)>='0' && value.charAt(i)<='9')
						continue;
					else{
						return -1;//age only in numbers 
					}
				}
			}
			return 1;
		}
		else if(parameter==SDC_ADDRESS){
			value=new String(value.trim());
			if(value.length()==0){
				return 0;
			}
			return 1;
			
		}
		else if(parameter==SDC_GENDER){
			if(value.charAt(0) == 'M' || value.charAt(0)=='F'){
				return 1;
			}
			return 0;
		}
		else if(parameter==SDC_SUBJECT){
			value=new String(value.trim());
			if(value.length()==0){
				return 0;
			}
			return 1;
		}
		else if(parameter==SDC_MOBILE){
			value=new String(value.trim());
			if(value.length()==0){
				return 0;
			}
			else{
				for(int i=0;i<value.length();i++){
					if(value.charAt(i)>='0' && value.charAt(i)<='9')
						continue;
					else{
						return -1;
					}
				}
			}
			return 1;
		}
		
		
		return 0;
	}
}
