package io;

import humanresources.AlreadyAddedException;
import humanresources.Employee;
import humanresources.Project;

public class ControlledProject extends Project {
    protected boolean isChanged;

    public ControlledProject(){super();}

    public ControlledProject(String name) {
        super(name);
    }

    public ControlledProject(String name, Employee[] employees) throws AlreadyAddedException {
        super(name, employees);
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
    public boolean remove(String firstName, String lastName){
        this.isChanged = true;
        return super.remove(firstName, lastName);
    }

    @Override
    public Employee[] employeesSortedBySalary(){
        this.isChanged = true;
        return super.employeesSortedBySalary();
    }
}
