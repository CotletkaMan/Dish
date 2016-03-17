package shared.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Map;

/**
 * Created by cotletkaman on 16.02.16.
 */
@XmlRootElement
public class ShortDish {
    private Long id;
    private String name;
    private byte[] image;
    private Date timeCooking;
    private Integer count;

    public ShortDish(){
    }

    public ShortDish(AppDish dish){
        this.id = dish.getId();
        this.name = dish.getDish().getName();
        this.image = dish.getDish().getImage();
        this.timeCooking = dish.getDish().getTime();
        this.count = dish.getDish().getCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getTimeCooking() {
        return timeCooking;
    }

    public void setTimeCooking(Date timeCooking) {
        this.timeCooking = timeCooking;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
