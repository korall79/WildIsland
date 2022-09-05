package dev.hellojava;

import java.util.Scanner;

public class OptionsMenu {
    static Scanner scanner = new Scanner(System.in);
    static int command;

    public static void showOptionsMenu(){
        do {
            System.out.println("Cделайте свой выбор и нажмите enter\n"+
                    "1: показать текущую настройку\n"+
                    "2: изменить настройку\n"+
                    "3: выход");
            command= scanner.nextInt();

            switch (command){
                case 1:
                    System.out.println("\n Текущие настройки\n"+
                            "rows: "+Main.rows+
                            "\ncolumns: "+Main.columns+
                            "\nenemies: "+Main.amountOfEnemies+
                            "\neat: "+Main.eatNeested+
                            "\nmoves: "+Main.moves+
                            "\nflowers: "+Main.getAmountOfFlowers);
                    break;
                case 2:
                    System.out.println("Введите новое значение для строк");
                    Main.rows= scanner.nextInt();
                    System.out.println("Введите новое значение для столбцов");
                    Main.columns= scanner.nextInt();
                    System.out.println("Введите новое значение для enemies");
                    Main.amountOfEnemies= scanner.nextInt();
                    System.out.println("Введите новое значение для eat");
                    Main.eatNeested= scanner.nextInt();
                    System.out.println("Введите новое значение для moves");
                    Main.moves= scanner.nextInt();
                    System.out.println("Введите новое значение для flowers");
                    Main.getAmountOfFlowers= scanner.nextInt();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Kоманда не распознана, пожалуйста, попробуйте еще раз");
                    break;
            }

        }while(command !=3);

    }
}
