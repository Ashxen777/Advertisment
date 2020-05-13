package model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Item implements Comparable<Item>, Serializable {
    private long id;
    private String title;
    private String text;
    private double price;
    private User user;
    private Category category;
    private Date createdDate;


   
    @Override
    public int compareTo(Item o) {
        return title.compareTo(o.getTitle());
    }
}
