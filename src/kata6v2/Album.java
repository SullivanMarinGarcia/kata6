package kata6v2;

import javax.xml.bind.annotation.*;



@XmlType(propOrder = {"userId", "id", "title"})
@XmlRootElement(name = "userId")

public class Album {
    
    private Integer userId;
    private Integer id;
    private String title;

    public Album(Integer userId, Integer id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }
    
    
    public Album(){
        
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    @XmlElement(name = "userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @XmlElement(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }
    
    @XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    @Override
    public String toString(){
        return "UserId: " + this.userId + " Id: " + this.id + " title: " + this.title + "\n";
    }
    
}
