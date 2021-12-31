package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.MyDate;
import model.*;
import model.RW.RWUser;
import model.User;


public class EditPersonInfoView {
    public void start(Stage primaryStage, int aId){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);
        pane.setVgap(5);

        RWUser rwUser = new RWUser();
        Label lab1 = new Label("Username : ");
        Label lab2 = new Label("Password : ");
        Label lab3 = new Label("Name : ");
        Label lab4 = new Label("Address : ");
        Label lab5 = new Label("Birthday : ");

        TextField usrname = new TextField((rwUser.getPersonById(aId)).getUser());
        TextField password = new TextField((rwUser.getPersonById(aId)).getPass());
        TextField name = new TextField((rwUser.getPersonById(aId)).getName());
        TextField address = new TextField((rwUser.getPersonById(aId)).getAddress());
        TextField birthday = new TextField(((rwUser.getPersonById(aId)).getBd()).toString());

        pane.add(lab1, 1, 0); pane.add(usrname, 3, 0);
        pane.add(lab2, 1, 1); pane.add(password, 3, 1);
        pane.add(lab3, 1, 2); pane.add(name, 3, 2);
        pane.add(lab4, 1, 3); pane.add(address, 3, 3);
        pane.add(lab5, 1, 4); pane.add(birthday, 3, 4);


        Button okBtn = new Button("Ok");
        Button cancelBtn = new Button("Cancel");

        pane.add(okBtn, 2, 5); pane.add(cancelBtn,3,5);


        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    String username= usrname.getText();
                    String pass=password.getText();
                    String nm=name.getText();
                    String add=address.getText();
                    String bth=birthday.getText();
                    User usr = rwUser.getPersonById(aId);
                    usr.user = username;
                    usr.setPass(pass);
                    usr.setName(nm);
                    usr.setAddress(add);
                    usr.setBd((new MyDate(bth)));
                    rwUser.delete(rwUser.getPersonById(aId));
                    rwUser.add(usr);
                    primaryStage.close();
                    ViewAdmin vwAdm = new ViewAdmin();
                    vwAdm.view(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                primaryStage.close();
                ViewAdmin vwAdm = new ViewAdmin();
                vwAdm.view(primaryStage);
            }

        });

        Scene sc=new Scene(pane,400,300);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Edit User By ID");
        primaryStage.show();


    }
}
