/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	CalDay day = new CalDay();
	assertFalse(day.isValid());
	String notgood = day.toString();	
	GregorianCalendar calendar = new GregorianCalendar(1,1,1);
	CalDay day0 = new CalDay(calendar);
	assertTrue(day0.isValid());
	String buffer0 = day0.getFullInfomrationApp(day0);
	Appt appt0 = new Appt(1,1,1,null,null,null);
	Appt appt1 = new Appt(1,1,1,1,1,"Dinner","This is Dinner", "gw@gmail.com");
	appt1.setRecurrence(null, 1, 1,1);
	Appt appt2 = new Appt(22,2,1,1,1,null, null, null);
	Appt appt3 = new Appt(25,2,-1,1,1,null,null,null);
	Appt appt4 = new Appt(0,1,1,1,1,null,null,null);
	Appt appt5 = new Appt(1,1,0,null,null,null);
	appt5.setValid();
	day0.addAppt(appt0);
	day0.addAppt(appt1);
	day0.addAppt(appt2);
	day0.addAppt(appt3);
	day0.addAppt(appt4);
	day0.addAppt(appt5);
	String buffer = day0.getFullInfomrationApp(day0);	
	String b = day0.toString();
	int size = day0.getSizeAppts();
	assertEquals(5,size);	
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

}
