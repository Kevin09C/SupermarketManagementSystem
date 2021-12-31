package model.RW;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.scene.control.Alert;
import model.*;


public class RWProducts {
    private ArrayList<Products> products;
    private static final String file = "products.bin";
    private File fi;


    SimpleDateFormat formatter;
    Date current;

    public RWProducts() {
        products = new ArrayList<>();
        fi = new File(file);
        if (fi.exists()) {
            readProducts();
        } else {
            createFile();
        }
    }


    private void createFile() {
        System.out.println("First usage -> Please register Data");
        Scanner in = new Scanner(System.in);
        System.out.print("name: ");
        String name = in.next();
        System.out.print("cateogry: ");
        String category = in.next();
        System.out.print("supplier: ");
        String supplier = in.next();
        System.out.print("purchased date: ");
        MyDate purchased_date = new MyDate(in.next());
        System.out.print("expiery date: ");
        MyDate expirey_date = new MyDate(in.next());
        System.out.print("quantity: ");
        double quantity = in.nextDouble();
        System.out.print("purchased_price: ");
        double purchased_price = in.nextDouble();
        System.out.print("selling_price: ");
        double selling_price = in.nextDouble();
        products.add(new Products(name, category, supplier, purchased_date, expirey_date, quantity, purchased_price, selling_price));
        writeProducts();
    }

    private void writeProducts() {
        try {
            FileOutputStream fos = new FileOutputStream(fi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("File cannot be written!!!");
        } catch (IOException e) {
            System.err.println("Problem with writing object");
        }
    }

    private void readProducts() {
        try {
            FileInputStream fis = new FileInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (ArrayList<Products>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!!");
        } catch (IOException e) {
            System.err.println("File is corrupted");
        } catch (ClassNotFoundException e) {
            System.err.println("Class does not match");
        }
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void addChecker(Products x) {
        int flag = 0;
        for (Products e : products) {
            if ((x.getName()).equals(e.getName()) && (x.getSupplier()).equals(e.getSupplier())
                    && x.getSelling_price() == e.getSelling_price() &&
                    (x.getExpirey_date()).equals(e.getExpirey_date())) {
                double temp = e.getQuantity();
                temp += x.getQuantity();
                e.setQuantity(temp);
                flag = 1;
            }
        }
        if (flag == 0) {
            add(x);
        }
    }

    public void add(Products x) {
        products.add(x);
        writeProducts();
    }


    public void update() {
        writeProducts();
    }

    public void addToBill(String nameProd, String supplier, double quantity) throws IOException {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        current = new Date();

        try (FileWriter fw = new FileWriter("bill.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Products e : products) {
                if ((nameProd.equals(e.getName()) && supplier.equals(e.getSupplier()))
                        && (e.getQuantity() - quantity) >= 0 && (quantity != 0)) {

                    out.println(formatter.format(current));
                    out.print(nameProd + " ");
                    out.print(supplier + " ");
                    out.println(quantity * e.getSelling_price());
                    e.setQuantity((e.getQuantity() - quantity));
                    update();

                } else if ((nameProd.equals(e.getName()) && supplier.equals(e.getSupplier()))
                        && (e.getQuantity() - quantity) < 0) {
                    Alert al = new Alert(Alert.AlertType.ERROR, "There is not enough stock of " + e.getName() + " in the supermarket");
                    al.show();
                }
            }

        } catch (IOException e) {
        }
    }

}

