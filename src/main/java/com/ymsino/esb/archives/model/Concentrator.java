package com.ymsino.esb.archives.model;



/**
 * Concentrator entity. @author MyEclipse Persistence Tools
 */

public class Concentrator  implements java.io.Serializable {


    // Fields    

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
      * 通讯费(单位：分)
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


    // Constructors

    /** default constructor */
    public Concentrator() {
    }

	/** minimal constructor */
    public Concentrator(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    
    /** full constructor */
    public Concentrator(String hardwareId, String logicCode, String areaCode, String chargingUnitId, String parentUnits, String name, String password, String meterType, String communication, String serial, String relaySystem, String province, String city, String district, String street, String address, String monthFreezeStartDate, String monthFreezeStartHour, String dayFreezeStartHour, String dayFreezeStartMinute, String terminalId, Long communicationCost, String simSN, String gprsNum, Long costTimestamp, String exceedFlow, String actualFlow, String collectionId, String collectionName, Short collectionType, Short collectionStatus, String gpsLongitude, String gpsLatitude, String collectionAddress, String channelId, String rtsOpen, String statuteType, String relayType, String tel, String rtsClose, String transmissionDelay, String responseTimeout, String primaryIp, String reserveIp, String gatewayIp, String proXyIp, String primaryPort, String reservePort, String gatewayPort, String proXyPort, String smsNum, String heartbeatCycle, Long startTimestamp, String algorithmNum, String algorithmKey, String terminalNoRespTimeout, String forwardTerminal, String rtsTimeout, String startTimeout, String terminalLocationCode, String terminalCommPassword, String terminalIp, Integer resendTime, String terminalPost, String terminalNum, String primaryCommPassword, Long createTimestamp) {
        this.hardwareId = hardwareId;
        this.logicCode = logicCode;
        this.areaCode = areaCode;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
        this.name = name;
        this.password = password;
        this.meterType = meterType;
        this.communication = communication;
        this.serial = serial;
        this.relaySystem = relaySystem;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.address = address;
        this.monthFreezeStartDate = monthFreezeStartDate;
        this.monthFreezeStartHour = monthFreezeStartHour;
        this.dayFreezeStartHour = dayFreezeStartHour;
        this.dayFreezeStartMinute = dayFreezeStartMinute;
        this.terminalId = terminalId;
        this.communicationCost = communicationCost;
        this.simSN = simSN;
        this.gprsNum = gprsNum;
        this.costTimestamp = costTimestamp;
        this.exceedFlow = exceedFlow;
        this.actualFlow = actualFlow;
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.collectionType = collectionType;
        this.collectionStatus = collectionStatus;
        this.gpsLongitude = gpsLongitude;
        this.gpsLatitude = gpsLatitude;
        this.collectionAddress = collectionAddress;
        this.channelId = channelId;
        this.rtsOpen = rtsOpen;
        this.statuteType = statuteType;
        this.relayType = relayType;
        this.tel = tel;
        this.rtsClose = rtsClose;
        this.transmissionDelay = transmissionDelay;
        this.responseTimeout = responseTimeout;
        this.primaryIp = primaryIp;
        this.reserveIp = reserveIp;
        this.gatewayIp = gatewayIp;
        this.proXyIp = proXyIp;
        this.primaryPort = primaryPort;
        this.reservePort = reservePort;
        this.gatewayPort = gatewayPort;
        this.proXyPort = proXyPort;
        this.smsNum = smsNum;
        this.heartbeatCycle = heartbeatCycle;
        this.startTimestamp = startTimestamp;
        this.algorithmNum = algorithmNum;
        this.algorithmKey = algorithmKey;
        this.terminalNoRespTimeout = terminalNoRespTimeout;
        this.forwardTerminal = forwardTerminal;
        this.rtsTimeout = rtsTimeout;
        this.startTimeout = startTimeout;
        this.terminalLocationCode = terminalLocationCode;
        this.terminalCommPassword = terminalCommPassword;
        this.terminalIp = terminalIp;
        this.resendTime = resendTime;
        this.terminalPost = terminalPost;
        this.terminalNum = terminalNum;
        this.primaryCommPassword = primaryCommPassword;
        this.createTimestamp = createTimestamp;
    }

   
    // Property accessors
    /**       
     *      * 集中器ID
     */

    public String getHardwareId() {
        return this.hardwareId;
    }
    
    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }
    /**       
     *      * 逻辑地址
     */

