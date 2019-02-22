package Task19;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task19 {

    public static void main(String[] args) throws IOException {

        Student stud = new Student();

        List<String> studList = null;

        try {
            studList = Files.readAllLines(Paths.get("C:\\Users\\dns\\IdeaProjects\\taskpp\\SharpLabz_Java\\src\\main\\resources\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student[] students = new Student[studList.size()];

        String buf = null;
        for (int i = 0; i < studList.size(); i++)
        {
            buf = studList.get(i);
            students[i] = Student.Parse(buf);//Инициализируем студентов
        }

        Arrays.sort(students, Student::compareTo);//Сортируем по убыванию среднего балла

        FileWriter fileWriter = new FileWriter("C:\\Users\\dns\\IdeaProjects\\taskpp\\SharpLabz_Java\\src\\main\\resources\\output.txt");

        for (int i = 0; i < studList.size(); i++)
        {
            fileWriter.write(String.format("%s\n", students[i].toString()));//Выводим отсортированный список
        }

        for (int i = 0; i < studList.size(); i++) {

            fileWriter.write(String.format("%s\n", students[i].Average()));//Выводим среднее аримфетическое для каждого студента
        }
        fileWriter.write(stud.PerfectStud(students, studList.size()).toString() + "\n");//лучшие студенты
        fileWriter.write(String.format("%f\n", stud.AverageInf(students, studList.size()))); //среднее арифметическое всех студентов по инфе
        fileWriter.write(String.format("%f\n",stud.AverageMath(students, studList.size())));// среднее арифм. всех студентов по матану
        fileWriter.write(String.format("%f\n",stud.AveragePhys(students, studList.size())));// среднее арифм всех студентов по физике
        fileWriter.flush();
    }
}

