/**
 * Programmer: 	Sharma Chakravarthy, Soumyava Das
 * Language:	Java
 * date:        09/10/2012
 * Purpose:		This program uses MavBoyTest class to read data from a text file to initialize
 * 				employees, items, clients, etc.
 * 				
 *              It checks and recovers from some exceptions while reading the input file
 *                 uses a bufferedReader which is different from project 2
 *              NO assumptions on the #employees etc. adjust your code accordingly!
 
 *              also shows how to write to an output file
 * 
 * USAGE:       You need to initialize your data structures as the first step. 
 *              once the values are read into local variables, 
 *              it  is YOUR responsibility to add code at proper places to create objects and manage them!
 *
 *              input and output file names are given as a command line argument 
 *              (e.g, java MavBoyTest dataFile-proj3.txt proj3-output.txt)
 *              for the naming convention used in this file. if you forget to give the data 
 *              files as  command line arguments, it will prompt you for that.	
 *          
 *              you can remove or comment out prints once you are sure it is reading the input correctly
 *
 * MAKE SURE:   your program is case insensitive (for state code, city, gender, employee type etc.)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @param inputfileName
 *            as input data filename containing input items with : as item separators
 * @param   outputFileName as output file name 
 */

public class MavBoyTest implements DateConstants, Proj3Constants {

	// introduce your (class and instance) attributes for this test class

	private static BufferedReader finput;
    private static Scanner cp;  //this is still command prompt
    private static PrintWriter foutput;
    private static Enterprise e;

    //define other variables as needed

	//Note that we are using a DIFFERENT method for reading input file;
	/**
	 * @param iFileName is the input data file name
	 */		

    public static BufferedReader openReadFile(String fileName){
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(fileName));
        }     
        catch(FileNotFoundException FNFE){    
          bf = null;
        }
       finally{
          return bf;
       }
    }

