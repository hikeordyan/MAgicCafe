package model;

public class Stuff {
    private String stuff_id;
    private String stuff_name;
    private String responsibility;
    private int is_free;
    private String last_order;
    private int orders_count;

    public Stuff() {
    }

    public Stuff(String stuff_id, String stuff_name, String responsibility, int is_free, String last_order, int orders_count) {
        this.stuff_id = stuff_id;
        this.stuff_name = stuff_name;
        this.responsibility = responsibility;
        this.is_free = is_free;
        this.last_order = last_order;
        this.orders_count = orders_count;
    }

    public String getStuff_id() {
        return stuff_id;
    }

    public void setStuff_id(String stuff_id) {
        this.stuff_id = stuff_id;
    }

    public String getStuff_name() {
        return stuff_name;
    }

    public void setStuff_name(String stuff_name) {
        this.stuff_name = stuff_name;
    }

    public int is_free() {
        return is_free;
    }

    public void setIs_free(int is_free) {
        this.is_free = is_free;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getLast_order() {
        return last_order;
    }

    public void setLast_order(String last_order) {
        this.last_order = last_order;
    }

    public int getOrders_count() {
        return orders_count;
    }

    public void setOrders_count(int orders_count) {
        this.orders_count = orders_count;
    }
    @Override
    public  String toString(){
        return stuff_id+"---"+stuff_name+"---"+responsibility+"---"+is_free;
    }
}
