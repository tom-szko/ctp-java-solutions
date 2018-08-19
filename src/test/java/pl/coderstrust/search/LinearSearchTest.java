package pl.coderstrust.search;

public class LinearSearchTest extends SearchTestBase {
    @Override
    public Searchable getSearchMethod() {
        return new LinearSearch();
    }
}
