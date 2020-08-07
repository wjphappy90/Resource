package com.itcast.skywalking_alarm.pojo;

public class AlarmMessage {
    private int scopeId;
    private String name;
    private int id0;
    private int id1;
    //告警的消息
    private String alarmMessage;
    //告警的产生时间
    private long startTime;

    public int getScopeId() {
        return scopeId;
    }

    public void setScopeId(int scopeId) {
        this.scopeId = scopeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId0() {
        return id0;
    }

    public void setId0(int id0) {
        this.id0 = id0;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "AlarmMessage{" +
                "scopeId=" + scopeId +
                ", name='" + name + '\'' +
                ", id0=" + id0 +
                ", id1=" + id1 +
                ", alarmMessage='" + alarmMessage + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
