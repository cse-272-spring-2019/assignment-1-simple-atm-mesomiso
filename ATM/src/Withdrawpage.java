import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Withdrawpage {
    Scene scene;
    Stage stage;
    Transactions transaction=new Transactions();
    AlertBox alertbox=new AlertBox();
    Homepage homepage;
    public Withdrawpage(Stage stage)
    {
        this.stage=stage;
    }
    public void prepareScene(){

        Label withdrawLabel=new Label("Enter the amount you wish to draw: ");
        TextField withdrawText=new TextField();
        Button submit=new Button("Submit");
        Label error=new Label("");
        Button back=new Button("Back");

        GridPane grid =new GridPane();

        grid.add(withdrawLabel,0,0);
        grid.add(withdrawText,1,0);
        grid.add(submit,2,0);
        grid.add(error,0,1);

        grid.add(back,0,2);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean z=withdrawText.getText().isEmpty();
                if(z)
                    error.setText("Please enter a value");
                else{
                double x=transaction.Withdraw(Double.parseDouble(withdrawText.getText()));
                if(x==-1)
                    error.setText("Not valid input");
                else
                    error.setText("Successful transaction. ");

            }
        }});

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homepage.getScene());
                error.setText("");
                withdrawText.setText("");
            }
        });
        scene=new Scene(grid,600,400);

}
    public Scene getScene(){
        return scene;
    }
    public void setHomepage(Homepage homepage) {
        this.homepage = homepage;
    }


}
