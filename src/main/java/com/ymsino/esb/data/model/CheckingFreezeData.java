package com.ymsino.esb.data.model;



/**
 * CheckingFreezeData entity. @author MyEclipse Persistence Tools
 */

public class CheckingFreezeData  implements java.io.Serializable {


    // Fields    

     /**
      * ˮ���������������id
     */
     private Long id;
     /**
      * �������߼���ַ
     */
     private String concHardwareId;
     /**
      * ��������ˮ��ID
     */
     private String meterHardwareId;
     /**
      * 1�ձ�ƶ���
     */
     private Float meterReading1;
     /**
      * 2�ձ�ƶ���
     */
     private Float meterReading2;
     /**
      * 3�ձ�ƶ���
     */
     private Float meterReading3;
     /**
      * 4�ձ�ƶ���
     */
     private Float meterReading4;
     /**
      * 5�ձ�ƶ���
     */
     private Float meterReading5;
     /**
      * 6�ձ�ƶ���
     */
     private Float meterReading6;
     /**
      * 7�ձ�ƶ���
     */
     private Float meterReading7;
     /**
      * 8�ձ�ƶ���
     */
     private Float meterReading8;
     /**
      * 9�ձ�ƶ���
     */
     private Float meterReading9;
     /**
      * 10�ձ�ƶ���
     */
     private Float meterReading10;
     /**
      * 11�ձ�ƶ���
     */
     private Float meterReading11;
     /**
      * 12�ձ�ƶ���
     */
     private Float meterReading12;
     /**
      * 13�ձ�ƶ���
     */
     private Float meterReading13;
     /**
      * 14�ձ�ƶ���
     */
     private Float meterReading14;
     /**
      * 15�ձ�ƶ���
     */
     private Float meterReading15;
     /**
      * 16�ձ�ƶ���
     */
     private Float meterReading16;
     /**
      * 17�ձ�ƶ���
     */
     private Float meterReading17;
     /**
      * 18�ձ�ƶ���
     */
     private Float meterReading18;
     /**
      * 19�ձ�ƶ���
     */
     private Float meterReading19;
     /**
      * 20�ձ�ƶ���
     */
     private Float meterReading20;
     /**
      * 21�ձ�ƶ���
     */
     private Float meterReading21;
     /**
      * 22�ձ�ƶ���
     */
     private Float meterReading22;
     /**
      * 23�ձ�ƶ���
     */
     private Float meterReading23;
     /**
      * 24�ձ�ƶ���
     */
     private Float meterReading24;
     /**
      * 25�ձ�ƶ���
     */
     private Float meterReading25;
     /**
      * 26�ձ�ƶ���
     */
     private Float meterReading26;
     /**
      * 27�ձ�ƶ���
     */
     private Float meterReading27;
     /**
      * 28�ձ�ƶ���
     */
     private Float meterReading28;
     /**
      * 29�ձ�ƶ���
     */
     private Float meterReading29;
     /**
      * 30�ձ�ƶ���
     */
     private Float meterReading30;
     /**
      * 31�ձ�ƶ���
     */
     private Float meterReading31;
     /**
      * ����ʱ��(��)
     */
     private String freezeYear;
     /**
      * ����ʱ��(��)
     */
     private String freezeMonth;
     /**
      * ����ʱ���
     */
     private Long createTimestamp;
     /**
      * �ͻ����
     */
     private String userId;
     /**
      * ��ˮ�û����
     */
     private String waterCustomerId;
     /**
      * �շѵ�λ���
     */
     private String chargingUnitId;
     /**
      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */
     private String parentUnits;


    // Constructors

