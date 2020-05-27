package service;

import common.DriverlessCarException;
import common.Orientation;
import dto.CurrentPositionDto;

/**
 * operations about driverless car
 */
public interface DriverlessCarService {

    /**
     * driverless car's move operation
     * @param orientation direction which the car will move
     * @param steps step times whitch the car will move
     */
    void move(Orientation orientation, int steps) throws DriverlessCarException;

    /**
     * return current position of the car
     * @return current position include positionX, positionY and orientation
     */
    CurrentPositionDto getCurrentPosition();
}
