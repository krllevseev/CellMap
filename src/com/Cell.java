package com;

/**
 * Created by kirillevseev on 6/2/18.
 */
class Cell {

    Object value;

    public Cell(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return value != null ? value.equals(cell.value) : cell.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}