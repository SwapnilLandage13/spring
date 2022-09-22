package com.spring.services.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T10:22:25.930911300+05:30[Asia/Calcutta]")
public class User   {
  @JsonProperty("userId")
  private Integer userId;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("city")
  private String city;

  @JsonProperty("created_on")
  private String createdOn;

  @JsonProperty("updated_on")
  private String updatedOn;

  @JsonProperty("is_deleted")
  private String isDeleted;

  @JsonProperty("password")
  private String password;

  public User userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User id
   * @return userId
  */
  @ApiModelProperty(value = "User id")


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * User firstname
   * @return firstName
  */
  @ApiModelProperty(value = "User firstname")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * User lastname
   * @return lastName
  */
  @ApiModelProperty(value = "User lastname")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User email
   * @return email
  */
  @ApiModelProperty(value = "User email")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User city(String city) {
    this.city = city;
    return this;
  }

  /**
   * User city
   * @return city
  */
  @ApiModelProperty(value = "User city")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public User createdOn(String createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * deletion date and time
   * @return createdOn
  */
  @ApiModelProperty(example = "2021-01-30T08:30:00Z", value = "deletion date and time")


  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public User updatedOn(String updatedOn) {
    this.updatedOn = updatedOn;
    return this;
  }

  /**
   * deletion date and time
   * @return updatedOn
  */
  @ApiModelProperty(example = "2021-01-30T08:30:00Z", value = "deletion date and time")


  public String getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(String updatedOn) {
    this.updatedOn = updatedOn;
  }

  public User isDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

  /**
   * User is_deleted
   * @return isDeleted
  */
  @ApiModelProperty(value = "User is_deleted")


  public String getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * password
   * @return password
  */
  @ApiModelProperty(value = "password")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.city, user.city) &&
        Objects.equals(this.createdOn, user.createdOn) &&
        Objects.equals(this.updatedOn, user.updatedOn) &&
        Objects.equals(this.isDeleted, user.isDeleted) &&
        Objects.equals(this.password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, firstName, lastName, email, city, createdOn, updatedOn, isDeleted, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    updatedOn: ").append(toIndentedString(updatedOn)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