    /** default constructor */
    public CheckingFreezeData() {
    }

    
    /** full constructor */
    public CheckingFreezeData(String concHardwareId, String meterHardwareId, Float meterReading1, Float meterReading2, Float meterReading3, Float meterReading4, Float meterReading5, Float meterReading6, Float meterReading7, Float meterReading8, Float meterReading9, Float meterReading10, Float meterReading11, Float meterReading12, Float meterReading13, Float meterReading14, Float meterReading15, Float meterReading16, Float meterReading17, Float meterReading18, Float meterReading19, Float meterReading20, Float meterReading21, Float meterReading22, Float meterReading23, Float meterReading24, Float meterReading25, Float meterReading26, Float meterReading27, Float meterReading28, Float meterReading29, Float meterReading30, Float meterReading31, String freezeYear, String freezeMonth, Long createTimestamp, String userId, String waterCustomerId, String chargingUnitId, String parentUnits) {
        this.concHardwareId = concHardwareId;
        this.meterHardwareId = meterHardwareId;
        this.meterReading1 = meterReading1;
        this.meterReading2 = meterReading2;
        this.meterReading3 = meterReading3;
        this.meterReading4 = meterReading4;
        this.meterReading5 = meterReading5;
        this.meterReading6 = meterReading6;
        this.meterReading7 = meterReading7;
        this.meterReading8 = meterReading8;
        this.meterReading9 = meterReading9;
        this.meterReading10 = meterReading10;
        this.meterReading11 = meterReading11;
        this.meterReading12 = meterReading12;
        this.meterReading13 = meterReading13;
        this.meterReading14 = meterReading14;
        this.meterReading15 = meterReading15;
        this.meterReading16 = meterReading16;
        this.meterReading17 = meterReading17;
        this.meterReading18 = meterReading18;
        this.meterReading19 = meterReading19;
        this.meterReading20 = meterReading20;
        this.meterReading21 = meterReading21;
        this.meterReading22 = meterReading22;
        this.meterReading23 = meterReading23;
        this.meterReading24 = meterReading24;
        this.meterReading25 = meterReading25;
        this.meterReading26 = meterReading26;
        this.meterReading27 = meterReading27;
        this.meterReading28 = meterReading28;
        this.meterReading29 = meterReading29;
        this.meterReading30 = meterReading30;
        this.meterReading31 = meterReading31;
        this.freezeYear = freezeYear;
        this.freezeMonth = freezeMonth;
        this.createTimestamp = createTimestamp;
        this.userId = userId;
        this.waterCustomerId = waterCustomerId;
        this.chargingUnitId = chargingUnitId;
        this.parentUnits = parentUnits;
    }

   
    // Property accessors
    /**       
     *      * ˮ���������������id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * �������߼���ַ
     */

    public String getConcHardwareId() {
        return this.concHardwareId;
    }
    
    public void setConcHardwareId(String concHardwareId) {
        this.concHardwareId = concHardwareId;
    }
    /**       
     *      * ��������ˮ��ID
     */

    public String getMeterHardwareId() {
        return this.meterHardwareId;
    }
    
    public void setMeterHardwareId(String meterHardwareId) {
        this.meterHardwareId = meterHardwareId;
    }
    /**       
     *      * 1�ձ�ƶ���
     */

    public Float getMeterReading1() {
        return this.meterReading1;
    }
    
    public void setMeterReading1(Float meterReading1) {
        this.meterReading1 = meterReading1;
    }
    /**       
     *      * 2�ձ�ƶ���
     */

    public Float getMeterReading2() {
        return this.meterReading2;
    }
    
    public void setMeterReading2(Float meterReading2) {
        this.meterReading2 = meterReading2;
    }
    /**       
     *      * 3�ձ�ƶ���
     */

    public Float getMeterReading3() {
        return this.meterReading3;
    }
    
    public void setMeterReading3(Float meterReading3) {
        this.meterReading3 = meterReading3;
    }
    /**       
     *      * 4�ձ�ƶ���
     */

    public Float getMeterReading4() {
        return this.meterReading4;
    }
    
    public void setMeterReading4(Float meterReading4) {
        this.meterReading4 = meterReading4;
    }
    /**       
     *      * 5�ձ�ƶ���
     */

    public Float getMeterReading5() {
        return this.meterReading5;
    }
    
