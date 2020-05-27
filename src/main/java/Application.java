import common.DriverlessCarException;
import common.Orientation;
import dto.CarParkSizeDto;
import init.InitOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.impl.DriverlessCarServiceImpl;

/**
 * application entry point
 */
public class Application {
    //logger
    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     *  application entry point
     * @param args
     */
    public static void main(String[] args){
        InitOperations initOperations = new InitOperations();
        //init car's current position
        initOperations.initCurrentPosition();
        //init car park size
        CarParkSizeDto carParkSizeDto = initOperations.initCarParkDto();
        logger.info("driverless car's car park size. length: "+ carParkSizeDto.getLength()+"; width: "+ carParkSizeDto.getWidth());

        //car move forward by step times in different direction
        int steps = 4;
        // car will move in the orientation
        Orientation orientation = Orientation.NORTH;
        try {// car start to move
            new DriverlessCarServiceImpl().move(orientation, steps);
        } catch (DriverlessCarException e) {//when car move out of the car park, it will throw Exception
            logger.error("car is going to drive out of the car park",e, e.getMessage());
        }
    }
}
