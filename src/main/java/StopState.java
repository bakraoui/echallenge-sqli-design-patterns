public class StopState extends ElevatorState{
    public StopState(Elevator elevator) {
        super(elevator);
    }


    @Override
    int distanceFromFloor(int floor) {
        return Integer.MAX_VALUE;
    }
}
