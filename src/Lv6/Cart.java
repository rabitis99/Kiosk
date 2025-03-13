package Lv6;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<MenuItem> cartlist = new ArrayList<>(); // 장바구니 목록
    private int total; // 총 금액

    // 장바구니에 메뉴 아이템 추가
    public void putToCart(MenuItem menuItem) {
        cartlist.add(menuItem);
    }

    // 장바구니 내역을 주문 출력
    public void printCart() {
        System.out.println("장바구니에 담긴 메뉴: ");
        cartlist.forEach(item -> System.out.println(item.getName()));
        System.out.println("총 금액: " + total);
    }

    // 장바구니에 담긴 항목 출력
    public void showCart() {
        if (cartlist.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("현재 장바구니 목록:");
            //하나의 연산으로 실행할 수 없음->가능한지 여부가 궁금
            List<Integer> cartPricetlist = cartlist.stream()
                    .map(MenuItem::getPrice)
                    .mapToInt(price-> (int) (price*1000))
                    .boxed()
                    .toList();
            List<String> cartNamelist=cartlist.stream()
                    .map(MenuItem::getName)
                    .toList();
            for (int i=0; i<cartNamelist.size();i++){
                System.out.println((i+1)+" ."+cartNamelist.get(i)+" "+cartPricetlist.get(i)+" 원");
            }
        }
    }

    // 특정 인덱스의 아이템을 장바구니에서 제거
    public void removeCart(int index) {
        if (index > 0 && index < cartlist.size()) {
            index-=1;
            System.out.println(cartlist.get(index).getName() + "을(를) 삭제했습니다.");
            cartlist.remove(index);
        } else {
            System.out.println("잘못된 값입니다.");
        }
    }
    public void calculateTotalprice(){
        total = (int) cartlist.stream()
                .map(MenuItem::getPrice)
                .mapToDouble(price->(price*1000))// 정수형 변환
                .sum();
    }
    // 장바구니 리스트 반환
    public List<MenuItem> getCartlist() {
        return cartlist;
    }

    // 총 금액 반환
    public int getTotal() {
        return total;
    }
    //장바구니 값 설정
    public void setCartlist(List<MenuItem> cartlist) {
        this.cartlist = cartlist;
    }
    // 전체 값 설정
    public void setTotal(int total) {
        this.total = total;
    }
}
