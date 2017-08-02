package com.demo.base.Enum;

public enum JobState {
    //任务状态 0停止 1运行 2等待3阻塞4错误
   STOP("停止",0),RUN("运行",1),WAIT("等待",2),BLOCK("阻塞",3),ERROR("错误",4);
    
    private String name;
    private Integer value;
    private JobState() {
    }
    private JobState(String name,Integer value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value.toString();
    }
    public String getName(){
        return this.name;
    }
    public Integer getValue(){
        return this.value;
    }
}
