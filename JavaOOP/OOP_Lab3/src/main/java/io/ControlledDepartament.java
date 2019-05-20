package io;

import humanresources.Departament;
import humanresources.Employee;
import humanresources.EmployeeGroup;
import humanresources.JobTitilesEnum;

import java.util.Collection;

public class ControlledDepartament extends Departament {
    protected boolean isChanged = false;

    public ControlledDepartament(){
        super("");
    }

    public ControlledDepartament(int capacity){
        super(capacity);
    }

    public ControlledDepartament(String name) {
        super(name);
    }

    public ControlledDepartament(String name, int capacity) {
        super(name, capacity);
    }

    public ControlledDepartament(String name, Employee[] employees) {
        super(name, employees);
    }

    public ControlledDepartament(EmployeeGroup employeeGroup){
        this(employeeGroup.getName(), employeeGroup.size());
        super.addAll(employeeGroup);
    }

    protected boolean isChanged(){
        return this.isChanged;
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
        if (super.remove(firstName, lastName)) {
            isChanged = true;
            return true;
        }
        return false;
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

    @Override
    public int removeAll(JobTitilesEnum jobTitle){
        this.isChanged = true;
        return super.removeAll(jobTitle);
    }
}
