package proektna173038.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rentID;

    String rentDate;

    String returDate;

    String issue;

    @ManyToOne
    Customer customer;

    @ManyToMany
    List<Cars> carsRented;

    public Rent() {
    }

    public Long getRentID() {
        return rentID;
    }

    public void setRentID(Long rentID) {
        this.rentID = rentID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturDate() {
        return returDate;
    }

    public void setReturDate(String returDate) {
        this.returDate = returDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Cars> getCarsRented() {
        return carsRented;
    }

    public void setCarsRented(List<Cars> carsRented) {
        this.carsRented = carsRented;
    }
}
