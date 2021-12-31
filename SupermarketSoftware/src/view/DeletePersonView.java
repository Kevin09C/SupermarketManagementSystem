package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.MyDate;
import model.*;
import model.RW.RWUser;

public class DeletePersonView {
    public void start(Stage PrimaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        Label label1 = new Label("Enter The ID");
        TextField textField = new TextField();

        Button Delete = new Button("Delete");
        Button Cancel = new Button("Cancel");

        HBox hB = new HBox();
        hB.setSpacing(10);
        hB.getChildren().addAll(label1, textField);
        hB.getChildren().addAll(Delete, Cancel);

        Cancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                PrimaryStage.close();
                ViewAdmin vwAdm = new ViewAdmin();
                vwAdm.view(PrimaryStage);
            }

        });

        Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {

                RWUser rwu = new RWUser();
                int aId= Integer.parseInt(textField.getText());
                if(rwu.getPersonById(aId)!=null){
                    rwu.delete(rwu.getPersonById(aId));
                    Alert al=new Alert(Alert.AlertType.CONFIRMATION, "The user has been successfully deleted.", ButtonType.OK);
                    al.show();
                    ViewAdmin vwAdm = new ViewAdmin();
                    vwAdm.view(PrimaryStage);
                }
                else{
                    Alert al=new Alert(Alert.AlertType.INFORMATION, "The user does not exist.", ButtonType.OK);
                    al.show();

                }
            }
        });

        pane.getChildren().add(hB);
        Scene scene = new Scene(pane,400,300);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Delete user by ID");
        PrimaryStage.show();





    }
}