/**
	 * @param oFileName is the input data file name
	 */		

    
    public static PrintWriter openWriteFile(String fileName){
        PrintWriter outputFile = null;
        try{
            outputFile = new PrintWriter(new FileWriter(fileName));
        }     
        catch(IOException IOE){    
          outputFile = null;
        }
       finally{
          return outputFile;
       }
    }

	// add here constructors and methods as needed

	/**
	 * @param takes
	 *            fileNames as command line argument. prompts if not given
	 */
        @SuppressWarnings("empty-statement")
	public static void main(String[] args) {

		// declare variables used for input handling
        String enterprisename = DEFAULT_ENTERPRISE_NAME;
        String inputLine = "", ifName = "", ofName = "";

		// determine if correct input file is provided

		cp = new Scanner(System.in);
		if (args.length < 1) {
			System.out.println("Input Data file name was not supplied");
			System.out.printf("Please type input data file name: ");
			ifName = "C:\\Users\\Keenan\\Desktop\\UTA\\Fall 2015\\Object Orientied programming (JAVA)\\proj3_Keenan_Parker_final_001\\dataFile-proj3-new.txt"; //cp.nextLine();  //modified code by keenan
                        ofName = "C:\\Users\\Keenan\\Desktop\\UTA\\Fall 2015\\Object Orientied programming (JAVA)\\proj3_Keenan_Parker_final_001\\out.txt";
		} 
        else if (args.length < 2){
            ifName =  args[ZEROI];       
            System.out.printf("Please type output data file name: ");
            ofName = cp.nextLine();
        } else {
            ifName = args[ZEROI];
            ofName = args[ONEI];
            }

		// See HOW RECOVERY is done (will cover in a few weeks)
		System.out.println("ifName ="+ifName);
		System.out.println("ofName ="+ofName);
		finput = openReadFile(ifName);
		while (finput == null) {
			System.out.println("ifName ="+ifName);
			System.out.println("Error: Input FILE "+ ifName+" does not exist.\nEnter correct file name: ");
			ifName = cp.nextLine();
			finput = openReadFile(ifName);
		}
        foutput = openWriteFile(ofName);
		System.out.println("ofName ="+ofName);
        while (foutput == null){
			System.out.printf("Error: Output FILE %s %s",  ofName,  " does not exist.\nEnter correct file name: ");
            ofName = cp.nextLine();
            foutput = openWriteFile(ofName);
		}  

		/* GET SportsMgmt DETAILS */
		// start reading from data file
		// get name
		try {
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
				inputLine = finput.readLine();
			String enterpriseName = inputLine;
			System.out.printf("\n%s %s \n", "Enterprise name is: ",
					enterpriseName);

			// add code as needed
                        Enterprise mavBoy = new Enterprise(enterpriseName); // Added code by Keenan
			/* GET numbers of empoyees, donors, athletes, and number of donations
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
				inputLine = finput.readLine();

			// reading 4 values from a single line
			String[] chopInputLine = inputLine.split(":");

			int numEmployees = Integer.parseInt(chopInputLine[ZEROI]);
			int numDonors = Integer.parseInt(chopInputLine[ONEI]);
			int numAthletes = Integer.parseInt(chopInputLine[TWOI]);
			int numDonations = Integer.parseInt(chopInputLine[THREEI]);

			System.out.printf("\nnumEmp, numDonors, numAthletes, numDonations: [%5d, %5d, %5d, %5d]\n",
							numEmployees, numDonors, numAthletes, numDonations);

			// add code here: use the above to initialize your arrays, arraylists,
			// and attributes as needed
            */

			/* GET EMPLOYEE DETAILS */

			// reading details for each employee from the data file
			System.out.printf("\nEmployees: \n");
	        int numEmployees = 0;
            inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();		
			while ( (!inputLine.toLowerCase().equals("end"))){
            	
				String[] chopEmp = inputLine.split(":");

				// fill all fields for a single employee from a single line
				String empType = chopEmp[ZEROI];
				String empFName = chopEmp[ONEI];
			    String empLName = chopEmp[TWOI];
				String empBDate = chopEmp[THREEI];
				String empGender = chopEmp[FOURI].toUpperCase();
				String empHireDate = chopEmp[FIVEI];
                double empBaseSalary = Double.parseDouble(chopEmp[SIXI]);
                double empRate = Double.parseDouble(chopEmp[SEVENI]);
                
				// add code here: in order to convert a date string to a Date object,
				// use the following
				// i.e., invoke the appropriate constructor of the Date class
				Date dob = new Date(empBDate);
                                    mavBoy.hireEmployee(empFName, empLName, empGender.toUpperCase(), empBDate, empType.toUpperCase(), empHireDate, empBaseSalary, empRate);// added code by Keenan
				System.out.printf("(%6s, %10s, %6s, %12s, %10.2f, %4s, %12s, %.2f)\n",
						empFName, empLName, empGender, empHireDate,
						empBaseSalary, empType, dob, empRate);

				// add code here: also, empTYpe is read as a string; if u are using a
				// enum, you need to convert it  using a switch or if statement

                //add this employee to array list
                inputLine = finput.readLine();
				while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();	
                numEmployees +=1;
			}
            System.out.printf("#Employees: %d\n", numEmployees);

			// reading details of items from the data file
			System.out.printf("\nItems: \n");

            int numItems =0;
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();

            while ( (!inputLine.toLowerCase().equals("end"))){
				String[] chopitem = inputLine.split(":");

				// get all fields of the donor
				String itemId = chopitem[ZEROI];
                String itemName = chopitem[ONEI];
                String itemDepartment = chopitem[TWOI];
				double itemPrice = Double.parseDouble(chopitem[THREEI]);
                String itemSize= chopitem[FOURI];
				String itemType = chopitem[FIVEI];
                int itemQuantity = Integer.parseInt(chopitem[SIXI]);
				
                   
				System.out.printf("[%s, %s, %s, %f, %s, %s, %d]\n", 
                    itemId, itemName, itemDepartment, itemPrice, 
                               itemSize, itemType, itemQuantity);

				// add code here to add item object to the enterprise
                mavBoy.addItem(itemId,itemName.toLowerCase(),itemDepartment.toLowerCase(), itemPrice, itemSize.toUpperCase(), itemType.toLowerCase(),itemQuantity);//Added by keenan
                inputLine = finput.readLine();
				while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();	
                numItems +=1;
			}
            System.out.printf("#Items: %d\n", numItems);

			/* GET CLIENT DETAILS */

			// reading details for each client from the data file
			System.out.printf("\nClients: \n");
			
            int numClients =0;
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
				inputLine = finput.readLine();

            while ( (!inputLine.toLowerCase().equals("end"))){
				String[] chopAthlete = inputLine.split(":");

				// fill all fields for a single client from a single line
				String[] chopClient = inputLine.split(":");
									
				// fill all fields for a single client from a single line 
				int clientId = Integer.parseInt(chopClient[ZEROI]);
				String clientFName = chopClient[ONEI];
                String clientLName = chopClient[TWOI];
				String clientDOB = chopClient[THREEI];
				String clientGender = chopClient[FOURI];
				String clientMemType = chopClient[FIVEI];
				String clientSince = chopClient[SIXI];	
				int  clientHouseNum = Integer.parseInt(chopClient[SEVENI]);
                String clientStreet = chopClient[EIGHTI];
                String clientCity = chopClient[NINEI];
                String clientState = chopClient[TENI];
                
				// add code: construct client object as appropriate
                                String customerHouseNum = Integer.toString(clientHouseNum);//Added code by Keenan
				mavBoy.addCustomer((int)clientId, clientFName, clientLName, clientGender.toLowerCase(), clientDOB, clientMemType, clientSince, customerHouseNum, clientStreet, clientCity, clientState);//Added code by Keenan
				System.out.printf("{%d, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s} \n",
                    clientId, clientFName, clientLName, clientDOB, clientGender, clientMemType, clientSince,  
				    clientHouseNum, clientStreet, clientCity, clientState);


                inputLine = finput.readLine();
				while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();
                numClients += 1;
			}
            System.out.printf("#clients: %d\n", numClients);
            
			// process menu from here
            int minYear=2147483647 ,maxYear=0;
            Date tempDate  = new Date();
        
            while ((inputLine = finput.readLine()) != null){
            if (inputLine.charAt(BASE_INDEX) == '/'){
                System.out.println(inputLine);
                foutput.println(inputLine);
            }
            else {
            String[] chopInput = inputLine.split(":");
			int functionNum = (int) Integer.parseInt(chopInput[ZEROI]);
             //add code: for processing them; use a switch statement after converting the first field
             //you can use foutput.print or foutput.println statements to write to an output file 
           
             switch(functionNum)
             {
                case 10:
                        Scanner mavInputString = new Scanner(System.in);
                        Scanner mavInputInt = new Scanner(System.in);
                        Scanner mavMainInput = new Scanner(System.in);
                        String userInput = "";
                        String buyDate;
                        String state,stateUpper;
                        int empId;
                        int customerId;
                        String itemId;
                        int qunaity;/*
                        while (!"0".equals(userInput))
                        {

                           System.out.println("\n\n1) List employees with details (including specialization) (no input)");
                           System.out.println("2) List customers in that state (input: state code as a string, all customers if “*”)");
                           System.out.println("3) List the portfolio of a customer (input: customer id) (portfolio means the items the customer has bought and the money spent by him/her)");
                           System.out.println("4) Release an employee (input: employee id)");
                           System.out.println("5) Display items available for purchase/selling (no input) perhaps 10 at a time");
                           System.out.println("6) Display client details (input: customer id or 0 for all)");
                           System.out.println("7) Buy a item for a client ( input: client id, item id, quantity, and optional date) if date is not given, assume today’s date; prompt appropriately");
                           System.out.println("0) Exit program\n");
                           System.out.printf("Please enter your response: ");
                           userInput = mavMainInput.nextLine();
                           if("1".equals(userInput) || "2".equals(userInput) || "3".equals(userInput) || "4".equals(userInput)|| "5".equals(userInput)|| "6".equals(userInput)|| "7".equals(userInput)) 
                           {
                               if("1".equals(userInput))
                               {
                                   mavBoy.listEmployees();
                                   continue;

                               }
                               if("2".equals(userInput))
                               {
                                   System.out.println("Please enter a State Abbriviation (ex. TX or NY) or * to show all customers: ");
                                   state = mavInputString.nextLine();
                                   stateUpper = state.toUpperCase();
                                   mavBoy.listCustomersByState(stateUpper);
                               }
                               if("3".equals(userInput))
                               {
                                   System.out.println("Please enter a customer Id: ");
                                   customerId = mavInputInt.nextInt();
                                   mavBoy.printCustomerPortfolio(customerId);
                                   continue;
                               }
                               if("4".equals(userInput))
                               {
                                   System.out.println("Please enter a Employee Id: ");
                                   empId = mavInputInt.nextInt();
                                   mavBoy.releaseEmployee(empId);
                                   continue;
                               }
                               if("5".equals(userInput))
                               {
                                   mavBoy.listItems();
                               }
                               if("6".equals(userInput))
                               {
                                   System.out.println("Please enter a customer Id: ");
                                   customerId = mavInputInt.nextInt();
                                   mavBoy.listCustomersByID(customerId);
                                   continue;
                               }
                               if("7".equals(userInput))
                               {
                                   System.out.println("Please enter a customer Id: ");
                                    customerId = mavInputInt.nextInt();
                                   System.out.println("Please enter a item Id: ");
                                    itemId = mavInputString.nextLine();
                                   System.out.println("Please enter a item qunaity: ");
                                    qunaity = mavInputInt.nextInt();
                                   System.out.println("Please enter a Date(optional), Enter NA if no date to specify: ");
                                   buyDate = mavInputString.nextLine();
                                   if("NA".equals(buyDate))
                                   {
                                       if(tempDate.getYear() > maxYear)
                                       {
                                           maxYear = tempDate.getYear();
                                       }
                                       if(tempDate.getYear() < minYear)
                                       {
                                           maxYear = tempDate.getYear();
                                       }
                                       mavBoy.sellItem(itemId, customerId, qunaity);
                                   }
                                   else
                                   {
                                       tempDate = new Date(buyDate);
                                       if(tempDate.getYear() > maxYear)
                                       {
                                           maxYear = tempDate.getYear();
                                       }
                                       if(tempDate.getYear() < minYear)
                                       {
                                           maxYear = tempDate.getYear();
                                       }
                                       mavBoy.sellItem(itemId, customerId, qunaity,buyDate);
                                   }
                                   continue;
                               } 
                           }
                           else
                           {
                               if(!"0".equals(userInput)) System.out.println("Invalid input please use list provided");

                           }

                        }*/
                     break;
                    
             	case 11:
             		int cID = Integer.parseInt(chopInput[ONEI]);
             		String iID = chopInput[TWOI];
             		String d = chopInput[THREEI];
             		int quan = Integer.parseInt(chopInput[FOURI]);
             		if("*".equals(d))
             		{
                            tempDate = new Date();
                            if(tempDate.getYear() > maxYear)
                            {
                                maxYear = tempDate.getYear();
                            }
                            if(tempDate.getYear() < minYear)
                            {
                                minYear = tempDate.getYear();
                            }
                            mavBoy.sellItemToFile(iID,cID,quan,foutput);
             		}
             		else
             		{
                            tempDate = new Date(d);
                            if(tempDate.getYear() > maxYear)
                            {
                                maxYear = tempDate.getYear();
                            }
                            if(tempDate.getYear() < minYear)
                            {
                                minYear = tempDate.getYear();
                            }
                            mavBoy.sellItemToFile(iID,cID,quan,d,foutput);
             		}
             		break;
             	
             	case 12:
             		cID = Integer.parseInt(chopInput[ONEI]);
             		String y = chopInput[TWOI];
             		if("*".equals(y))
             		{
                            foutput.println("Client ID: "+cID+" | Year: ALL");
                            mavBoy.printCustomerPortfolioToFile(cID,foutput);
             		}
             		else
             		{
                            foutput.println("Client ID: "+cID+" | Year: "+y);
                            mavBoy.printYearlyCustomerPortfolio(cID,y,foutput);
             		}
             		//foutput.println("12");
             		break;
             		
             	case 13: 
             		//Input: employee type, fname, lname, dob, gender, hire date, base salary,double value
             		String eType = chopInput[ONEI];
             		String f = chopInput[TWOI];
             		String l = chopInput[THREEI];
             		String db =  chopInput[FOURI];
             		String g =  chopInput[FIVEI];
             		String dh =  chopInput[SIXI];
             		double salary = Double.parseDouble(chopInput[SEVENI]);
             		double rate = Double.parseDouble(chopInput[EIGHTI]);
             		mavBoy.hireEmployee(f,l,g,db,eType,dh,salary,rate,foutput);
             		//foutput.println("13");
             		break;
             		
             	case 14:
             		int employeeID = Integer.parseInt(chopInput[ONEI]);
             		mavBoy.releaseEmployee(employeeID);
                        mavBoy.listEmployeesToFile(foutput);
                        foutput.println("\n");
             		break;
             		
             	case 15:
                        employeeID = Integer.parseInt(chopInput[ONEI]);
                        int payRate = Integer.parseInt(chopInput[TWOI]);
             		mavBoy.payEmployee(employeeID,payRate, foutput);
             		break;
             		
             	case 16:
             		 iID = chopInput[ONEI];
             		mavBoy.itemPurchases(iID,foutput);
             		break;
             	
             	case 17:
                        int i,k,id;
             		String cusID = chopInput[ONEI];
             		y = chopInput[TWOI];
                        
                        ArrayList<Customer> customerList = mavBoy.getCustomers();
                        if("*".equals(cusID))
                        {
                            if("*".equals(y))
                            {
                                for(k=minYear;k<=maxYear;k++)
                                {
                                     y = Integer.toString(k);
                                    for(i=0;i<customerList.size();i++)
                                    {
                                        mavBoy.retainCustomerType2(customerList.get(i).getCustomerID(),y,foutput);
                                    }
                                }
                            }
                            else
                            {
                                for(i=0;i<customerList.size();i++)
                                {
                                   mavBoy.retainCustomerType2(customerList.get(i).getCustomerID(),y,foutput);
                                }
                            }
                            break;
                        }
                        if("*".equals(y))
                        {
                            for(i=minYear;i<=maxYear;i++)
                            {
                                y = Integer.toString(i);
                                id = Integer.parseInt(cusID);
                                mavBoy.retainCustomerType2(id,y,foutput);
                            }
                            break;
                        }
                        id = Integer.parseInt(cusID);
             		mavBoy.retainCustomerType2(id,y,foutput);
             		//foutput.println("1?");
             		break;
             	
             	case 0:
             		foutput.close();
                        setEnterprise(mavBoy);
                        MavGUI window = new MavGUI(e);  
             		//System.exit(1);
			break;
             	
             }
             
             System.out.println(inputLine);
             //foutput.println(inputLine);
             
          }
             
        } 
            
		} catch (NumberFormatException NFE) {
			System.out.println("I/O Error in File: " + ifName + "\ncheck for: "
					+ NFE.getMessage() + " and correct it in: " + inputLine);
		} 
        catch(IOException IOE){
        System.out.println("input/output Data error in File: " + ifName + "\nPlease correct " + IOE.getMessage() + " in the file!" + inputLine);
        } 
        finally 
        {
              
          foutput.close();
        }
             
              
	}
      
        
        
public static void setEnterprise(Enterprise ent)
{
    e = ent;
}
     
public Enterprise getEnterprise()
{
   return e;
}
}


