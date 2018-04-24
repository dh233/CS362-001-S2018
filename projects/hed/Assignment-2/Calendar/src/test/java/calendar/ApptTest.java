/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      //assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);	//bug found due to am //repeated statement as well
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
	//assertFalse(appt0.getValid());
	//String stringemail = appt0.getEmailAddress();
	//assertEquals("xyz@gmail.com", stringemail);
  }

@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	Appt appt1 = new Appt(1,30,1, 1, -1, "Dinner", "This is my dinner", "hello@gmail.com");
	String string1 = appt1.toString();
	//assertEquals("\t1/1/-1 at 1:30am, Dinner, This is my dinner\n", string1);
	appt1.setValid();
	//assertFalse(appt1.getValid());
	int hour = appt1.getStartHour();
	int minute = appt1.getStartMinute();
	int day = appt1.getStartDay();
	int month = appt1.getStartMonth();
	int year = appt1.getStartYear();
	assertEquals(1, hour);
	assertEquals(30, minute);
	assertEquals(1, day);
	assertEquals(1, month);
	assertEquals(-1, year);
	String title = appt1.getTitle();
	String desc = appt1.getDescription();
	//assertEquals("Dinner", title);
	//assertEquals("This is my dinner", desc);
	assertEquals("hello@gmail.com", appt1.getEmailAddress());
	
	
	Appt appt2 = new Appt(0,0,13,1,1,"Sleep", "This is my sleep", "8@yahoo.com");	//bug found due to pm
	appt2.setValid();
	//assertFalse(appt2.getValid());
	String string2 = appt2.toString();
	//assertEquals("\t13/1/1 at 12:00am, Sleep, This is my sleep\n", string2);
	
	
	Appt appt3 = new Appt(1,35,2000,"B", "This is B", "h@gmail.com");
	appt3.setValid();
	//assertFalse(appt3.getValid());
	
	Appt appt30 = new Appt(1,-1,2000,"Bopposite", null, null);
	appt30.setValid();
	//assertFalse(appt30.getValid());
	
	Appt appt4 = new Appt(1,2,0,"C", "This is C", "H@gmail.com");	
	appt4.setValid();
	//assertFalse(appt4.getValid());

	Appt appt5 = new Appt(1,1,2003, null, null, null);
	appt5.setValid();
	//assertTrue(appt5.getValid());
	assertFalse(appt5.hasTimeSet());
	String email5 = appt5.getEmailAddress();
	//assertEquals("", email5);

	Appt appt6 = new Appt(-1,-1,1,1,1,"D", "This is D", null);
	appt6.setValid();
	//assertTrue(appt6.getValid());

	Appt appt7 = new Appt(25,0,1,1,1,"E", "This is E", null);
	appt7.setValid();
	//assertFalse(appt7.getValid());

	Appt appt8 = new Appt(1,67,1,1,1,"F", "This is F", null);
	appt8.setValid();
	//assertFalse(appt8.getValid());
	int[] a = {2,3,4};
	appt8.setRecurrence(a,1,2,1);
	assertFalse(appt8.isOn(1,2,1));
	assertTrue(appt8.isOn(1,1,1));
	int rec = appt8.getRecurNumber();
	a = appt8.getRecurDays();
	int inc = appt8.getRecurIncrement();
	//assertEquals(1,appt8.getRecurNumber());
	//assertEquals(a,appt8.getRecurDays());
	//assertEquals(2, appt8.getRecurIncrement());
	assertTrue(appt8.isRecurring());
	appt8.setRecurrence(null,1,1,1);	
}

}
