import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BalanceInquirypage {
    public void show(){
    Stage window=new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    Label text=new Label();
    Button ok=new Button("Ok");

    VBox layout=new VBox(10);
    ok.setOnAction(e->window.close());

}}
