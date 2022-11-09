import java.util.HashMap;
import java.util.Map;

/*
* @author bakraoui ayoub
* @date   27-10-2022
* */
public class Building {

    /*
    * @param numberOfFloors : total number of floors in the building
    * */
    private final int numberOfFloors;


    /*
     * @param listElevators : list of elevators
     * */
    private Map<String,Elevator> listElevators = new HashMap<>();

    /*
     * @param dispatcher : class that requestElevator method delegated to it
     * */
    Dispatcher dispatcher = new Dispatcher();

    public Building(int numberOfFloor, String ...elevators) {
        this.numberOfFloors = numberOfFloor;

        ElevatorFactory factory = ElevatorFactory.getInstance();

        // elevators
        for (String el : elevators) {
            /*
             * split elevator
             * elevatorArray[0] : elevatorId
             * elevatorArray[1] : currentFloor
             */
            String[] elevatorArray = el.split(":");

            Elevator  elevator = factory.createElevator(
                            elevatorArray[0],
                            Integer.parseInt(elevatorArray[1])
                        );

            /* add elevator to the Map */
            listElevators.put(elevatorArray[0], elevator );
        }

    }

    // Elevators getter
    public Map<String, Elevator> getListElevators() {
        return listElevators;
    }
    public void setListElevators(Map<String, Elevator> listElevators) {
        this.listElevators = listElevators;
    }

    // numberOfFloor getter and setter
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /*
    * @method change the state of the given elevator to the given state UP - DOWN
    * @param take two params : elevator id , state
    * @return : void
    * */
    void move(String elevatorId, String state ) {
        Elevator elevator = listElevators.get(elevatorId); // get elevator by id
        ElevatorState st;
        switch (state) {
            case "UP" -> st = new UpState(elevator);

            case "DOWN" -> st = new DownState(elevator);

            default -> st = new RestState(elevator);
        }
        elevator.setState(st); // change elevator state
    }


    /*
     * @method to stop/ block the elevator
     * @param take two params : elevator id , floor where elevator blocked
     * @return : void
     * */
    void stopAt(String id, int floor) {
        Elevator elevator = listElevators.get(id);
        elevator.setCurrentFloor(floor);
        elevator.setState(new StopState(elevator));
    }

    /*
     * @method request an elevator from a given floor
     * @param take one params : direction
     * @return : id of the closest elevator
     * */
    public String requestElevator(int floor) {
        return dispatcher.getClosestElevatorTo(listElevators, floor);
    }

    /*
     * @method request an elevator from top floor
     * @return : id of the closest elevator
     * */
    public String requestElevator() {
        return dispatcher.getClosestElevatorTo(listElevators, numberOfFloors);
    }

}
