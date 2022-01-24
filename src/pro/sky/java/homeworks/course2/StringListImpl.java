package pro.sky.java.homeworks.course2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListImpl implements StringList {

    private final String[] stringList;

    public StringListImpl(int size) {
        stringList = new String[size];
    }

    @Override
    public String add(String item) {
        for (int a = 0; a < stringList.length; a++) {
            if (stringList[a] == null) {
                stringList[a] = item;
                System.out.println(item + " добавлена в ячейку " + a);
                return item;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Массив заполнен");
    }

    @Override
    public String add(int index, String item) {
        if (index >= stringList.length || index <= 0 || stringList[index] != null) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет или она занята");
        }
        stringList[index] = item;
        System.out.println(item + " добавлена в ячейку " + index);
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= stringList.length || index <= 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        stringList[index] = item;
        System.out.println(item + " изменила содержание в ячейке " + index);
        return item;
    }

    @Override
    public String remove(String item) {
        for (int b = 0; b < stringList.length; b++) {
            if (stringList[b] == item) {
                stringList[b] = null;
                System.out.println(item + " удалена");
                item = null;
                return item;
            }
        }
        throw new ArrayIndexOutOfBoundsException(item + " не найдена");
    }

    @Override
    public String remove(int index) {
        if (index >= stringList.length || index <= 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        String removedStringByIndex = stringList[index];
        stringList[index] = null;
        System.out.println("Из ячейки " + index + " удалена " + removedStringByIndex);
        return removedStringByIndex;
    }

    @Override
    public boolean contains(String item) {
        for (int с = 0; с < stringList.length; с++) {
            if (stringList[с] == item) {
                System.out.println(item + " найдена");
                return true;
            }
        }
        throw new ArrayIndexOutOfBoundsException(item + " не найдена");
    }

    @Override
    public int indexOf(String item) {
        for (int c = 0; c < stringList.length; c++) {
            if (stringList[c] == item) {
                System.out.println("Строка " + item + " найдена под индексом " + c);
                return c;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int c = stringList.length - 1; c >= 0; c--) {
            if (stringList[c] == item) {
                System.out.println(item + " найдена с конца в ячейке " + c);
                return c;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= stringList.length || index <= 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        System.out.println("В ячейке " + index + " найдена строка " + stringList[index]);
        return stringList[index];
    }

    @Override
    public boolean equals(StringList[] otherList) {
        if (Arrays.equals(stringList, otherList)) {
            return true;
        } else if (otherList == null) {
            throw new IllegalArgumentException("Передан пустой массив");
        }
        return false;
    }

    @Override
    public int size() {
        int CountOfNotNullCells = 0;
        for (int calculatingCells = 0; calculatingCells < stringList.length; calculatingCells++) {
            if (stringList[calculatingCells] != null) {
                CountOfNotNullCells++;
            }
        }
        return CountOfNotNullCells;
    }

    @Override
    public boolean isEmpty() {
        int nullCells = 0;
        for (int cells = 0; cells < stringList.length; cells++) {
            if (stringList[cells] == null) {
                nullCells++;
            }
        }
        if (nullCells == stringList.length) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int e = 0; e < stringList.length; e++) {
            stringList[e] = null;
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.stream(stringList)
                .filter(e -> e != null)
                .toArray(String[]::new);
    }

//    private int getCountOfFreeCells() {
//            int innerCountOfFreeCells = 0;
//            for (int calculatingFreeCells = 0; calculatingFreeCells < stringList.length; calculatingFreeCells++) {
//                if (stringList[calculatingFreeCells] == null) {
//                    innerCountOfFreeCells++;
//                }
//            }
//            return innerCountOfFreeCells;
//        }
}


