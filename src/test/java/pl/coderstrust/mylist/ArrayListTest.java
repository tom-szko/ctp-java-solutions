package pl.coderstrust.mylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends ArrayListTestBase {
    @Override
    public List<Long> getEmptyList() {
        return new ArrayList<>();
    }

    @Override
    public List<Long> getEmptyList(int elements) {
        return new ArrayList<>(elements);
    }
}
