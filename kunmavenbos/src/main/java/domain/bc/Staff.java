package domain.bc;

import java.util.HashSet;
import java.util.Set;


/**
 * 收派员
 * Staff entity. @author MyEclipse Persistence Tools
 */

public class Staff  implements java.io.Serializable {


    // 收派员id
     private String id;
     //关联标准对象（重量范围）
     private Standard standard;
     //姓名
     private String name;
     //电话
     private String telephone;
     //是否有跟踪定位
     private String haspda;
     //是否删除,默认不删除
     private String deltag="0";
     //单位
     private String station;
     //负责的定区
     private Set decidedZones = new HashSet(0);


    // Constructors

    /** default constructor */
    public Staff() {
    }

	/** minimal constructor */
    public Staff(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Staff(String id, Standard standard, String name, String telephone, String haspda, String deltag, String station, Set decidedZones) {
        this.id = id;
        this.standard = standard;
        this.name = name;
        this.telephone = telephone;
        this.haspda = haspda;
        this.deltag = deltag;
        this.station = station;
        this.decidedZones = decidedZones;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Standard getStandard() {
        return this.standard;
    }
    
    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHaspda() {
        return this.haspda;
    }
    
    public void setHaspda(String haspda) {
        this.haspda = haspda;
    }

    public String getDeltag() {
        return this.deltag;
    }
    
    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    public String getStation() {
        return this.station;
    }
    
    public void setStation(String station) {
        this.station = station;
    }

    public Set getDecidedZones() {
        return this.decidedZones;
    }
    
    public void setDecidedZones(Set decidedZones) {
        this.decidedZones = decidedZones;
    }
   








}