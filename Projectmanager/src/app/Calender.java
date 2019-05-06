package app;


class Calender{

    Boolean checkDate(String date){
        if (date.length() != 10){
            return false;
        }
        int year = Integer.parseInt(date.substring(0,3));
        int month = Integer.parseInt(date.substring(5,6));
        int day = Integer.parseInt(date.substring(8,9));
        if (year < 2000 && year > 2999){
            return false;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            if (day < 1 || day > 31){
                return false;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11){
            if (day < 1 || day > 30){
                return false;
            }
        } else if (month == 2){
            if (year%4 == 0){
                if (day < 1 || day > 29){
                    return false;
                }
            } else {
                if (day < 1 || day > 28){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    Boolean compareDates(String startDate, String endDate){
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