    public void setMeterReading5(Float meterReading5) {
        this.meterReading5 = meterReading5;
    }
    /**       
     *      * 6�ձ�ƶ���
     */

    public Float getMeterReading6() {
        return this.meterReading6;
    }
    
    public void setMeterReading6(Float meterReading6) {
        this.meterReading6 = meterReading6;
    }
    /**       
     *      * 7�ձ�ƶ���
     */

    public Float getMeterReading7() {
        return this.meterReading7;
    }
    
    public void setMeterReading7(Float meterReading7) {
        this.meterReading7 = meterReading7;
    }
    /**       
     *      * 8�ձ�ƶ���
     */

    public Float getMeterReading8() {
        return this.meterReading8;
    }
    
    public void setMeterReading8(Float meterReading8) {
        this.meterReading8 = meterReading8;
    }
    /**       
     *      * 9�ձ�ƶ���
     */

    public Float getMeterReading9() {
        return this.meterReading9;
    }
    
    public void setMeterReading9(Float meterReading9) {
        this.meterReading9 = meterReading9;
    }
    /**       
     *      * 10�ձ�ƶ���
     */

    public Float getMeterReading10() {
        return this.meterReading10;
    }
    
    public void setMeterReading10(Float meterReading10) {
        this.meterReading10 = meterReading10;
    }
    /**       
     *      * 11�ձ�ƶ���
     */

    public Float getMeterReading11() {
        return this.meterReading11;
    }
    
    public void setMeterReading11(Float meterReading11) {
        this.meterReading11 = meterReading11;
    }
    /**       
     *      * 12�ձ�ƶ���
     */

    public Float getMeterReading12() {
        return this.meterReading12;
    }
    
    public void setMeterReading12(Float meterReading12) {
        this.meterReading12 = meterReading12;
    }
    /**       
     *      * 13�ձ�ƶ���
     */

    public Float getMeterReading13() {
        return this.meterReading13;
    }
    
    public void setMeterReading13(Float meterReading13) {
        this.meterReading13 = meterReading13;
    }
    /**       
     *      * 14�ձ�ƶ���
     */

    public Float getMeterReading14() {
        return this.meterReading14;
    }
    
    public void setMeterReading14(Float meterReading14) {
        this.meterReading14 = meterReading14;
    }
    /**       
     *      * 15�ձ�ƶ���
     */

    public Float getMeterReading15() {
        return this.meterReading15;
    }
    
    public void setMeterReading15(Float meterReading15) {
        this.meterReading15 = meterReading15;
    }
    /**       
     *      * 16�ձ�ƶ���
     */

    public Float getMeterReading16() {
        return this.meterReading16;
    }
    
    public void setMeterReading16(Float meterReading16) {
        this.meterReading16 = meterReading16;
    }
    /**       
     *      * 17�ձ�ƶ���
     */

    public Float getMeterReading17() {
        return this.meterReading17;
    }
    
    public void setMeterReading17(Float meterReading17) {
        this.meterReading17 = meterReading17;
    }
    /**       
     *      * 18�ձ�ƶ���
     */

    public Float getMeterReading18() {
        return this.meterReading18;
    }
    
    public void setMeterReading18(Float meterReading18) {
        this.meterReading18 = meterReading18;
    }
    /**       
     *      * 19�ձ�ƶ���
     */

    public Float getMeterReading19() {
        return this.meterReading19;
    }
    
    public void setMeterReading19(Float meterReading19) {
        this.meterReading19 = meterReading19;
    }
    /**       
     *      * 20�ձ�ƶ���
     */

    public Float getMeterReading20() {
        return this.meterReading20;
    }
    
    public void setMeterReading20(Float meterReading20) {
        this.meterReading20 = meterReading20;
    }
    /**       
     *      * 21�ձ�ƶ���
     */

    public Float getMeterReading21() {
        return this.meterReading21;
    }
    
    public void setMeterReading21(Float meterReading21) {
        this.meterReading21 = meterReading21;
    }
    /**       
     *      * 22�ձ�ƶ���
     */

    public Float getMeterReading22() {
        return this.meterReading22;
    }
    
