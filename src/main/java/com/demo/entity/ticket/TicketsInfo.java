package com.demo.entity.ticket;

import java.util.List;
import java.util.Map;

import com.demo.util.SqLiteUtil;

public class TicketsInfo {
    
    private final String sql = "select * from station where 1=1";
    
    private String trainNo;
    //车次
    private String stationTrainCode;
    //始发站代号
    private String startStationTelecode;
    //终点站代号
    private String endStationTelecode;
    //出发站代号
    private String fromStationTelecode;
    //到达站代号
    private String toStationTelecode;
    //出发时间
    private String startTime;
    //到达时间
    private String arriveTime;
    //历时
    private String lishi;
    private String canWebBuy;
    private String ypInfo;
    private String startTrainDate;
    private String trainSeatFeature;
    private String locationCode;
    private String fromStationNo;
    private String toStationNo;
    private String isSupportCard;
    private String controlledTrainFlag;
    private String ggNum;
    private String grNum;
    private String qtNum;
    //软卧
    private String rwNum;
    //软座
    private String rzNum;
    private String tzNum;
    //无座
    private String wzNum;

    private String ybNum;
    //硬卧
    private String ywNum;
    //硬座
    private String yzNum;
    //二等座
    private String zeNum;
    //一等座
    private String zyNum;
    //商务座
    private String swzNum;
    private String srrbNum;
    private String ypEx;
    
    
    
