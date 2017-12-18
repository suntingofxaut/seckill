package org.seckill.dto;

/**
 * 暴露秒杀地址DTO
 */
public class Exposer {
    //是否开启秒杀
    private boolean exposed;
    //加密方法
    private String md5;
    //秒杀ID
    private long seckllId;
    //系统时间
    private long now;
    //开启时间
    private long start;
    //结束时间
    private long end;

    public Exposer(boolean exposed, long seckllId) {
        this.exposed = exposed;
        this.seckllId = seckllId;
    }

    public Exposer(boolean exposed,long seckllId, long now, long start, long end) {

        this.exposed = exposed;
        this.seckllId = seckllId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, String md5, long seckllId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckllId = seckllId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckllId() {
        return seckllId;
    }

    public void setSeckllId(long seckllId) {
        this.seckllId = seckllId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckllId=" + seckllId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
