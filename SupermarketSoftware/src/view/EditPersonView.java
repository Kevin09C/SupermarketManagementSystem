package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.RW.RWUser;
import org.w3c.dom.Text;

public class EditPersonView {
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        Label label1 = new Label("Enter The ID");
        TextField ID = new TextField();
        Button OK = new Button("OK");
        Button Cancel = new Button("Cancel");

        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(label1, ID);
        hb.getChildren().addAll(OK, Cancel);

        Cancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                primaryStage.close();
                ViewAdmin vwAdm = new ViewAdmin();
                vwAdm.view(primaryStage);
            }

        });

        OK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {

                RWUser rwu = new RWUser();
                int aId= Integer.parseInt(ID.getText());
                if(rwu.getPersonById(aId)!=null){
                    (new EditPersonInfoView()).start(primaryStage, aId);
                }
                else{
                    Alert al=new Alert(Alert.AlertType.INFORMATION, "The user does not exist.", ButtonType.OK);
                    al.show();

                }
            }
        });


        pane.getChildren().addAll(hb);
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Edit User By ID");
        primaryStage.show();




    }
}
