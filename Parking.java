/**
 * Created by Paca on 3/21/14.
 */
public class Parking {
    private int cashier;
    private Pila parkPlace;
    private Pila auxParkPlace;

    public Parking() {
        cashier = 0;
        parkPlace = new PilaE();
        auxParkPlace = new PilaE();

    }

    public void addCar(Auto carToAdd){
        parkPlace.apilar(carToAdd);
        cashier = cashier + 5;
    }

    public void removeCar(String patentOfCarToRemove){
        if (parkPlace.verTope() != null){
            Auto carToAnalize = (Auto) parkPlace.verTope();
            try {
                while (!carToAnalize.getPatente().equals(patentOfCarToRemove)){
                    auxParkPlace.apilar(parkPlace.verTope());
                    parkPlace.desapilar();
                    carToAnalize = (Auto) parkPlace.verTope();

                }
            } catch (NullPointerException e){

            }
        }
        parkPlace.desapilar();

        while (auxParkPlace.verTope() != null){
            parkPlace.apilar(auxParkPlace.verTope());
            auxParkPlace.desapilar();
        }

    }

    public Parking(int cashier) {
        this.cashier = cashier;
    }
}
