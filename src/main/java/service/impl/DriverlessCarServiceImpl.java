package service.impl;

import common.DriverlessCarException;
import common.ExceptionConstants;
import dto.CurrentPositionDto;
import dto.CarParkSizeDto;
import init.CurrentPositionSingleton;
import init.InitOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DriverlessCarService;
import common.Orientation;

/**
 * operations about driverless car
 */
public class DriverlessCarServiceImpl implements DriverlessCarService {

    private final static Logger logger = LoggerFactory.getLogger(DriverlessCarServiceImpl.class);

    /**
     * driverless car's move operation
     * @param orientation direction which the car will move
     * @param steps step times whitch the car will move
     */
    public void move(Orientation orientation, int steps) throws DriverlessCarException {
        //get car's current position
        CurrentPositionDto currentPositionDto = getCurrentPosition();
        //set car's orientation
        currentPositionDto.setOrientation(orientation);
        //once orientation is defined, it will start to calculate the target position by steps
        if(Orientation.EAST == orientation){
            currentPositionDto.setPositionX(currentPositionDto.getPositionX() + steps);
        }else if(Orientation.WEST == orientation){
            currentPositionDto.setPositionX(currentPositionDto.getPositionX() - steps);
        }else if(Orientation.SOUTH == orientation){
            currentPositionDto.setPositionY(currentPositionDto.getPositionY() - steps);
        }else{
            currentPositionDto.setPositionY(currentPositionDto.getPositionY() + steps);
        }
        logger.info("After moved, the driverless car's position. positionX: "+currentPositionDto.getPositionX()+"; positionY: "+currentPositionDto.getPositionY()+"; orientation: "+currentPositionDto.getOrientation());
        //it will throw exception, if the car is out of car park
        if(isOutOfPark(currentPositionDto)){
            throw new DriverlessCarException(ExceptionConstants.OUT_CAR_PARK_EXCEPTION);
        }
    }

    /**
     * return current position of the car
     * @return current position include positionX, positionY and orientation
     */
    public CurrentPositionDto getCurrentPosition() {
        return CurrentPositionSingleton.getSingleInstance();
    }

    /**
     * true means the car is out of car park
     * @param currentPositionDto
     * @return
     */
    private boolean isOutOfPark(CurrentPositionDto currentPositionDto){
        //get car park size
        CarParkSizeDto carParkSizeDto = new InitOperations().initCarParkDto();
        int length = carParkSizeDto.getLength();
        int width = carParkSizeDto.getWidth();
        //get car's current position
        int positionX = currentPositionDto.getPositionX();
        int positionY = currentPositionDto.getPositionY();

        //if the car is in the car park size, it will return false
        if (length>=positionX && positionX>=0 && width>=positionY && positionY>=0){
            return false;
        }

        //if the car is out of the park size, it will return true;
        return true;
    }
}
