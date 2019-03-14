import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Homepage {
    Withdrawpage withdrawpage;
    Scene scene;
    Stage stage;
    Loginpage loginpage;
    Deposit depositpage;
    Transactions transaction=new Transactions();
    AlertBox alertbox=new AlertBox();

    public Homepage(Stage stage)
    {
        this.stage=stage;
    }
    public void prepareScene() {

        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        Button balanceInquiry = new Button("Balance inquiry");
        Button next = new Button("Next");
        Label nextlabel=new Label("");
        Button  previous=new Button("Previous");
        Label previouslabel=new Label("");
        Button logout = new Button("Logout");
        VBox vbox=new VBox(10);
        vbox.getChildren().addAll(withdraw,deposit,balanceInquiry,next,previous,previouslabel,logout);
        vbox.setAlignment(Pos.TOP_CENTER);
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginpage.getScene());

            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(withdrawpage.getScene());

            }
        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(depositpage.getScene());
            }
        });
        balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alertbox.display("Your current balance is",transaction.getBalance());
                transaction.setActions("Balance Inquiry");
                transaction.setNumbers(0.0);

            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        previous.setOnAction(e->alertbox.display(transaction.getActions1(),transaction.getNumbers1())
        );
        next.setOnAction(e->alertbox.display(transaction.getActions2(),transaction.getNumbers2()));

        scene=new Scene(vbox,600,400);
    }
    public Scene getScene(){
        return scene;
    }
    public void setLogin(Loginpage loginpage){
        this.loginpage=loginpage;
    }
    public void setWithdrawpage(Withdrawpage withdrawpage)
    {this.withdrawpage=withdrawpage;}

    public void setDeposit(Deposit depositpage) {
        this.depositpage = depositpage;
    }
}