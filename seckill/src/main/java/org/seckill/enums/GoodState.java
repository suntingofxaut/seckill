package org.seckill.enums;

/**
 * 使用枚举表示常量数据字典
 */
public enum  GoodState {

    NOTSTART(1,"抢购未开始"),
    END(2,"抢购结束"),
    SECKILLED(3,"抢购成功"),
    DOING(4,"抢购中。。。");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    GoodState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static GoodState stateof(int index) {
        for (GoodState state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
