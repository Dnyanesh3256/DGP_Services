package com.example.digitalgram_panchayatservices.governmentgr;

public class GovernmentGrData {
    private String pdfTitle, pdfUrl, list;

    public GovernmentGrData() {}



    public GovernmentGrData(String title, String pdfUrl, String list) {
        this.pdfTitle = title;
        this.pdfUrl = pdfUrl;
        this.list = list;
    }

    public String getpdfTitle()
    {
        return pdfTitle;
    }
    public void setpdfTitle(String pdfTitle){
        this.pdfTitle=pdfTitle;
    }

    public String getList () {
        return list;
    }

    public void setList (String list){
        this.list = list;
    }

    public String getPdfUrl () {
        return pdfUrl;
    }

    public void setPdfUrl (String pdfUrl){
        this.pdfUrl = pdfUrl;
    }
}

