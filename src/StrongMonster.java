import java.util.Random;
import java.util.Scanner;

public class StrongMonster extends Monster {

    Random r = new Random();

    StrongMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("💪"); // символ сильного монстра
    }

    // метод при столкновении
    public void attack(Person person) {
        int a = r.nextInt(50) + 1;
        int b = r.nextInt(50) + 1;
        int answer = a + b;

        System.out.println("Монстр который снимает 2 жизни! Реши пример:");
        System.out.println(a + " + " + b + " = ?");

        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();

        if (user == answer) {
            System.out.println("Верно! Ты победил сильного монстра!");
        } else {
            System.out.println("Неправильно! Ты теряешь 2 жизни!");
            person.downLive();
            person.downLive();
        }
    }
}