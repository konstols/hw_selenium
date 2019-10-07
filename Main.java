import java.util.concurrent.TimeUnit;

public class Main {

   // public static WebDriver driver;


    public static void main(String[] args) throws Exception {

       /* System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        String baseUrl="http://yugmeteo.donpac.ru/warning/";
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String s= driver.findElement(By.xpath("//div[@class='redtext ']/..//h3")).getText();
        List<WebElement> webList= driver.findElements(By.xpath("//div[@class='redtext ']/..//h3[1]"));
        System.out.println("??????? ?????: " + driver.findElement(By.xpath("//iframe[@src='/bullettin/warning.jsp']")).getText());
        driver.quit();
*/
   //    GetWarning getWarning=new GetWarning();
   //    String str= getWarning.getURL("http://yugmeteo.donpac.ru//bullettin/warning.jsp");


        PostWeb getWarning=new PostWeb();
        EmailSender send = new EmailSender();


        String strNew="";
        for (; ;){

            String str= getWarning.sendGet();
            System.out.println(str);

            if (str.equalsIgnoreCase(strNew)){
                System.out.println("Нет изменений");
                            }
                            else {
                send.emailSend("Информация о прогнозируемых опасных явлениях", str);
                strNew=str;
            }
            TimeUnit.MINUTES.sleep(30);
        }




    }


}
