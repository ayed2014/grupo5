package Bank;

/**
 * Created by Paca on 4/11/14.
 */
public class BankWindow {
    Boolean imFree;
    int timeBeingBusy;
    int amountOfPeopleAttended;
    int timeBeingFree;

    public BankWindow() {
        imFree = true;
        amountOfPeopleAttended = 0;
        timeBeingBusy = 0;
        timeBeingFree = 0;
    }

    public void setImFree(Boolean imFree) {
        this.imFree = imFree;
    }

    public void addOneAmountOfPeopleAttended() {
        amountOfPeopleAttended ++;
    }

    public Boolean getImFree() {
        return imFree;
    }

    public int getTimeBeingBusy() {
        return timeBeingBusy;
    }

    public int getAmountOfPeopleAttended() {
        return amountOfPeopleAttended;
    }

    public void addOneSecondToTimeBeingBusy(){
        timeBeingBusy ++;
    }

    public void addOneToTimeBeingFree(){
        timeBeingFree ++;
    }

    public int getTimeBeingFree(){
        return timeBeingFree;
    }

    public void resetTimeBeingBusy(){
        timeBeingBusy = 0;
    }
}
