package app;

import java.util.GregorianCalendar;
import java.util.Calendar;


class Calender{

    Calendar getDate() {
        Calendar c = new GregorianCalendar();
        Calendar calender = new GregorianCalendar(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));

        return calender;

    }

	public void set(int year, int year2) {
	}
}

