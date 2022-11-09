public class UpState extends ElevatorState{

    public UpState(Elevator elevator) {
        super(elevator);
    }


    @Override
    public int distanceFromFloor(int floor) {
        int currentFloor = elevator.getCurrentFloor();
        int distance ;

        if (currentFloor <= floor ) {
            distance = Math.abs(floor - currentFloor);
        }else {
            distance = 10 - currentFloor + 10 - floor;
        }
        return distance;
    }
}
