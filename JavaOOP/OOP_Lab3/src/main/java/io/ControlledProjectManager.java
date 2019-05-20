package io;

import humanresources.AlreadyAddedException;
import humanresources.EmployeeGroup;
import humanresources.ProjectsManager;

import java.util.Collection;
import java.util.Objects;

public class ControlledProjectManager extends ProjectsManager {
    protected Source<EmployeeGroup> source;

    public ControlledProjectManager(){}

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
        createControlledEmployeeGroup(employeeGroup);
        return super.add(employeeGroup);
    }

    @Override
    public boolean remove(Object o){
        delete((EmployeeGroup) o);
        return super.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends EmployeeGroup> c){
        c.forEach(this::createControlledEmployeeGroup);
        return super.removeAll(c);
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
        c.forEach(object -> delete((EmployeeGroup) object));
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c){
        this.stream().filter(order -> !c.contains(order)).forEach(this::delete);
        return super.retainAll(c);
    }

    @Override
    public void clear(){
        this.forEach(this::delete);
        super.clear();
    }

    @Override
    public void add(int index, EmployeeGroup element){
        createControlledEmployeeGroup(element);
        super.add(index, element);
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
