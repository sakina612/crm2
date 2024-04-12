package com.example.crms1;

public class Dataclass2_o {
    private String DataTile;
    private String DataDesc;
    private String DataLang;
    private String DataImage;

    public String getDataTile() {
        return DataTile;
    }

    public String getDataDesc() {
        return DataDesc;
    }

    public String getDataLang() {
        return DataLang;
    }
    public String getDataImage() {
        return DataImage;
    }



    public Dataclass2_o(String DataTile, String DataDesc, String DataLang,String DataImage ){
        this.DataTile = DataTile;
        this.DataDesc = DataDesc;
        this.DataLang = DataLang;
        this.DataImage = DataImage;

    }
}
