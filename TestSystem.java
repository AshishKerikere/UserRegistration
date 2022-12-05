import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSystem {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

       try{
            System.out.println("Enter User First Name");
            String userFirstName = scanner.next();
            userFirstName = userFirstNameInputandValidation(userFirstName);
        }catch (UserFirstNameException e){
            System.out.println(e);
        }

        try{
            System.out.println("Enter User Last Name");
            String userLastName = scanner.next();
            userLastName = userLastNameInputandValidation(userLastName);
        }catch (UserLastNameException e){
            System.out.println(e);
        }

        try{
            System.out.println("Enter Mobile Number");
            String mobileNumber = scanner.next();
            mobileNumber = mobileNumberInputAndValidate(mobileNumber);
        }catch (mobileNumberException e){
            System.out.println(e);
        }

        try{
            System.out.println("Enter Email ID");
            String emailAddress = scanner.next();
            emailAddress = UserEmailId.evaluateTypeAndCheck(emailAddress);
        }catch (EmailIDException e){
            System.out.println(e);
        }

        System.out.println("Enter Password");
        String password = scanner.next();
        try{
            password = checkPasswordLength(password);
        }catch (PasswordLengthException e){
            System.out.println(e);
        }

        try{
            password = passwordUpperCaseCharacters(password);
        }catch (PasswordUpperCaseCharactersException e){
            System.out.println(e);
        }

        try{
            password = checkPasswordNumericCount(password);
        }catch (PasswordNumericCountException e){
            System.out.println(e);
        }

        try{
            password = checkPasswordSpecialCharacters(password);
        }catch (PasswordSpecialCharactersException e){
            System.out.println(e);
        }

    }

    public static String userFirstNameInputandValidation(String userFirstName) throws UserFirstNameException {

        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher(userFirstName);
        if(!matcher.find()){
            throw new UserFirstNameException();
        }

        return userFirstName;
    }

    public static String userLastNameInputandValidation(String userLastName) throws UserLastNameException {

        Pattern pattern = Pattern.compile("^[A-Z][a-z]{3,}");
        Matcher matcher = pattern.matcher(userLastName);
        if(!matcher.find()){
            throw new UserLastNameException();
        }
        return userLastName;
    }

    public static String mobileNumberInputAndValidate(String mobileNumber) throws mobileNumberException{

        Pattern pattern = Pattern.compile("^[9]{1}[1]{1}[\\s]{1}[9876]{1}[0-9]{9}$");
        Matcher matcher = pattern.matcher(mobileNumber);
        if(!matcher.find()){
            throw new mobileNumberException();
        }
        return mobileNumber;
    }

    public static String checkPasswordLength(String password) throws PasswordLengthException{
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-[\\w]]{8,}");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()){
            throw new PasswordLengthException();
        }
        return password;
    }

    public static String passwordUpperCaseCharacters(String password) throws PasswordUpperCaseCharactersException{
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()){
            throw new PasswordUpperCaseCharactersException();
        }

        return password;
    }

    public static String checkPasswordNumericCount(String password) throws PasswordNumericCountException{
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()){
            throw new PasswordNumericCountException();
        }

        return password;
    }

    public static String checkPasswordSpecialCharacters(String password) throws PasswordSpecialCharactersException{
        Pattern pattern = Pattern.compile("[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-]{1}");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()){
            throw new PasswordSpecialCharactersException();
        }

        return password;
    }
}
