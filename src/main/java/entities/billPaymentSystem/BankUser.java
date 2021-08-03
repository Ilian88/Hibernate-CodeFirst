package entities.billPaymentSystem;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "bank_users")
public class BankUser extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public BankUser() {
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
