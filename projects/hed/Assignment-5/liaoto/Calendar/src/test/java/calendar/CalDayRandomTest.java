package calendar;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */


public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 
	  private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
		
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		
		 
		 System.out.println("Start testing...");
		 
		try{ 
			int l = 10000;
			for (int iteration = 0; elapsed < l; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				GregorianCalendar calendar = new GregorianCalendar(1,1,1);
				CalDay day0 = new CalDay(calendar);
				assertTrue(day0.isValid());
				 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 25);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 61);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 1);
				
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
				appt.setValid();
				 day0.addAppt(appt);
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+l);
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	  }
}
