package init;

import dto.CurrentPositionDto;

/**
 * CurrentPositionSingleton which always contains driverless car current position
 * it would be single instance and shared by whole situation or system
 */
public class CurrentPositionSingleton {

    //init CurrentPositionDto object
    private static CurrentPositionDto instance = new CurrentPositionDto();

    //private constructor method
    private CurrentPositionSingleton(){}

    //get init single instance
    public static CurrentPositionDto getSingleInstance(){
        return instance;
    }
}
