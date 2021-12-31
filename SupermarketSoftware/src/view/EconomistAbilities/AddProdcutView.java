package view.EconomistAbilities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MyDate;
import model.Products;
import model.RW.RWProducts;
import view.LogIn;

public class AddProdcutView {
    public void view() {
        Stage primaryStage = new Stage();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(5);
        gp.setVgap(5);

        Text name = new Text("Name of the product: "); TextField nameTF = new TextField();
        Text category = new Text("Cateogry: "); TextField ctgTF = new TextField();
        Text supplier = new Text("Supplier: "); TextField suppTF = new TextField();
        Text purchased_price = new Text("Purchased price: "); TextField p_priceTF = new TextField();
        Text purchased_date = new Text("Purchased Date: "); TextField p_dateTF = new TextField();
        Text Quantity = new Text ("Quantity"); TextField quant = new TextField();
        Text expiery_date = new Text("Expiery Date: "); TextField e_dateTF = new TextField();
        Text selling_price = new Text("Price sold: "); TextField s_priceTF = new TextField();

        gp.add(supplier, 0, 0); gp.add(suppTF, 1, 0);
        gp.add(name, 0, 1); gp.add(nameTF, 1, 1);
        gp.add(category, 0, 2); gp.add(ctgTF, 1,2);
        gp.add(purchased_price, 0, 3); gp.add(p_priceTF, 1,3);
        gp.add(selling_price, 0, 4); gp.add(s_priceTF, 1,4);
        gp.add(Quantity, 0,5); gp.add(quant, 1, 5);
        gp.add(purchased_date, 0, 6); gp.add(p_dateTF,1,6);
        gp.add(expiery_date, 0, 7); gp.add(e_dateTF, 1,7);

        Button add = new Button("Add");
        Button back = new Button("Back");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                RWProducts rwp = new RWProducts();
                String nm = nameTF.getText();
                String ct = ctgTF.getText();
                String sp = suppTF.getText();
                String qnt = quant.getText();
                String p_price = p_priceTF.getText();
                String p_date = p_dateTF.getText();
                String e_date = e_dateTF.getText();
                String s_price = s_priceTF.getText();
                double q = Double.parseDouble(qnt);
                double pp = Double.parseDouble(p_price);
                double sprc = Double.parseDouble(s_price);
                Products prod = new Products(nm, ct, sp, new MyDate(p_date), new MyDate(e_date), q, pp, sprc);
                rwp.add(prod);

            }

        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    (new LogIn()).start(primaryStage);
                } catch (Exception e) {
                    System.err.println("Log in did not work!!!");
                }
            }
        });
        gp.add(add, 0, 8); gp.add(back, 1, 8);
        Scene scene = new Scene(gp);
        primaryStage.setTitle("Stock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}

