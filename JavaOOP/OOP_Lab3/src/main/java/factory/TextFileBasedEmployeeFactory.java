package factory;

import humanresources.*;
import io.*;

public class TextFileBasedEmployeeFactory extends EmployeeFactory {
    private String path;
    private GroupsManagerTextFileSource groupsManagerTextFileSource;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public GroupsManagerTextFileSource getGroupsManagerTextFileSource() {
        return groupsManagerTextFileSource;
    }

    public void setGroupsManagerTextFileSource(GroupsManagerTextFileSource groupsManagerTextFileSource) {
        this.groupsManagerTextFileSource = groupsManagerTextFileSource;
    }

    public TextFileBasedEmployeeFactory(String path){
        this.path = path;
        groupsManagerTextFileSource = new GroupsManagerTextFileSource(path);
    }

    @Override
    public EmployeeGroup createDepartment() {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartament();
    }

    @Override
    public EmployeeGroup createDepartment(int capacity) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartament(capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartament(name);
    }

    @Override
    public EmployeeGroup createDepartment(String name, int capacity) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartament(name, capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name, Employee[] employees) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartament(name, employees);
    }

    @Override
    public EmployeeGroup createDepartment(EmployeeGroup employeeGroup) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartament(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
    }

    @Override
    public EmployeeGroup createProject() {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledProject();
    }

    @Override
    public EmployeeGroup createProject(String name) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledProject(name);
    }

    @Override
    public EmployeeGroup createProject(String name, Employee[] employees) throws AlreadyAddedException {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledProject(name, employees);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartamentManager(groupsName);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledDepartamentManager(groupsName, employees);
    }

    @Override
    public GroupsManager createProjectManager() {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledProjectManager();
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        setPath(groupsManagerTextFileSource.getPath());
        return new ControlledProjectManager(employeeGroups);
    }
}
