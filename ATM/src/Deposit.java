import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Deposit {

    Stage stage;
    AlertBox alertbox=new AlertBox();
    Transactions transaction=new Transactions();
    Homepage homepage;
    Scene scene;
    public Deposit(Stage stage)
    {this.stage=stage;}
    public void prepareScene(){
        Label depositLabel=new Label("Enter the amount you wish to deposit: ");
        TextField depositText=new TextField();
        Button submit=new Button("Submit");
        Label error=new Label("");
        Button back=new Button("Back");

        GridPane grid =new GridPane();

        grid.add(depositLabel,0,0);
        grid.add(depositText,1,0);
        grid.add(error,0,1);
        grid.add(submit,2,0);
        grid.add(back,0,2);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean z=depositText.getText().isEmpty();
                if(z)
                    error.setText("Please enter a value");
                else{
                double x=transaction.Deposit(Double.parseDouble(depositText.getText()));
                 if(x==-1)
                    error.setText("Not valid input");
                else
                    error.setText("Successful transaction");
                }
        }});


        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homepage.getScene());
                error.setText("");
                depositText.setText("");
            }
        });
        scene=new Scene(grid,600,400);

    }
    public Scene getScene(){
        return this.scene;
    }
    public void setHomepage(Homepage homepage) {
        this.homepage = homepage;
    }


}


