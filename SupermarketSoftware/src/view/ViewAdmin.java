package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import model.User;
import model.RW.RWUser;

public class ViewAdmin {

    public void view(Stage st) {
        Pane pane=new StackPane();

        RWUser rwu=new RWUser();
        Object[] lista=rwu.getUsers().toArray();
        Text[] arr=new Text[lista.length];
        VBox vb=new VBox();
        for(int i=0; i<lista.length; i++) {
            if(lista[i] instanceof Cashier ||lista[i] instanceof Economist) {
                System.out.println(lista[i].toString());
                arr[i]=new Text("ID: "+((User) lista[i]).getId()+" -> "+lista[i].toString());
                vb.getChildren().add(arr[i]);
            }
        }
        Button addEcon=new Button("Add Economist");
        Button addCashier=new Button("Add Cashier");
        Button edit=new Button("Edit User By Id");
        Button dele=new Button("Delete By Id");
        Button dil=new Button("Log Out");
        // Veprimet e Butonave
        addEcon.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                (new AddEconomist()).view(st);
            }

        });
        addCashier.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                (new AddCashier()).view(st);
            }

        });
        dil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    (new LogIn()).start(st);
                } catch (Exception e) {
                    System.err.println("Logini nuk funksionon!!!");
                }
            }
        });
        dele.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                (new DeletePersonView()).start(st);
            }
        });
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                (new EditPersonView()).start(st);
            }
        });

        vb.getChildren().add(addEcon);
        vb.getChildren().add(addCashier);
        vb.getChildren().add(edit);
        vb.getChildren().add(dele);
        vb.getChildren().add(dil);

        //Veprimet e Butonave

        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);

        pane.getChildren().add(vb);
        Scene sc=new Scene(pane,400,300);
        st.setScene(sc);
        st.setTitle("Admin View");
        st.show();
    }

}
