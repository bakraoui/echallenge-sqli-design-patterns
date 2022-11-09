import java.util.Collection;
import java.util.Map;

public class Dispatcher {


    /*
     * @method get the closest elevator to the given floor
     * @param take two params : list of elevators, direction
     * @return : id of the closest elevator
     * */
    public String getClosestElevatorTo(Map<String, Elevator> elevatorMap, int floor) {

        Collection<Elevator> elevators = elevatorMap.values();
        int min = Integer.MAX_VALUE;
        String id = "";
        for (Elevator e: elevators ) {
            int distance = e.getState().distanceFromFloor(floor);
            if ( distance < min  ){
                min = distance;
                id = e.getId();
            }
        }
        return id;
    }
}
