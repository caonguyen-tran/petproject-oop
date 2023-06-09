package model;


import java.util.Date;


public class Project {
    private String project_ID, project_name;
    private Date ngayBatDau, ngayKetThuc;
    private double kinhPhiDauTu;
    private String nguoiChuNhiem;

    public Project(String project_ID, String project_name, Date ngayBatDau, Date ngayKetThuc, String nguoiChuNhiem, double kinhPhiDauTu){
        this.project_ID = project_ID;
        this.project_name = project_name;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.kinhPhiDauTu = kinhPhiDauTu;
        this.nguoiChuNhiem = nguoiChuNhiem;
    }

    public double getKinhPhiDauTu() {
        return kinhPhiDauTu;
    }

    public void setKinhPhiDauTu(double kinhPhiDauTu) {
        this.kinhPhiDauTu = kinhPhiDauTu;
    }

    
    public String getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(String project_ID) {
        this.project_ID = project_ID;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getnguoiChuNhiem() {
        return nguoiChuNhiem;
    }

    public void setnguoiChuNhiem(String nguoiChuNhiem) {
        this.nguoiChuNhiem = nguoiChuNhiem;
    }
}
