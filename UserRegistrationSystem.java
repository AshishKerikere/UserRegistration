import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String emailAddress = UserEmailId.evaluateTypeAndCheck();
        System.out.println("This is correct email" +emailAddress);
    }

    public static String userFirstNameInputandValidation() {
        System.out.println("Enter User First Name");
        String userFirstName = scanner.next();
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher(userFirstName);
        if (matcher.find()) {
            return userFirstName;
        } else {
            userFirstName = userFirstNameInputandValidation();
            return userFirstName;
        }
    }

    public static String userLastNameInputandValidation() {
        System.out.println("Enter User Last Name");
        String userLastName = scanner.next();
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher(userLastName);
        if(matcher.find()){
            return userLastName;
        }
        else {
            userLastName = userLastNameInputandValidation();
            return userLastName;
        }
    }

}
