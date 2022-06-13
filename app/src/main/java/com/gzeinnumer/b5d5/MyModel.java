package com.gzeinnumer.b5d5;

public class MyModel {
    private int no;
    private String nama;

    public MyModel(int no, String nama) {
        this.no = no;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}

