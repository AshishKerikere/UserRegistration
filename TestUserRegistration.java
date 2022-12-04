import org.junit.*;

public class TestUserRegistration {

    @Before
    public void setUp() {
        System.out.println("@Before Annotation");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass Annotation");
    }

   @Test
    public void validate_name_with_userFirstNameInputandValidation(){
        System.out.println("@Test <validate_name_with_userFirstNameInputandValidation> Annotation");

        String check = "Ashish"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "Ash"; // Sad test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));
    }

    @Test
    public void validate_name_with_userLastNameInputandValidation(){
        System.out.println("@Test <validate_name_with_userLastNameInputandValidation> Annotation");

        String check = "Kerikere"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "Ka"; // Sad test case
        Assert.assertEquals("Wrong Input", TestSystem.userFirstNameInputandValidation(check));
    }

   @Test
    public void validate_mobileNumberInputAndValidate(){
        System.out.println("@Test <validate_mobileNumberInputAndValidate> Annotation");

        String check = "91 9657374204"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "99349284"; // Sad test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));
    }

    @Test
    public void validate_checkPasswordLength(){
        System.out.println("@Test <validate_checkPasswordLength> Annotation");

        String check = "Ash#kerikere"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "Ashish"; // Sad test case
        Assert.assertEquals("Wrong Input", TestSystem.userFirstNameInputandValidation(check));
    }

    @Test
    public void validate_passwordUpperCaseCharacters(){
        System.out.println("@Test <validate_passwordUpperCaseCharacters> Annotation");

        String check = "AshishKeri"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "Ashishkeri"; // Sad test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));
    }

    @Test
    public void validate_checkPasswordNumericCount(){
        System.out.println("@Test <validate_checkPasswordNumericCount> Annotation");

        String check = "Ashish6Kerikere"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "AshishKerikere"; // Sad test case
        Assert.assertEquals("Wrong Input", TestSystem.userFirstNameInputandValidation(check));
    }

    @Test
    public void validate_checkPasswordSpecialCharacters(){
        System.out.println("@Test <validate_checkPasswordSpecialCharacters> Annotation");

        String check = "Ashish#Kerikere"; // Happy test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));

        check = "AshKerikere"; // Sad test case
        Assert.assertEquals("Correct Input", TestSystem.userFirstNameInputandValidation(check));
    }

    @After
    public void after() {
        System.out.println("@After Annotation");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass Annotation");
    }
}
