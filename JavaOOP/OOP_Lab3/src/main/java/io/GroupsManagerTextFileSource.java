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
        //todo ДОлго и муторно считываешь данные из файла и на основе этих данных создаешь новых эмплоев и заменяешь ими имеющийеся(DONE)
        //todo затем набиваешь новых эмплоев, инфу о которых считал из файла(DONE)
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
        outputStream.write(employeeGroup.getName());
        outputStream.write(employeeGroup.size());
        for(Employee employee : employeeGroup){
            outputStream.write(employee.getFirstName());
            outputStream.write(employee.getSecondName());
            outputStream.write(employee.getJobTitle().toString());
            outputStream.write(employee.getSalary());
            if(employee.isTraveller()){
                outputStream.write(((StaffEmployee) employee).getBonus());
                businessTravels = ((StaffEmployee) employee).getTravels();
                for(BusinessTravel businessTravel : businessTravels){
                    outputStream.write(businessTravel.getCompensation());
                    outputStream.write(businessTravel.getDescription());
                    outputStream.write(businessTravel.getDestination());
                    outputStream.write(businessTravel.getStartBusinessTravel().getYear());
                    outputStream.write(businessTravel.getStartBusinessTravel().getMonthValue());
                    outputStream.write(businessTravel.getStartBusinessTravel().getDayOfMonth());
                    outputStream.write(businessTravel.getEndBusinessTravel().getYear());
                    outputStream.write(businessTravel.getEndBusinessTravel().getMonthValue());
                    outputStream.write(businessTravel.getEndBusinessTravel().getDayOfMonth());
                }
            }
            else
                outputStream.write(0);
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
            //todo ДОлго и муторно записываешь все поля всех эмплоев в файл writeUtf, writeInt, writeDouble(DONE)
            writeEmployee(writer, employeeGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //todo с удалением и созданием та же фигня, что и BinaryFileSource(DONE)

    @Override
    public void create(EmployeeGroup employeeGroup) {
        store(employeeGroup);
    }

    private String path(EmployeeGroup employeeGroup) {
        return employeeGroup.getName() + ".txt";
    }
}
