package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

/**
 * @author lhang
 * @create 2020-06-27 18:49
 */
@Entity
public class User {
    private int userID;
    private String userName;
    private Date date;
    //该属性值为： userID: userName
    private String desc;
    //大文本
    private String content;
    //图片
    private Blob headImage;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }


    public User(String userName, Date date) {
        this.userName = userName;
        this.date = date;
    }

    public User(String userName, Date date, String content, Blob headImage) {
        this.userName = userName;
        this.date = date;
        this.content = content;
        this.headImage = headImage;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "headImage")
    public Blob getHeadImage() {
        return headImage;
    }

    public void setHeadImage(Blob headImage) {
        this.headImage = headImage;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @Column(name = "userID")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userID != user.userID) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
