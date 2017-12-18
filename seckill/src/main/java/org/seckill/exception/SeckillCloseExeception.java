package org.seckill.exception;

/**
 * 秒杀关闭异常
 */
public class SeckillCloseExeception extends SeckillExecption{
    public SeckillCloseExeception(String message) {
        super(message);
    }

    public SeckillCloseExeception(String message, Throwable cause) {
        super(message, cause);
    }
}
