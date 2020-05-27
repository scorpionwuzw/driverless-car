package util;

import common.RegularConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * project utils
 */
public class Utils {

    //log tool
    private final static Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * read first line of one file
     * @param fullFilePath
     * @return the first line of the file
     * @throws IOException
     */
    public static String readFirstLine(String fullFilePath) throws IOException {
        //first line text
        String lineTxt = null;
        //bufferedReader for file
        BufferedReader bufferedReader = null;
        //start to deal with file
        try {
            //start to read file
            File file=new File(fullFilePath);
            if(file.isFile() && file.exists()){
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), RegularConstants.UTF8));
                lineTxt = bufferedReader.readLine();
            }else{// if the file does not exist, it will generate a log
                logger.info("class Utils, method readLine, can not find file");
            }
        } catch (Exception e) {
            logger.info("class Utils, method readLine, read file error occurs", e);
        }finally {
            //close the bufferedReader
            bufferedReader.close();
        }
        //get line text and return
        return lineTxt;
    }
}
