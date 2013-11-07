package com.ymsino.esb.archives.vo;

import java.io.Serializable;

public class ConcentratorReturn implements Serializable {

	/**
     * 集中器ID
    */
    private String hardwareId;
    /**
     * 逻辑地址
    */
    private String logicCode;
    /**
     * 区域码
    */
    private String areaCode;
    /**
     * 状态 ：1在线，-1离线
    */
    private Short status;
    /**
     * 收费单位编号
    */
    private String chargingUnitId;
    /**
     * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
    */
    private String parentUnits;
    /**
     * 集中器名称
    */
    private String name;
    /**
     * 集中器密码
    */
    private String password;
    /**
     * 表类别
    */
    private String meterType;
    /**
     * 上行通讯方式
    */
    private String communication;
    /**
     * 工作串口
    */
    private String serial;
    /**
     * 中继方式
    */
    private String relaySystem;
    /**
     * 省
    */
    private String province;
    /**
     * 市
    */
    private String city;
    /**
     * 区县
    */
    private String district;
    /**
     * 街道（乡镇）
    */
    private String street;
    /**
     * 通讯地址
    */
    private String address;
    /**
     * 月冻结起始日
    */
    private String monthFreezeStartDate;
    /**
     * 月冻结起始时
    */
    private String monthFreezeStartHour;
    /**
     * 日冻结起始时
    */
    private String dayFreezeStartHour;
    /**
     * 日冻结起始分
    */
    private String dayFreezeStartMinute;
    /**
     * 终端编号
    */
    private String terminalId;
    /**
     * 通讯费(单位：毫)
    */
    private Long communicationCost;
    /**
     * SIM卡号
    */
    private String simSN;
    /**
     * GPRS号码
    */
    private String gprsNum;
    /**
     * 费用日期
    */
    private Long costTimestamp;
    /**
     * 超流量
    */
    private String exceedFlow;
    /**
     * 实际流量
    */
    private String actualFlow;
    /**
     * 采集点编号
    */
    private String collectionId;
    /**
     * 采集点名称
    */
    private String collectionName;
    /**
     * 采集点类型
    */
    private Short collectionType;
    /**
     * 采集点状态
    */
    private Short collectionStatus;
    /**
     * GPS经度
    */
    private String gpsLongitude;
    /**
     * GPS纬度
    */
    private String gpsLatitude;
    /**
     * 采集点地址
    */
    private String collectionAddress;
    /**
     * 信道编号
    */
    private String channelId;
    /**
     * RTS开
    */
    private String rtsOpen;
    /**
     * 规约类型
    */
    private String statuteType;
    /**
     * 中继类型
    */
    private String relayType;
    /**
     * 电话号码
    */
    private String tel;
    /**
     * RTS关
    */
    private String rtsClose;
    /**
     * 传输延时
    */
    private String transmissionDelay;
    /**
     * 响应超时
    */
    private String responseTimeout;
    /**
     * 主用IP地址
    */
    private String primaryIp;
    /**
     * 备用IP地址
    */
    private String reserveIp;
    /**
     * 网关IP地址
    */
    private String gatewayIp;
    /**
     * 代理IP地址
    */
    private String proXyIp;
    /**
     * 主用端口
    */
    private String primaryPort;
    /**
     * 备用端口
    */
    private String reservePort;
    /**
     * 网关端口
    */
    private String gatewayPort;
    /**
     * 代理端口
    */
    private String proXyPort;
    /**
     * 短信号码
    */
    private String smsNum;
    /**
     * 心跳周期
    */
    private String heartbeatCycle;
    /**
     * 启用日期
    */
    private Long startTimestamp;
    /**
     * 算法编号
    */
    private String algorithmNum;
    /**
     * 算法密钥
    */
    private String algorithmKey;
    /**
     * 终端无回答超时
    */
    private String terminalNoRespTimeout;
    /**
     * 经由转发的终端
    */
    private String forwardTerminal;
    /**
     * RTS延时
    */
    private String rtsTimeout;
    /**
     * 启动延迟时间
    */
    private String startTimeout;
    /**
     * 终端区位码
    */
    private String terminalLocationCode;
    /**
     * 终端通信密码
    */
    private String terminalCommPassword;
    /**
     * 终端IP
    */
    private String terminalIp;
    /**
     * 超时重发次数
    */
    private Integer resendTime;
    /**
     * 终端端口
    */
    private String terminalPost;
    /**
     * 终端地址码
    */
    private String terminalNum;
    /**
     * 主站通信密码
    */
    private String primaryCommPassword;
    /**
     * 创建时间
    */
    private Long createTimestamp;
	public String getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}
	public String getLogicCode() {
		return logicCode;
	}
	public void setLogicCode(String logicCode) {
		this.logicCode = logicCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getChargingUnitId() {
		return chargingUnitId;
	}
	public void setChargingUnitId(String chargingUnitId) {
		this.chargingUnitId = chargingUnitId;
	}
	public String getParentUnits() {
		return parentUnits;
	}
	public void setParentUnits(String parentUnits) {
		this.parentUnits = parentUnits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMeterType() {
		return meterType;
	}
	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getRelaySystem() {
		return relaySystem;
	}
	public void setRelaySystem(String relaySystem) {
		this.relaySystem = relaySystem;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMonthFreezeStartDate() {
		return monthFreezeStartDate;
	}
	public void setMonthFreezeStartDate(String monthFreezeStartDate) {
		this.monthFreezeStartDate = monthFreezeStartDate;
	}
	public String getMonthFreezeStartHour() {
		return monthFreezeStartHour;
	}
	public void setMonthFreezeStartHour(String monthFreezeStartHour) {
		this.monthFreezeStartHour = monthFreezeStartHour;
	}
	public String getDayFreezeStartHour() {
		return dayFreezeStartHour;
	}
	public void setDayFreezeStartHour(String dayFreezeStartHour) {
		this.dayFreezeStartHour = dayFreezeStartHour;
	}
	public String getDayFreezeStartMinute() {
		return dayFreezeStartMinute;
	}
	public void setDayFreezeStartMinute(String dayFreezeStartMinute) {
		this.dayFreezeStartMinute = dayFreezeStartMinute;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public Long getCommunicationCost() {
		return communicationCost;
	}
	public void setCommunicationCost(Long communicationCost) {
		this.communicationCost = communicationCost;
	}
	public String getSimSN() {
		return simSN;
	}
	public void setSimSN(String simSN) {
		this.simSN = simSN;
	}
	public String getGprsNum() {
		return gprsNum;
	}
	public void setGprsNum(String gprsNum) {
		this.gprsNum = gprsNum;
	}
	public Long getCostTimestamp() {
		return costTimestamp;
	}
	public void setCostTimestamp(Long costTimestamp) {
		this.costTimestamp = costTimestamp;
	}
	public String getExceedFlow() {
		return exceedFlow;
	}
	public void setExceedFlow(String exceedFlow) {
		this.exceedFlow = exceedFlow;
	}
	public String getActualFlow() {
		return actualFlow;
	}
	public void setActualFlow(String actualFlow) {
		this.actualFlow = actualFlow;
	}
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public Short getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(Short collectionType) {
		this.collectionType = collectionType;
	}
	public Short getCollectionStatus() {
		return collectionStatus;
	}
	public void setCollectionStatus(Short collectionStatus) {
		this.collectionStatus = collectionStatus;
	}
	public String getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(String gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public String getGpsLatitude() {
		return gpsLatitude;
	}
	public void setGpsLatitude(String gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}
	public String getCollectionAddress() {
		return collectionAddress;
	}
	public void setCollectionAddress(String collectionAddress) {
		this.collectionAddress = collectionAddress;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getRtsOpen() {
		return rtsOpen;
	}
	public void setRtsOpen(String rtsOpen) {
		this.rtsOpen = rtsOpen;
	}
	public String getStatuteType() {
		return statuteType;
	}
	public void setStatuteType(String statuteType) {
		this.statuteType = statuteType;
	}
	public String getRelayType() {
		return relayType;
	}
	public void setRelayType(String relayType) {
		this.relayType = relayType;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRtsClose() {
		return rtsClose;
	}
	public void setRtsClose(String rtsClose) {
		this.rtsClose = rtsClose;
	}
	public String getTransmissionDelay() {
		return transmissionDelay;
	}
	public void setTransmissionDelay(String transmissionDelay) {
		this.transmissionDelay = transmissionDelay;
	}
	public String getResponseTimeout() {
		return responseTimeout;
	}
	public void setResponseTimeout(String responseTimeout) {
		this.responseTimeout = responseTimeout;
	}
	public String getPrimaryIp() {
		return primaryIp;
	}
	public void setPrimaryIp(String primaryIp) {
		this.primaryIp = primaryIp;
	}
	public String getReserveIp() {
		return reserveIp;
	}
	public void setReserveIp(String reserveIp) {
		this.reserveIp = reserveIp;
	}
	public String getGatewayIp() {
		return gatewayIp;
	}
	public void setGatewayIp(String gatewayIp) {
		this.gatewayIp = gatewayIp;
	}
	public String getProXyIp() {
		return proXyIp;
	}
	public void setProXyIp(String proXyIp) {
		this.proXyIp = proXyIp;
	}
	public String getPrimaryPort() {
		return primaryPort;
	}
	public void setPrimaryPort(String primaryPort) {
		this.primaryPort = primaryPort;
	}
	public String getReservePort() {
		return reservePort;
	}
	public void setReservePort(String reservePort) {
		this.reservePort = reservePort;
	}
	public String getGatewayPort() {
		return gatewayPort;
	}
	public void setGatewayPort(String gatewayPort) {
		this.gatewayPort = gatewayPort;
	}
	public String getProXyPort() {
		return proXyPort;
	}
	public void setProXyPort(String proXyPort) {
		this.proXyPort = proXyPort;
	}
	public String getSmsNum() {
		return smsNum;
	}
	public void setSmsNum(String smsNum) {
		this.smsNum = smsNum;
	}
	public String getHeartbeatCycle() {
		return heartbeatCycle;
	}
	public void setHeartbeatCycle(String heartbeatCycle) {
		this.heartbeatCycle = heartbeatCycle;
	}
	public Long getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Long startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public String getAlgorithmNum() {
		return algorithmNum;
	}
	public void setAlgorithmNum(String algorithmNum) {
		this.algorithmNum = algorithmNum;
	}
	public String getAlgorithmKey() {
		return algorithmKey;
	}
	public void setAlgorithmKey(String algorithmKey) {
		this.algorithmKey = algorithmKey;
	}
	public String getTerminalNoRespTimeout() {
		return terminalNoRespTimeout;
	}
	public void setTerminalNoRespTimeout(String terminalNoRespTimeout) {
		this.terminalNoRespTimeout = terminalNoRespTimeout;
	}
	public String getForwardTerminal() {
		return forwardTerminal;
	}
	public void setForwardTerminal(String forwardTerminal) {
		this.forwardTerminal = forwardTerminal;
	}
	public String getRtsTimeout() {
		return rtsTimeout;
	}
	public void setRtsTimeout(String rtsTimeout) {
		this.rtsTimeout = rtsTimeout;
	}
	public String getStartTimeout() {
		return startTimeout;
	}
	public void setStartTimeout(String startTimeout) {
		this.startTimeout = startTimeout;
	}
	public String getTerminalLocationCode() {
		return terminalLocationCode;
	}
	public void setTerminalLocationCode(String terminalLocationCode) {
		this.terminalLocationCode = terminalLocationCode;
	}
	public String getTerminalCommPassword() {
		return terminalCommPassword;
	}
	public void setTerminalCommPassword(String terminalCommPassword) {
		this.terminalCommPassword = terminalCommPassword;
	}
	public String getTerminalIp() {
		return terminalIp;
	}
	public void setTerminalIp(String terminalIp) {
		this.terminalIp = terminalIp;
	}
	public Integer getResendTime() {
		return resendTime;
	}
	public void setResendTime(Integer resendTime) {
		this.resendTime = resendTime;
	}
	public String getTerminalPost() {
		return terminalPost;
	}
	public void setTerminalPost(String terminalPost) {
		this.terminalPost = terminalPost;
	}
	public String getTerminalNum() {
		return terminalNum;
	}
	public void setTerminalNum(String terminalNum) {
		this.terminalNum = terminalNum;
	}
	public String getPrimaryCommPassword() {
		return primaryCommPassword;
	}
	public void setPrimaryCommPassword(String primaryCommPassword) {
		this.primaryCommPassword = primaryCommPassword;
	}
	public Long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
