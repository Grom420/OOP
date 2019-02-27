package psuti.pp.exam.crud;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import psuti.pp.exam.backend.data.Person;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class PersonGrid extends Grid<Person> {

    public PersonGrid() {
        setSizeFull();
        initGrid();

    }

    public Person getSelectedRow() {
        return asSingleSelect().getValue();
    }


    private void initGrid(){
        initPersonColumns();
        initAddressColumns();
    }

    private void initPersonColumns(){
        addColumn(Person::getFirstName)
                .setHeader("First Name")
                .setFlexGrow(4);

        addColumn(Person::getSecondName)
                .setHeader("Second Name")
                .setFlexGrow(4);

        addColumn(Person::getMiddleName)
                .setHeader("Middle Name")
                .setFlexGrow(4);
        addColumn(Person::getDocNumber)
                .setHeader("Document")
                .setFlexGrow(4);

        addColumn(Person::getPhoneNumber)
                .setHeader("Phone Name")
                .setFlexGrow(4);
    }

    private void initAddressColumns(){
        addColumn(Person::getAddress)
                .setHeader("Addreess")
                .setFlexGrow(20);
    }
}
