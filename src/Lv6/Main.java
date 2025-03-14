package Lv6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성 (사용자 입력을 받기 위함)
        Scanner scanner = new Scanner(System.in);

        // 메뉴 데이터베이스 생성 (메뉴 정보를 관리)
        MenuDataBase menuDataBase = new MenuDataBase();

        // 키오스크 기능 클래스 생성 (메뉴 데이터베이스를 활용)
        KioskFunction kioskFunction = new KioskFunction(menuDataBase);
        // 키오스크 객체 생성 (사용자 입력 및 키오스크 기능 연결)
        Kiosk kiosk = new Kiosk(scanner, kioskFunction);

        // 키오스크 실행
        kiosk.start();
    }
}
