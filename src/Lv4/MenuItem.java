package Lv4;

import java.util.List;

public class MenuItem {
    private String name;
    private double price;
    private String commet;

    public MenuItem(String name,double price,String commet){
        this.name=name;
        this.price=price;
        this.commet=commet;
    }
    public void printMenuItem(){
        System.out.println(name+"| W"+price+" |"+commet);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}
