package io;

import humanresources.AlreadyAddedException;
import humanresources.Employee;
import humanresources.EmployeeGroup;
import humanresources.Project;

import java.util.Collection;

public class ControlledProject extends Project {
    protected boolean isChanged;

    public ControlledProject(){super();}

    public ControlledProject(String name) {
        super(name);
    }

    public ControlledProject(String name, Employee[] employees) throws AlreadyAddedException {
        super(name, employees);
    }

    public ControlledProject(EmployeeGroup employeeGroup){
        this(employeeGroup.getName());
        super.addAll(employeeGroup);
    }

    protected boolean isChanged(){
        return this.isChanged;
    }

    @Override
    public void setName(String name){
        this.isChanged = true;
        super.setName(name);
    }

    @Override
    public boolean add(Employee employee){
        if (super.add(employee)) {
            isChanged = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Employee> c){
        boolean isChanged = false;
        for (Employee employee : c) {
            if (add(employee))
                isChanged = true;
        }
        return isChanged;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Employee> c){
        boolean isChanged = false;
        if (super.addAll(index, c)) {
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c){
        boolean isChanged = false;
        if (super.removeAll(c)) {
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c){
        boolean isChanged = false;
        if (super.retainAll(c)) {
            isChanged = true;
        }
        return isChanged;
    }

    @Override
    public Employee set(int index, Employee element){
        Employee employee = super.set(index, element);
        isChanged = true;
        return employee;
    }

    @Override
    public void add(int index, Employee element){
        super.add(index, element);
        isChanged = true;
    }

    @Override
    public Employee remove(int index){
        Employee employee = super.remove(index);
        isChanged = true;
        return employee;
    }

    @Override
    public boolean remove(Object o){
        if (super.remove(o)) {
            isChanged = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String firstName, String lastName){
        this.isChanged = true;
        return super.remove(firstName, lastName);
    }

    @Override
    public Employee[] employeesSortedBySalary(){
        this.isChanged = true;
        return super.employeesSortedBySalary();
    }

    @Override
    public Employee[] sortBySalaryAndBonus(Employee[] arrEmp){
        this.isChanged = true;
        return super.sortBySalaryAndBonus(arrEmp);
    }
}
