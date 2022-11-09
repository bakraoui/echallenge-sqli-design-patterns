public class DownState extends ElevatorState{


    public DownState(Elevator elevator) {
        super(elevator);
    }


    @Override
    public int distanceFromFloor(int floor) {
        int currentFloor = elevator.getCurrentFloor();
        int distance ;

        if (currentFloor <= floor ) {
            distance = currentFloor +  floor;
        }else {
            distance = Math.abs(floor - currentFloor);
        }

        return distance;
    }
}
