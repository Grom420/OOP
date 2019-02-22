package Task17;

public class Time{

    private int seconds;
    private int minutes;
    private int hours;

    public Time(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }



    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) throws ExSeconds {
        if (seconds < 0 || seconds > 59)
            throw new ExSeconds();
        else
            this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) throws ExMinutes {
        if (minutes < 0 || minutes > 59)
            throw new ExMinutes();
        else
            this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) throws ExHours {
        if (hours < 0 || hours > 23)
            throw  new ExHours();
        else
            this.hours = hours;
    }
}
