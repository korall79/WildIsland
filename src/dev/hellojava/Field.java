package dev.hellojava;

public class Field implements Fieldbl{
    private int sizeX;
    private int sizeY;

    private Fieldbl [][]field;

    public Field(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        field = new Fieldbl[sizeX][sizeY];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setFieldbl(int x, int y, Fieldbl object) {
        field [x][y] = object;
    }

    public Fieldbl getFieldbl(int x, int  y) {
        return field [x][y];
    }
    public void showField(){        // выводит поле
        System.out.println();
        for (int i = 0; i < sizeX; i++) {
            System.out.println();
            for (int j = 0; j < sizeY; j++) {
                System.out.println(field[i][j].getSymbol());

            }

        }
        System.out.println();
    }

    @Override
    public String getSymbol() {
        return null;
    }
}
