package pl.coderstrust.mylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends ArrayListTestBase {
    @Override
    public List<Long> getList() {
        return new ArrayList<>();
    }

    @Override
    public List<Long> getList(int elements) {
        return new ArrayList<>(elements);
    }
}
