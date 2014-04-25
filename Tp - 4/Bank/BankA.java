package Bank;
import Queue.*;

/**
 * Created by Paca on 4/11/14.
 */
public class BankA {
    BankWindow window1;
    BankWindow window2;
    BankWindow window3;

    int peopleAttendedUntil15;
    int peopleAttended;
    int freeTimeWindow1;
    int freeTimeWindow2;
    int freeTimeWindow3;

    QueueD line;

    public BankA(){
        window1 = new BankWindow();
        window2 = new BankWindow();
        window3 = new BankWindow();

        line = new QueueD();
    }

    public void starDay(){
        for (int i = 0; i <= 15 ; i++) {
            line.enqueue(new Person());
        }

        for (int i = 0; i < 18000 ; i++) {
            if (i % 90 == 0){
                line.enqueue(new Person());
            }
            operateWindow1();
            operateWindow2();
            operateWindow3();
        }
        peopleAttendedUntil15 = window1.getAmountOfPeopleAttended() + window2.getAmountOfPeopleAttended() + window3.getAmountOfPeopleAttended();

        while (!line.isEmpty()){
            operateWindow1();
            if (!line.isEmpty()){
                operateWindow2();
            }
            if (!line.isEmpty()){
                operateWindow3();
            }
        }
        peopleAttended = window1.getAmountOfPeopleAttended() + window2.getAmountOfPeopleAttended() + window3.getAmountOfPeopleAttended();

        freeTimeWindow1 = window1.getTimeBeingFree();
        freeTimeWindow2 = window2.getTimeBeingFree();
        freeTimeWindow3 = window3.getTimeBeingFree();


    }

    private void operateWindow1(){
        if (window1.getImFree()){
            if (!line.isEmpty()){
                line.dequeue();
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
            if (!line.isEmpty()){
                line.dequeue();
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
            if (!line.isEmpty()){
                line.dequeue();
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

    public int getPeopleAttendedUntil15(){
        return peopleAttendedUntil15;
    }

    public int getPeopleAttended(){
        return peopleAttended;
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
}
