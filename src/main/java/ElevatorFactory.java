public class ElevatorFactory {

    private static ElevatorFactory elevatorFactory;
    private ElevatorFactory(){}

    public static synchronized ElevatorFactory getInstance() {
        if (elevatorFactory == null)
            elevatorFactory = new ElevatorFactory();
        return elevatorFactory;
    }


    public Elevator createElevator(String id, int currentFloor) {
        return new Elevator(id, currentFloor);
    }

}
