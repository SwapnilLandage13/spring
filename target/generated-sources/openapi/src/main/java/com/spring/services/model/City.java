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
 * City
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T10:22:25.930911300+05:30[Asia/Calcutta]")
public class City   {
  @JsonProperty("cityId")
  private Integer cityId;

  @JsonProperty("cityName")
  private String cityName;

  public City cityId(Integer cityId) {
    this.cityId = cityId;
    return this;
  }

  /**
   * city Id
   * @return cityId
  */
  @ApiModelProperty(value = "city Id")


  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public City cityName(String cityName) {
    this.cityName = cityName;
    return this;
  }

  /**
   * city name
   * @return cityName
  */
  @ApiModelProperty(value = "city name")


  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City) o;
    return Objects.equals(this.cityId, city.cityId) &&
        Objects.equals(this.cityName, city.cityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cityId, cityName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class City {\n");
    
    sb.append("    cityId: ").append(toIndentedString(cityId)).append("\n");
    sb.append("    cityName: ").append(toIndentedString(cityName)).append("\n");
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

