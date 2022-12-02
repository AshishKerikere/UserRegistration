import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String mobileNumber = mobileNumberInputAndValidate();
        System.out.println(mobileNumber +" is an acceptable Mobile Number");
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

    public static String mobileNumberInputAndValidate() {
        System.out.println("Enter the Mobile Number");
        String mobileNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[9]{1}[1]{1}[\\s]{1}[9876]{1}[0-9]{9}$");
        Matcher matcher = pattern.matcher(mobileNumber);
        if(matcher.find()){
            return mobileNumber;
        }
        else {
            mobileNumber = mobileNumberInputAndValidate();
            return mobileNumber;
        }
    }

}
