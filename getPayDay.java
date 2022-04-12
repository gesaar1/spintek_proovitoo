package proovitoo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class getPayDay {


    /*
     * Function returns the number corresponding to the weekday
     *
     * Monday = 1, Tuesday = 2, Wednesday = 3, Thursday = 4, Friday = 5, Saturday = 6, Sunday = 7
     *
     * @param date Specific date
     * @return number corresponding to the date
     */
    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }


    /*
     * Function returns list of dates for a specific year (using every tenth date of that year)
     *
     * @param year Year for which information is requested
     * @return list of dates
     */
    public static List<String> getDay(int year) {
        List<String> days = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            String date;
            if (i < 10){
                date = year + "-0" + i + "-" + "10";
            }
            else {
                date = year + "-" + i + "-" + "10";
            }
            days.add(date);
        }
        return days;
    }


    /*
     * @param days List of dates, example ["2000-12-10", "2000-01-10", ... ]
     * @return map of date and weekday number, example { "2000-12-10" = 7, "2000-01-10" = 1 }
     */
    public static HashMap<String, Integer> getWeekdays(List<String> days){
        HashMap<String, Integer> yearMap = new HashMap<>();
        for (String date : days) {
            int dateNumber = getDayNumberNew(LocalDate.parse(date));
                yearMap.put(date, dateNumber);
            }
        return yearMap;
    }


    /*
     * Function returns right pay days
     * @param days Date and weekday map, example { "2000-12-10" = 7, "2000-01-10" = 1 }
     * @return list of pay days
     */
    public static List<String> getPayDays (HashMap<String, Integer> days) {
        List<String> payDays = new ArrayList<>();
        for (String date : days.keySet()) {
            int element = days.get(date);
            String substring = date.substring(0, date.length() - 2);
            if (element == 6) {
                String newDate = substring + "09";
                payDays.add(newDate);
            }
            else if (element == 7) {
                String newDate = substring + "08";
                payDays.add(newDate);
            }
            else {
                payDays.add(date);
            }
        }
        Collections.sort(payDays);
        return payDays;
    }


    /*
     * Function returns right reminder days
     * @param days Date and weekday map, example { "2000-12-10" = 7, "2000-01-10" = 1 }
     * @return list of reminder days
     */
    public static List<String> getReminders (HashMap<String, Integer> days) {
        List<String> remindDays = new ArrayList<>();
        for (String date : days.keySet()) {
            int element = days.get(date);
            String substring = date.substring(0, date.length() - 2);
            int dateNumber = Integer.parseInt(date.substring(date.length() - 1));

            if (dateNumber == 0){
                int number = Integer.parseInt(date.substring(date.length() - 2));
                dateNumber += number;
            }

            if ( element == 4 || element == 5) {
                String newDate = substring + "0" + (dateNumber - 3);
                remindDays.add(newDate);
            }
            else if (element == 3 || element == 2 || element == 1){
                String newDate = substring + "0" + (dateNumber - 5);
                remindDays.add(newDate);
            }
        }
        Collections.sort(remindDays);
        return remindDays;
    }
}
