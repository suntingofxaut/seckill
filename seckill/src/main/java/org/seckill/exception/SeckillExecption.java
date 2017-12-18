package org.seckill.exception;

/**
 * 秒杀相关的异常
 */
public class SeckillExecption extends RuntimeException{
    public SeckillExecption(String message) {
        super(message);
    }

    public SeckillExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
