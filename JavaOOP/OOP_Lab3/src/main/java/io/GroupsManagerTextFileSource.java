package io;

import humanresources.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupsManagerTextFileSource extends GroupsManagerFileSource {
    public GroupsManagerTextFileSource(String path) {
        setPath(path);
    }

    @Override
    public void load(EmployeeGroup employeeGroup) {
        try {
            Scanner scanner = new Scanner(path(employeeGroup));
            employeeGroup.setName(scanner.next());
            List<Employee> employees = loadEmployee(scanner);
            scanner.close();
            employeeGroup.clear();
            employeeGroup.addAll(employees);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalDatesException e) {
            e.printStackTrace();
        }
    }

    private List<Employee> loadEmployee(Scanner scanner) throws IOException, IllegalDatesException {
        int size = scanner.nextInt();
        List<Employee> employees = new ArrayList<>(size);
        String firstName;
        String lastName;
        String jobTitle;
        String description;
        String destination;
        LocalDateTime startTravel;
        LocalDateTime endTravel;
        int salary;
        int bonus;
        StaffEmployee staffEmployee;
        for (int i = 0; i < size; i++) {
            firstName = scanner.next();
            lastName = scanner.next();
            jobTitle = scanner.next();
            salary = scanner.nextInt();
            bonus = scanner.nextInt();
            if(bonus != 0) {
                staffEmployee = new StaffEmployee(firstName, lastName, JobTitilesEnum.valueOf(jobTitle), salary);
                description = scanner.next();
                destination = scanner.next();
                startTravel = LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 0, 0);
                endTravel = LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 0, 0);
                staffEmployee.add(new BusinessTravel(bonus, description, destination, startTravel, endTravel));
                employees.add(staffEmployee);
            }
            else
                employees.add(new PartTimeEmployee(firstName, lastName, salary));
        }
        return employees;
    }

    private void writeEmployee(PrintWriter outputStream, EmployeeGroup employeeGroup) throws IOException {
        BusinessTravel[] businessTravels;
        outputStream.println(employeeGroup.getName());
        outputStream.println(employeeGroup.size());
        for(Employee employee : employeeGroup){
            outputStream.println(employee.getFirstName());
            outputStream.println(employee.getSecondName());
            outputStream.println(employee.getJobTitle().toString());
            outputStream.println(employee.getSalary());
            if(employee.isTraveller()){
                outputStream.println(((StaffEmployee) employee).getBonus());
                businessTravels = ((StaffEmployee) employee).getTravels();
                for(BusinessTravel businessTravel : businessTravels){
                    outputStream.println(businessTravel.getCompensation());
                    outputStream.println(businessTravel.getDescription());
                    outputStream.println(businessTravel.getDestination());
                    outputStream.println(businessTravel.getStartBusinessTravel().getYear());
                    outputStream.println(businessTravel.getStartBusinessTravel().getMonthValue());
                    outputStream.println(businessTravel.getStartBusinessTravel().getDayOfMonth());
                    outputStream.println(businessTravel.getEndBusinessTravel().getYear());
                    outputStream.println(businessTravel.getEndBusinessTravel().getMonthValue());
                    outputStream.println(businessTravel.getEndBusinessTravel().getDayOfMonth());
                }
            }
            else
                outputStream.println(0);
        }
        outputStream.close();
    }

    @Override
    public void delete(EmployeeGroup employeeGroup) {
        try {
            Files.delete(Paths.get(getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store(EmployeeGroup employeeGroup) {
        try {
            PrintWriter writer = new PrintWriter(path(employeeGroup), "UTF-8");
            writeEmployee(writer, employeeGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void create(EmployeeGroup employeeGroup) {
        store(employeeGroup);
    }

    private String path(EmployeeGroup employeeGroup) {
        return getPath() + employeeGroup.getName() + ".txt";
    }
}
