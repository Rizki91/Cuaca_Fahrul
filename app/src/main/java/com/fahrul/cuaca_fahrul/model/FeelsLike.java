
package com.fahrul.cuaca_fahrul.model;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeelsLike implements Serializable, Parcelable
{

    @SerializedName("day")
    @Expose
    private Double day;
    @SerializedName("night")
    @Expose
    private Double night;
    @SerializedName("eve")
    @Expose
    private Double eve;
    @SerializedName("morn")
    @Expose
    private Double morn;
    public final static Creator<FeelsLike> CREATOR = new Creator<FeelsLike>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FeelsLike createFromParcel(android.os.Parcel in) {
            return new FeelsLike(in);
        }

        public FeelsLike[] newArray(int size) {
            return (new FeelsLike[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3089760819548442825L;

    protected FeelsLike(android.os.Parcel in) {
        this.day = ((Double) in.readValue((Double.class.getClassLoader())));
        this.night = ((Double) in.readValue((Double.class.getClassLoader())));
        this.eve = ((Double) in.readValue((Double.class.getClassLoader())));
        this.morn = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public FeelsLike() {
    }

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public FeelsLike withDay(Double day) {
        this.day = day;
        return this;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public FeelsLike withNight(Double night) {
        this.night = night;
        return this;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public FeelsLike withEve(Double eve) {
        this.eve = eve;
        return this;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }

    public FeelsLike withMorn(Double morn) {
        this.morn = morn;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(day);
        dest.writeValue(night);
        dest.writeValue(eve);
        dest.writeValue(morn);
    }

    public int describeContents() {
        return  0;
    }

}
