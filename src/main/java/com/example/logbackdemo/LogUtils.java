package com.example.logbackdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志相关公用方法
 */
public class LogUtils {

    private static final Logger logger= LoggerFactory.getLogger(LogUtils.class);

    /**
     * 获取调用者方法，类名、方法名、行数
     * @return
     */
    public static String getLineInfo() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        //ClassName(调用类)：LogUtils.java, Method(调用方法名)：getLineInfo, Line(行号)：15
        return ("ClassName(调用类)：" + ste.getFileName() + ", Method(调用方法名)：" + ste.getMethodName() + ", Line(行号)：" + ste.getLineNumber());
    }

    /**
     * 获取传入值所在类名、方法、行数
     * @param ste
     * @return
     */
    public static String getLineInfo(StackTraceElement ste) {
        //ClassName(调用类)：*.java, Method(调用方法名)：*, Line(行号)：*
        return ("ClassName(调用类)：" + ste.getFileName() + ", Method(调用方法名)：" + ste.getMethodName() + ", Line(行号)：" + ste.getLineNumber());
    }

    public static void info(Logger logger,StackTraceElement ste,String msg){
        if(logger.isInfoEnabled()){
            logger.info(getLineInfo(ste)+"\n\t\t>>>>>>>>>>>>>>>>>:{}",msg);
        }
    }

    public static void info(Logger logger,String msg){
        if(logger.isInfoEnabled()){
            logger.info(getLineInfo(Thread.currentThread().getStackTrace()[2])+"\n\t\t>>>>>>>>>>>>>>>>>:{}",msg);
        }
    }

    public static void error(Logger logger,StackTraceElement ste,String msg){
        if(logger.isErrorEnabled()){
            logger.error(getLineInfo(ste)+"\n\t\t>>>>>>>>>>>>>>>>>:{}",msg);
        }
    }

    public static void error(Logger logger,String msg){
        if(logger.isErrorEnabled()){
            logger.error(getLineInfo(Thread.currentThread().getStackTrace()[2])+"\n\t\t>>>>>>>>>>>>>>>>>:{}",msg);
        }
    }

    public static void error(Logger logger,StackTraceElement ste,Throwable throwable){
        if(logger.isErrorEnabled()){
            logger.error(getLineInfo(ste)+"\n\t\t>>>>>>>>>>>>>>>>>:{}"+throwable.getMessage(),throwable);
        }
    }

    public static void error(Logger logger,Throwable throwable){
        if(logger.isErrorEnabled()){
            logger.error(getLineInfo(Thread.currentThread().getStackTrace()[2])+"\n\t\t>>>>>>>>>>>>>>>>>:{}"+throwable.getMessage(),throwable);
        }
    }

    public static void debug(Logger logger,StackTraceElement ste,String msg){
        if(logger.isDebugEnabled()){
            logger.debug(getLineInfo(ste)+"\n\t\t>>>>>>>>>>>>>>>>>:{}",msg);
        }
    }

    public static void debug(Logger logger,String msg){
        if(logger.isDebugEnabled()){
            logger.debug(getLineInfo(Thread.currentThread().getStackTrace()[2])+"\n\t\t>>>>>>>>>>>>>>>>>:{}",msg);
        }
    }

    public static String getSource() {

        // 自动获取调用者的方法名
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];// 获取第3个元素，第0个元素为
        // stackTrace参数，第1个为本方法的参数，第2个元素为调用者的参数
        // 第3个元素为调用者的调用者参数
        String className = ste.getClassName();// 获取调用者的类名
        String methodName = ste.getMethodName();// 获取调用者的方法名
        int lineNumber = ste.getLineNumber();// 获取行号

        String source = "调用类:" + className + ",调用方法名:" + methodName + ";行号:" + lineNumber + "\r\n\t";

        return source;
    }


//    public static void main(String[] args) {
//        System.out.println("getLine:"+getLineInfo());
//        System.out.println("getSource:"+LogUtils.getSource());
//        System.out.println("getLineInfo:"+getLineInfo(new Throwable().getStackTrace()[0]));
//        info(logger,Thread.currentThread().getStackTrace()[1],"sre");
//        info(logger,"wwww");
//    }

}
