   package com.example.unishop.horoscope;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class WResponse {

    @SerializedName("sunsign")
    @Expose
    private String sunsign;
    @SerializedName("credit")
    @Expose
    private String credit;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("horoscope")
    @Expose
    private String horoscope;
    @SerializedName("meta")
    @Expose
    private Main main;

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public Main getMeta() {
        return main;
    }

    public void setMeta(Main meta) {
        this.main = meta;
    }

}