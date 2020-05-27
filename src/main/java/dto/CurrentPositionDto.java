package dto;

import lombok.Data;
import common.Orientation;

/**
 *  current postion of the driverless car object
 */

@Data
public class CurrentPositionDto {

    /**
     *  positionX
     */
    private int positionX;

    /**
     *  positionY
     */
    private int positionY;

    /**
     * orientation
     */
    private Orientation orientation;
}
