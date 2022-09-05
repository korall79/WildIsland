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
        return " U+1F407 ";
    }

    public Player(int rowIndex, int columnIndex, Game game) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.game = game;
        this.field = game.getField();

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

    public void makeMove(String command) {
        switch (command) {
            case MOVE_LEFT:
                movePlayer(0, -1);
                break;
            case MOVE_RIGHT:
                movePlayer(0, 1);
                break;
            case MOVE_UP:
                movePlayer(-1, 0);
                break;
            case MOVE_DOWN:
                movePlayer(1, 0);
                break;
            case NO_MOVE:
                break;
            default:
                showError(command);
                break;
        }
    }

    private void movePlayer(int deltaRowIndex, int deltaColumnIndex) {
        int newRowIndex = rowIndex + deltaRowIndex;
        int newColumnIndex = columnIndex + deltaColumnIndex;

        if ((newRowIndex > 0) && (newRowIndex <= field.getSizeX())
                && (newColumnIndex > 0) && (newColumnIndex < field.getSizeX())
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
