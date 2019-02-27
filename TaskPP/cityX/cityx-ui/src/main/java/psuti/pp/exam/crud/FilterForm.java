package psuti.pp.exam.crud;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

/**
 * A form for editing a single product.
 */
public class FilterForm extends Div {

    private VerticalLayout content;

    //cityX
    private TextField firstName;
    private TextField secondName;
    private TextField middleName;
    private DatePicker birthDate;

    private TextField city;
    private TextField county;
    private TextField street;
    private TextField building;
    private TextField litera;
    private TextField corpus;
    private TextField apartment;

    private TextField phone;
    private TextField docNumber;

    private Button search;
    private Button cancel;

    private SampleCrudLogic viewLogic;

    public FilterForm(SampleCrudLogic sampleCrudLogic) {
        setClassName("filter-form");

        content = new VerticalLayout();
        content.setSizeUndefined();
        add(content);

        viewLogic = sampleCrudLogic;

        initSearchForm();

        search = new Button("Search");
        search.setWidth("100%");
        search.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        search.addClickListener(event -> {
            filterPersons();
            changeVisible();
        });

        this.setVisible(false);

        cancel = new Button("Cancel");
        cancel.setWidth("100%");
        cancel.addClickListener(event -> changeVisible());

        content.add(search, cancel);
    }

    public void changeVisible() {
            this.setVisible(!this.isVisible());
    }

    private void initSearchForm() {
        initPersonBox();

        phone = new TextField("Phone");
        phone.setWidth("100%");
        content.add(phone);

        docNumber = new TextField("Document number");
        docNumber.setWidth("100%");
        content.add(docNumber);

        initAddressBox();
    }

    private void initPersonBox() {
        firstName = new TextField("First Name");
        firstName.setWidth("100%");
        content.add(firstName);

        secondName = new TextField("Second Name");
        secondName.setWidth("100%");
        content.add(secondName);

        middleName = new TextField("Middle Name");
        middleName.setWidth("100%");
        content.add(middleName);

        birthDate = new DatePicker("Birth Date");
        birthDate.setWidth("100%");
        content.add(birthDate);
    }

    private void initAddressBox(){
        city = new TextField("City");
        city.setWidth("100%");
        content.add(city);

        county = new TextField("County");
        county.setWidth("100%");
        content.add(county);

        street = new TextField("Street");
        street.setWidth("100%");
        content.add(street);

        building = new TextField("Building");
        building.setWidth("100%");
        content.add(building);

        litera = new TextField("Litera");
        litera.setWidth("100%");
        content.add(litera);

        corpus = new TextField("Corpus");
        corpus.setWidth("100%");
        content.add(corpus);

        apartment = new TextField("Apartment");
        apartment.setWidth("100%");
        content.add(apartment);
    }

    private void filterPersons() {
        viewLogic.clearFilters();
        if(firstName.getValue() != null) {
            viewLogic.addFilter("firstName", firstName.getValue());
        }
        if(secondName.getValue() != null) {
            viewLogic.addFilter("secondName", secondName.getValue());
        }
        if(middleName.getValue() != null) {
            viewLogic.addFilter("middleName", middleName.getValue());
        }
        if(birthDate.getValue() != null) {
            viewLogic.addFilter("birthDate", birthDate.getValue().toString());
        }
        if(docNumber.getValue() != null) {
            viewLogic.addFilter("docNumber", docNumber.getValue());
        }
        if(phone.getValue() != null) {
            viewLogic.addFilter("phone", phone.getValue());
        }
        if(county.getValue() != null) {
            viewLogic.addFilter("county", county.getValue());
        }
        if(city.getValue() != null) {
            viewLogic.addFilter("city", city.getValue());
        }
        if(street.getValue() != null) {
            viewLogic.addFilter("street", street.getValue());
        }
        if(building.getValue() != null) {
            viewLogic.addFilter("building", building.getValue());
        }
        if(litera.getValue() != null) {
            viewLogic.addFilter("litera", litera.getValue());
        }
        if(corpus.getValue() != null) {
            viewLogic.addFilter("corpus", corpus.getValue());
        }
        if(apartment.getValue() != null) {
            viewLogic.addFilter("apartment", apartment.getValue());
        }

        viewLogic.startSearch();
    }
}
