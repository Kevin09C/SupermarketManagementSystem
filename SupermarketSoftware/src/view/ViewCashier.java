package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import model.RW.RWProducts;

import java.io.*;
import java.util.Scanner;

public class ViewCashier {
    public static void alertWindow() {
        Alert al=new Alert(Alert.AlertType.WARNING, "There is not enough quantity to make this purchase", ButtonType.OK);
        al.show();
    }

    public void view(Stage primaryStage, User usr){
        GridPane gp = new GridPane();

        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(7.5);
        gp.setVgap(7.5);

        Button billAdd = new Button("Add to the bill");
        Button totalBill = new Button("View Bill");
        Button logOut = new Button("Log Out");
        TextField nm = new TextField();
        TextField sppl = new TextField();
        TextField qn = new TextField();
        Text name = new Text("Name of product");
        Text suppl = new Text("Supplier");
        Text quant = new Text("Quantity");
        gp.add(name, 0, 0);
        gp.add(suppl, 1, 0);
        gp.add(quant, 2 , 0);
        gp.add(nm, 0, 1);
        gp.add(sppl, 1, 1);
        gp.add(qn, 2, 1);
        VBox vb=new VBox();



        billAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RWProducts bill = new RWProducts();
                String nameProd = nm.getText();
                String suppName = sppl.getText();
                String qnt = qn.getText();
                try {
                    bill.addToBill(nameProd, suppName, Double.parseDouble(qnt));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        totalBill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        logOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    (new LogIn()).start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gp.add(billAdd, 0, 2);
        gp.add(totalBill, 1, 2);
        gp.add(logOut, 2, 2);
        Scene sc = new Scene(gp, 350, 400);
        primaryStage.setScene(sc);
        primaryStage.show();

    }


}
