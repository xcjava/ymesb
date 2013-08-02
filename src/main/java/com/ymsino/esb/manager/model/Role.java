package com.ymsino.esb.manager.model;



/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     /**
      * 角色id
     */
     private Long id;
     /**
      * 角色名字
     */
     private String name;
     /**
      * 角色描述
     */
     private String description;
     /**
      * 创建时间
     */
     private Long createTimestamp;
     /**
      * 状态:0新建,1启用,-1停用
     */
     private Short status;
     /**
      * 创建人ID
     */
     private String createrId;
     /**
      * 权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}
     */
     private String popedomJson;


    // Constructors

    /** default constructor */
    public Role() {
    }

    
    /** full constructor */
    public Role(String name, String description, Long createTimestamp, Short status, String createrId, String popedomJson) {
        this.name = name;
        this.description = description;
        this.createTimestamp = createTimestamp;
        this.status = status;
        this.createrId = createrId;
        this.popedomJson = popedomJson;
    }

   
    // Property accessors
    /**       
     *      * 角色id
     */

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 角色名字
     */

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 角色描述
     */

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
     *      * 状态:0新建,1启用,-1停用
     */

    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
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
     *      * 权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}
     */

    public String getPopedomJson() {
        return this.popedomJson;
    }
    
    public void setPopedomJson(String popedomJson) {
        this.popedomJson = popedomJson;
    }
   



	public boolean equals(Object other) {
		if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof Role) ) return false;
		Role castOther = ( Role ) other;
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