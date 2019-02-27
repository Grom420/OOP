package psuti.pp.exam.crud;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import psuti.pp.exam.MainLayout;
import psuti.pp.exam.backend.data.Person;

import java.util.logging.Logger;

/**
 * A view for performing create-read-update-delete operations on products.
 *
 * See also {@link SampleCrudLogic} for fetching the data, the actual CRUD
 * operations and controlling the view based on events from outside.
 */
@Route(value = "Inventory", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class SampleCrudView extends HorizontalLayout
        implements HasUrlParameter<String> {

    public static final String VIEW_NAME = "Inventory";
    private static final Logger log = Logger.getLogger(SampleCrudView.class.getName());
    private PersonGrid grid;
    private FilterForm form;
    private PersonForm personForm;


    private SampleCrudLogic viewLogic = new SampleCrudLogic(this);
    private Button filterBtn;

    public PersonDataProvider getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(PersonDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        grid.setDataProvider(dataProvider);
    }

    private PersonDataProvider dataProvider = new PersonDataProvider();


    public SampleCrudView() {
        setSizeFull();
        HorizontalLayout topLayout = createTopBar();

        grid = new PersonGrid();
        grid.setDataProvider(dataProvider);
        grid.asSingleSelect().addValueChangeListener(
                event -> viewLogic.rowSelected(event.getValue()));

        grid.getDataProvider().refreshAll();
        form = new FilterForm(viewLogic);
        personForm = new PersonForm();

        VerticalLayout barAndGridLayout = new VerticalLayout();
        barAndGridLayout.add(topLayout);
        barAndGridLayout.add(grid);
        barAndGridLayout.setFlexGrow(1, grid);
        barAndGridLayout.setFlexGrow(0, topLayout);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.expand(grid);

        add(barAndGridLayout);
        add(form);
        add(personForm);
    }

    public HorizontalLayout createTopBar() {
        filterBtn = new Button("Filter");
        filterBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        filterBtn.setIcon(VaadinIcon.PLUS_CIRCLE.create());
        filterBtn.addClickListener(click ->
                form.changeVisible()
        );

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");
        topLayout.add(filterBtn);

        return topLayout;
    }

    public void setNewProductEnabled(boolean enabled) {
        filterBtn.setEnabled(enabled);
    }

    public void clearSelection() {
        grid.getSelectionModel().deselectAll();
    }

    public void showForm(boolean show) {
        form.setVisible(show);

        /* FIXME The following line should be uncommented when the CheckboxGroup
         * issue is resolved. The category CheckboxGroup throws an
         * IllegalArgumentException when the form is disabled.
         */
        //form.setEnabled(show);
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        viewLogic.enter(parameter);
    }

    public void showPerson(Person p){
        personForm.showPerson(p);
    }
}
