
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.*;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	DataHandler dataHandler;
	dataHandler = new DataHandler();
	Calendar rightnow = Calendar.getInstance();	
	int thisMonth = rightnow.get(Calendar.MONTH);
	int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	int thisYear = rightnow.get(Calendar.YEAR);
	 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

	GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
 		GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);

	//calDays = (LinkedList<CalDay>)dataHandler.getApptRange(today,tomorrow);
	
	//dataHandler = new DataHandler();
	//Calendar rightnow = Calendar.getInstance();	
	//int thisMonth = rightnow.get(Calendar.MONTH);
	//int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	//int thisYear = rightnow.get(Calendar.YEAR);
	Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
	calendar.add(calendar.DAY_OF_MONTH,1);
	int startMinute = 13;
	int startHour = 13;
	int startMonth = thisMonth+1;
	int startDay = thisDay;
	int startYear = thisYear;
	Appt appt0 = new Appt(15,30,thisDay, thisMonth+1, thisYear, "Birthday", "This is my birthday", null);
	dataHandler.saveAppt(appt0);
	// create another appointment
         startHour=14;
		 startMinute=30;
		 startDay=thisDay;  	
		 startMonth=thisMonth+1; 	
		 startYear=thisYear; 	
		 String title="Class";
		 String description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data
		String emailAddress = null; 
         Appt appt2 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description,emailAddress);
         System.out.println(appt2.toString());
         dataHandler.saveAppt(appt2);
         // create another appointment
         startHour=16;
		 startMinute=30;
		 startDay=calendar.get(Calendar.DAY_OF_MONTH);
		 startMonth=calendar.get(Calendar.MONTH)+1;	
		 startYear=thisYear;	
		 title="Visit";
		 description="Visiting my parents!";
		 //Construct a new Appointment object with the initial data	 
         Appt appt3 = new Appt(startHour,startMinute ,startDay , startMonth ,startYear ,title,description,emailAddress);
         int[] recurDaysArr={0,1,2,3,4,5,6};
         appt3.setRecurrence( null, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
         appt3.setValid();
         dataHandler.saveAppt(appt3);
    // create another appointment
         startHour=16;
		 startMinute=30;
		 startDay=-1;		
		 startMonth=thisMonth+2;	
		 startYear=thisYear;	
		 title="Visit";
		 description="Visiting my parents!";
		 //Construct a new Appointment object with the initial data	 
         Appt appt4 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description,emailAddress);
         int[] recurDaysArr4={2,3,4};
         appt4.setRecurrence( recurDaysArr4, Appt.RECUR_BY_MONTHLY, 3, Appt.RECUR_NUMBER_FOREVER);
         appt4.setValid();
         dataHandler.saveAppt(appt4);
		 Appt appt6 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description,emailAddress);
         int[] recurDaysArr6={2,3,4};
         appt6.setRecurrence( recurDaysArr6, Appt.RECUR_BY_YEARLY, 3, Appt.RECUR_NUMBER_FOREVER);
         appt6.setValid();
         dataHandler.saveAppt(appt6);
		Appt appt5 = new Appt(1,1,1,1,0,null,null,null);
		appt5.setValid();
		dataHandler.saveAppt(appt5);
		dataHandler.deleteAppt(appt5);
 		//get a list of appointments for one day, which is today
		GregorianCalendar past = new GregorianCalendar(1990, 1, 1);
 		//GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
 		//GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar future = new GregorianCalendar(2020, 1,1);
		future.add(past.DAY_OF_MONTH,1);
 		tomorrow.add(today.DAY_OF_MONTH,1);
 	        //Create a linked list of calendar days to return
 	       // LinkedList<CalDay> calDays = new LinkedList<CalDay>();
 			calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today,tomorrow);
		//calDays = (LinkedList<CalDay>) dataHandler.getApptRange(tomorrow, today);
		//assertEquals(null, caldays);	
		calDays = (LinkedList<CalDay>) dataHandler.getApptRange(past, future);
 	 		//Delete an appointment
  			dataHandler.deleteAppt(appt2);
     	/** instance of DataHandler **/
 		DataHandler dataHandler2 = new DataHandler("calendar2.xml",false);
 		dataHandler2.saveAppt(appt2);
		dataHandler2.deleteAppt(appt2);
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

}
