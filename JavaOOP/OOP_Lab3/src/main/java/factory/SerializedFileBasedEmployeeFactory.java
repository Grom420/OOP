package factory;

import humanresources.*;
import io.*;

//TODO эталонная фабрика - все остальные делай как она(DONE)
public class SerializedFileBasedEmployeeFactory extends EmployeeFactory {
    private String path;
    //todo сурс нужно создавать локально и только для менеджеров(DONE)

    public SerializedFileBasedEmployeeFactory(String path){
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
        //todo логика создания менеджеров ВО ВСЕХ ФАБРИКАХ ТАКАЯ!(DONE)
        GroupsManagerSerializedFileSource fs = new GroupsManagerSerializedFileSource(path);
        ControlledDepartamentManager manager = new ControlledDepartamentManager(groupsName);
        manager.setSource(fs);
        return manager;
    }

    @Override
    public GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees) {
        GroupsManagerSerializedFileSource fs = new GroupsManagerSerializedFileSource(path);
        ControlledDepartamentManager manager = new ControlledDepartamentManager(groupsName, employees);
        manager.setSource(fs);
        return manager;
    }

    @Override
    public GroupsManager createProjectManager() {
        GroupsManagerSerializedFileSource fs = new GroupsManagerSerializedFileSource(path);
        ControlledProjectManager manager = new ControlledProjectManager();
        manager.setSource(fs);
        return manager;
    }

    @Override
    public GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        GroupsManagerSerializedFileSource fs = new GroupsManagerSerializedFileSource(path);
        ControlledProjectManager manager = new ControlledProjectManager(employeeGroups);
        manager.setSource(fs);
        return manager;
    }
}
