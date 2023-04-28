package com.vulnerable.application.service;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

public class MediumFlag implements Serializable {
    static final long serialVersionUID = 13371337L;

    private String mediumFlag;

    public MediumFlag() {
    }

    public MediumFlag(String url) throws IOException {
        this.mediumFlag = System.getenv("MEDIUMFLAG");
        URL u = new URL(url + "?flag=" + this.mediumFlag);
        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);
    }

}
