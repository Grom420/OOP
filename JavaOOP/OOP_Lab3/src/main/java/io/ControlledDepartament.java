package io;

import humanresources.Departament;
import humanresources.Employee;
import humanresources.JobTitilesEnum;

public class ControlledDepartament extends Departament {
    private Departament departament;
    protected boolean isChanged;

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

    public ControlledDepartament(Departament departament){
        this.departament = departament;
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

    @Override
    public Employee[] sortBySalaryAndBonus(Employee[] arrEmp){
        this.isChanged = true;
        return super.sortBySalaryAndBonus(arrEmp);
    }

    @Override
    public boolean remove(Employee employee){
        this.isChanged = true;
        return super.remove(employee);
    }

    @Override
    public int removeAll(JobTitilesEnum jobTitle){
        this.isChanged = true;
        return super.removeAll(jobTitle);
    }
}
