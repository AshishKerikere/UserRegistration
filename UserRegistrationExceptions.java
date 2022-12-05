public class UserRegistrationExceptions extends Exception{
    public String toString(){
        return "User Registration System Exception.";
    }
}

class UserFirstNameException extends UserRegistrationExceptions{
    public String toString(){
        return "Invalid First Name";
    }
}

class UserLastNameException extends UserRegistrationExceptions{
    public String toString(){
        return "Invalid Last Name";
    }
}

class mobileNumberException extends UserRegistrationExceptions{
    public String toString(){
        return "Invalid Mobile Number";
    }
}

class PasswordException extends UserRegistrationExceptions{
    public String toString(){
        return "Invalid Password";
    }
}

class PasswordLengthException extends PasswordException{
    public String toString(){
        return "Password is not atleast 8 characters long";
    }
}

class PasswordUpperCaseCharactersException extends PasswordException{
    public String toString(){
        return "Password doesnot have atleast one Uppercase character";
    }
}

class PasswordNumericCountException extends PasswordException{
    public String toString(){
        return "Password Doesnot have atleast one Numberic Character";
    }
}

class PasswordSpecialCharactersException extends PasswordException{
    public String toString(){
        return "Password does not have exactly one special character";
    }
}

class EmailIDException extends UserRegistrationExceptions{
    public String toString(){
        return "Invalid EmailID entered.";
    }
}
