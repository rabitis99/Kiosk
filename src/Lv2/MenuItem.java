package Lv2;

public class MenuItem {
    String name;
    double price;
    String commet;
    public MenuItem(String name,double price,String commet){
        this.name=name;
        this.price=price;
        this.commet=commet;
    }
    public void printMenuItem(){
        System.out.println(name+"| W"+price+" |"+commet);
    }
}
