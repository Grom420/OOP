package factory;

import humanresources.AlreadyAddedException;
import humanresources.Employee;
import humanresources.EmployeeGroup;
import humanresources.GroupsManager;
import io.*;

public class BinaryFileBasedEmployeeFactory extends EmployeeFactory {
    private String path;
    private GroupsManagerBinaryFileSource groupsManagerBinaryFileSource;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public GroupsManagerBinaryFileSource getGroupsManagerBinaryFileSource() {
        return groupsManagerBinaryFileSource;
    }

    public void setGroupsManagerBinaryFileSource(GroupsManagerBinaryFileSource groupsManagerBinaryFileSource) {
        this.groupsManagerBinaryFileSource = groupsManagerBinaryFileSource;
    }

    public BinaryFileBasedEmployeeFactory(String path){
        this.path = path;
    }

    @Override
    public EmployeeGroup createDepartment() {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartament();
    }

    @Override
    public EmployeeGroup createDepartment(int capacity) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartament(capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartament(name);
    }

    @Override
    public EmployeeGroup createDepartment(String name, int capacity) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartament(name, capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name, Employee[] employees) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartament(name, employees);
    }

    @Override
    public EmployeeGroup createDepartment(EmployeeGroup employeeGroup) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartament(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
    }

    @Override
    public EmployeeGroup createProject() {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledProject();
    }

    @Override
    public EmployeeGroup createProject(String name) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledProject(name);
    }

    @Override
    public EmployeeGroup createProject(String name, Employee[] employees) throws AlreadyAddedException {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledProject(name, employees);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartamentManager(groupsName);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledDepartamentManager(groupsName, employees);
    }

    @Override
    public GroupsManager createProjectManager() {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledProjectManager();
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        setPath(groupsManagerBinaryFileSource.getPath());
        return new ControlledProjectManager(employeeGroups);
    }
}
