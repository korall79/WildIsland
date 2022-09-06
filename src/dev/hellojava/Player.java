package dev.hellojava;

public class Player implements Fieldbl {
    private static final String MOVE_LEFT = "a";
    private static final String MOVE_RIGHT = "d";
    private static final String MOVE_UP = "w";
    private static final String MOVE_DOWN = "z";
    private static final String NO_MOVE = "s";
    private int rowIndex;
    private int columnIndex;
    private Field field;
    private Game game;

    @Override
    public String getSymbol() {
        return "@";
    }

    public Player(int rowIndex, int columnIndex, Game game) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.game = game;
        this.field = game.getField();
        field.setFieldbl(rowIndex,columnIndex,this);

    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Boolean makeMove(String command) {

        Boolean isIncorrectMove= true;

        switch (command) {
            case MOVE_LEFT:
                isIncorrectMove = movePlayer(0, -1);
                break;
            case MOVE_RIGHT:
                isIncorrectMove =movePlayer(0, 1);
                break;
            case MOVE_UP:
                isIncorrectMove =movePlayer(-1, 0);
                break;
            case MOVE_DOWN:
                isIncorrectMove = movePlayer(1, 0);
                break;
            case NO_MOVE:
                isIncorrectMove =false;
                break;
            default:
                showError(command);
                break;
        }
        return isIncorrectMove;
    }

    private Boolean movePlayer(int deltaRowIndex, int deltaColumnIndex) {
        int newRowIndex = rowIndex + deltaRowIndex;
        int newColumnIndex = columnIndex + deltaColumnIndex;

        if ((newRowIndex >= 0) && (newRowIndex <= field.getSizeX())
                && (newColumnIndex >= 0) && (newColumnIndex < field.getSizeY())
                && !((field.getFieldbl(newRowIndex, newColumnIndex)) instanceof Enemy)) {

            if (field.getFieldbl(newRowIndex, newColumnIndex) instanceof Flower) {
                Flower flower = (Flower) (field.getFieldbl(newRowIndex, newColumnIndex));
                game.setEatGathered(flower.getEat());
                game.getFlowerArrayList().remove(flower);
                swapPlayer(newRowIndex, newColumnIndex);

            }
            if (field.getFieldbl(newRowIndex, newColumnIndex) instanceof Empty) {
                swapPlayer(newRowIndex, newColumnIndex);
            }
            return false;
        }
        else {
            return true;
        }
    }

    private void swapPlayer(int newRowIndex, int newColumnIndex) {
        field.setFieldbl(newRowIndex, newColumnIndex, this);
        field.setFieldbl(rowIndex, columnIndex, new Empty());
        rowIndex = newRowIndex;
        columnIndex = newColumnIndex;
    }

    private void showError(String command) {
        System.out.println("Жаль, нет " + command + " команды, попробуйте еще раз");

    }
}
