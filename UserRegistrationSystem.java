import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userFirstName = userFirstNameInputandValidation();
        System.out.println(userFirstName +" is a valid First User Name.");
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

}
