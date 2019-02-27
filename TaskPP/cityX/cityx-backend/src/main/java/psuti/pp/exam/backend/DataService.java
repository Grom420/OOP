package psuti.pp.exam.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import psuti.pp.exam.backend.data.Person;
import psuti.pp.exam.backend.mock.FilterDataService;
import psuti.pp.exam.backend.mock.MockDataService;

/**
 * Back-end service interface for retrieving and updating product data.
 */
public abstract class DataService implements Serializable {

    public abstract Collection<Person> getAllPersons() throws IOException;

    public static DataService get() {
        return MockDataService.getInstance();
    }

    public static DataService get(HashMap<String,String> filters) throws IOException {
        return FilterDataService.getInstance(filters);
    }

}