    public String getLogicCode() {
        return this.logicCode;
    }
    
    public void setLogicCode(String logicCode) {
        this.logicCode = logicCode;
    }
    /**       
     *      * 区域码
     */

    public String getAreaCode() {
        return this.areaCode;
    }
    
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    /**       
     *      * 收费单位编号
     */

    public String getChargingUnitId() {
        return this.chargingUnitId;
    }
    
    public void setChargingUnitId(String chargingUnitId) {
        this.chargingUnitId = chargingUnitId;
    }
    /**       
     *      * 上级收费单位编号，多个用"||"包住，如|123||456|,用于搜索
     */

    public String getParentUnits() {
        return this.parentUnits;
    }
    
    public void setParentUnits(String parentUnits) {
        this.parentUnits = parentUnits;
    }
    /**       
     *      * 集中器名称
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 集中器密码
     */

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * 表类别
     */

    public String getMeterType() {
        return this.meterType;
    }
    
    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }
    /**       
     *      * 上行通讯方式
     */

    public String getCommunication() {
        return this.communication;
    }
    
    public void setCommunication(String communication) {
        this.communication = communication;
    }
    /**       
     *      * 工作串口
     */

    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**       
     *      * 中继方式
     */

    public String getRelaySystem() {
        return this.relaySystem;
    }
    
    public void setRelaySystem(String relaySystem) {
        this.relaySystem = relaySystem;
    }
    /**       
     *      * 省
     */

    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    /**       
     *      * 市
     */

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    /**       
     *      * 区县
     */

    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    /**       
     *      * 街道（乡镇）
     */

    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    /**       
     *      * 通讯地址
     */

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    /**       
     *      * 月冻结起始日
     */

    public String getMonthFreezeStartDate() {
        return this.monthFreezeStartDate;
    }
    
    public void setMonthFreezeStartDate(String monthFreezeStartDate) {
        this.monthFreezeStartDate = monthFreezeStartDate;
    }
    /**       
     *      * 月冻结起始时
     */

    public String getMonthFreezeStartHour() {
        return this.monthFreezeStartHour;
    }
    
    public void setMonthFreezeStartHour(String monthFreezeStartHour) {
        this.monthFreezeStartHour = monthFreezeStartHour;
    }
    /**       
     *      * 日冻结起始时
     */

    public String getDayFreezeStartHour() {
        return this.dayFreezeStartHour;
    }
    
    public void setDayFreezeStartHour(String dayFreezeStartHour) {
        this.dayFreezeStartHour = dayFreezeStartHour;
    }
    /**       
     *      * 日冻结起始分
     */

    public String getDayFreezeStartMinute() {
        return this.dayFreezeStartMinute;
    }
    
    public void setDayFreezeStartMinute(String dayFreezeStartMinute) {
        this.dayFreezeStartMinute = dayFreezeStartMinute;
    }
    /**       
     *      * 终端编号
     */

    public String getTerminalId() {
        return this.terminalId;
    }
    
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
    /**       
     *      * 通讯费(单位：分)
     */

    public Long getCommunicationCost() {
        return this.communicationCost;
    }
    
    public void setCommunicationCost(Long communicationCost) {
        this.communicationCost = communicationCost;
    }
    /**       
     *      * SIM卡号
     */

    public String getSimSN() {
        return this.simSN;
    }
    
    public void setSimSN(String simSN) {
        this.simSN = simSN;
    }
    /**       
     *      * GPRS号码
     */

    public String getGprsNum() {
        return this.gprsNum;
    }
    
    public void setGprsNum(String gprsNum) {
        this.gprsNum = gprsNum;
    }
    /**       
     *      * 费用日期
     */

    public Long getCostTimestamp() {
        return this.costTimestamp;
    }
    
    public void setCostTimestamp(Long costTimestamp) {
        this.costTimestamp = costTimestamp;
    }
    /**       
     *      * 超流量
     */

    public String getExceedFlow() {
        return this.exceedFlow;
    }
    
    public void setExceedFlow(String exceedFlow) {
        this.exceedFlow = exceedFlow;
    }
    /**       
     *      * 实际流量
     */

    public String getActualFlow() {
        return this.actualFlow;
    }
    
    public void setActualFlow(String actualFlow) {
        this.actualFlow = actualFlow;
    }
    /**       
     *      * 采集点编号
     */

    public String getCollectionId() {
        return this.collectionId;
    }
    
    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }
    /**       
     *      * 采集点名称
     */

    public String getCollectionName() {
        return this.collectionName;
    }
    
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
    /**       
     *      * 采集点类型
     */

    public Short getCollectionType() {
        return this.collectionType;
    }
    
    public void setCollectionType(Short collectionType) {
        this.collectionType = collectionType;
    }
    /**       
     *      * 采集点状态
     */

    public Short getCollectionStatus() {
        return this.collectionStatus;
    }
    
    public void setCollectionStatus(Short collectionStatus) {
        this.collectionStatus = collectionStatus;
    }
    /**       
     *      * GPS经度
     */

    public String getGpsLongitude() {
        return this.gpsLongitude;
    }
    
    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }
    /**       
     *      * GPS纬度
     */

    public String getGpsLatitude() {
        return this.gpsLatitude;
    }
    
    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }
    /**       
     *      * 采集点地址
     */

    public String getCollectionAddress() {
        return this.collectionAddress;
    }
    
    public void setCollectionAddress(String collectionAddress) {
        this.collectionAddress = collectionAddress;
    }
    /**       
     *      * 信道编号
     */

    public String getChannelId() {
        return this.channelId;
    }
    
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    /**       
     *      * RTS开
     */

    public String getRtsOpen() {
        return this.rtsOpen;
    }
    
    public void setRtsOpen(String rtsOpen) {
        this.rtsOpen = rtsOpen;
    }
    /**       
     *      * 规约类型
     */

    public String getStatuteType() {
        return this.statuteType;
    }
    
    public void setStatuteType(String statuteType) {
        this.statuteType = statuteType;
    }
    /**       
     *      * 中继类型
     */

    public String getRelayType() {
        return this.relayType;
    }
    
    public void setRelayType(String relayType) {
        this.relayType = relayType;
    }
    /**       
     *      * 电话号码
     */

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**       
     *      * RTS关
     */

    public String getRtsClose() {
        return this.rtsClose;
    }
    
    public void setRtsClose(String rtsClose) {
        this.rtsClose = rtsClose;
    }
    /**       
     *      * 传输延时
     */

    public String getTransmissionDelay() {
        return this.transmissionDelay;
    }
    
    public void setTransmissionDelay(String transmissionDelay) {
        this.transmissionDelay = transmissionDelay;
    }
    /**       
     *      * 响应超时
     */

    public String getResponseTimeout() {
        return this.responseTimeout;
    }
    
    public void setResponseTimeout(String responseTimeout) {
        this.responseTimeout = responseTimeout;
    }
    /**       
     *      * 主用IP地址
     */

    public String getPrimaryIp() {
        return this.primaryIp;
    }
    
    public void setPrimaryIp(String primaryIp) {
        this.primaryIp = primaryIp;
    }
    /**       
     *      * 备用IP地址
     */

    public String getReserveIp() {
        return this.reserveIp;
    }
    
    public void setReserveIp(String reserveIp) {
        this.reserveIp = reserveIp;
    }
    /**       
     *      * 网关IP地址
     */

    public String getGatewayIp() {
        return this.gatewayIp;
    }
    
    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }
    /**       
     *      * 代理IP地址
     */

    public String getProXyIp() {
        return this.proXyIp;
    }
    
    public void setProXyIp(String proXyIp) {
        this.proXyIp = proXyIp;
    }
    /**       
     *      * 主用端口
     */

    public String getPrimaryPort() {
        return this.primaryPort;
    }
    
    public void setPrimaryPort(String primaryPort) {
        this.primaryPort = primaryPort;
    }
    /**       
     *      * 备用端口
     */

    public String getReservePort() {
        return this.reservePort;
    }
    
    public void setReservePort(String reservePort) {
        this.reservePort = reservePort;
    }
    /**       
     *      * 网关端口
     */

    public String getGatewayPort() {
        return this.gatewayPort;
    }
    
    public void setGatewayPort(String gatewayPort) {
        this.gatewayPort = gatewayPort;
    }
    /**       
     *      * 代理端口
     */

    public String getProXyPort() {
        return this.proXyPort;
    }
    
    public void setProXyPort(String proXyPort) {
        this.proXyPort = proXyPort;
    }
    /**       
     *      * 短信号码
     */

    public String getSmsNum() {
        return this.smsNum;
    }
    
    public void setSmsNum(String smsNum) {
        this.smsNum = smsNum;
    }
    /**       
     *      * 心跳周期
     */

    public String getHeartbeatCycle() {
        return this.heartbeatCycle;
    }
    
    public void setHeartbeatCycle(String heartbeatCycle) {
        this.heartbeatCycle = heartbeatCycle;
    }
    /**       
     *      * 启用日期
     */

    public Long getStartTimestamp() {
        return this.startTimestamp;
    }
    
    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }
    /**       
     *      * 算法编号
     */

    public String getAlgorithmNum() {
        return this.algorithmNum;
    }
    
    public void setAlgorithmNum(String algorithmNum) {
        this.algorithmNum = algorithmNum;
    }
    /**       
     *      * 算法密钥
     */

    public String getAlgorithmKey() {
        return this.algorithmKey;
    }
    
    public void setAlgorithmKey(String algorithmKey) {
        this.algorithmKey = algorithmKey;
    }
    /**       
     *      * 终端无回答超时
     */

    public String getTerminalNoRespTimeout() {
        return this.terminalNoRespTimeout;
    }
    
    public void setTerminalNoRespTimeout(String terminalNoRespTimeout) {
        this.terminalNoRespTimeout = terminalNoRespTimeout;
    }
    /**       
     *      * 经由转发的终端
     */

    public String getForwardTerminal() {
        return this.forwardTerminal;
    }
    
    public void setForwardTerminal(String forwardTerminal) {
        this.forwardTerminal = forwardTerminal;
    }
    /**       
     *      * RTS延时
     */

    public String getRtsTimeout() {
        return this.rtsTimeout;
    }
    
    public void setRtsTimeout(String rtsTimeout) {
        this.rtsTimeout = rtsTimeout;
    }
    /**       
     *      * 启动延迟时间
     */

    public String getStartTimeout() {
        return this.startTimeout;
    }
    
    public void setStartTimeout(String startTimeout) {
        this.startTimeout = startTimeout;
    }
    /**       
     *      * 终端区位码
     */

    public String getTerminalLocationCode() {
        return this.terminalLocationCode;
    }
    
    public void setTerminalLocationCode(String terminalLocationCode) {
        this.terminalLocationCode = terminalLocationCode;
    }
    /**       
     *      * 终端通信密码
     */

    public String getTerminalCommPassword() {
        return this.terminalCommPassword;
    }
    
    public void setTerminalCommPassword(String terminalCommPassword) {
        this.terminalCommPassword = terminalCommPassword;
    }
    /**       
     *      * 终端IP
     */

    public String getTerminalIp() {
        return this.terminalIp;
    }
    
    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp;
    }
    /**       
     *      * 超时重发次数
     */

    public Integer getResendTime() {
        return this.resendTime;
    }
    
    public void setResendTime(Integer resendTime) {
        this.resendTime = resendTime;
    }
    /**       
     *      * 终端端口
     */

    public String getTerminalPost() {
        return this.terminalPost;
    }
    
    public void setTerminalPost(String terminalPost) {
        this.terminalPost = terminalPost;
    }
    /**       
     *      * 终端地址码
     */

    public String getTerminalNum() {
        return this.terminalNum;
    }
    
    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }
    /**       
     *      * 主站通信密码
     */

    public String getPrimaryCommPassword() {
        return this.primaryCommPassword;
    }
    
    public void setPrimaryCommPassword(String primaryCommPassword) {
        this.primaryCommPassword = primaryCommPassword;
    }
    /**       
     *      * 创建时间
     */

    public Long getCreateTimestamp() {
        return this.createTimestamp;
    }
    
    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof Concentrator) ) return false;
		Concentrator castOther = ( Concentrator ) other;
		if( this.getHardwareId() == null || castOther.getHardwareId() == null){
			return false;
		}
		
		return ( (this.getHardwareId()==castOther.getHardwareId()) || ( this.getHardwareId()!=null && castOther.getHardwareId()!=null && this.getHardwareId().equals(castOther.getHardwareId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getHardwareId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getHardwareId().hashCode());
		return result;
	}





}