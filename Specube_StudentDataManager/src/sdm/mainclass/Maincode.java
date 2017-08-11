package sdm.mainclass;

import java.io.File;
import sdm.programflow.*;
public class Maincode {
	public static void main(String[] args){
	
		File file = new File("config.dat");
		
		file.delete(); //Remove this code during release/final build
		
		if(file.exists()){
			//System.out.print("CONFIG IS COMPLETE "); //debug purpose only, remove during release time
			//System.out.print(file.getAbsolutePath());//debug only, remove during release time
			new Normalflow().start();
		}
		else if(!file.exists()){
			new Configflow().start();
		}
		
	}
}
