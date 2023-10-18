package com.example.furama2.contract;

public class ContractDetail {
    int code;
    int codeContract;
    int codeServiceAttach;
    int quantity;
//    ma_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
//    ma_hop_dong          INT,
//    ma_dich_vu_di_kem    INT,
//    so_luong             INT,
public int getCode() {
    return code;
}

    public void setCode(int code) {
        this.code = code;
    }

    public int getCodeContract() {
        return codeContract;
    }

    public void setCodeContract(int codeContract) {
        this.codeContract = codeContract;
    }

    public int getCodeServiceAttach() {
        return codeServiceAttach;
    }

    public void setCodeServiceAttach(int codeServiceAttach) {
        this.codeServiceAttach = codeServiceAttach;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ContractDetail(int code, int codeContract, int codeServiceAttach, int quantity) {
        this.code = code;
        this.codeContract = codeContract;
        this.codeServiceAttach = codeServiceAttach;
        this.quantity = quantity;
    }

    public ContractDetail() {
    }

    public ContractDetail(int codeContract, int codeServiceAttach, int quantity) {
        this.codeContract = codeContract;
        this.codeServiceAttach = codeServiceAttach;
        this.quantity = quantity;
    }
}
