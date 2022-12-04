import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSystem {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static String userFirstNameInputandValidation(String userFirstName) {

        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher(userFirstName);
        if(matcher.find()){
            return "Correct Input";
        }
        else {
            return "Wrong Input";
        }
    }

    public static String userLastNameInputandValidation(String userLastName) {

        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher(userLastName);
        if(matcher.find()){
            return "Correct Input";
        }
        else {
            return "Wrong Input";
        }
    }

    public static String mobileNumberInputAndValidate(String mobileNumber) {

        Pattern pattern = Pattern.compile("^[9]{1}[1]{1}[\\s]{1}[9876]{1}[0-9]{9}$");
        Matcher matcher = pattern.matcher(mobileNumber);
        if(matcher.find()){
            return "Correct Input";
        }
        else {
            return "Wrong Input";
        }
    }

    public static String checkPasswordLength(String password){
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-[\\w]]{8,}");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            return "Correct Input";
        }
        else{
            return "Wrong Input";
        }
    }

    public static String passwordUpperCaseCharacters(String password){
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            return "Correct Input";
        }
        else{
            return "Wrong Input";
        }
    }

    public static String checkPasswordNumericCount(String password){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            return "Correct Input";
        }
        else{
            return "Wrong Input";
        }
    }

    public static String checkPasswordSpecialCharacters(String password){
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-]{1}");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()){
            return "Correct Input";
        }
        else{
            return "Wrong Input";
        }
    }
}
