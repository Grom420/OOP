package factory;

import humanresources.*;
import io.*;

public class SerializedFileBasedEmployeeFactory extends EmployeeFactory {
    private String path;
    private GroupsManagerSerializedFileSource groupsManagerSerializedFileSource;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public GroupsManagerSerializedFileSource getGroupsManagerSerializedFileSource() {
        return groupsManagerSerializedFileSource;
    }

    public void setGroupsManagerSerializedFileSource(GroupsManagerSerializedFileSource groupsManagerSerializedFileSource) {
        this.groupsManagerSerializedFileSource = groupsManagerSerializedFileSource;
    }

    public SerializedFileBasedEmployeeFactory(String path){
        this.path = path;
        groupsManagerSerializedFileSource = new GroupsManagerSerializedFileSource(path);
    }

    @Override
    public EmployeeGroup createDepartment() {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartament();
    }

    @Override
    public EmployeeGroup createDepartment(int capacity) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartament(capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartament(name);
    }

    @Override
    public EmployeeGroup createDepartment(String name, int capacity) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartament(name, capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name, Employee[] employees) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartament(name, employees);
    }

    @Override
    public EmployeeGroup createDepartment(EmployeeGroup employeeGroup) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartament(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
    }

    @Override
    public EmployeeGroup createProject() {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledProject();
    }

    @Override
    public EmployeeGroup createProject(String name) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledProject(name);
    }

    @Override
    public EmployeeGroup createProject(String name, Employee[] employees) throws AlreadyAddedException {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledProject(name, employees);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartamentManager(groupsName);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledDepartamentManager(groupsName, employees);
    }

    @Override
    public GroupsManager createProjectManager() {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledProjectManager();
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        setPath(groupsManagerSerializedFileSource.getPath());
        return new ControlledProjectManager(employeeGroups);
    }
}
