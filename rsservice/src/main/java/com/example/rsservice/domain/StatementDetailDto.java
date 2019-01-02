package com.example.rsservice.domain;

public class StatementDetailDto {

    String stmId;

    String punNumber;

    String totalAmt;

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

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }
}
