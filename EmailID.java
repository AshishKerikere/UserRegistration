import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailId {

    public static String evaluateTypeAndCheck(String emailAddress) {

        int atSymbolCount = 0;
        int dotSymbolCount = 0;
        int atSymbolLocation = 0;
        int[] dotSymbolLocations = new int[3];

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

                    return "Correct Input";
                }
                else{

                    return "Wrong Input";
                }
            }
            else {

                return "Wrong Input";
            }
        }

        else if (atSymbolCount == 1 && dotSymbolCount == 3) {
            if (atSymbolLocation > dotSymbolLocations[0] && atSymbolLocation < dotSymbolLocations[1]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        optionalString1Check(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && optionalString2Check(emailAddress) && mandatoryString3Check(emailAddress,dotSymbolLocations, 4)){

                    return "Correct Input";
                }
                else {

                    return "Wrong Input";
                }
            }
            else {

                return "Wrong Input";
            }
        }


        else if (atSymbolCount == 1 && dotSymbolCount == 2){

            if(dotSymbolLocations[0] < atSymbolLocation && atSymbolLocation < dotSymbolLocations[1]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        optionalString1Check(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations) &&
                        mandatoryString3Check(emailAddress, dotSymbolLocations, 2)){

                    return "Correct Input";
                }
                else {

                    return "Wrong Input";
                }
            }

            else if(atSymbolLocation < dotSymbolLocations[0]){
                if (mandatoryPrefixCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && mandatoryDomainCheck(emailAddress, atSymbolLocation, dotSymbolLocations)
                        && optionalString2Check(emailAddress) && mandatoryString3Check(emailAddress,dotSymbolLocations, 3)){

                    return "Correct Input";
                }
                else {

                    return "Wrong Input";
                }
            }

            else{

                return "Wrong Input";
            }
        }

        else {

            return "Wrong Input";
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
