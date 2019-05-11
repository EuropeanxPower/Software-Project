package app;

//Skrevet af Christian
public class Calender {

    //Checks if the userinput is a valid format for a date and if the date is a "real" date.
    public Boolean checkDate(String date) {
        if (date.length() != 10) {
            return false;
        }
        String[] realDate = date.split("-");
        int year = Integer.parseInt(realDate[0]);
        int day = Integer.parseInt(realDate[2]);
        //Is the date in the reasonablty near future?
        if (year < 2000 && year > 2999) {
            return false;
        }
        //Is the month 31 days long?
        if ("01".equals(realDate[1]) || "03".equals(realDate[1]) || "05".equals(realDate[1]) || "07".equals(realDate[1]) || "08".equals(realDate[1]) || "10".equals(realDate[1]) || "12".equals(realDate[1])) {
            if (day < 01 || day > 31) {
                return false;
            }
            //Is the month 30 days long?
        } else if ("04".equals(realDate[1]) || "06".equals(realDate[1]) || "09".equals(realDate[1]) || "11".equals(realDate[1])) {
            if (day < 01 || day > 30) {
                return false;
            }
            //Is the month 29 days long?
        } else if ("02".equals(realDate[1])) {
            if (year % 4 == 0) {
                if (day < 01 || day > 29) {
                    return false;
                }
            } else {
                //Is the month 28 days long?
                if (day < 01 || day > 28) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
