package Lv6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 입력값이 숫자인지 판별
 */
public class InputValidator {
    public int getValidInt(Scanner scanner) {
        int stack=0;
        while (stack<5) {
            try {
                return scanner.nextInt();//입력값 반환
            } catch (InputMismatchException e) {
                System.out.print("⚠ 숫자만 입력해주세요.");
                scanner.next(); // 잘못된 입력 버리기
                stack++;
            }
        }return -1;
    }
}
