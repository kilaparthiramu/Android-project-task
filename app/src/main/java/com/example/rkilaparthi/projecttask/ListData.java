package com.example.rkilaparthi.projecttask;

/**
 * Created by rkilaparthi on 9/26/2016.
 */
public class ListData {

    private String auction_id;
    private String auction_detail;
    private String zone;
    private String area;
    private String view;
    private String google_map;



    public ListData(String auction_id, String auction_detail, String zone, String area, String view, String google_map) {

        this.auction_id = auction_id;
        this.auction_detail = auction_detail;
        this.zone = zone;
        this.area = area;
        this.view = view;
        this.google_map = google_map;
    }




    public String getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public String getAuction_detail() {
        return auction_detail;
    }

    public void setAuction_detail(String auction_detail) {
        this.auction_detail = auction_detail;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getGoogle_map() {
        return google_map;
    }

    public void setGoogle_map(String google_map) {
        this.google_map = google_map;
    }
}
