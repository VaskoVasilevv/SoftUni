package IntroductionToHibernate.Lab.entity;

import ormFramework.annotation.Entity;

import javax.persistence.Column;
import javax.persistence.Id;

@Entity(tableName = "users")

public class User {
    @Id
    private int id;

    @Column(name = "username",columnDefinition = "VARCHAR(50)")
    private String username;
    @Column(name ="password",columnDefinition = "VARCHAR(10)")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
