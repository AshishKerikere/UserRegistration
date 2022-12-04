import org.junit.*;
public class TestUserEmailId {

    @Before
    public void setUp() {
        System.out.println("@Before Annotation");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass Annotation");
    }

    @Test
    public void validate_evaluateTypeAndCheck(){
        System.out.println("@Test <validate_evaluateTypeAndCheck> Annotation");

        String emailID = "abc@yahoo.com";
        Assert.assertEquals("Correct Input", UserEmailId.evaluateTypeAndCheck(emailID));

        emailID = "abc-100@yahoo.com";
        Assert.assertEquals("Correct Input", UserEmailId.evaluateTypeAndCheck(emailID));

        emailID = "abc@.com.my";
        Assert.assertEquals("Wrong Input", UserEmailId.evaluateTypeAndCheck(emailID));

        emailID = "abc@abc@gmail.com";
        Assert.assertEquals("Correct Input", UserEmailId.evaluateTypeAndCheck(emailID));

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
