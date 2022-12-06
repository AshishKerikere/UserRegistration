import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationSystemLambda {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter User First Name");
        String userFirstName = scanner.next();
        FirstName firstName = (userFirstName1) -> {

            Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
            Matcher matcher = pattern.matcher(userFirstName1);
            if (matcher.find()) {
                System.out.println("Correct Input");
            } else {
                System.out.println("Wrong Input");
            }
        };
        firstName.userFirstNameInputandValidation(userFirstName);

        System.out.println("Enter User Last Name");
        String userLastName = scanner.next();
        LastName lastName = (userLastName1) -> {
            Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
            Matcher matcher = pattern.matcher(userLastName1);
            if(matcher.find()){
                System.out.println("Correct Input");
            }
            else {
                System.out.println("Wrong Input");
            }
        };
        lastName.userLastNameInputandValidation(userLastName);

        System.out.println("Enter User Mobile Number");
        String userMobileNumber = scanner.nextLine();
        MobileNumber mobileNumber = (userMobileNumber1) -> {
            Pattern pattern = Pattern.compile("^[9]{1}[1]{1}[\\s]{1}[9876]{1}[0-9]{9}$");
            Matcher matcher = pattern.matcher(userMobileNumber1);
            if(matcher.find()){
                System.out.println("Correct Input");
            }
            else {
                System.out.println("Wrong Input");
            }
        };

        mobileNumber.mobileNumberInputAndValidate(userMobileNumber);

        System.out.println("Enter the Password");
        String password = scanner.next();

        PasswordLength passwordLength =(password1) -> {
            Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-[\\w]]{8,}");
            Matcher matcher = pattern.matcher(password1);
            if (matcher.find()){
                return true;
            }
            else{
                return false;
            }
        };


        PasswordUpperCase passwordUpperCase = (password2) -> {
            Pattern pattern = Pattern.compile("[A-Z]+");
            Matcher matcher = pattern.matcher(password2);
            if (matcher.find()){
                return true;
            }
            else{
                return false;
            }
        };

        PasswordNumeric passwordNumeric = (password3) -> {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(password3);
            if (matcher.find()){
                return true;
            }
            else{
                return false;
            }
        };


        PasswordSpecialCharacter passwordSpecialCharacter = (password4) -> {
            Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-]{1}");
            Matcher matcher = pattern.matcher(password4);
            if (matcher.find()){
                return true;
            }
            else{
                return false;
            }
        };

        boolean length = passwordLength.checkPasswordLength(password);
        boolean upperCase = passwordUpperCase.passwordUpperCaseCharacters(password);
        boolean numericCount = passwordNumeric.checkPasswordNumericCount(password);
        boolean specialCharacters = passwordSpecialCharacter.checkPasswordSpecialCharacters(password);

        if(length && upperCase && numericCount &&specialCharacters){
            System.out.println("Password is Correct");
        }

        else{
        System.out.println("Password is Wrong");
        }

    }
}

/* ---------- List of Interfaces --------- */

interface FirstName{
    public void userFirstNameInputandValidation(String firstName);
}

interface LastName{
    public void userLastNameInputandValidation(String lastName);
}

interface MobileNumber{
    public void mobileNumberInputAndValidate(String mobileNumber);
}

interface PasswordLength{
    public boolean checkPasswordLength(String password);
}

interface PasswordUpperCase{
    public boolean passwordUpperCaseCharacters(String password);
}

interface PasswordNumeric{
    public boolean checkPasswordNumericCount(String password);
}

interface PasswordSpecialCharacter{
    public boolean checkPasswordSpecialCharacters(String password);
}

interface Email{
    public void evaluateTypeAndCheck(String emailAddress);
}
