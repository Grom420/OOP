package psuti.pp.exam.backend.mock;

import psuti.pp.exam.backend.DataService;
import psuti.pp.exam.backend.data.Person;
import sun.plugin.javascript.navig4.Layer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.*;
import java.io.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterDataService extends DataService {
    private static FilterDataService INSTANCE;

    /**
     * filters - набор фильтров имя-значение.
     * Название поля фильтра указывается как "name" или "county"
     * */

    private FilterDataService(HashMap<String,String> filters) throws IOException {
        //TODO УБРАТЬ ИСКЛЮЧЕНИЕ И НАПИСАТЬ ЛОГИКУ КОТОРАЯ БУДЕТ НА ОСНОВЕ ФИЛЬТРОВ ОТКИДЫВАТЬ СПИСОК ОБЪЕКТОВ ТИПА PERSON


        throw new NotImplementedException();
    }

    public synchronized static DataService getInstance(HashMap<String,String> filters) throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new FilterDataService(filters);
        }
        return INSTANCE;
    }

    /***
     * Должен возвращать список отфильтрованных людей, надо учесть переполнение и если записей слишком много то
     * не стоит все их выводить
     */


    @Override
    public synchronized List<Person> getAllPersons() throws IOException {
        //TODO ВОЗВРАЩЕНИЕ СПИСКА ЛЮДЕЙ


        throw new NotImplementedException();
    }

}
class WriterJAXB {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\U_LIVT3-410-12\\IdeaProjects\\examthirdday_koloyarskiy\\DB\\Fiz_DB\\ins2.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line = null;

        WriterJAXB writerJAXB = new WriterJAXB();
        int count = 1;
        Person person = new Person();
        OutputStream os = new FileOutputStream("C:\\Users\\U_LIVT3-410-12\\IdeaProjects\\examthirdday_koloyarskiy\\DB\\Fiz_DB\\file.xml");
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {

            String[] line1 = line.split("\t");
            person.setId(count);
            person.setFirstName(line1[5]);
            person.setSecondName(line1[6]);
            person.setMiddleName(line1[7]);
            person.setDocNumber(line1[1]);
            writerJAXB.addXml(person, os);
            count++;
        }
    }

        public static void addXml(Person person, OutputStream os){

            try {


                JAXBContext jc =  JAXBContext.newInstance(Person.class);
                Marshaller m = jc.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(person, os);

                os.flush();
            } catch (JAXBException | IOException e) {e.printStackTrace();}
        }
}
