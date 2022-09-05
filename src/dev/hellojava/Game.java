package dev.hellojava;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int sizeX;
    private int sizeY;
    private int amountOfEnemies;
    private int eatNeested;
    private int movesLeft;
    private int eatGathered;
    private Field field;
    private boolean isGameFinished= false;
    private int amountOfFlowers;
    private ArrayList<Flower> flowerArrayList= new ArrayList<Flower>();
    private Random randomNumber =new Random();


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
    public Field getField(){
        return this.field;
    }
    public ArrayList<Flower> getFlowerArrayList(){
        return this.flowerArrayList;
    }

    public void setEatGathered(int eatToAdd){
        this.eatGathered+=eatToAdd;

    }

    public void fiilFieldWithEmptyObject() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                field.setFieldbl(i, j, new Empty());
            }
        }
    }
    public void startGame(){
        possesPlayer();
        possesEnemies();
        possesFlowers();

        while (!isGameFinished){
            showField();                           //показать поле
            playerTurn();                          //ход игрока
            computerTurn();
            chekIfGameNotfinished();            //проверить, не закончилась ли игра


        }
    }

    private void possesPlayer() {
    }
    private void possesEnemies() {
    }
    private void possesFlowers() {
        gtnerateFlowers();
    }

    private void showField() {
    }
    private void playerTurn() {
    }
    private void computerTurn() {
    }
    private void gtnerateFlowers(){
        for (int i = amountOfFlowers-flowerArrayList.size(); i > 0; ) {

            int flowerAmountOfEat = randomNumber.nextInt(9)+1;
            int flowerRowPosition = randomNumber.nextInt(sizeX);
            int flowerColumnPosition = randomNumber.nextInt(sizeY);

            if (field.getFieldbl(flowerRowPosition,flowerColumnPosition)instanceof Player){

                eatGathered = eatGathered+flowerAmountOfEat;
                i--;

            }else  if (field.getFieldbl(flowerRowPosition,flowerColumnPosition) instanceof Empty){

                Flower flower = new Flower(flowerAmountOfEat, flowerRowPosition, flowerColumnPosition);
                field.setFieldbl(flowerRowPosition, flowerColumnPosition, flower);
                flowerArrayList.add(flower);
                i--;
            }
        }
    }
    private void chekIfGameNotfinished() {
    }
}