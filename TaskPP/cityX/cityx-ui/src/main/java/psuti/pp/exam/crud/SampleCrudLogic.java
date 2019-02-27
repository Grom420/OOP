package psuti.pp.exam.crud;

import psuti.pp.exam.backend.DataService;
import psuti.pp.exam.backend.data.Person;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class provides an interface for the logical operations between the CRUD
 * view, its parts like the product editor form and the data source, including
 * fetching and saving products.
 *
 * Having this separate from the view makes it easier to test various parts of
 * the system separately, and to e.g. provide alternative views for the same
 * data.
 */
public class SampleCrudLogic implements Serializable {

    private SampleCrudView view;
    private HashMap<String,String> filters;

    public SampleCrudLogic(SampleCrudView simpleCrudView) {
        view = simpleCrudView;
        filters = new HashMap<String,String>();
    }

    public void cancelProduct() {
        setFragmentParameter("");
        view.clearSelection();
    }

    /**
     * Update the fragment without causing navigator to change view
     */
    private void setFragmentParameter(String productId) {
    }

    public void enter(String productId) {
    }

    public void addFilter(String name, String value) {
        filters.put(name, value);
    }

    public void clearFilters(){
        filters = new HashMap<String,String>();
    }

    public void startSearch() {
        view.setDataProvider(new PersonDataProvider(DataService.get(filters)));
    }

    public void rowSelected(Person person) {
        view.showPerson(person);
    }
}