    public void setMeterReading22(Float meterReading22) {
        this.meterReading22 = meterReading22;
    }
    /**       
     *      * 23�ձ�ƶ���
     */

    public Float getMeterReading23() {
        return this.meterReading23;
    }
    
    public void setMeterReading23(Float meterReading23) {
        this.meterReading23 = meterReading23;
    }
    /**       
     *      * 24�ձ�ƶ���
     */

    public Float getMeterReading24() {
        return this.meterReading24;
    }
    
    public void setMeterReading24(Float meterReading24) {
        this.meterReading24 = meterReading24;
    }
    /**       
     *      * 25�ձ�ƶ���
     */

    public Float getMeterReading25() {
        return this.meterReading25;
    }
    
    public void setMeterReading25(Float meterReading25) {
        this.meterReading25 = meterReading25;
    }
    /**       
     *      * 26�ձ�ƶ���
     */

    public Float getMeterReading26() {
        return this.meterReading26;
    }
    
    public void setMeterReading26(Float meterReading26) {
        this.meterReading26 = meterReading26;
    }
    /**       
     *      * 27�ձ�ƶ���
     */

    public Float getMeterReading27() {
        return this.meterReading27;
    }
    
    public void setMeterReading27(Float meterReading27) {
        this.meterReading27 = meterReading27;
    }
    /**       
     *      * 28�ձ�ƶ���
     */

    public Float getMeterReading28() {
        return this.meterReading28;
    }
    
    public void setMeterReading28(Float meterReading28) {
        this.meterReading28 = meterReading28;
    }
    /**       
     *      * 29�ձ�ƶ���
     */

    public Float getMeterReading29() {
        return this.meterReading29;
    }
    
    public void setMeterReading29(Float meterReading29) {
        this.meterReading29 = meterReading29;
    }
    /**       
     *      * 30�ձ�ƶ���
     */

    public Float getMeterReading30() {
        return this.meterReading30;
    }
    
    public void setMeterReading30(Float meterReading30) {
        this.meterReading30 = meterReading30;
    }
    /**       
     *      * 31�ձ�ƶ���
     */

    public Float getMeterReading31() {
        return this.meterReading31;
    }
    
    public void setMeterReading31(Float meterReading31) {
        this.meterReading31 = meterReading31;
    }
    /**       
     *      * ����ʱ��(��)
     */

    public String getFreezeYear() {
        return this.freezeYear;
    }
    
    public void setFreezeYear(String freezeYear) {
        this.freezeYear = freezeYear;
    }
    /**       
     *      * ����ʱ��(��)
     */

    public String getFreezeMonth() {
        return this.freezeMonth;
    }
    
    public void setFreezeMonth(String freezeMonth) {
        this.freezeMonth = freezeMonth;
    }
    /**       
     *      * ����ʱ���
     */

    public Long getCreateTimestamp() {
        return this.createTimestamp;
    }
    
    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
    /**       
     *      * �ͻ����
     */

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      * ��ˮ�û����
     */

    public String getWaterCustomerId() {
        return this.waterCustomerId;
    }
    
    public void setWaterCustomerId(String waterCustomerId) {
        this.waterCustomerId = waterCustomerId;
    }
    /**       
     *      * �շѵ�λ���
     */

    public String getChargingUnitId() {
        return this.chargingUnitId;
    }
    
    public void setChargingUnitId(String chargingUnitId) {
        this.chargingUnitId = chargingUnitId;
    }
    /**       
     *      * �ϼ��շѵ�λ��ţ������"||"��ס����|123||456|,��������
     */

    public String getParentUnits() {
        return this.parentUnits;
    }
    
    public void setParentUnits(String parentUnits) {
        this.parentUnits = parentUnits;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof CheckingFreezeData) ) return false;
		CheckingFreezeData castOther = ( CheckingFreezeData ) other;
		if( this.getId() == null || castOther.getId() == null){
			return false;
		}
		
		return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getId().hashCode());
		return result;
	}





}