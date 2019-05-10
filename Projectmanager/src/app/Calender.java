package app;


public class Calender{

    public Boolean checkDate(String date){
        if (date.length() != 10){
            return false;
        }
        String[] realDate = date.split("-");
        int year = Integer.parseInt(realDate[0]);
        int day = Integer.parseInt(realDate[2]);
        if (year < 2000 && year > 2999){
            return false;
        }
        if ("01".equals(realDate[1]) || "03".equals(realDate[1]) || "05".equals(realDate[1]) || "07".equals(realDate[1]) || "8".equals(realDate[1]) || "10".equals(realDate[1]) || "12".equals(realDate[1])){
            if (day < 01 || day > 31){
                return false;
            }
        } else if ("4".equals(realDate[1]) || "6".equals(realDate[1]) || "9".equals(realDate[1]) || "11".equals(realDate[1])){
            if (day < 01 || day > 30){
                return false;
            }
        } else if ("2".equals(realDate[1])){
            if (year%4 == 0){
                if (day < 01 || day > 29){
                    return false;
                }
            } else {
                if (day < 01 || day > 28){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public Boolean compareDates(String startDate, String endDate){
        if (Integer.parseInt(startDate.substring(0,3)) > Integer.parseInt(endDate.substring(0,3))){
            return false;
        } else {
            if (Integer.parseInt(startDate.substring(5,6)) > Integer.parseInt(endDate.substring(5,6))){
                return false;
            } else {
                if (Integer.parseInt(startDate.substring(8,9)) > Integer.parseInt(endDate.substring(8,9))) {
                    return false;
                }
            }
        }
        return true;
    }
}
