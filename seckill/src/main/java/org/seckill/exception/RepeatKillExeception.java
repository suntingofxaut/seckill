package org.seckill.exception;

/**
 * 重复秒杀异常（运行起异常）
 */
public class RepeatKillExeception extends SeckillExecption {

    public RepeatKillExeception(String message) {
        super(message);
    }

    public RepeatKillExeception(String message, Throwable cause) {
        super(message, cause);
    }
}
