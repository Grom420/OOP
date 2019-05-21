package factory;

import humanresources.Employee;
import humanresources.EmployeeGroup;
import humanresources.GroupsManager;

public class OrdinaryEmployeeFactory extends EmployeeFactory {
    @Override
    public EmployeeGroup createDepartment() {
        return null;
    }

    @Override
    public EmployeeGroup createDepartment(int capacity) {
        return null;
    }

    @Override
    public EmployeeGroup createDepartment(String name) {
        return null;
    }

    @Override
    public EmployeeGroup createDepartment(String name, int capacity) {
        return null;
    }

    @Override
    public EmployeeGroup createDepartment(String name, Employee[] employees) {
        return null;
    }

    @Override
    public EmployeeGroup createProject() {
        return null;
    }

    @Override
    public EmployeeGroup createProject(String name) {
        return null;
    }

    @Override
    public EmployeeGroup createProject(String name, Employee[] employees) {
        return null;
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName) {
        return null;
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        return null;
    }

    @Override
    public GroupsManager createProjectManager() {
        return null;
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) {
        return null;
    }
}
