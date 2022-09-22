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
 * Blog
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T10:22:25.930911300+05:30[Asia/Calcutta]")
public class Blog   {
  @JsonProperty("blogId")
  private Integer blogId;

  @JsonProperty("blogtitle")
  private String blogtitle;

  @JsonProperty("blogbody")
  private String blogbody;

  @JsonProperty("publishby")
  private String publishby;

  @JsonProperty("isdeleted")
  private String isdeleted;

  @JsonProperty("createdon")
  private String createdon;

  @JsonProperty("updatedon")
  private String updatedon;

  @JsonProperty("userBlogId")
  private Integer userBlogId;

  public Blog blogId(Integer blogId) {
    this.blogId = blogId;
    return this;
  }

  /**
   * Blog blog_id
   * @return blogId
  */
  @ApiModelProperty(value = "Blog blog_id")


  public Integer getBlogId() {
    return blogId;
  }

  public void setBlogId(Integer blogId) {
    this.blogId = blogId;
  }

  public Blog blogtitle(String blogtitle) {
    this.blogtitle = blogtitle;
    return this;
  }

  /**
   * Blog blog_title
   * @return blogtitle
  */
  @ApiModelProperty(value = "Blog blog_title")


  public String getBlogtitle() {
    return blogtitle;
  }

  public void setBlogtitle(String blogtitle) {
    this.blogtitle = blogtitle;
  }

  public Blog blogbody(String blogbody) {
    this.blogbody = blogbody;
    return this;
  }

  /**
   * Blog blog_body
   * @return blogbody
  */
  @ApiModelProperty(value = "Blog blog_body")


  public String getBlogbody() {
    return blogbody;
  }

  public void setBlogbody(String blogbody) {
    this.blogbody = blogbody;
  }

  public Blog publishby(String publishby) {
    this.publishby = publishby;
    return this;
  }

  /**
   * Blog publish_by
   * @return publishby
  */
  @ApiModelProperty(value = "Blog publish_by")


  public String getPublishby() {
    return publishby;
  }

  public void setPublishby(String publishby) {
    this.publishby = publishby;
  }

  public Blog isdeleted(String isdeleted) {
    this.isdeleted = isdeleted;
    return this;
  }

  /**
   * Blog is_deleted
   * @return isdeleted
  */
  @ApiModelProperty(value = "Blog is_deleted")


  public String getIsdeleted() {
    return isdeleted;
  }

  public void setIsdeleted(String isdeleted) {
    this.isdeleted = isdeleted;
  }

  public Blog createdon(String createdon) {
    this.createdon = createdon;
    return this;
  }

  /**
   * deletion date and time
   * @return createdon
  */
  @ApiModelProperty(example = "2021-01-30T08:30:00Z", value = "deletion date and time")


  public String getCreatedon() {
    return createdon;
  }

  public void setCreatedon(String createdon) {
    this.createdon = createdon;
  }

  public Blog updatedon(String updatedon) {
    this.updatedon = updatedon;
    return this;
  }

  /**
   * deletion date and time
   * @return updatedon
  */
  @ApiModelProperty(example = "2021-01-30T08:30:00Z", value = "deletion date and time")


  public String getUpdatedon() {
    return updatedon;
  }

  public void setUpdatedon(String updatedon) {
    this.updatedon = updatedon;
  }

  public Blog userBlogId(Integer userBlogId) {
    this.userBlogId = userBlogId;
    return this;
  }

  /**
   * userBlog Id
   * @return userBlogId
  */
  @ApiModelProperty(value = "userBlog Id")


  public Integer getUserBlogId() {
    return userBlogId;
  }

  public void setUserBlogId(Integer userBlogId) {
    this.userBlogId = userBlogId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Blog blog = (Blog) o;
    return Objects.equals(this.blogId, blog.blogId) &&
        Objects.equals(this.blogtitle, blog.blogtitle) &&
        Objects.equals(this.blogbody, blog.blogbody) &&
        Objects.equals(this.publishby, blog.publishby) &&
        Objects.equals(this.isdeleted, blog.isdeleted) &&
        Objects.equals(this.createdon, blog.createdon) &&
        Objects.equals(this.updatedon, blog.updatedon) &&
        Objects.equals(this.userBlogId, blog.userBlogId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blogId, blogtitle, blogbody, publishby, isdeleted, createdon, updatedon, userBlogId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Blog {\n");
    
    sb.append("    blogId: ").append(toIndentedString(blogId)).append("\n");
    sb.append("    blogtitle: ").append(toIndentedString(blogtitle)).append("\n");
    sb.append("    blogbody: ").append(toIndentedString(blogbody)).append("\n");
    sb.append("    publishby: ").append(toIndentedString(publishby)).append("\n");
    sb.append("    isdeleted: ").append(toIndentedString(isdeleted)).append("\n");
    sb.append("    createdon: ").append(toIndentedString(createdon)).append("\n");
    sb.append("    updatedon: ").append(toIndentedString(updatedon)).append("\n");
    sb.append("    userBlogId: ").append(toIndentedString(userBlogId)).append("\n");
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

