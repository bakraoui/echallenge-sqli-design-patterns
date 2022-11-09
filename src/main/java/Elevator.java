public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState state = new RestState(this);

    public Elevator(String id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }
}
