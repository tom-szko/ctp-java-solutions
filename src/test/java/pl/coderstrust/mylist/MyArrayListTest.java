package pl.coderstrust.mylist;

import java.util.List;

public class MyArrayListTest extends ArrayListTestBase {
    @Override
    public List<Long> getEmptyList() {
        return new MyArrayList();
    }

    @Override
    public List<Long> getEmptyList(int elements) {
        return new MyArrayList(elements);
    }
}
