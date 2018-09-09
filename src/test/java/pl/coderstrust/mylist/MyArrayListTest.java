package pl.coderstrust.mylist;

import java.util.List;

public class MyArrayListTest extends ArrayListTestBase {
    @Override
    public List<Long> getList() {
        return new MyArrayList();
    }

    @Override
    public List<Long> getList(int elements) {
        return new MyArrayList(elements);
    }
}
