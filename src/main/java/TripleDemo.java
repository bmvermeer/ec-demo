import org.eclipse.collections.api.tuple.Triple;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.tuple.Tuples;

public class TripleDemo {

    /*
    List of triples containing: (String CountryName, int DialingCode, boolean EuMember)
    Printing names of eu countries.
     */
    public void printEuCountries() {
        var countries = Lists.immutable.of(
                Tuples.triple("Netherlands", 31, true),
                Tuples.triple("United Kingdom", 44, false),
                Tuples.triple("Germany", 49, true)
        );

        var euCountries = countries
                .select(Triple::getThree)
                .collect(Triple::getOne);

        euCountries.forEach(System.out::println);
    }

    /*
    returning a triple contraining starttime, endtime and result
     */
    public Triple factorialCalculation(int n) {
        var start = System.currentTimeMillis();
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        var end = System.currentTimeMillis();
        return Tuples.triple(start, end, fact);
    }

    public static void main(String[] args) {
        TripleDemo tripleDemo = new TripleDemo();
        tripleDemo.printEuCountries();
        var facResult = tripleDemo.factorialCalculation(11);
        System.out.println(facResult);
    }
}
