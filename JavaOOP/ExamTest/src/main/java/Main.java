import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws NoAccessException, QueueException {

        Client client1 = new DayClient("Дмитрий", "Колоярский", LocalDateTime.of(1999, 12, 4, 0,0 ));
        Client client2 = new FullDayClient("Алексей", "Костюков", LocalDateTime.of(1999, 12, 4, 0,0 ));
        Client client3 = new Client("Даниил", "Кириллов", LocalDateTime.of(1999, 12, 4, 0,0 ));
        FitnessRegistrator registrator = new FitnessRegistrator();
        registrator.add(client3, FitnessServiceEnumeration.GYM);
        registrator.add(client2, FitnessServiceEnumeration.POOL);
        registrator.add(client1, FitnessServiceEnumeration.GYM);
        System.out.println(registrator.toString());
    }
}
