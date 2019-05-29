package factory;

import humanresources.*;
import io.*;

public class TextFileBasedEmployeeFactory extends EmployeeFactory {
    private String path;

    public TextFileBasedEmployeeFactory(String path){
        this.path = path;
    }

    @Override
    public EmployeeGroup createDepartment() {
        return new ControlledDepartament();
    }

    @Override
    public EmployeeGroup createDepartment(int capacity) {
        return new ControlledDepartament(capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name) {
        return new ControlledDepartament(name);
    }

    @Override
    public EmployeeGroup createDepartment(String name, int capacity) {
        return new ControlledDepartament(name, capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name, Employee[] employees) {
        return new ControlledDepartament(name, employees);
    }

    @Override
    public EmployeeGroup createDepartment(EmployeeGroup employeeGroup) {
        return new ControlledDepartament(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
    }

    @Override
    public EmployeeGroup createProject() {
        return new ControlledProject();
    }

    @Override
    public EmployeeGroup createProject(String name) {
        return new ControlledProject(name);
    }

    @Override
    public EmployeeGroup createProject(String name, Employee[] employees) throws AlreadyAddedException {
        return new ControlledProject(name, employees);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName) {
        GroupsManagerTextFileSource fs = new GroupsManagerTextFileSource(path);
        ControlledDepartamentManager manager = new ControlledDepartamentManager(groupsName);
        manager.setSource(fs);
        return manager;
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        GroupsManagerTextFileSource fs = new GroupsManagerTextFileSource(path);
        ControlledDepartamentManager manager = new ControlledDepartamentManager(groupsName, employees);
        manager.setSource(fs);
        return manager;
    }

    @Override
    public GroupsManager createProjectManager() {
        GroupsManagerTextFileSource fs = new GroupsManagerTextFileSource(path);
        ControlledProjectManager manager = new ControlledProjectManager();
        manager.setSource(fs);
        return manager;
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        GroupsManagerTextFileSource fs = new GroupsManagerTextFileSource(path);
        ControlledProjectManager manager = new ControlledProjectManager(employeeGroups);
        manager.setSource(fs);
        return manager;
    }
}
