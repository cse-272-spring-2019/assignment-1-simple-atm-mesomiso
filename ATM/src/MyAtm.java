import javafx.application.Application;
import javafx.stage.Stage;

public class MyAtm extends Application {
    public static void main(String []args) {
       launch(args);

    }
        public void start(Stage primaryStage) throws Exception{
            primaryStage.setTitle("ATM");
            Loginpage loginpage=new Loginpage(primaryStage);
            Homepage homepage=new Homepage(primaryStage);
            Withdrawpage withdrawpage=new Withdrawpage(primaryStage);
            Deposit depositpage=new Deposit(primaryStage);

            loginpage.prepareScene();
            withdrawpage.prepareScene();
            homepage.prepareScene();
            depositpage.prepareScene();

            loginpage.setHome(homepage);
            homepage.setLogin(loginpage);
            homepage.setWithdrawpage(withdrawpage);
            withdrawpage.setHomepage(homepage);
            homepage.setDeposit(depositpage);
            depositpage.setHomepage(homepage);

            primaryStage.setScene(loginpage.getScene());


            primaryStage.show();

        }

}
