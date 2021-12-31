package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Cashier;
import model.Economist;
import model.MyDate;
import model.RW.RWUser;

public class AddCashier {
    public void view(Stage st) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        Label lab1 = new Label("Username : ");
        Label lab2 = new Label("Password : ");
        Label lab3 = new Label("Name : ");
        Label lab4 = new Label("Address : ");
        Label lab5 = new Label("Birthday : ");

        TextField usrname = new TextField();
        TextField password = new TextField();
        TextField name = new TextField();
        TextField address = new TextField();
        TextField birthday = new TextField();

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
                    RWUser rwu=new RWUser();
                    String username= usrname.getText();
                    String pass=password.getText();
                    String nm=name.getText();
                    String add=address.getText();
                    String bth=birthday.getText();
                    Cashier csh = new Cashier(username, pass, nm, add, new MyDate(bth));
                    rwu.add(csh);
                    st.close();
                    ViewAdmin vwAdm = new ViewAdmin();
                    vwAdm.view(st);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                st.close();
                ViewAdmin vwAdm = new ViewAdmin();
                vwAdm.view(st);
            }

        });

        Scene sc=new Scene(pane,400,300);
        st.setScene(sc);
        st.setTitle("Add Cashier: ");
        st.show();

    }

}


