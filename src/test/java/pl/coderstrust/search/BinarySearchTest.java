package pl.coderstrust.search;

public class BinarySearchTest extends SearchTestBase{
    @Override
    public SearchMethod getSearchMethod() {
        return new BinarySearch();
    }
}
