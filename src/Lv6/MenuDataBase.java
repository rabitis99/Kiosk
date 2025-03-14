package Lv6;

import java.util.ArrayList;
import java.util.List;

public class MenuDataBase {
    private List<Menu>menuList=new ArrayList<>();

    private List<MenuItem> hamburgerMenu =new ArrayList<>();
    private List<MenuItem> dessertMenus = new ArrayList<>();
    private List<MenuItem> drinkMenus = new ArrayList<>();

    private Menu burgers=new Menu("[  burger menu  ]",  hamburgerMenu);
    private Menu drinks=new Menu("[  drink menu  ]",  drinkMenus);
    private Menu desserts=new Menu("[  dessert menu  ]", dessertMenus);

    public MenuDataBase() {

        hamburgerMenu.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));;
        hamburgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Hamburger  ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinkMenus.add(new MenuItem("Coke", 2.0, "시원한 코카콜라"));
        drinkMenus.add(new MenuItem("Lemonade", 3.0, "상큼한 레모네이드"));
        drinkMenus.add(new MenuItem("Iced Coffee", 3.5, "시원한 아이스 커피"));
        drinkMenus.add(new MenuItem("Milkshake", 4.5, "부드럽고 달콤한 밀크쉐이크"));

        dessertMenus.add(new MenuItem("Vanilla Ice Cream", 3.5, "부드러운 바닐라 아이스크림"));
        dessertMenus.add(new MenuItem("Chocolate Brownie", 4.2, "진한 초콜릿 브라우니"));
        dessertMenus.add(new MenuItem("Cheesecake", 5.0, "크리미한 치즈케이크"));
        dessertMenus.add(new MenuItem("Apple Pie", 4.8, "달콤한 사과 파이"));

        menuList.add(burgers);
        menuList.add(drinks);
        menuList.add(desserts);
    }

    public List<MenuItem> getHamburgerMenu() {
        return hamburgerMenu;
    }

    public List<MenuItem> getDessertMenus() {
        return dessertMenus;
    }

    public List<MenuItem> getDrinkMenus() {
        return drinkMenus;
    }

    public Menu getBurgers() {
        return burgers;
    }

    public Menu getDrinks() {
        return drinks;
    }

    public Menu getDesserts() {
        return desserts;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
