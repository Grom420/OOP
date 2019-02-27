package psuti.pp.exam.crud;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import psuti.pp.exam.backend.data.Person;

public class PersonForm extends Div {
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

    private Button cancel;

    public PersonForm(){
        setClassName("person-form");

        content = new VerticalLayout();
        content.setSizeUndefined();
        add(content);

        initFields();

        cancel = new Button("Cancel");
        cancel.setWidth("100%");
        cancel.addClickListener(event -> changeVisible());
        content.add(cancel);

        this.setVisible(false);
    }

    public void showPerson(Person p) {
        setValues(p);
        setVisible(true);
    }

    public void changeVisible() {
        this.setVisible(!this.isVisible());
    }

    private void setValues(Person person) {
        firstName.setValue(person.getFirstName());
        secondName.setValue(person.getSecondName());
        middleName.setValue(person.getMiddleName());
        birthDate.setValue(person.getBirthDate());

        phone.setValue(person.getPhoneNumber());
        docNumber.setValue(person.getDocNumber());

        city.setValue(person.getCity());
        county.setValue(person.getCounty());
        street.setValue(person.getStreet());
        building.setValue(person.getBuilding().toString());
        litera.setValue(person.getLiter().toString());
        corpus.setValue(person.getCorpus().toString());
        apartment.setValue(person.getApartment().toString());
    }

    private void initFields() {
        initPersonBox();

        phone = new TextField("Phone");
        phone.setWidth("100%");
        content.add(phone);
        phone.setReadOnly(true);

        docNumber = new TextField("Document number");
        docNumber.setWidth("100%");
        content.add(docNumber);
        docNumber.setReadOnly(true);

        initAddressBox();
        setVisible(false);
    }

    private void initPersonBox() {
        firstName = new TextField("First Name");
        firstName.setWidth("100%");
        content.add(firstName);
        firstName.setReadOnly(true);

        secondName = new TextField("Second Name");
        secondName.setWidth("100%");
        content.add(secondName);
        secondName.setReadOnly(true);

        middleName = new TextField("Middle Name");
        middleName.setWidth("100%");
        content.add(middleName);
        middleName.setReadOnly(true);

        birthDate = new DatePicker("Birth Date");
        birthDate.setWidth("100%");
        content.add(birthDate);
        birthDate.setReadOnly(true);
    }

    private void initAddressBox() {
        city = new TextField("City");
        city.setWidth("100%");
        content.add(city);
        city.setReadOnly(true);

        county = new TextField("County");
        county.setWidth("100%");
        content.add(county);
        county.setReadOnly(true);

        street = new TextField("Street");
        street.setWidth("100%");
        content.add(street);
        street.setReadOnly(true);

        building = new TextField("Building");
        building.setWidth("100%");
        content.add(building);
        building.setReadOnly(true);


        litera = new TextField("Litera");
        litera.setWidth("100%");
        content.add(litera);
        litera.setReadOnly(true);

        corpus = new TextField("Corpus");
        corpus.setWidth("100%");
        content.add(corpus);
        corpus.setReadOnly(true);

        apartment = new TextField("Apartment");
        apartment.setWidth("100%");
        content.add(apartment);
        apartment.setReadOnly(true);
    }
}
