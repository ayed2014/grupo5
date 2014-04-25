package Bank;
import Queue.*;
import org.omg.CORBA._PolicyStub;

/**
 * Created by Paca on 4/11/14.
 */
public class BankB {
    BankWindow window1;
    BankWindow window2;
    BankWindow window3;

    QueueD line1;
    QueueD line2;
    QueueD line3;

    int freeTimeWindow1;
    int freeTimeWindow2;
    int freeTimeWindow3;

    int peopleAttendedUntil15;
    int peopleAttended;

    public BankB(){
        window1 = new BankWindow();
        window2 = new BankWindow();
        window3 = new BankWindow();

        line1 = new QueueD();
        line2 = new QueueD();
        line3 = new QueueD();
    }

    public void starDay(){
        for (int i = 0; i < 5 ; i++) {
            line1.enqueue(new Person());
        }

        for (int i = 0; i < 5 ; i++) {
            line2.enqueue(new Person());
        }

        for (int i = 0; i < 5 ; i++) {
            line3.enqueue(new Person());
        }

        for (int i = 0; i < 18000 ; i++) {
            if (i % 90 == 0){
                enqueueToBestLine(new Person());
            }
            operateWindow1();
            operateWindow2();
            operateWindow3();
        }

        peopleAttendedUntil15 = window1.getAmountOfPeopleAttended() + window2.getAmountOfPeopleAttended() + window3.getAmountOfPeopleAttended();

        while (!line1.isEmpty()){
            operateWindow1();
        }

        while (!line2.isEmpty()){
            operateWindow2();
        }

        while (!line3.isEmpty()){
            operateWindow3();
        }

        peopleAttended = window1.getAmountOfPeopleAttended() + window2.getAmountOfPeopleAttended() + window3.getAmountOfPeopleAttended();

        freeTimeWindow1 = window1.getTimeBeingFree();
        freeTimeWindow2 = window2.getTimeBeingFree();
        freeTimeWindow3 = window3.getTimeBeingFree();
    }

    private void enqueueToBestLine(Person personToEnqueue){
        int randomBetweenTwo = (int) (Math.random() * 2 + 1);
        int randomBetweenThree = (int) (Math.random() * 3 + 1);

        if (line1.lenght() == line2.lenght() && line1.lenght() == line3.lenght() ){
            if (randomBetweenThree == 1){
                line1.enqueue(personToEnqueue);
            }else if (randomBetweenThree == 2){
                line2.enqueue(personToEnqueue);
            }else {
                line3.enqueue(personToEnqueue);
            }
        } else if (line1.lenght() < line3.lenght() && line1.lenght() == line2.lenght()){
            if (randomBetweenTwo == 1){
                line1.enqueue(personToEnqueue);
            } else {
                line2.enqueue(personToEnqueue);
            }
        } else if (line1.lenght() < line2.lenght() && line1.lenght() == line3.lenght()){
            if (randomBetweenTwo == 1){
                line1.enqueue(personToEnqueue);
            }else {
                line3.enqueue(personToEnqueue);
            }
        } else if (line2.lenght() < line1.lenght() && line2.lenght() == line3.lenght()){
            if (randomBetweenTwo == 1){
                line2.enqueue(personToEnqueue);
            }else {
                line3.enqueue(personToEnqueue);
            }
        } else if (line3.lenght() < line1.lenght() && line3.lenght() < line2.lenght()){
            line3.enqueue(personToEnqueue);
        } else if (line2.lenght() < line1.lenght() && line2.lenght() < line3.lenght()){
            line2.enqueue(personToEnqueue);
        } else {
            line1.enqueue(personToEnqueue);
        }
    }

    private void operateWindow1(){
        if (window1.getImFree()){
            if (!line1.isEmpty()){
                line1.dequeue();
                window1.setImFree(false);
                window1.addOneAmountOfPeopleAttended();
            }else {
                window1.addOneToTimeBeingFree();
            }
        } else {
            if (window1.getTimeBeingBusy() >= 30){
                if ((int)(Math.random() * (90 - window1.getTimeBeingBusy()) + 1) == 1 ){
                    window1.setImFree(true);
                    window1.resetTimeBeingBusy();
                }
            }
            window1.addOneSecondToTimeBeingBusy();

        }
    }

    private void operateWindow2(){
        if (window2.getImFree()){
            if (!line2.isEmpty()){
                line2.dequeue();
                window2.setImFree(false);
                window2.addOneAmountOfPeopleAttended();
            }else {
                window2.addOneToTimeBeingFree();
            }
        } else {
            if (window2.getTimeBeingBusy() >= 30){
                if ((int)(Math.random() * (120 - window2.getTimeBeingBusy()) + 1) == 1 ){
                    window2.setImFree(true);
                    window2.resetTimeBeingBusy();
                }
            }
            window2.addOneSecondToTimeBeingBusy();
        }
    }


    private void operateWindow3(){
        if (window3.getImFree()){
            if (!line3.isEmpty()){
                line3.dequeue();
                window3.setImFree(false);
                window3.addOneAmountOfPeopleAttended();
            }else {
                window3.addOneToTimeBeingFree();
            }
        } else {
            if (window3.getTimeBeingBusy() >= 30){
                if ((int)(Math.random() * (150 - window3.getTimeBeingBusy()) + 1) == 1 ){
                    window3.setImFree(true);
                    window3.resetTimeBeingBusy();
                }
            }
            window3.addOneSecondToTimeBeingBusy();

        }
    }

    public int getFreeTimeWindow1() {
        return freeTimeWindow1;
    }

    public int getFreeTimeWindow2() {
        return freeTimeWindow2;
    }

    public int getFreeTimeWindow3() {
        return freeTimeWindow3;
    }

    public int getPeopleAttendedUntil15() {
        return peopleAttendedUntil15;
    }

    public int getPeopleAttended() {
        return peopleAttended;
    }
}
