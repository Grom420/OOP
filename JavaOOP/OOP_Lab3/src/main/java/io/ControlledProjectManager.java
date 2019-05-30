package io;

import humanresources.AlreadyAddedException;
import humanresources.EmployeeGroup;
import humanresources.ProjectsManager;

import java.util.Collection;
import java.util.Objects;

public class ControlledProjectManager extends ProjectsManager {
    protected Source<EmployeeGroup> source;

    public ControlledProjectManager(){}

    public Source<EmployeeGroup> getSource() {
        return source;
    }

    public void setSource(Source<EmployeeGroup> source) {
        this.source = source;
    }

    public ControlledProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        super(employeeGroups);
    }

    private void createControlledEmployeeGroup(EmployeeGroup employeeGroup) {
        ControlledProject project = new ControlledProject(employeeGroup);
        source.create(project);
    }

    private void delete(EmployeeGroup employeeGroup) {
        source.delete(employeeGroup);
    }

    @Override
    public boolean add(EmployeeGroup employeeGroup) {
        if(super.add(employeeGroup)){
            createControlledEmployeeGroup(employeeGroup);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o){
        if (super.remove(o)) {
            delete((EmployeeGroup) o);
            return true;
        }
        return false;
    }

    //todo следующие 4 метода аналогично ControlledDepartamentManager
    @Override
    public boolean addAll(Collection<? extends EmployeeGroup> c){
        c.forEach(this::createControlledEmployeeGroup);
        boolean areAdded = super.addAll(c);
        super.removeAll(c);
        return areAdded;
    }

    @Override
    public boolean addAll(int index, Collection<? extends EmployeeGroup> c){
        c.forEach(this::createControlledEmployeeGroup);
        boolean areAdded = super.addAll(index, c);
        super.removeAll(c);
        return areAdded;
    }

    @Override
    public boolean removeAll(Collection<?> c){
        boolean areRemoved = super.removeAll(c);
        c.forEach(object -> delete((EmployeeGroup) object));
        return areRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c){
        boolean areRetained = super.retainAll(c);
        this.stream().filter(order -> !c.contains(order)).forEach(this::delete);
        return areRetained;
    }

    @Override
    public void clear(){
        super.clear();
        this.forEach(this::delete);
    }

    @Override
    public void add(int index, EmployeeGroup element){
        super.add(index, element);
        createControlledEmployeeGroup(element);
    }

    @Override
    public EmployeeGroup remove(int index){
        EmployeeGroup removedOrder = super.remove(index);
        if (Objects.nonNull(removedOrder))
            delete(super.get(index));
        return removedOrder;
    }

    public void store() {
        this.stream().filter(order -> ((ControlledDepartament) order).isChanged).forEach(order -> {
            source.store(order);
        });
    }

    public void load() {
        this.forEach(order -> {
            source.load(order);
        });
    }
}
