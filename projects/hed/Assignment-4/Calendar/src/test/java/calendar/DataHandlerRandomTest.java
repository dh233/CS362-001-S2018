package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	   private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	 
	 public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	 
	 @Test
	  public void radnomtest()  throws Throwable  {
		 DataHandler dataHandler;
		dataHandler = new DataHandler();	
		DataHandler dataHandler2 = new DataHandler("calendar2.xml",false);
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		
		 
		 System.out.println("Start testing...");
		 
		try{ 
			int l = 10000;
			for (int iteration = 0; elapsed < l; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				 int Day=ValuesGenerator.getRandomIntBetween(random, -1, 32);
				 int Month=ValuesGenerator.getRandomIntBetween(random, -1, 13);
				 int Year=ValuesGenerator.getRandomIntBetween(random, -1, 1);
				GregorianCalendar calendar = new GregorianCalendar(Day,Month,Year);
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 25);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 1);
				GregorianCalendar calendar2 = new GregorianCalendar(startDay,startMonth,startYear);
	
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
				Appt appt1 = new Appt(startHour,
		                  startMinute ,
		                  Day ,
		                  Month ,
		                  Year,
		                  title,
		                 description,
		                 emailAddress);
				appt.setValid();
				appt1.setValid();
				 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				boolean s0 = dataHandler.saveAppt(appt);
				boolean s1 = dataHandler2.saveAppt(appt);
				boolean d0;
				boolean d1;
				if(startYear > Year){
					if(startMonth > Month){
						if(startDay > Day){
							calDays = (LinkedList<CalDay>) dataHandler.getApptRange(calendar, calendar2);
						}
						else{
							d0 = dataHandler.deleteAppt(appt);
						}
					}
					else{
						d0 = dataHandler.deleteAppt(appt);
						d1 = dataHandler.deleteAppt(appt1);
					}
				}
				else{
					d0 = dataHandler.deleteAppt(appt);
				}
				boolean d2 = dataHandler2.deleteAppt(appt);
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			    if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+l);
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	  }
		 
	 }


