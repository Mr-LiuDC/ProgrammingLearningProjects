package cn.alittler.study.springboot.exception;

@SuppressWarnings("serial")
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

}
