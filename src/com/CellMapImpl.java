package com;

/**
 * Created by kirillevseev on 6/2/18.
 */
public class CellMapImpl implements CellMap {

    private static int DEFAULT_INITIAL_SIZE = 10;
    private static int SIZE_MULTIPLIER = 2;

    private Cell[][] cellMap;
    private int size = 0;


    public CellMapImpl() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public CellMapImpl(int initialCapacity) {
        super();
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Capacity cannot be < 1");
        }
        this.cellMap = new Cell[initialCapacity][2];
    }

    @Override
    public void put(Cell key, Cell value) {
        if (key == null) {
            eraseMap();
            return;
        }

        if (size == cellMap.length) {
            increaseSize();
        }

        int position = checkIfKeyExists(key);
        if (position < 0) {
            position = size;
            size++;
        }

        cellMap[position][0] = key;
        cellMap[position][1] = value;

    }

    @Override
    public Cell get(Cell key) {
        for (int i = 0; i < cellMap.length; i++) {
            if (cellMap[i][0] != null && cellMap[i][0].equals(key)) {
                return cellMap[i][1];
            }
        }
        return null;
    }

    private void increaseSize() {
        Cell[][] newCellMap = new Cell[cellMap.length * SIZE_MULTIPLIER][2];
        newCellMap = copyArray(cellMap, newCellMap);
        cellMap = newCellMap;
    }

    private Cell[][] copyArray(Cell[][] oldArray, Cell[][] newArray) {
        for (int i = 0; i < oldArray.length; i++) {
            for (int j = 0; j < oldArray[i].length; j++) {
                newArray[i][j] = oldArray[i][j];
            }

        }
        return newArray;
    }

    private void eraseMap() {
        this.cellMap = new Cell[DEFAULT_INITIAL_SIZE][2];
        size = 0;
    }

    private int checkIfKeyExists(Cell key) {
        int position = -1;
        for (int i = 0; i < cellMap.length; i++) {
            if (cellMap[i][0] != null && cellMap[i][0].equals(key)) {
                position = i;
                break;
            }
        }
        return position;
    }


}
