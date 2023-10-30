package Domains;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Employee employee;
    private Client client;
    private ArrayList<Domains.Product> products;
    private float totalPrice;
    private Date date;
    private Status status;
    private Delivery delivery;

    public Order(Client client,Employee employee, Date date, Status status) {
        this.employee = employee;
        this.client=client;
        //this.products = products; TODO LE IA DIN REPO
        this.date = date;
        this.status = status;
        //TODO initializat un delivery aici
        //this.delivery = delivery;
        //TODO TOTAL PRICE= PRODUSE+TAXA TRANSPORT
    }

    //TODO ADD PRODUCT+ TOTAL PRICE
    //change order
    //validdare produse pe stoc

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "employee=" + employee +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                ", status=" + status +
                ", delivery=" + delivery +
                '}';
    }
}
