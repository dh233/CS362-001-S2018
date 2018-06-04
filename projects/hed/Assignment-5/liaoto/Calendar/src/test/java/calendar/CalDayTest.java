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
	assertEquals(null, day.iterator());
	String notgood = day.toString();	
	GregorianCalendar calendar = new GregorianCalendar(1,1,1);
	CalDay day0 = new CalDay(calendar);
	assertTrue(day0.isValid());
	String buffer0 = day0.getFullInfomrationApp(day0);
	Appt appt0 = new Appt(12,30,1,1,1,null,null,null);
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
	assertEquals(b,b);
	int size = day0.getSizeAppts();
	assertEquals(5,size);	
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	GregorianCalendar calendar = new GregorianCalendar();
	CalDay day = new CalDay(calendar);
	assertTrue(day.isValid());
	
	GregorianCalendar c1 = new GregorianCalendar(1,1,1);
	CalDay d1 = new CalDay(c1);
	assertTrue(d1.isValid());
	String date = d1.toString();
	//System.out.println(date);
	//assertEquals("\t --- 3/1/1 --- \n",date);
	assertEquals("\t --- 3/1/1 --- \n --- -------- Appointments ------------ --- \n\n", date); //essentially what it is above but without formatting issues
	
	Appt a1 = new Appt(1,2,1,"E","This is E","he@gmail.com");
	a1.setValid();
	d1.addAppt(a1);
	
	assertEquals(1,d1.getDay());
	assertEquals(2,d1.getMonth());
	assertEquals(1,d1.getYear());
		
	Appt a2 = new Appt(13,9,1,2,1,"A","This is A", null);
	a2.setValid();
	d1.addAppt(a2);
	
	String inf = d1.getFullInfomrationApp(d1);
	assertEquals(inf, inf);
	assertTrue(a2.hasTimeSet());
	assertEquals(13, a2.getStartHour());
	assertEquals(9, a2.getStartMinute());

	Appt appt11 = new Appt(12,10,1,2,1,"E", "This is E", null);//wrng hour
	appt11.setValid();
	d1.addAppt(appt11);
	assertEquals(12, appt11.getStartHour());
	assertEquals(10, appt11.getStartMinute());


	Appt appt12 = new Appt(11,11,1,2,1,"E", "This is E", null);
	appt12.setValid();
	d1.addAppt(appt12);

	inf = d1.getFullInfomrationApp(d1);
	assertEquals(inf, inf);
	
	Appt appt13 = new Appt(1,9,1,2,1,"E", "This is E", null);//wrong hour
	appt13.setValid();
	assertTrue(appt13.getValid());
	d1.addAppt(appt13);

	inf = d1.getFullInfomrationApp(d1);
	assertEquals(inf, inf);

	Appt a3 = new Appt(0,0,1,2,1,"A", "A", null);
	a3.setValid();
	d1.addAppt(a3);

	inf = d1.getFullInfomrationApp(d1);
	assertEquals(inf, inf);

	Appt a4 = new Appt(-1,10,1,2,1, "B", "B", null);
	a4.setValid();
	d1.addAppt(a4);

	String info = d1.getFullInfomrationApp(d1);
	assertEquals("2-1-1 \n\t12:00AM A A \n\t1:09AM E This is E \n\t11:11AM E This is E \n\t0:10AM E This is E \n\t1:09PM A This is A ",info);
	//System.out.println(info);
 }	

@Test(timeout = 4000)
public void test02() throws Throwable {
	GregorianCalendar c = new GregorianCalendar(1,1,1);
	CalDay day = new CalDay(c);	
	assertTrue(day.isValid());
	
	
	Appt a1 = new Appt(1,1,1,"No Time", "This has No Time", null);//wrng hour
	a1.setValid();
	String info = day.getFullInfomrationApp(day);
	assertEquals(info, info);

	day.addAppt(a1);
	info = day.getFullInfomrationApp(day);
	assertEquals(info, info);

	Appt a2 = new Appt(12, 30, 1,1,1, "Time", "This has Time", null);
	a2.setValid();
	day.addAppt(a2);
	info = day.getFullInfomrationApp(day);
	assertEquals(info, info);

	Appt a4 = new Appt(13, 10, 1, 1,1, "TIme", "This has Time", null);
	a4.setValid();
	day.addAppt(a2);
	assertTrue(a2.getStartHour() < a4.getStartHour());

	GregorianCalendar c2 = new GregorianCalendar(1,1,1);
	CalDay d5 = new CalDay(c2);	
	assertTrue(d5.isValid());
	Appt a3 = new Appt(13,10,1,1,1,"No Time", "This has No Time", null);
	a3.setValid();
	info = d5.getFullInfomrationApp(d5);
	assertEquals(info, info);
}

@Test(timeout = 4000)
public void test03() throws Throwable {
	GregorianCalendar c = new GregorianCalendar(1,1,1);
	CalDay day = new CalDay(c);
	assertTrue(day.isValid());
	Appt a0 = new Appt(1,30, 1,1,1,"A", "This is A", null);
	Appt a1 = new Appt(2,30, 1,1,1,"B", "This is B", null);
	Appt a2 = new Appt(0,30, 1,1,1,"A", "This is A", null);
	Appt a3 = new Appt(2,31, 1,1,1,"B", "This is B", null);
	Appt a4 = new Appt(1,29, 1,1,1,"A", "This is A", null);
	Appt a5 = new Appt(3,00, 1,1,1,"B", "This is B", null);
	Appt a6 = new Appt(0,59, 1,1,1,"A", "This is A", null);
	Appt a7 = new Appt(1,40, 1,1,1,"B", "This is B", null);
	Appt a8 = new Appt(4,30, 1,1,1,"A", "This is A", null);
	Appt a9 = new Appt(2,33, 1,1,1,"B", "This is B", null);
	a0.setValid();
	a1.setValid();
	a2.setValid();
	a3.setValid();
	a4.setValid();
	a5.setValid();
	a6.setValid();
	a7.setValid();
	a8.setValid();
	a9.setValid();
	day.addAppt(a0);
	day.addAppt(a1);
	day.addAppt(a2);
	day.addAppt(a3);
	day.addAppt(a4);
	day.addAppt(a5);
	day.addAppt(a6);
	day.addAppt(a7);
	day.addAppt(a8);
	day.addAppt(a9);
	
	String info = day.getFullInfomrationApp(day);
	String com = "2-1-1 \n\t12:30AM A This is A \n\t12:59AM A This is A \n\t1:30AM A This is A \n\t1:29AM A This is A \n\t1:40AM B This is B \n\t2:30AM B This is B \n\t2:31AM B This is B \n\t2:33AM B This is B \n\t3:00AM B This is B \n\t4:30AM A This is A ";
	assertEquals(com, info);
}

}
