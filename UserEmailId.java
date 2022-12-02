import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UserEmailId {

    static Scanner scanner = new Scanner(System.in);
    public static String evaluateTypeAndCheck() {

        System.out.println("Enter the Email address");
        String emailAddress = scanner.next();

        int atSymbolCount = 0;
        int dotSymbolCount = 0;
        int atSymbolLocation = 0;
        int[] dotSymbolLocations = new int[3];
        //int validCase;

        for (int i = 0; i<emailAddress.length(); i++){
            if (emailAddress.charAt(i) == '.'){
                dotSymbolCount++;
                dotSymbolLocations[dotSymbolCount-1] = i;
            }
            if (emailAddress.charAt(i) == '@'){
                atSymbolCount++;
                atSymbolLocation = i;
            }
        }

        if (atSymbolCount == 1 && dotSymbolCount == 1){
            if (atSymbolLocation < dotSymbolLocations[0]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && mandatoryString3Check(emailAddress, dotSymbolLocations, 1)){
                    System.out.println("Case1 syntax is correct and matches Regex Pattern");
                    return emailAddress;
                }
                else{
                    System.out.println("Case 1 syntax is correct but doesnot match Regex Patterns");
                    System.out.print("Re-");
                    emailAddress = evaluateTypeAndCheck();
                    return emailAddress;
                }
            }
            else {
                System.out.println("Invalid Case 1");
                System.out.print("Re-");
                emailAddress = evaluateTypeAndCheck();
                return emailAddress;
            }
        }

        else if (atSymbolCount == 1 && dotSymbolCount == 3) {
            if (atSymbolLocation > dotSymbolLocations[0] && atSymbolLocation < dotSymbolLocations[1]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        optionalString1Check(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && optionalString2Check(emailAddress) && mandatoryString3Check(emailAddress,dotSymbolLocations, 4)){
                    System.out.println("Case4 syntax is correct and matches Regex Pattern");
                    return emailAddress;
                }
                else {
                    System.out.println("Case 4 syntax is correct but does not match Regex Patterns");
                    System.out.print("Re-");
                    emailAddress = evaluateTypeAndCheck();
                    return emailAddress;
                }
            }
            else {
                System.out.println("Invalid Use case 4");
                System.out.print("Re-");
                emailAddress = evaluateTypeAndCheck();
                return emailAddress;
            }
        }


        else if (atSymbolCount == 1 && dotSymbolCount == 2){

            if(dotSymbolLocations[0] < atSymbolLocation && atSymbolLocation < dotSymbolLocations[1]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        optionalString1Check(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        mandatoryString3Check(emailAddress, dotSymbolLocations, 2)){
                    System.out.println("Case 2 Syntax is Correct and matches Regex Pattern");
                    return emailAddress;
                }
                else {
                    System.out.println("Case 2 Syntax is Correct but doesnot match Regex Pattern");
                    System.out.print("Re-");
                    emailAddress = evaluateTypeAndCheck();
                    return emailAddress;
                }
            }

            else if(atSymbolLocation < dotSymbolLocations[0]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && optionalString2Check(emailAddress) && mandatoryString3Check(emailAddress,dotSymbolLocations, 3)){
                    System.out.println("Case 3 Syntax is Correct and matches Regex Pattern");
                    return emailAddress;
                }
                else {
                    System.out.println("Case 3 Syntax is Correct but doesnot match Regex Pattern");
                    System.out.print("Re-");
                    emailAddress = evaluateTypeAndCheck();
                    return emailAddress;
                }
            }

            else{
                System.out.println("invalid Use Case 2 and 3");
                System.out.print("Re-");
                emailAddress = evaluateTypeAndCheck();
                return emailAddress;
            }
        }

        else {
            System.out.println("Invalid way of Writing email address");
            System.out.print("Re-");
            emailAddress = evaluateTypeAndCheck();
            return emailAddress;
        }
    }
    //UC1
    public static boolean mandatoryPrefixCheck(String emailAddress, int atSymbolLocation, int[] dotSymbolLocations){
        String mandatoryPrefix;

        if (atSymbolLocation < dotSymbolLocations[0]){
            mandatoryPrefix = emailAddress.substring(0,atSymbolLocation);
        }
        else {
            mandatoryPrefix = emailAddress.substring(0, dotSymbolLocations[0]);
        }

        Pattern pattern = Pattern.compile("^[a-zA-z][a-zA-Z0-9]*[+_-]?[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(mandatoryPrefix);
        return matcher.find();
    }
    //UC4
    public static boolean optionalString1Check(String emailAddress, int atSymbolLocation, int[] dotSymbolLocations){
        String optionalString1 = emailAddress.substring(dotSymbolLocations[0]+1, atSymbolLocation);
        Pattern pattern = Pattern.compile("^[a-zA-z0-9][a-zA-Z0-9]*[-]?[a-zA-Z0-9]$");
        Matcher matcher = pattern.matcher(optionalString1);
        return matcher.find();
    }

    //UC2 method
    public static boolean mandatoryDomainCheck(String emailAddress, int atSymbolLocation, int[] dotSymbolLocations){
        String mandatoryDomain;
        mandatoryDomain = emailAddress.substring(atSymbolLocation+1, emailAddress.indexOf('.', atSymbolLocation+1));
        Pattern pattern = Pattern.compile("^[a-zA-z][a-zA-Z0-9]*[-]?[a-zA-Z0-9]$");
        Matcher matcher = pattern.matcher(mandatoryDomain);
        return matcher.find();
    }
    //UC5
    public static boolean optionalString2Check(String emailAddress){
        String optionalString2 = emailAddress.substring(emailAddress.lastIndexOf('.')+1);
        Pattern pattern = Pattern.compile("^[a-z][a-z]$");
        Matcher matcher = pattern.matcher(optionalString2);
        return (matcher.find());

    }
    //UC3
    public static boolean mandatoryString3Check(String emailAddress, int[] dotSymbolLocations,int caseChecker){
        String mandatoryPart3;
        if(caseChecker == 1 || caseChecker == 2){
            mandatoryPart3 = emailAddress.substring(emailAddress.lastIndexOf('.')+1);
        }
        else if(caseChecker == 4) {
            mandatoryPart3 = emailAddress.substring(dotSymbolLocations[1]+1, dotSymbolLocations[2]);
        }
        else {
            mandatoryPart3 = emailAddress.substring(dotSymbolLocations[0]+1, dotSymbolLocations[1]);
        }
        Pattern pattern = Pattern.compile("^[a-z][a-z]?[a-z]$");
        Matcher matcher = pattern.matcher(mandatoryPart3);
        return (matcher.find());
    }
}
