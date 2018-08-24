package pl.coderstrust.search;

public class LinearSearchTest extends SearchTestBase {
    @Override
    public SearchMethod getSearchMethod() {
        return new LinearSearch();
    }
}
