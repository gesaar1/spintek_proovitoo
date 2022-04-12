package proovitoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        ArrayList<String> days = (ArrayList<String>) proovitoo.getPayDay.getDay(year);
        HashMap<String, Integer> pay = proovitoo.getPayDay.getWeekdays(days);

        ArrayList<String> payDates = (ArrayList<String>) proovitoo.getPayDay.getPayDays(pay);

        HashMap<String, Integer> payDaysWithWeeks = proovitoo.getPayDay.getWeekdays(payDates);

        List<String> remindDates = proovitoo.getPayDay.getReminders(payDaysWithWeeks);

        proovitoo.composeSheet.main(payDates, (ArrayList<String>) remindDates, year);

    }
}
