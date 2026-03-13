import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        String castle = "\uD83C\uDFF0";
        int sizeBoard = 5;

        Person person = new Person(sizeBoard);

        int step = 0;

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 5;
        Random r = new Random();

        Monster[] arrMonster = new Monster[countMonster + 1];
        int count = 0;
        Monster test;

        while (count <= countMonster) {

            int type = r.nextInt(3); // 0..2
            if (type == 0) {
                test = new Monster(sizeBoard);
            } else if (type == 1) {
                test = new BigMonster(sizeBoard);
            } else {
                test = new StrongMonster(sizeBoard);
            }

            if (board[test.getY()][test.getX()].equals("  ")) {
                board[test.getY()][test.getX()] = test.getImage();
                arrMonster[count] = test;
                count++;
            }
        }

        int castleX = r.nextInt(sizeBoard);
        int castleY = 0;
        board[castleY][castleX] = castle;

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: Да/Нет)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {

            case "Да":
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = sc.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);

                while (true) {

                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
                    outputBoard(board, person.getLive());

                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + ")");

                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    if (person.moveCorrect(x, y)) {

                        String next = board[y - 1][x - 1];

                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;

                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                    "\nХод номер: " + step);

                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;

                        } else {
                            for (Monster monster : arrMonster) {

                                if (monster.conflictPerson(x, y)) {

                                    if (monster instanceof StrongMonster) {
                                        ((StrongMonster) monster).attack(person);


                                    } else if (monster instanceof BigMonster) {
                                        if (!monster.taskMonster(difficultGame)) {
                                            person.downLive();
                                        }


                                    } else {
                                        if (!monster.taskMonster(difficultGame)) {
                                            person.downLive();
                                        }
                                    }

                                    board[person.getY() - 1][person.getX() - 1] = "  ";
                                    person.move(x, y);

                                    break;
                                }
                            }
                        }

                        if (person.getLive() <= 0) {
                            System.out.println("Ты проиграл! У тебя закончились жизни.");
                            return;
                        }

                    } else {
                        System.out.println("Неккоректный ход");
                    }
                }

                break;

            case "Нет":
                System.out.println("Жаль, приходи еще!");
                break;

            default:
                System.out.println("Данные введены неккоректно");
                break;
        }
    }

    static void outputBoard(String[][] board, int live) {

        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }

        System.out.println(wall);
        System.out.println("Количество жизней:\t" + live + "\n");
    }
}