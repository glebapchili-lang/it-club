import java.util.Scanner;

public class game {
    public static void main(String[] args) {
    int step = 0;
    int personX;
    int personY;
    int personLive = 3;
    int sizeBoard = 5;
    personX = 1 + sizeBoard / 2;
    personY = 1 + sizeBoard / 2;
    step = step + 1;
    step += 1;
    step -= 10;
    step *= 5;
    step /= 2;
    String person = "Г";
    String monster = "ММ";
    String gamingField = "+ —— + —— + —— +\n"
    +"|    |     |   |\n"
    + "+ —— + —— + —— +\n"
    + "|    | " + monster + " |    |\n"
    + "+ —— + —— + —— +\n"
    + "| " + person + "  |    |    |\n"
    + "+ —— + —— + —— +";
        System.out.println(gamingField);
    String begin = "|   | |";
    String end = "|    |";
    String full = begin + monster + end; // |   | Мм |   |
    System.out.println("Привет! Ты готов начать играть в игру? (Напиши: Да или Нет");
    System.out.println("Количество жизней: " + personLive);
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();
    System.out.println("Ваш ответ:\t" + answer);
    if  (answer.equals("ДА")); {


    } else {
}
