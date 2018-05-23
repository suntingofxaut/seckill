package org.seckill.enums;

public enum RedisOptionResult {
    ERROE(-1,"An unknown error!"),
    PTUS_SUCCESS(1,"The database batch writes to the cache successfully!"),
    PTUS_FAIL(2, "The database batch writes to the cache failed!"),
    GETS_SUCCESS(3,"The cache batch writes to the database successfully!"),
    GETS_FAIL(4,"The cache batch writes to the database failed!");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    RedisOptionResult(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static RedisOptionResult stateof(int index) {
        for (RedisOptionResult state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
