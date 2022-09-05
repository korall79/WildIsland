package dev.hellojava;

import java.util.Scanner;

public class Main {
    public static  int rows=3;            //строки
    public static int columns=4;          //столбцы
    public static int amountOfEnemies=10;  //количество врагов
    public static int eatNeested=100;       //необходимая еда
    public static int moves=40;            //перемещения
    public static int getAmountOfFlowers = 10;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Добро пожаловать");
            System.out.println("1: Старт");
            System.out.println("2: Опции");
            System.out.println("3: Титры");
            System.out.println("4: Выход");

            command = scanner.nextLine();
            switch (command){
                case "1":
                    startNewGame();
                    break;
                case "2":
                    OptionsMenu.showOptionsMenu();
                    break;
                case "3":
                    showCredits();          //показать титры
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Команда не распознана! Попробуйте еще раз!");

            }
        }
        while (!command.equals("4"));


    }

    private static void openOptionsMenu() {
    }
    private static void startNewGame() {
        Game game = new Game(rows, columns, amountOfEnemies, eatNeested,moves, getAmountOfFlowers);
        game.fiilFieldWithEmptyObject();
        game.startGame();

    }
    private static void showCredits() {         //показать титры
        System.out.println("JavaRash\n"+
                            "contact me at Alis\n");
    }
}
