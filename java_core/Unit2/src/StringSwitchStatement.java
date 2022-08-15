import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
    public static void main(String[] args) {
    StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("today is "+statement.getTypeOfDay(calendar));
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+1);
        System.out.println("tomorow is "+statement.getTypeOfDay(calendar));
    }

  String getTypeOfDay(Calendar calendar){
   String type = calendar.getDisplayName(
           Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi"));
   switch (type){
       case "Th 2":
           return "Start of work week";
       case "Th 3":
       case "Th 4":
           return "MidWeek";
       case"Th 7":
       case"CN": return "weekend";
   }
   return "unknown";
  }
}
