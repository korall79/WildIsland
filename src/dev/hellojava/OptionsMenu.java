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
                    String value;
                    System.out.println("Введите новое значение для rows, оставьте пустым, чтобы сохранить текущее значение ["+ Main.rows+ "] :");
                    scanner.hasNextLine();

                    value = scanner.nextLine();
                    if (!value.isBlank()){
                        Main.rows= Integer.parseInt(value);
                    }
                    System.out.println("Введите новое значение для columns, оставьте пустым, чтобы сохранить текущее значение ["+ Main.columns+ "] :");
                    value = scanner.nextLine();
                    if (!value.isBlank()){
                        Main.columns= Integer.parseInt(value);
                    }
                    System.out.println("Введите новое значение для enemies, оставьте пустым, чтобы сохранить текущее значение ["+ Main.amountOfEnemies+ "] :");
                    value = scanner.nextLine();
                    if (!value.isBlank()){
                        Main.amountOfEnemies= Integer.parseInt(value);
                    }
                    System.out.println("Введите новое значение для eat, оставьте пустым, чтобы сохранить текущее значение ["+ Main.eatNeested+ "] :");
                    value = scanner.nextLine();
                    if (!value.isBlank()){
                        Main.eatNeested= Integer.parseInt(value);
                    }
                    System.out.println("Введите новое значение для moves, оставьте пустым, чтобы сохранить текущее значение ["+ Main.moves+ "] :");
                    value = scanner.nextLine();
                    if (!value.isBlank()){
                        Main.moves= Integer.parseInt(value);
                    }
                    System.out.println("Введите новое значение для flowers, оставьте пустым, чтобы сохранить текущее значение ["+ Main.getAmountOfFlowers+ "] :");
                    value = scanner.nextLine();
                    if (!value.isBlank()){
                        Main.getAmountOfFlowers= Integer.parseInt(value);
                    }

                    if(!isValuesNotPlayable()){
                        System.out.println("Введенные вами значения не воспроизводятся, проверьте и повторите попытку");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Kоманда не распознана, пожалуйста, попробуйте еще раз");
                    break;
            }

        }while(command !=3);

    }
    private static Boolean isValuesNotPlayable(){
        int fildSize = Main.rows * Main.columns;
        int allGameObjects = Main.amountOfEnemies + Main.getAmountOfFlowers +1;
        boolean isValuesNotPlayable = ((allGameObjects/ fildSize) > 0.75);
        return isValuesNotPlayable;
    }
}
