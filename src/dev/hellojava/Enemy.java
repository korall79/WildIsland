package dev.hellojava;

public class Enemy implements Fieldbl{

    private int rowIndex;
    private int columnIndex;


    @Override
    public String getSymbol() {
        return "\uD83D\uDC3A ";
    }

    public Enemy(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
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
}
