package common;

/**
 * some exception constants defined here
 */
public enum  ExceptionConstants {

    // current position is out of car park
    OUT_CAR_PARK_EXCEPTION(100001, "current position is out of car park");


    private int code;
    private String msg;

    ExceptionConstants(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public int getCode(){
        return this.code;
    }
}
