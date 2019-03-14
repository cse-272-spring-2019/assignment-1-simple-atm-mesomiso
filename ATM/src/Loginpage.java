import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Loginpage {
    Scene scene;
    Stage stage;
    Homepage homepage;



    public  Loginpage(Stage stage){
        this.stage=stage;
    }
    public void prepareScene(){

        Label cardnumberlabel=new Label("Cardnumber: ");
        PasswordField cardnumberpassword=new PasswordField();
        Button submit=new Button("Submit");
        Label error=new Label("");

        GridPane grid=new GridPane();
        grid.add(cardnumberlabel,0,0);
        grid.add(cardnumberpassword,1,0);
        grid.add(submit,1,1);
        grid.add(error,1,2);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username=cardnumberpassword.getText();
                Transactions authentication=new Transactions();
                boolean validate=authentication.Validation(username);
                if(validate) {
                    stage.setScene(homepage.getScene());
                    cardnumberpassword.setText("");
                }
                else
                    error.setText("Please re-enter the right cardnumber");

            }
        });
        scene=new Scene(grid,600,400);
    }
    public Scene getScene(){
        return scene;
    }
    public void setHome(Homepage homepage){
        this.homepage=homepage;
    }

}



