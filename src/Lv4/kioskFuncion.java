package Lv4;

public class kioskFuncion {
    private MenuDataBase menuDataBase;

    public kioskFuncion(MenuDataBase menuDataBase){
        this.menuDataBase=menuDataBase;
    }

    public Menu printCategory(int i){
        System.out.println(menuDataBase.getMenuList().get(i).getCategory());
        return menuDataBase.getMenuList().get(i);
    }

    public void printMenuItem(Menu menu){
        for (MenuItem menuItem:menu.getMenuItems()){
            menuItem.printMenuItem();
        }
    }
    public void printSelction(Menu menu,int i){
        String name = menu.getMenuItems().get(i).getName();
        double price =menu.getMenuItems().get(i).getPrice();
        System.out.println(name+price+"을 선택하셨습니다.");
    }

}
