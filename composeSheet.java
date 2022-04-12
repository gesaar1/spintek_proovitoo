package proovitoo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class composeSheet {

    /*
     * Function creates csv file
     * @param payDates List of pay days
     * @param reminders List of reminder days
     * @param year Year for which information is requested
     */
    public static void main(ArrayList<String> payDates, ArrayList<String> reminders, int year) {

        try (PrintWriter writer = new PrintWriter( year + ".csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("pay day");
            sb.append(',');
            sb.append("reminder date");
            sb.append('\n');

            for (int i = 0; i < payDates.size(); i++) {
                sb.append(payDates.get(i));
                sb.append(',');
                sb.append(reminders.get(i));
                sb.append('\n');
            }
            writer.write(sb.toString());

            System.out.println("done!");

            Path path = Paths.get(year + ".csv");
            System.out.println(path.toAbsolutePath());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
