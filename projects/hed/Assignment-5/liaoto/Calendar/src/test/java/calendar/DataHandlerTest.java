
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
	int thisMonth = 1;
	int thisDay = 1;
	int thisYear = 1;
	 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

	GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
 		GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay+1);
	Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
	calendar.add(calendar.DAY_OF_MONTH,1);
	
	int startMinute = 13;
	int startHour = 13;
	int startMonth = thisMonth+1;
	int startDay = thisDay;
	int startYear = thisYear;
	Appt appt0 = new Appt(15,30,thisDay, thisMonth+1, thisYear, "Birthday", "This is my birthday", null);
	boolean s0 = dataHandler.saveAppt(appt0);
	assertTrue(s0);
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
         //System.out.println(appt2.toString());
         boolean s2 = dataHandler.saveAppt(appt2);
	 assertTrue(s2);
	calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today, tomorrow);
	String kd = calDays.toString();
	//System.out.println(kd);
	//System.out.println(kd.length());
	/*CalDay daytest = new CalDay(today);
	StringBuilder sb = new StringBuilder();
	String com = "\t --- 3/1/1 --- \n --- -------- Appointments ------------ --- \n";
	System.out.println(com.length());
	sb.append(com);
	Iterator<Appt> a90 = (Iterator<Appt>)calDays.iterator();
	sb.append(a90 + " \n");
	assertEquals(sb, kd);*/
	 
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
         boolean s3 = dataHandler.saveAppt(appt3);
	assertTrue(s3);
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
         boolean s4 = dataHandler.saveAppt(appt4);
	assertFalse(s4);
		 Appt appt6 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description,emailAddress);
         int[] recurDaysArr6={2,3,4};
         appt6.setRecurrence( recurDaysArr6, Appt.RECUR_BY_YEARLY, 3, Appt.RECUR_NUMBER_FOREVER);
         appt6.setValid();
         boolean s6 = dataHandler.saveAppt(appt6);
	assertFalse(s6);
		Appt appt5 = new Appt(1,1,1,1,0,null,null,null);
		appt5.setValid();
		boolean s5 = dataHandler.saveAppt(appt5);
		assertFalse(s5);
		boolean s5re = dataHandler.deleteAppt(appt5);
		assertFalse(s5re);
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
 		
		boolean s2s = dataHandler2.saveAppt(appt2);
		assertTrue(s2s);
		boolean s2d = dataHandler2.deleteAppt(appt2);
		assertTrue(s2d);
		
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	DataHandler dataHandler4;
	dataHandler4 = new DataHandler("calendar3.xml", false);
	Appt a0 = new Appt(15,30,1, 1, 1, "A", "This is A", null);
	a0.setValid();
	boolean s0 = dataHandler4.saveAppt(a0);
	assertTrue(s0);
	boolean d0 = dataHandler4.deleteAppt(a0);
	assertTrue(d0);
	boolean d00 = dataHandler4.deleteAppt(a0);
	assertFalse(d00);
	
	GregorianCalendar today = new GregorianCalendar(1,1,1);
 	GregorianCalendar tomorrow = new GregorianCalendar(1,1,2);
	GregorianCalendar week = new GregorianCalendar(1,1,11);
	GregorianCalendar month = new GregorianCalendar(1,2,20);
	GregorianCalendar year = new GregorianCalendar(2,2,20);
	LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	calDays = (LinkedList<CalDay>)dataHandler4.getApptRange(today,tomorrow);
	assertEquals(1,calDays.size());
	CalDay day = calDays.get(0);
	String test0 = day.getFullInfomrationApp(day);
	//assertEquals("2-1-1 ", test0);
	
	Appt a1 = new Appt(1,30,1,2,1, "B", "This is B", null);
	a1.setValid();
	boolean s01 = dataHandler4.saveAppt(a1);
	assertTrue(s01);
	calDays = (LinkedList<CalDay>)dataHandler4.getApptRange(today,tomorrow);
	day = calDays.get(0);
	String test1 = day.getFullInfomrationApp(day);
	//System.out.println(test1);
	////assertEquals("2-1-1 \n\t1:30AM B This is B ",test1);
	
	Appt a2 = new Appt(1,20,1,2,1, "C", "This is C", null);
	a2.setValid();
	int[] r ={2,3,4};
	a2.setRecurrence(r,Appt.RECUR_BY_WEEKLY, 3, Appt.RECUR_NUMBER_FOREVER);
	boolean s2 = dataHandler4.saveAppt(a2);
	assertTrue(s2);
	calDays = (LinkedList<CalDay>)dataHandler4.getApptRange(today,week);
	assertEquals(10,calDays.size());
	CalDay day0 = calDays.get(0);
	CalDay day1 = calDays.get(1);
	CalDay day2 = calDays.get(2);
	CalDay day3 = calDays.get(3);
	CalDay day4 = calDays.get(4);
	CalDay day5 = calDays.get(5);
	CalDay day6 = calDays.get(6);
	CalDay day7 = calDays.get(7);
	CalDay day8 = calDays.get(8);
	CalDay day9 = calDays.get(9);
	String test2 = day7.getFullInfomrationApp(day7);
	String test3 = day0.getFullInfomrationApp(day0);
	//System.out.println(test3);
	//assertEquals("2-1-1 \n\t1:30AM B This is B \n\t1:20AM C This is C ", test3);
	//System.out.println(test2);
	//assertEquals("2-1-1 \n\t1:20AM C This is C ",test2);
	
	Appt a3 = new Appt(1,40,1,2,1, "D", "This is D", null);
	a3.setValid();
	a3.setRecurrence(r,Appt.RECUR_BY_MONTHLY, 3, Appt.RECUR_NUMBER_FOREVER);
	boolean s3 = dataHandler4.saveAppt(a3);
	assertTrue(s3);
	calDays = (LinkedList<CalDay>)dataHandler4.getApptRange(today,month);
	//for(int i = 0; i < calDays.size();i++){
	CalDay month0 = calDays.get(28);
	String test4 = month0.getFullInfomrationApp(month0);
	//System.out.println(test4);
	assertEquals("3-1-1 \n\t1:20AM C This is C \n\t1:40AM D This is D ", test4);
	
	Appt a4 = new Appt(1,50,1,2,1,"E", "This is E", null);
	a4.setValid();
	a4.setRecurrence(r, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
	boolean s4 = dataHandler4.saveAppt(a4);
	assertTrue(s4);
	calDays = (LinkedList<CalDay>)dataHandler4.getApptRange(today,year);
	assertEquals(412, calDays.size());
	CalDay year0 = calDays.get(365);
	String test5 = year0.getFullInfomrationApp(year0);
	//System.out.println(test5);
	assertEquals("2-1-2 \n\t1:20AM C This is C \n\t1:40AM D This is D \n\t1:50AM E This is E ", test5);
	
	boolean SaveTest = dataHandler4.save();
	assertTrue(SaveTest);
  }

}
