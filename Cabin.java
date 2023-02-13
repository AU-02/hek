//package Ship; //CREATING PACKAGE
import java.util.Scanner; //IMPORTING SCANNER CLASS
import java.io.*; //IMPORTING IO PACKAGE TO STORE AND LOAD DATA FROM FILES

class Cabin //CREATING CLASS
{
	static String[] cabin = new String[12]; //DECLARE CABIN ARRAY WITH 12 ELEMENTS(GLOBAL VARIABLE)
	
	//CREATING SCANNER CLASS OBJECT-static
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String []args) //MAIN METHOD
	{
		//LABEL FOR MENUE - IT WILL WORK UNTIL THE USER DOESN'T WANT TO STOP
		menue:while(true)
		{
			//DISPLAYING MENUE TO USER
			System.out.println("A. Add a Customer to a Cabin \nV. View All Cabins\nE. Display Empty cabins \nD: Delete customer from cabin \nF: Find cabin from customer name \nS: Store program data into file \nL: Load program data from file \nO: View passengers Ordered alphabetically by name\nT:Print Expense Details of the passengers \nZ:Exit");
			//GETTING THE SELECTION AS USER INPUT
			System.out.println("Enter the letter of your selection from the menue: ");
			char selection=sc.next().charAt(0);
			System.out.println("------------------------------------------------------");
			
			//SWITH CASE TO EXECUTE THE METHODS BASED ON THE USER SELECTION
			switch(selection)
			{
				case 'A': 
				addCustomerToCabin(); //CALL METHOD
				System.out.println("------------------------------------------------------");
				break; //BREAK FROM THE SWITCH CASE AND GOTO THE MENUE PRINTING STATEMENT
				
				case 'V':
				viewAllCabins();
				System.out.println("------------------------------------------------------");
				break;
				
				case 'E':
				displayEmptyCabins();	
				System.out.println("------------------------------------------------------");
				break;

				case 'D':
				deleteCustomerFromCabin();
				System.out.println("------------------------------------------------------");
				break;
				
				case 'F':
				findCabinFromCustomerName();
				System.out.println("------------------------------------------------------");
				break;
				
				case 'S':
				storeData();
				System.out.println("------------------------------------------------------");
				break;
				
				case 'L':
				loadData();
				System.out.println("------------------------------------------------------");
				break;
					
				case 'O':		
				sortPassengers();
				System.out.println("------------------------------------------------------");
				break;
				
				case 'T':
				Passenger []psngrList=new Passenger[3];
				psngrList[0]=new Passenger();
				psngrList[1]=new Passenger();
				psngrList[2]=new Passenger();
				
				psngrList[0].setFirstName("Jhon");
				psngrList[0].setSurName("Kennedy");
				psngrList[0].setExpense(120.2);
				
				psngrList[1].setFirstName("Will");
				psngrList[1].setSurName("Smith");
				psngrList[1].setExpense(321.12);
				
				psngrList[2].setFirstName("Marie");
				psngrList[2].setSurName("Jorge");
				psngrList[2].setExpense(1222.12);
				
				double totExp=0;
				
				System.out.println("Expenses per passenger: ");
				System.out.println("----------------------------------------------------\nFirst Name \t Sur Name\t Expense\n----------------------------------------------------");
				
				for(int i=0;i<psngrList.length;i++)
				{
					System.out.println(psngrList[i].getFirstName()+"\t\t "+ psngrList[i].getSurName()+"\t\t\t"+psngrList[i].getExpense());
					totExp+=psngrList[i].getExpense();
				}
				
				System.out.println("\nTotal Expenses of All Passengers:"+totExp);
				System.out.println("------------------------------------------------------");
				break;
				
				case 'Z':
				System.out.println("Thank You!"); //STOP THE MENUE AND END THE PROGRAM
				System.out.println("------------------------------------------------------");
				break menue;
				
				default:
				System.out.println("Enter a correct selection value!");
				System.out.println("------------------------------------------------------");
				break;
			}
		}
	}
	
	//METHOD TO VIEW ALL CABINS
	private static void viewAllCabins()
	{
		System.out.println("Cabins:");
		for(int i=0;i<cabin.length;i++)
		{
			System.out.print(i+1+": ");
			if(cabin[i]==null)
				System.out.println('e');
			else
				System.out.println(cabin[i]);
		}
		
	}
	
	
	private static void addCustomerToCabin()
	{
		System.out.println("Enter the cabin number you want to add customer to:");
		int cNum=sc.nextInt();
		
		System.out.println("Enter the customer name:");
		cabin[cNum-1]=sc.next();
	}
	private static void displayEmptyCabins()
	{
		System.out.println("Empty Cabin Numbers:");
		for(int i=0;i<cabin.length;i++)
		{
			//CHECKING WHETHER THE ARRAY ELEMENT IS NULL
			if(cabin[i]==null)
				System.out.println(i);
		}

	}
	private static void deleteCustomerFromCabin()
	{
		System.out.println("Enter the cabin number to delete customer");
		int delNum=sc.nextInt();
		//MAKING THE ARRAY ELEMENT AS NULL
		cabin[delNum]=null;
	}
	private static void findCabinFromCustomerName()
	{
		//GET CUSTOMER NAME AS USER INPUT
		System.out.println("Enter the customer name to find cabin:");
		String cName=sc.next();
		boolean found=false;
		
		for(int i=0;i<cabin.length;i++)
		{
			//COMPARE THE ELEMENT IN THE ARRAY WITH THE USER INPUT
			if(cabin[i]==cName)
			{
				System.out.println("The customer is in cabin "+i);
				found=true;
			}
		}
		if(found==false)
			System.out.println("The customer name you entered doesn't match any cabin");

	}
	
	private static void storeData()
	{
		try {
			File myObj = new File("filename.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
    	
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Message");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	private static void loadData()
	{
		File myObj = new File("filename.txt");
		if (myObj.exists()) {
		  System.out.println("File name: " + myObj.getName());
		  System.out.println("Absolute path: " + myObj.getAbsolutePath());
		  System.out.println("Writeable: " + myObj.canWrite());
		  System.out.println("Readable :" + myObj.canRead());
		  System.out.println("File size in bytes :" + myObj.length());
		} else {
		  System.out.println("The file does not exist.");
		}
  }
		
		
	
	private static void sortPassengers()
	{
		//LOGIC FOR SORTING     
         for(int i = 0; i<cabin.length; i++)   //HOLDS EACH ELEMENT
         {  
             for (int j = i+1; j<cabin.length; j++)  //CHECK FOR REMAINING ELEMENTS 
             {  
				//MAKING THE ELEMENT BLANK IF IT'S NULL(TO COMPARE)
				if(cabin[i]==null)
					cabin[i]="";
				else if(cabin[j]==null)
					cabin[j]="";
				
                //COMPARES EACH ELEMENT OF THE ARRAY TO ALL THE REMAINING ELEMENTS
                if(cabin[i].compareTo(cabin[j])>0)   
                {  
                    //SWAPPING ARRAY ELEMENTS  
                    String temp = cabin[i];  
                    cabin[i] = cabin[j];  
                    cabin[j] = temp;  
                 }  
              }  
           } 
	}
}