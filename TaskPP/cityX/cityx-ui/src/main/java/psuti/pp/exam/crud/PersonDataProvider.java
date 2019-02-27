package psuti.pp.exam.crud;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import psuti.pp.exam.backend.DataService;
import psuti.pp.exam.backend.data.Person;

import javax.xml.crypto.Data;

public class PersonDataProvider extends ListDataProvider<Person> {

    /** Text filter that can be changed separately. */
    private String filterText = "";

    private static final Logger log = Logger.getLogger(PersonDataProvider.class.getName());

    public PersonDataProvider() {
        this(DataService.get());
    }

    public PersonDataProvider(DataService obj){
        super(obj.getAllPersons());
    }


}
