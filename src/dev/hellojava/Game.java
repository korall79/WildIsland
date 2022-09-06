package dev.hellojava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int sizeX;
    private int sizeY;
    private int amountOfEnemies;
    private int eatNeested;
    private int movesLeft;
    private int eatGathered;
    private Field field;
    private boolean isGameFinished = false;
    private int amountOfFlowers;
    private ArrayList<Flower> flowerArrayList = new ArrayList<Flower>();
    private ArrayList<Enemy> enemyArrayList = new ArrayList<Enemy>();
    private Random randomNumber = new Random();
    private Player player;
    private Scanner scanner = new Scanner(System.in);
    private boolean isIncorrectCommand = true;



    public Game(int sizeX, int sizeY,
                int amountOfEnemies, int eatNeested, int movesLeft, int amountOfFlowers) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.amountOfEnemies = amountOfEnemies;
        this.amountOfFlowers = amountOfFlowers;
        this.eatNeested = eatNeested;
        this.movesLeft = movesLeft;
        field = new Field(sizeX, sizeX);

    }

    public Field getField() {
        return this.field;
    }

    public ArrayList<Flower> getFlowerArrayList() {
        return this.flowerArrayList;
    }

    public void setEatGathered(int eatToAdd) {
        this.eatGathered += eatToAdd;

    }

    public void fiilFieldWithEmptyObject() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                field.setFieldbl(i, j, new Empty());
            }
        }
    }

    public void startGame() {
        possesPlayer();
        possesEnemies();
        possesFlowers();

        while (!isGameFinished) {
            showField();                           //показать поле
            playerTurn();                          //ход игрока
            if (isIncorrectCommand) {
                inCorrectCommand();
                continue;
            }
            computerTurn();
            chekIfGameNotfinished();            //проверить, не закончилась ли игра


        }
    }

    private void inCorrectCommand() {
        System.out.println("Вы ввели неверную команду, проверьте и повторите попытку");
    }

    private void possesPlayer() {
        int playerRowPosition = randomNumber.nextInt(sizeX);
        int playerColumnPosition = randomNumber.nextInt(sizeY);
        player = new Player(playerRowPosition, playerColumnPosition, this);
    }

    private void possesEnemies() {
        generateEnemies();
        
    }

    private void generateEnemies() {
        for (int i = amountOfEnemies - enemyArrayList.size(); i > 0; ) {


            int enemyRowPosition = randomNumber.nextInt(sizeX);
            int enemyColumnPosition = randomNumber.nextInt(sizeY);


            if (field.getFieldbl(enemyRowPosition, enemyColumnPosition) instanceof Empty) {

                Enemy enemy = new Enemy(enemyRowPosition, enemyColumnPosition);
                field.setFieldbl(enemyRowPosition, enemyColumnPosition, enemy);
                enemyArrayList.add(enemy);
                i--;
            }
        }
    }

    private void possesFlowers() {
        generateFlowers();
    }

    private void showField() {
    }

    private void playerTurn() {

        System.out.println("Введите команду и нажмите Enter:");
        String command = scanner.nextLine();
        isIncorrectCommand = player.makeMove(command);

    }

    private void computerTurn() {
        enemyMove();
        generateFlowers();
        movesLeft--;

    }

    private void generateFlowers() {
        for (int i = amountOfFlowers - flowerArrayList.size(); i > 0; ) {

            int flowerAmountOfEat = randomNumber.nextInt(9) + 1;
            int flowerRowPosition = randomNumber.nextInt(sizeX);
            int flowerColumnPosition = randomNumber.nextInt(sizeY);

            if (field.getFieldbl(flowerRowPosition, flowerColumnPosition) instanceof Player) {

                eatGathered = eatGathered + flowerAmountOfEat;
                i--;

            } else if (field.getFieldbl(flowerRowPosition, flowerColumnPosition) instanceof Empty) {

                Flower flower = new Flower(flowerAmountOfEat, flowerRowPosition, flowerColumnPosition);
                field.setFieldbl(flowerRowPosition, flowerColumnPosition, flower);
                flowerArrayList.add(flower);
                i--;
            }
        }
    }

    private void enemyMove() {
        int rowIndex = 0;
        int columnIndex = 0;
        int newRowIndex = 0;
        int newColumnIndex = 0;
        int regenerateIndex = 0;
        boolean isNeededToRegenerate = true;

        for (Enemy enemy : enemyArrayList) {
            rowIndex = enemy.getRowIndex();
            columnIndex = enemy.getColumnIndex();

            do {
                int deltaRow = randomNumber.nextInt(3) - 1;
                int deltaColumn = randomNumber.nextInt(3) - 1;
                newRowIndex = rowIndex + deltaRow;
                newColumnIndex = columnIndex + deltaColumn;

                if ((newRowIndex < 0) || (newColumnIndex < 0) || (newRowIndex >= field.getSizeX())
                        || (newColumnIndex >= field.getSizeY()) ||
                        field.getFieldbl(newRowIndex, newColumnIndex) instanceof Player ||
                        field.getFieldbl(newRowIndex, newColumnIndex) instanceof Enemy) {
                    regenerateIndex++;
                    isNeededToRegenerate = true;
                } else {
                    if (field.getFieldbl(newRowIndex, newColumnIndex) instanceof Flower) {
                        Flower flower = (Flower) field.getFieldbl(newRowIndex, newColumnIndex);
                        flowerArrayList.remove(flower);

                        field.setFieldbl(newRowIndex, newColumnIndex, enemy);
                        field.setFieldbl(rowIndex, columnIndex, new Empty());
                        enemy.setRowIndex(newRowIndex);
                        enemy.setColumnIndex(newColumnIndex);
                        isNeededToRegenerate = swapEnemy(rowIndex, columnIndex, newRowIndex, newColumnIndex, enemy);
                    } else {
                        field.setFieldbl(newRowIndex, newColumnIndex, enemy);
                        field.setFieldbl(rowIndex, columnIndex, new Empty());
                        enemy.setRowIndex(newRowIndex);
                        enemy.setColumnIndex(newColumnIndex);
                        isNeededToRegenerate = swapEnemy(rowIndex, columnIndex, newRowIndex, newColumnIndex, enemy);

                    }
                }

            } while (isNeededToRegenerate && regenerateIndex <= 10);

        }

    }

    private boolean swapEnemy(int rowIndex, int columnIndex, int newRowIndex, int newColumnIndex, Enemy enemy) {
        field.setFieldbl(newRowIndex, newColumnIndex, enemy);
        field.setFieldbl(rowIndex, columnIndex, new Empty());
        enemy.setRowIndex(newRowIndex);
        enemy.setColumnIndex(newColumnIndex);

        return false;
    }

    private void chekIfGameNotfinished() {
        if (movesLeft == 0) {

        }
    }
}