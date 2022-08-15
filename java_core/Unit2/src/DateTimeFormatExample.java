import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("vi","VN");
        DateFormat dateFormat = new SimpleDateFormat("EEEEE,dd,MMMMMyyyy", locale);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }
}
