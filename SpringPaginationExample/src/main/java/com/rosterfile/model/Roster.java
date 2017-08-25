package com.rosterfile.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jimmy Pena on 8/22/2017.
 */

@Entity
@Table(name = "SALESROSTER")
public class Roster implements Serializable {



    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    private String ZRT;
    private char AREA;
    private String ZONE;
    private char REGION;
    private String TERRITORY;
    private String FULL_NAME;
    private String LAST_NAME;
    private String FIRST_NAME;
    private char MIDDLE_INITIAL;
    private String NICKNAME;
    private String HOME_PHONE;
    private String CELL_PHONE;
    private String MAILADDRESS1;
    private String MAILADDRESS2;
    private String MAILADDRESS3;
    private String MAILCITY;
    private String MAILSTATE;
    private String MAILZIPCODE;
    private String HOMEADDRESS1;
    private String HOMEADDRESS2;
    private String HOMEADDRESS3;
    private String HOMECITY;
    private String HOMESTATE;
    private String HOMEZIPCODE;
    private String SHIPADDRESS1;
    private String SHIPADDRESS2;
    private String SHIPADDRESS3;
    private String SHIPCITY;
    private String SHIPSTATE;
    private String SHIPZIPCODE;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date HIREDATE;

    private String EMPLOYEENUMBER;

    public Roster(){}

    public String getZRT() {
        return ZRT;
    }

    public void setZRT(String ZRT) {
        this.ZRT = ZRT;
    }

    public char getAREA() {
        return AREA;
    }

    public void setAREA(char AREA) {
        this.AREA = AREA;
    }

    public String getZONE() {
        return ZONE;
    }

    public void setZONE(String ZONE) {
        this.ZONE = ZONE;
    }

    public char getREGION() {
        return REGION;
    }

    public void setREGION(char REGION) {
        this.REGION = REGION;
    }

    public String getTERRITORY() {
        return TERRITORY;
    }

    public void setTERRITORY(String TERRITORY) {
        this.TERRITORY = TERRITORY;
    }

    public String getFULL_NAME() {
        return FULL_NAME;
    }

    public void setFULL_NAME(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public char getMIDDLE_INITIAL() {
        return MIDDLE_INITIAL;
    }

    public void setMIDDLE_INITIAL(char MIDDLE_INITIAL) {
        this.MIDDLE_INITIAL = MIDDLE_INITIAL;
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public String getHOME_PHONE() {
        return HOME_PHONE;
    }

    public void setHOME_PHONE(String HOME_PHONE) {
        this.HOME_PHONE = HOME_PHONE;
    }

    public String getCELL_PHONE() {
        return CELL_PHONE;
    }

    public void setCELL_PHONE(String CELL_PHONE) {
        this.CELL_PHONE = CELL_PHONE;
    }

    public String getMAILADDRESS1() {
        return MAILADDRESS1;
    }

    public void setMAILADDRESS1(String MAILADDRESS1) {
        this.MAILADDRESS1 = MAILADDRESS1;
    }

    public String getMAILADDRESS2() {
        return MAILADDRESS2;
    }

    public void setMAILADDRESS2(String MAILADDRESS2) {
        this.MAILADDRESS2 = MAILADDRESS2;
    }

    public String getMAILADDRESS3() {
        return MAILADDRESS3;
    }

    public void setMAILADDRESS3(String MAILADDRESS3) {
        this.MAILADDRESS3 = MAILADDRESS3;
    }

    public String getMAILCITY() {
        return MAILCITY;
    }

    public void setMAILCITY(String MAILCITY) {
        this.MAILCITY = MAILCITY;
    }

    public String getMAILSTATE() {
        return MAILSTATE;
    }

    public void setMAILSTATE(String MAILSTATE) {
        this.MAILSTATE = MAILSTATE;
    }

    public String getMAILZIPCODE() {
        return MAILZIPCODE;
    }

    public void setMAILZIPCODE(String MAILZIPCODE) {
        this.MAILZIPCODE = MAILZIPCODE;
    }

    public String getHOMEADDRESS1() {
        return HOMEADDRESS1;
    }

    public void setHOMEADDRESS1(String HOMEADDRESS1) {
        this.HOMEADDRESS1 = HOMEADDRESS1;
    }

    public String getHOMEADDRESS2() {
        return HOMEADDRESS2;
    }

    public void setHOMEADDRESS2(String HOMEADDRESS2) {
        this.HOMEADDRESS2 = HOMEADDRESS2;
    }

    public String getHOMEADDRESS3() {
        return HOMEADDRESS3;
    }

    public void setHOMEADDRESS3(String HOMEADDRESS3) {
        this.HOMEADDRESS3 = HOMEADDRESS3;
    }

    public String getHOMECITY() {
        return HOMECITY;
    }

    public void setHOMECITY(String HOMECITY) {
        this.HOMECITY = HOMECITY;
    }

    public String getHOMESTATE() {
        return HOMESTATE;
    }

    public void setHOMESTATE(String HOMESTATE) {
        this.HOMESTATE = HOMESTATE;
    }

    public String getHOMEZIPCODE() {
        return HOMEZIPCODE;
    }

    public void setHOMEZIPCODE(String HOMEZIPCODE) {
        this.HOMEZIPCODE = HOMEZIPCODE;
    }

    public String getSHIPADDRESS1() {
        return SHIPADDRESS1;
    }

    public void setSHIPADDRESS1(String SHIPADDRESS1) {
        this.SHIPADDRESS1 = SHIPADDRESS1;
    }

    public String getSHIPADDRESS2() {
        return SHIPADDRESS2;
    }

    public void setSHIPADDRESS2(String SHIPADDRESS2) {
        this.SHIPADDRESS2 = SHIPADDRESS2;
    }

    public String getSHIPEADDRESS3() {
        return SHIPADDRESS3;
    }

    public void setSHIPEADDRESS3(String SHIPEADDRESS3) {
        this.SHIPADDRESS3 = SHIPEADDRESS3;
    }

    public String getSHIPCITY() {
        return SHIPCITY;
    }

    public void setSHIPCITY(String SHIPCITY) {
        this.SHIPCITY = SHIPCITY;
    }

    public String getSHIPSTATE() {
        return SHIPSTATE;
    }

    public void setSHIPSTATE(String SHIPSTATE) {
        this.SHIPSTATE = SHIPSTATE;
    }

    public String getSHIPZIPCODE() {
        return SHIPZIPCODE;
    }

    public void setSHIPZIPCODE(String SHIPZIPCODE) {
        this.SHIPZIPCODE = SHIPZIPCODE;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE=HIREDATE;
    }

    public String getEMPLOYEENUMBER() {
        return EMPLOYEENUMBER;
    }

    public void setEMPLOYEENUMBER(String EMPLOYEENUMBER) {
        this.EMPLOYEENUMBER = EMPLOYEENUMBER;
    }
}
