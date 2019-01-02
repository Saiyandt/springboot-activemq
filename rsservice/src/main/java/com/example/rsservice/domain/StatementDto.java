package com.example.rsservice.domain;


import java.io.Serializable;

public class StatementDto {

    String stmId;

    String punNumber;

    public String getStmId() {
        return stmId;
    }

    public void setStmId(String stmId) {
        this.stmId = stmId;
    }

    public String getPunNumber() {
        return punNumber;
    }

    public void setPunNumber(String punNumber) {
        this.punNumber = punNumber;
    }
}
