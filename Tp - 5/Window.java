/**
 * Created by Paca on 4/24/14.
 */
public class Window {
    private boolean isFree;
    private double cashier;
    private int freeTime;
    private int totalPassengersWaitingTime;
    private int passengersAttended;
    private Passenger passenger;

    public Window(){
        isFree = true;
        cashier = 0;
        freeTime = 0;
        totalPassengersWaitingTime = 0;
        passengersAttended = 0;
    }

    public boolean isFree() {
        return isFree;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public double getCashier() {
        return cashier;
    }

    public void pay() {
        cashier += 0.7;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void addOneToFreeTime() {
        freeTime ++;
    }

    public void setTotalPassengerWaitingTime(int waitingTime){
        totalPassengersWaitingTime += waitingTime;
    }

    public int getTotalPassengersWaitingTime() {
        return totalPassengersWaitingTime;
    }

    public int getPassengersAttended() {
        return passengersAttended;
    }

    public void plusPassengerAttended() {
        passengersAttended ++;
    }

    public int getAverageWaitingTime(){
        return (int) (totalPassengersWaitingTime/passengersAttended);
    }
}
