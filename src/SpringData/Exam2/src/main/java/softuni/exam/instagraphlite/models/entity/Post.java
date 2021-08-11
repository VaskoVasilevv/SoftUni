package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    private String caption;
    private User user;
    private Picture picture;

    public Post() {

    }

    public String getCaption() {
        return caption;
    }
    @Column(nullable = false)
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(optional = false)
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
