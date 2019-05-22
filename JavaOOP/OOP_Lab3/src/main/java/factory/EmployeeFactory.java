package factory;

import humanresources.AlreadyAddedException;
import humanresources.Employee;
import humanresources.EmployeeGroup;
import humanresources.GroupsManager;

public abstract class EmployeeFactory {
   public abstract EmployeeGroup createDepartment();
   public abstract EmployeeGroup createDepartment(int capacity);
   public abstract EmployeeGroup createDepartment(String name);
   public abstract EmployeeGroup createDepartment(String name, int capacity);
   public abstract EmployeeGroup createDepartment(String name, Employee[] employees);
   public abstract EmployeeGroup createDepartment(EmployeeGroup employeeGroup);
   public abstract EmployeeGroup createProject();
   public abstract EmployeeGroup createProject(String name);
   public abstract EmployeeGroup createProject(String name, Employee[] employees) throws AlreadyAddedException;
   public abstract GroupsManager createDepartmentManager(String groupsName);
   public abstract GroupsManager createDepartmentManager(String groupsName, EmployeeGroup[] employees);
   public abstract GroupsManager createProjectManager();
   public abstract GroupsManager createProjectManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException;

   static public EmployeeFactory getEmployeeFactory(EmployeesFactoryTypesEnumeration type, String path) {
      switch (type){
         case ORDINARY_GROUPS_FACTORY:
            return new OrdinaryEmployeeFactory();
         case TEXT_FILE_BASED_GROUPS_FACTORY:
            return new TextFileBasedEmployeeFactory(path);
         case BINARY_FILE_BASED_GROUPS_FACTORY:
            return new  BinaryFileBasedEmployeeFactory(path);
         case SERIALIZED_FILE_ASED_GROUPS_FACTORY:
            return new SerializedFileBasedEmployeeFactory(path);
         case SOCKET_BASED_GROUPS_FACTORY:
            return null;
      }
      return null;
   }
}
