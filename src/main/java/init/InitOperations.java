package init;

import common.RegularConstants;
import common.Orientation;
import dto.CurrentPositionDto;
import dto.CarParkSizeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Utils;

import java.io.IOException;

public class InitOperations {

    private final static Logger logger = LoggerFactory.getLogger(InitOperations.class);

    /**
     * init current position
     * @return
     */
    public CurrentPositionDto initCurrentPosition(){
        CurrentPositionDto currentPositionDto = CurrentPositionSingleton.getSingleInstance();
        try {
            //read file to get init position of the driverless car
            String filePath = this.getClass().getClassLoader().getResource(RegularConstants.INIT_CURRENT_POSTIION_FILE).getPath();
            String line = Utils.readFirstLine(filePath);
            String[] currentPositions = line.split(RegularConstants.COMMA);
            currentPositionDto.setPositionX(Integer.parseInt(currentPositions[0]));
            currentPositionDto.setPositionY(Integer.parseInt(currentPositions[1]));
            currentPositionDto.setOrientation(Orientation.getOrientationByKey(Integer.parseInt(currentPositions[2])));
        } catch (IOException e) {
            logger.info("class InitOperations, method initCurrentPosition error occurs!", e);
        }
        logger.info("driverless car's current position. positionX: "+currentPositionDto.getPositionX()+"; positionY: "+currentPositionDto.getPositionY()+"; orientation: "+currentPositionDto.getOrientation());
        return currentPositionDto;
    }

    /**
     * init car park size
     * @return
     */
    public CarParkSizeDto initCarParkDto(){
        CarParkSizeDto carParkSizeDto = new CarParkSizeDto();
        try {
            //read file to get init car park size of the driverless car
            String filePath = this.getClass().getClassLoader().getResource(RegularConstants.INIT_CAR_PARK_SIZE_FILE).getPath();
            String line = Utils.readFirstLine(filePath);
            String[] rectangleParams = line.split(RegularConstants.COMMA);
            carParkSizeDto.setLength(Integer.parseInt(rectangleParams[0]));
            carParkSizeDto.setWidth(Integer.parseInt(rectangleParams[1]));
        } catch (IOException e) {
            logger.info("class InitOperations, method initRectangleDto error occurs!", e);
        }
        return carParkSizeDto;
    }
}
