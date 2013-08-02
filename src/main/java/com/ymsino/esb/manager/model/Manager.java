package com.ymsino.esb.manager.model;



/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager  implements java.io.Serializable {


    // Fields    

     /**
      * 管理员id
     */
     private String userId;
     /**
      * 登录ip
     */
     private String loginIp;
     /**
      * 最后登录时间
     */
     private Long lastLoginTimestamp;
     /**
      * 姓名
     */
     private String name;
     /**
      * 部门
     */
     private String dept;
     /**
      * 密码(MD5加密)
     */
     private String password;
     /**
      * 职位
     */
     private String position;
     /**
      * 邮箱
     */
     private String email;
     /**
      * 电话
     */
     private String tel;
     /**
      * 状态: -2冻结, -1不通过审核, 0新建, 1审核
     */
     private Short status;
     /**
      * 创建时间
     */
     private Long createTimestamp;
     /**
      * 修改时间
     */
     private Long modifiyTimestamp;
     /**
      * 审核时间
     */
     private Long checkTimestamp;
     /**
      * 创建人ID
     */
     private String createrId;
     /**
      * 修改人ID
     */
     private String modifierId;
     /**
      * 审核人ID
     */
     private String checkerId;
     /**
      * 角色id，多个用"||"包住，如|123||456|
     */
     private String roles;


    // Constructors

    /** default constructor */
    public Manager() {
    }

	/** minimal constructor */
    public Manager(String userId) {
        this.userId = userId;
    }
    
    /** full constructor */
    public Manager(String userId, String loginIp, Long lastLoginTimestamp, String name, String dept, String password, String position, String email, String tel, Short status, Long createTimestamp, Long modifiyTimestamp, Long checkTimestamp, String createrId, String modifierId, String checkerId, String roles) {
        this.userId = userId;
        this.loginIp = loginIp;
        this.lastLoginTimestamp = lastLoginTimestamp;
        this.name = name;
        this.dept = dept;
        this.password = password;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.modifiyTimestamp = modifiyTimestamp;
        this.checkTimestamp = checkTimestamp;
        this.createrId = createrId;
        this.modifierId = modifierId;
        this.checkerId = checkerId;
        this.roles = roles;
    }

   
    // Property accessors
    /**       
     *      * 管理员id
     */

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      * 登录ip
     */

    public String getLoginIp() {
        return this.loginIp;
    }
    
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
    /**       
     *      * 最后登录时间
     */

    public Long getLastLoginTimestamp() {
        return this.lastLoginTimestamp;
    }
    
    public void setLastLoginTimestamp(Long lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;
    }
    /**       
     *      * 姓名
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 部门
     */

    public String getDept() {
        return this.dept;
    }
    
    public void setDept(String dept) {
        this.dept = dept;
    }
    /**       
     *      * 密码(MD5加密)
     */

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * 职位
     */

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    /**       
     *      * 邮箱
     */

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 电话
     */

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**       
     *      * 状态: -2冻结, -1不通过审核, 0新建, 1审核
     */

    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
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
    /**       
     *      * 修改时间
     */

    public Long getModifiyTimestamp() {
        return this.modifiyTimestamp;
    }
    
    public void setModifiyTimestamp(Long modifiyTimestamp) {
        this.modifiyTimestamp = modifiyTimestamp;
    }
    /**       
     *      * 审核时间
     */

    public Long getCheckTimestamp() {
        return this.checkTimestamp;
    }
    
    public void setCheckTimestamp(Long checkTimestamp) {
        this.checkTimestamp = checkTimestamp;
    }
    /**       
     *      * 创建人ID
     */

    public String getCreaterId() {
        return this.createrId;
    }
    
    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
    /**       
     *      * 修改人ID
     */

    public String getModifierId() {
        return this.modifierId;
    }
    
    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }
    /**       
     *      * 审核人ID
     */

    public String getCheckerId() {
        return this.checkerId;
    }
    
    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }
    /**       
     *      * 角色id，多个用"||"包住，如|123||456|
     */

    public String getRoles() {
        return this.roles;
    }
    
    public void setRoles(String roles) {
        this.roles = roles;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof Manager) ) return false;
		Manager castOther = ( Manager ) other;
		if( this.getUserId() == null || castOther.getUserId() == null){
			return false;
		}
		
		return ( (this.getUserId()==castOther.getUserId()) || ( this.getUserId()!=null && castOther.getUserId()!=null && this.getUserId().equals(castOther.getUserId()) ) );
	}

	public int hashCode() {
		java.util.Random random = new java.util.Random();
		int result = 0;
		result += result + (this.getUserId() == null ? random.nextInt(Integer.MAX_VALUE) : this.getUserId().hashCode());
		return result;
	}





}