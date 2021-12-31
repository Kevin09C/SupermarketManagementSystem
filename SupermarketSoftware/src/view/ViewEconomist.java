package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import model.RW.RWProducts;
import view.EconomistAbilities.AddProdcutView;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ViewEconomist {
    public void view(Stage primaryStage, User usr){
        StackPane spane = new StackPane();
        RWProducts rwu=new RWProducts();
        Object[] lista=rwu.getProducts().toArray();
        Text[] arr=new Text[lista.length];
        VBox vb=new VBox();
        for(int i=0; i<lista.length; i++) {

            arr[i] = new Text("There are " + ((Products)lista[i]).getQuantity() + " of product "
                    +  ((Products)lista[i]).getName() + " left");
            vb.getChildren().add(arr[i]);
        }


        Button addProd = new Button("Add Product");
        Button prf = new Button("Cashier's Performance");
        Button statistics = new Button("Statistics");
        Button suppliers = new Button("Suppliers");

        vb.getChildren().addAll(addProd, prf, statistics, suppliers);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);


        addProd.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

               new AddProdcutView().view();
            }

        });
        spane.getChildren().add(vb);
        Scene scene = new Scene(spane,400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Economist view");
        primaryStage.show();
        }
    }

