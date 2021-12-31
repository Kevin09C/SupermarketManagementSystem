package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrator;
import model.Cashier;
import model.Economist;
import model.*;
import model.User;
import model.RW.RWUser;

public class LogIn extends Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    @Override
    public void start(Stage st) throws Exception {


        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        Label user=new Label("Username");
        Label pass=new Label("Password");
        TextField usertf=new TextField();
        TextField passtf=new TextField();
        gp.add(scenetitle, 0, 0, 2, 1);
        gp.add(user, 0, 1);
        gp.add(pass, 0, 2);
        gp.add(usertf, 1, 1);
        gp.add(passtf, 1, 2);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        //Zona e butonave
        HBox hb=new HBox();
        Button logIn=new Button("Log In");
        Button cancel=new Button("Cancel");
        //Veprimet e butonave
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ev) {
                System.exit(0);
            }
        });
        logIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RWUser rwu=new RWUser();
                String user=usertf.getText();
                String pass=passtf.getText();
                User usr=rwu.checkLogin(user, pass);
                if(usr instanceof Administrator) {
                    //Faqja e Adminit
                    (new ViewAdmin()).view(st);
                } else if(usr instanceof Economist) {
                    (new ViewEconomist()).view(st,usr);
                } else if (usr instanceof Cashier){
                    (new ViewCashier()).view(st,usr);
                }
                else{
                    Alert al=new Alert(AlertType.WARNING, "Username and Password is incorrect", ButtonType.OK);
                    al.show();
                }

            }
        });


        hb.getChildren().addAll(logIn, cancel);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10,10,10,10));
        hb.setSpacing(10);
        Pane pane=new StackPane();
        VBox vb=new VBox();
        vb.getChildren().addAll(gp,hb);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(vb);

        Scene sc=new Scene(pane,350,300);
        st.setScene(sc);
        st.setTitle("LogIn");
        st.show();
    }

}
