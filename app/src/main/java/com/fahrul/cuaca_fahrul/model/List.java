
package com.fahrul.cuaca_fahrul.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List implements Serializable, Parcelable
{

    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("weatherone")
    @Expose
    private java.util.List<Weatherone> weatherone = null;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("pop")
    @Expose
    private Double pop;
    @SerializedName("rain")
    @Expose
    private Rain rain;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;
    public final static Creator<List> CREATOR = new Creator<List>() {


        @SuppressWarnings({
            "unchecked"
        })
        public List createFromParcel(Parcel in) {
            return new List(in);
        }

        public List[] newArray(int size) {
            return (new List[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2641199046501127815L;

    protected List(Parcel in) {
        this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.main = ((Main) in.readValue((Main.class.getClassLoader())));
        in.readList(this.weatherone, (Weatherone.class.getClassLoader()));
        this.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
        this.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
        this.visibility = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pop = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rain = ((Rain) in.readValue((Rain.class.getClassLoader())));
        this.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
        this.dtTxt = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public List() {
    }

    /**
     * 
     * @param dt
     * @param pop
     * @param rain
     * @param visibility
     * @param dtTxt
     * @param weatherone
     * @param main
     * @param clouds
     * @param sys
     * @param wind
     */
    public List(Integer dt, Main main, java.util.List<Weatherone> weatherone, Clouds clouds, Wind wind, Integer visibility, Double pop, Rain rain, Sys sys, String dtTxt) {
        super();
        this.dt = dt;
        this.main = main;
        this.weatherone = weatherone;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.rain = rain;
        this.sys = sys;
        this.dtTxt = dtTxt;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weatherone> getWeather() {
        return weatherone;
    }

    public void setWeather(java.util.List<Weatherone> weatherone) {
        this.weatherone = weatherone;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dt);
        dest.writeValue(main);
        dest.writeList(weatherone);
        dest.writeValue(clouds);
        dest.writeValue(wind);
        dest.writeValue(visibility);
        dest.writeValue(pop);
        dest.writeValue(rain);
        dest.writeValue(sys);
        dest.writeValue(dtTxt);
    }

    public int describeContents() {
        return  0;
    }

}