    public TicketsInfo() {
    }
    public TicketsInfo(String trainNo, String stationTrainCode, String startStationTelecode, String endStationTelecode,
            String fromStationTelecode, String toStationTelecode, String startTime, String arriveTime, String lishi,
            String canWebBuy, String ypInfo, String startTrainDate, String trainSeatFeature, String locationCode,
            String fromStationNo, String toStationNo, String isSupportCard, String controlledTrainFlag, String ggNum,
            String grNum, String qtNum, String rwNum, String rzNum, String tzNum, String wzNum, String ybNum,
            String ywNum, String yzNum, String zeNum, String zyNum, String swzNum, String srrbNum, String ypEx) {
        this.trainNo = trainNo;
        this.stationTrainCode = stationTrainCode;
        this.startStationTelecode = startStationTelecode;
        this.endStationTelecode = endStationTelecode;
        this.fromStationTelecode = fromStationTelecode;
        this.toStationTelecode = toStationTelecode;
        this.startTime = startTime;
        this.arriveTime = arriveTime;
        this.lishi = lishi;
        this.canWebBuy = canWebBuy;
        this.ypInfo = ypInfo;
        this.startTrainDate = startTrainDate;
        this.trainSeatFeature = trainSeatFeature;
        this.locationCode = locationCode;
        this.fromStationNo = fromStationNo;
        this.toStationNo = toStationNo;
        this.isSupportCard = isSupportCard;
        this.controlledTrainFlag = controlledTrainFlag;
        this.ggNum = ggNum;
        this.grNum = grNum;
        this.qtNum = qtNum;
        this.rwNum = rwNum;
        this.rzNum = rzNum;
        this.tzNum = tzNum;
        this.wzNum = wzNum;
        this.ybNum = ybNum;
        this.ywNum = ywNum;
        this.yzNum = yzNum;
        this.zeNum = zeNum;
        this.zyNum = zyNum;
        this.swzNum = swzNum;
        this.srrbNum = srrbNum;
        this.ypEx = ypEx;
    }
    public String getTrainNo() {
        return trainNo;
    }
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public String getStationTrainCode() {
        return stationTrainCode;
    }
    public void setStationTrainCode(String stationTrainCode) {
        this.stationTrainCode = stationTrainCode;
    }
    public String getStartStationTelecode() {
        return startStationTelecode;
    }
    public String getStartStationCn() {
        return getStationCn(startStationTelecode);
    }
    public void setStartStationTelecode(String startStationTelecode) {
        this.startStationTelecode = startStationTelecode;
    }
    public String getEndStationTelecode() {
        return endStationTelecode;
    }
    public String getEndStationCn() {
        return getStationCn(endStationTelecode);
    }
    public void setEndStationTelecode(String endStationTelecode) {
        this.endStationTelecode = endStationTelecode;
    }
    public String getFromStationTelecode() {
        return fromStationTelecode;
    }
    public String getFromStationCn() {
        return getStationCn(fromStationTelecode);
    }
    public void setFromStationTelecode(String fromStationTelecode) {
        this.fromStationTelecode = fromStationTelecode;
    }
    public String getToStationTelecode() {
        return toStationTelecode;
    }
    public String getToStationCn() {
        return getStationCn(toStationTelecode);
    }
    public void setToStationTelecode(String toStationTelecode) {
        this.toStationTelecode = toStationTelecode;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getArriveTime() {
        return arriveTime;
    }
    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }
    public String getLishi() {
        return lishi;
    }
    public void setLishi(String lishi) {
        this.lishi = lishi;
    }
    public String getCanWebBuy() {
        return canWebBuy;
    }
    public void setCanWebBuy(String canWebBuy) {
        this.canWebBuy = canWebBuy;
    }
    public String getYpInfo() {
        return ypInfo;
    }
    public void setYpInfo(String ypInfo) {
        this.ypInfo = ypInfo;
    }
    public String getStartTrainDate() {
        return startTrainDate;
    }
    public void setStartTrainDate(String startTrainDate) {
        this.startTrainDate = startTrainDate;
    }
    public String getTrainSeatFeature() {
        return trainSeatFeature;
    }
    public void setTrainSeatFeature(String trainSeatFeature) {
        this.trainSeatFeature = trainSeatFeature;
    }
    public String getLocationCode() {
        return locationCode;
    }
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
    public String getFromStationNo() {
        return fromStationNo;
    }
    public void setFromStationNo(String fromStationNo) {
        this.fromStationNo = fromStationNo;
    }
    public String getToStationNo() {
        return toStationNo;
    }
    public void setToStationNo(String toStationNo) {
        this.toStationNo = toStationNo;
    }
    public String getIsSupportCard() {
        return isSupportCard;
    }
    public void setIsSupportCard(String isSupportCard) {
        this.isSupportCard = isSupportCard;
    }
    public String getControlledTrainFlag() {
        return controlledTrainFlag;
    }
    public void setControlledTrainFlag(String controlledTrainFlag) {
        this.controlledTrainFlag = controlledTrainFlag;
    }
    public String getGgNum() {
        return ggNum;
    }
    public void setGgNum(String ggNum) {
        this.ggNum = ggNum;
    }
    public String getGrNum() {
        return grNum;
    }
    public void setGrNum(String grNum) {
        this.grNum = grNum;
    }
    public String getQtNum() {
        return qtNum;
    }
    public void setQtNum(String qtNum) {
        this.qtNum = qtNum;
    }
    public String getRwNum() {
        return rwNum;
    }
    public void setRwNum(String rwNum) {
        this.rwNum = rwNum;
    }
    public String getRzNum() {
        return rzNum;
    }
    public void setRzNum(String rzNum) {
        this.rzNum = rzNum;
    }
    public String getTzNum() {
        return tzNum;
    }
    public void setTzNum(String tzNum) {
        this.tzNum = tzNum;
    }
    public String getWzNum() {
        return wzNum;
    }
    public void setWzNum(String wzNum) {
        this.wzNum = wzNum;
    }
    public String getYbNum() {
        return ybNum;
    }
    public void setYbNum(String ybNum) {
        this.ybNum = ybNum;
    }
    public String getYwNum() {
        return ywNum;
    }
    public void setYwNum(String ywNum) {
        this.ywNum = ywNum;
    }
    public String getYzNum() {
        return yzNum;
    }
    public void setYzNum(String yzNum) {
        this.yzNum = yzNum;
    }
    public String getZeNum() {
        return zeNum;
    }
    public void setZeNum(String zeNum) {
        this.zeNum = zeNum;
    }
    public String getZyNum() {
        return zyNum;
    }
    public void setZyNum(String zyNum) {
        this.zyNum = zyNum;
    }
    public String getSwzNum() {
        return swzNum;
    }
    public void setSwzNum(String swzNum) {
        this.swzNum = swzNum;
    }
    public String getSrrbNum() {
        return srrbNum;
    }
    public void setSrrbNum(String srrbNum) {
        this.srrbNum = srrbNum;
    }
    public String getYpEx() {
        return ypEx;
    }
    public void setYpEx(String ypEx) {
        this.ypEx = ypEx;
    }
    private String getStationCn(String stationCode){
        String stationCn = "";
        StringBuffer sqlStart=new StringBuffer(sql);
        sqlStart.append(" and station_code = ").append("'").append(stationCode).append("'");
        List<Map<String, String>> startStationCn = SqLiteUtil.getRowValue(sqlStart.toString());
        if(startStationCn.size()>0){
            stationCn = startStationCn.get(0).get("station_cn");        
        }
        return stationCn;
    }
}
