import List.*;
import Queue.*;

/**
 * Created by Paca on 4/24/14.
 */
public class Station {
    private List windows;
    private Queue line;
    int amountOfWindows;

    public Station(int amountOfWindows){
        this.amountOfWindows =  amountOfWindows;
        windows = new EList();
        for (int i = 0; i < amountOfWindows ; i++) {
            windows.insertBefore(new Window());
        }
        line = new QueueD();
    }

    public void starDay(){
        for (int i = 0; i < 57600 ; i++) {

            if (i % 10 == 0){
                for (int j = 0; j < 5 ; j++) {
                    line.enqueue(new Passenger(i));
                }
            }
            operateWindows(i);
        }

        getInfo();
    }

    private void getInfo(){
        for (int i = 0; i < amountOfWindows ; i++) {
            windows.goTo(i);
            Window auxWindow = (Window) windows.seeActual();

            System.out.println("\nVentanilla " + i + ": ");
            System.out.println("Tiempo de espera promedio por pasajero: " + auxWindow.getAverageWaitingTime());
            System.out.println("Monto recaudado: " + auxWindow.getCashier());
            System.out.println("Tiempo ocioso de cada ventanilla: " + auxWindow.getFreeTime());

        }
    }

    private void operateWindows(int time){
        for (int i = 0; i < amountOfWindows ; i++) {
            windows.goTo(i);
            Window windowToOperate = (Window) windows.seeActual();

            if (time < 57570){
                if (!line.isEmpty()){
                    operateWindow(windowToOperate, time);
                }else if (windowToOperate.isFree()){
                    windowToOperate.addOneToFreeTime();
                }
            }else if(windowToOperate.getPassenger() != null){
                windowToOperate.setFree(true);
                windowToOperate.pay();
                windowToOperate.plusPassengerAttended();
                windowToOperate.setTotalPassengerWaitingTime(windowToOperate.getPassenger().getPassengerWaitingTime(time));
            }
        }
    }

    private void operateWindow(Window windowToOperate,int time){
        if (windowToOperate.isFree()){
            windowToOperate.setFree(false);
            windowToOperate.setPassenger((Passenger) line.dequeue());
        }else {
            if (time % 10 == 0 && windowToOperate.getPassenger() != null){
                if ((int) (Math.random() * 3) + 1 == 1){
                    windowToOperate.setFree(true);
                    windowToOperate.pay();
                    windowToOperate.plusPassengerAttended();
                    windowToOperate.setTotalPassengerWaitingTime(windowToOperate.getPassenger().getPassengerWaitingTime(time));
                }
            }

        }
    }
}
