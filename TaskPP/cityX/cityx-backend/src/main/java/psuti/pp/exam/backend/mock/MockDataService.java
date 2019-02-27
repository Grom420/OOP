package psuti.pp.exam.backend.mock;

import java.util.LinkedList;
import java.util.List;

import psuti.pp.exam.backend.DataService;
import psuti.pp.exam.backend.data.Person;

/**
 * Mock data model. This implementation has very simplistic locking and does not
 * notify users of modifications.
 */
public class MockDataService extends DataService {

    private static MockDataService INSTANCE;

    private List<Person> persons;

    private int nextProductId = 0;

    private MockDataService() {
        persons = new LinkedList<>();
        //persons = new ArrayList<>();
        nextProductId = persons.size() + 1;
    }

    public synchronized static DataService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MockDataService();
        }
        return INSTANCE;
    }

    @Override
    public synchronized List<Person> getAllPersons() {
        return persons;
    }
}
