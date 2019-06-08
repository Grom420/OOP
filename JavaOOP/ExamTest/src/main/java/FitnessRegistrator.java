import java.time.LocalDateTime;
import java.util.*;

public class FitnessRegistrator implements Comparator<Client> {
    private List<Client> clientsOfGym;
    private List<Client> clientsOfPool;
    private List<Client> clientsOfGroup;
    private FitnessLogger fitnessLogger;

    public FitnessRegistrator(){
        clientsOfGym = new ArrayList<>();
        clientsOfPool = new ArrayList<>();
        clientsOfGroup = new ArrayList<>();
        fitnessLogger = new FitnessLogger();
    }

    public void add(Client client, FitnessServiceEnumeration fitnessServiceEnumeration) throws NoAccessException, QueueException {
        if(client instanceof DayClient && !(client instanceof FullDayClient) && fitnessServiceEnumeration.equals(FitnessServiceEnumeration.POOL))
            throw new NoAccessException("Вам нельзя сюда");
        if(!(client instanceof DayClient) && fitnessServiceEnumeration.equals(FitnessServiceEnumeration.GROUP))
            throw new NoAccessException("У вас одноразовый абонемент");
        if(!(client instanceof DayClient) && LocalDateTime.now().getHour() < 8 || LocalDateTime.now().getHour() > 22)
            throw new NoAccessException("Время истекло");
        if(fitnessServiceEnumeration.equals(FitnessServiceEnumeration.POOL)){
            if(clientsOfPool.size() == 20)
                throw new QueueException("None");
            clientsOfPool.add(client);
            fitnessLogger.writer(enter(client));
        }
        if(fitnessServiceEnumeration.equals(FitnessServiceEnumeration.GYM)){
            if(clientsOfGym.size() == 20)
                throw new QueueException("None");
            clientsOfGym.add(client);
            fitnessLogger.writer(enter(client));
        }
        if(fitnessServiceEnumeration.equals(FitnessServiceEnumeration.GROUP)){
            if(clientsOfGroup.size() == 20)
                throw new QueueException("None");
            clientsOfGroup.add(client);
            fitnessLogger.writer(enter(client));
        }
    }

    public void delete(Client client){
        clientsOfGroup.remove(client);
        clientsOfPool.remove(client);
        clientsOfGym.remove(client);
    }

    private StringBuilder enter(Client client){
        StringBuilder sb = new StringBuilder();
        sb.append(client.getName()).append(" ").append(client.getLastName()).append(" ").append(client.getBirthday())
                .append(" ")
                .append(client.getDateOfRegistry()).append(" ");
        if(client instanceof DayClient){
            sb.append("DayClient ");
            sb.append(((DayClient) client).getEndDateOfRegistry());
        } else
            sb.append("Client");
        return sb;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GYM: ").append("\n");
        clientsOfGym.sort(this);
        clientsOfGroup.sort(this);
        clientsOfPool.sort(this);
        for(Client client : clientsOfGym){
            sb.append(enter(client));
            sb.append("\n");
        }
        sb.append("\n").append("POOL: ").append("\n");
        for(Client client : clientsOfPool){
            sb.append(enter(client));
            sb.append("\n");
        }
        sb.append("\n").append("GROUP: ").append("\n");
        for(Client client : clientsOfGroup){
            sb.append("\n");
            sb.append(enter(client));
        }
        return sb.toString();
    }

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
