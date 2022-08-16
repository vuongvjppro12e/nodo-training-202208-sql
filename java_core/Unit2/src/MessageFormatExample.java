import java.text.MessageFormat;
import java.util.Calendar;

public class MessageFormatExample {
    public static void main(String[] args) {
        String dateFormat = "EEEEE,ddMMMMM,yyyy";
        String message = MessageFormat.format(
                "Hello {0}! Today is {1}.",args[0],
                dateFormat.format(String.valueOf(Calendar.getInstance().getTime())));
        System.out.println(message);
    }
}
