package factory;

import humanresources.*;

public class OrdinaryEmployeeFactory extends EmployeeFactory {
    @Override
    public EmployeeGroup createDepartment() {
        return new Departament();
    }

    @Override
    public EmployeeGroup createDepartment(int capacity) {
        return new Departament(capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name) {
        return new Departament(name);
    }

    @Override
    public EmployeeGroup createDepartment(String name, int capacity) {
        return new Departament(name, capacity);
    }

    @Override
    public EmployeeGroup createDepartment(String name, Employee[] employees) {
        return new Departament(name, employees);
    }

    @Override
    public EmployeeGroup createDepartment(EmployeeGroup employeeGroup) {
        return new Departament(employeeGroup.getName(), (Employee[]) employeeGroup.toArray());
    }

    @Override
    public EmployeeGroup createProject() {
        return new Project();
    }

    @Override
    public EmployeeGroup createProject(String name) {
        return new Project(name);
    }

    @Override
    public EmployeeGroup createProject(String name, Employee[] employees) throws AlreadyAddedException {
        return new Project(name, employees);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName) {
        return new DepartamentsManager(groupsName);
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        return new DepartamentsManager(groupsName, employees);
    }

    @Override
    public GroupsManager createProjectManager() {
        return new ProjectsManager();
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        return new ProjectsManager(employeeGroups);
    }
}
