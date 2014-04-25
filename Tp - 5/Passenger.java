/**
 * Created by Paca on 4/24/14.
 */
public class Passenger {
    private int initialTime;

    public Passenger(int initialTime){
        this.initialTime = initialTime;
    }

    public int getPassengerWaitingTime(int endTime){
        return endTime - initialTime;
    }
}
