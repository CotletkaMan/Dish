package shared.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cotletkaman on 02.02.16.
 */
@Entity
public class Statistics {
    private Long id;
    private Date createDate;
    private Long countView;
    private Long countLike;

    public Statistics(){}

    @Id
    @GeneratedValue
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Date getCreateDate(){
        return createDate;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    @Column(nullable = false)
    public Long getCountView(){
        return countView;
    }

    public void setCountView(Long countView){
        this.countView = countView;
    }

    @Column(nullable = false)
    public Long getCountLike(){
        return countLike;
    }

    public void setCountLike(Long countLike){
        this.countLike = countLike;
    }
}
