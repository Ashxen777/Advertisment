package model;

import java.io.Serializable;
import java.util.Date;


public class Item implements Comparable<Item>, Serializable {
    private long id;
    private String title;
    private String text;
    private double price;
    private User user;
    private Category category;
    private Date createdDate;


    public Item(long id, String title, String text, double price, User user, Category category, Date createdDate) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.price = price;
        this.user = user;
        this.category = category;
        this.createdDate=createdDate;

    }

    public Item() {
    }

    public Item(String itemDatum, String datum, double v, User currentUser, Category category, Date date) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice(double price) {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (text != null ? !text.equals(item.text) : item.text != null) return false;
        if (user != null ? !user.equals(item.user) : item.user != null) return false;
        if (category != item.category) return false;
        return createdDate != null ? createdDate.equals(item.createdDate) : item.createdDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", user=" + user +
                ", category=" + category +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return title.compareTo(o.getTitle());
    }
}
