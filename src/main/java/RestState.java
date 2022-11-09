public class RestState extends ElevatorState{


    public RestState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public int distanceFromFloor(int floor) {
        return Math.abs(floor - elevator.getCurrentFloor());
    }

}
