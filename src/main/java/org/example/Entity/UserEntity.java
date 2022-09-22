package org.example.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "user_blog",schema ="public")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "f_name")
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "is_deleted")
    private String is_deleted;
    @Column(name = "created_on")
    private Timestamp created_on;
    @Column(name = "updated_on")
    private Timestamp updated_on;
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BlogEntity> blogEntities;

    public UserEntity(String firstName, String lastName, String email,String city) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }
    public UserEntity(Integer userId,String firstName, String lastName, String email, String city,String is_deleted) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.is_deleted = is_deleted;
    }
    public UserEntity(Integer userId, String firstName, String lastName, String email, String city,String password,String is_deleted, Timestamp created_on, Timestamp updated_on, Set<BlogEntity> blogEntities) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.password = password;
        this.is_deleted = is_deleted;
        this.created_on = created_on;
        this.updated_on = updated_on;
        this.blogEntities = blogEntities;
    }

    public UserEntity(String firstName, String lastName, String email,String city, Timestamp created_on, Timestamp updated_on) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.created_on = created_on;
        this.updated_on = updated_on;
    }
    public UserEntity() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on = updated_on;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Set<BlogEntity> getBlogEntities() {
        return blogEntities;
    }

    public void setBlogEntities(Set<BlogEntity> blogEntities) {
        this.blogEntities = blogEntities;
    }
}
