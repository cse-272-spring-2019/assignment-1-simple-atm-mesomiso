import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {
    public void display(String Message,Double balance)
    {

        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Label text=new Label();
        Label value=new Label();
        Button ok=new Button("Ok");
        text.setText(Message);
        value.setText(" "+balance);

        VBox layout=new VBox(10);
        ok.setOnAction(e -> window.close());

        layout.getChildren().addAll(text,value,ok);
        layout.setAlignment(Pos.CENTER);

        window.setMinWidth(350);
        Scene scene=new Scene(layout);

        window.setScene(scene);
        window.showAndWait();

    }
}

