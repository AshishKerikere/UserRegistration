import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        passwordInput();
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

    public static void passwordInput(){
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        checkPasswordLength(password);
    }

    public static void checkPasswordLength(String password){
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-[\\w]]{8,}");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            System.out.println("Password Length is 8 or more characters");
            passwordUpperCaseCharacters(password);
        }
        else{
            System.out.println("Password Length is not atleast 8 characters in Length");
            System.out.print("Re-");
            passwordInput();
        }
    }

    public static void passwordUpperCaseCharacters(String password){
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            System.out.println("Password has 1 or more Upper Case Characters");
            checkPasswordNumericCount(password);
        }
        else{
            System.out.println("Password does not have UpperCase characters");
            System.out.print("Re-");
            passwordInput();
        }
    }

    public static void checkPasswordNumericCount(String password){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            System.out.println("Password has 1 or more Numeric Character");
        }
        else{
            System.out.println("Password does not have any Numeric Characters");
            System.out.print("Re-");
            passwordInput();
        }
    }
}
