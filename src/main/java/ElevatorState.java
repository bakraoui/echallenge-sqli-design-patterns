public abstract class ElevatorState {

    protected Elevator elevator ;
    public ElevatorState(Elevator elevator) {
        this.elevator = elevator;
    }
    abstract int  distanceFromFloor(int floor);
}
