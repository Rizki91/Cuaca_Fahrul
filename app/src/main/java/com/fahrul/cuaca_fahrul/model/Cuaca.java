
package com.fahrul.cuaca_fahrul.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuaca implements Serializable, Parcelable
{

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timezone_offset")
    @Expose
    private Integer timezoneOffset;
    @SerializedName("daily")
    @Expose
    private List<Daily> daily = null;
    public final static Creator<Cuaca> CREATOR = new Creator<Cuaca>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Cuaca createFromParcel(android.os.Parcel in) {
            return new Cuaca(in);
        }

        public Cuaca[] newArray(int size) {
            return (new Cuaca[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8092940298069775111L;

    protected Cuaca(android.os.Parcel in) {
        this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
        this.lon = ((Double) in.readValue((Double.class.getClassLoader())));
        this.timezone = ((String) in.readValue((String.class.getClassLoader())));
        this.timezoneOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.daily, (Daily.class.getClassLoader()));
    }

    public Cuaca() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Cuaca withLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Cuaca withLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Cuaca withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public Cuaca withTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public Cuaca withDaily(List<Daily> daily) {
        this.daily = daily;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(lat);
        dest.writeValue(lon);
        dest.writeValue(timezone);
        dest.writeValue(timezoneOffset);
        dest.writeList(daily);
    }

    public int describeContents() {
        return  0;
    }

}
