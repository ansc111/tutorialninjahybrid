package experiments;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	Date  date= new Date();
	
	//System.out.println(date.toString().replace(" ", "_").replace(":","_"));
	
	String datetext=date.toString();
	String dateTextWithoutSpaces = datetext.replace(" ", " _");
	String textwithoutspaceandcolumn=dateTextWithoutSpaces.replace(":","_");
	System.out.println(textwithoutspaceandcolumn);
	
	
	
	}

}
