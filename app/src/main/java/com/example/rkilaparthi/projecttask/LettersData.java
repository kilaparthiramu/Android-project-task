package com.example.rkilaparthi.projecttask;

/**
 * Created by rkilaparthi on 10/3/2016.
 */
public class LettersData {

    private String scheme_name;
    private String dateof_upload;
    private String version;
    private String description;
    private String view;

    public LettersData(String scheme_name, String dateof_upload, String version, String description, String view) {
        this.scheme_name = scheme_name;
        this.dateof_upload = dateof_upload;
        this.version = version;
        this.description = description;
        this.view = view;
    }

    public String getScheme_name() {
        return scheme_name;
    }

    public void setScheme_name(String scheme_name) {
        this.scheme_name = scheme_name;
    }

    public String getDateof_upload() {
        return dateof_upload;
    }

    public void setDateof_upload(String dateof_upload) {
        this.dateof_upload = dateof_upload;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
