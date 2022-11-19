package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounds")
public class BankAccount extends BillingDetail{

    private String name;
    private String swiftCode;

    public BankAccount() {
    }
    @Column(nullable = false,length = 50)
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "swift_code",length = 60,unique = true)
    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
