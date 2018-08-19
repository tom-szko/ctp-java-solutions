package pl.coderstrust.search;

public class BinarySearchTest extends SearchTestBase{
    @Override
    public Searchable getSearchMethod() {
        return new BinarySearch();
    }
}
