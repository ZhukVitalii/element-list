package beetle.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="list_element")
@NoArgsConstructor
@Getter
@Setter
public class Element implements Comparable<Element>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    @Column(name = "order_no")
    private int orderNo;


    public Element(String text, int orderNo) {
        this.text = text;
        this.orderNo = orderNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public int compareTo(Element element) {
        return this.orderNo - element.orderNo;
    }

}
