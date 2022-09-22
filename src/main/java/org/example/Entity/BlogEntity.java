package org.example.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blog_data",schema ="public")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer blogId;

    @Column(name = "blog_title")
    private String blogtitle;

    @Column(name = "blog_body")
    private String blogbody;

    @Column(name = "publish_by")
    private String publishby;

    @Column(name = "deleted_on")
    private String isdeleted;

    @Column(name = "created_on")
    private Timestamp createdon;

    @Column(name = "updated_on")
    private Timestamp updatedon;

    @ManyToOne
    @JoinColumn(name = "user_blog_id", referencedColumnName = "user_id")
    UserEntity userEntity;
    private Timestamp blogDeletedOn;

    public BlogEntity() {
    }

    public BlogEntity(String blogtitle, String blogbody, String isdeleted, Timestamp createdon) {
        this.blogtitle = blogtitle;
        this.blogbody = blogbody;
        this.isdeleted = isdeleted;
        this.createdon = createdon;
    }

    public BlogEntity(Integer blogid, String blogtitle, String blogbody, String publishby, String isdeleted, Timestamp createdon, Timestamp updatedon, UserEntity userEntity) {
        this.blogId = blogid;
        this.blogtitle = blogtitle;
        this.blogbody = blogbody;
        this.publishby = publishby;
        this.isdeleted = isdeleted;
        this.createdon = createdon;
        this.updatedon = updatedon;
        this.userEntity = userEntity;
    }

    public BlogEntity(Integer blogid, String blogtitle, String blogbody, String publishby, String isdeleted, UserEntity userEntity) {
        this.blogId = blogid;
        this.blogtitle = blogtitle;
        this.blogbody = blogbody;
        this.publishby = publishby;
        this.isdeleted = isdeleted;
        this.userEntity = userEntity;
    }
    public BlogEntity(String blogtitle, String blogbody, String publishby, String isdeleted) {
        this.blogtitle = blogtitle;
        this.blogbody = blogbody;
        this.publishby = publishby;
        this.isdeleted = isdeleted;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getBlogbody() {
        return blogbody;
    }

    public void setBlogbody(String blogbody) {
        this.blogbody = blogbody;
    }

    public String getPublishby() {
        return publishby;
    }

    public void setPublishby(String publishby) {
        this.publishby = publishby;
    }

    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Timestamp getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Timestamp createdon) {
        this.createdon = createdon;
    }

    public Timestamp getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Timestamp updatedon) {
        this.updatedon = updatedon;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getBlogDeletedOn() {
        return isdeleted;
    }

    public void setBlogDeletedOn(Timestamp blogDeletedOn) {
        this.blogDeletedOn = blogDeletedOn;
    }
}
