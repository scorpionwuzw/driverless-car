package common;

import lombok.Data;

/**
 *  when car move out of the car park, it will throw a exception
 */
@Data
public class DriverlessCarException extends Exception{

    private int code;
    private String msg;


    public DriverlessCarException(){

    }

    public DriverlessCarException(String msg){
        super(msg);
        this.msg = msg;
    }

    public DriverlessCarException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public DriverlessCarException(ExceptionConstants exceptionConstants){
        super(exceptionConstants.getMsg());
        this.code = exceptionConstants.getCode();
        this.msg = exceptionConstants.getMsg();
    }
}
