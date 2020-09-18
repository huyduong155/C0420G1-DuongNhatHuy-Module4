package furama.model;

import org.springframework.stereotype.Component;
import validate.PhoneNumber;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Pattern(regexp = "KH-[\\d]{4}",message = "customer code is not format")
    private String id;

    private String name;

    private String birthday;

    @Pattern(regexp = "[\\d]{9}",message = "must be a number and length =9 ")
    private String IdCard;

    @PhoneNumber
//    @Size(min = 10,max = 11)
    private String phoneNumber;

    @Email(message = "email is not format")
    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "id_customer_type")
    private CustomerType customerType;

    @OneToMany
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
