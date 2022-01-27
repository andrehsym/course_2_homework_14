package pro.sky.java.homeworks.course2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListImpl implements StringList {

    private final String[] stringList;
    private int size = 0;

    public StringListImpl(int length) {
        stringList = new String[length];
    }

    @Override
    public String add(String item) {
        if (size >= stringList.length) {
            throw new ArrayIndexOutOfBoundsException("Массив заполнен");
        }
        stringList[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        if (stringList[index - 1] == null) {
            throw new ArrayIndexOutOfBoundsException(index + " выходит за пределы фактического\n" +
                    "    // количества элементов");
        }
        if (stringList[stringList.length - 1] != null) {
            throw new ArrayIndexOutOfBoundsException("Массив заполнен, добавление нового элемента невозможно");
        } else if (stringList[stringList.length - 1] == null && stringList[index] != null) {
            System.arraycopy(stringList, index, stringList, index + 1, stringList.length - 1 - (index + 1));
            stringList[index] = item;
            size++;
            return item;
        }
        stringList[index] = item;
        size++;
        return item;
        }

    @Override
    public String set(int index, String item) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        if (stringList[index - 1] == null) {
            throw new ArrayIndexOutOfBoundsException(index + " выходит за пределы фактического\n" +
                    "    // количества элементов");
        }
        stringList[index] = item;
        size++;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int j = 0; j < stringList.length; j++) {
            if (stringList[j].equals(item)) {
                stringList[j] = null;
                System.arraycopy(stringList, j + 1, stringList, j, stringList.length - 1 - j);
                size--;
                return item;
            }
        }
        throw new ArrayIndexOutOfBoundsException(item + " не найдена");
    }

    @Override
    public String remove(int index) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        if (stringList[index] == null) {
            throw new NullPointerException("Ячейка пуста");
        }
        String removedStringByIndex = stringList[index];
        stringList[index] = null;
        System.arraycopy(stringList, index + 1, stringList, index, stringList.length - 1 - index);
        size--;
        return removedStringByIndex;
    }

    @Override
    public boolean contains(String item) {
        for (String s : stringList) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int k = 0; k < stringList.length; k++) {
            if (stringList[k].equals(item)) {
                return k;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int k = stringList.length - 1; k >= 0; k--) {
            if (stringList[k] == null) {
                continue;
            }
            if (stringList[k].equals(item)) {
                return k;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= stringList.length || index <= 0) {
            throw new ArrayIndexOutOfBoundsException("Ячейки " + index + " в массиве нет");
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null || getClass() != otherList.getClass()) {
            throw new NullPointerException("Передан null...");
        }
        StringListImpl that = (StringListImpl) otherList;
        return Arrays.equals(stringList, that.stringList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(stringList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (String s : stringList) {
            if (s != null) {
                return false;
            }
        }
    return true;
    }

    @Override
    public void clear() {
        Arrays.fill(stringList, null);
    }

    @Override
    public String[] toArray() {
//       String[] newStringListArray = Arrays.copyOf(stringList, stringList.length);
//       return newStringListArray;

        return Arrays.stream(stringList)
                .filter(e -> e != null)
                .toArray(String[]::new);
    }
}


