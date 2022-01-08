
package com.fahrul.cuaca_fahrul.model;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Temp implements Serializable, Parcelable
{

    @SerializedName("day")
    @Expose
    private Double day;
    @SerializedName("min")
    @Expose
    private Double min;
    @SerializedName("max")
    @Expose
    private Double max;
    @SerializedName("night")
    @Expose
    private Double night;
    @SerializedName("eve")
    @Expose
    private Double eve;
    @SerializedName("morn")
    @Expose
    private Double morn;
    public final static Creator<Temp> CREATOR = new Creator<Temp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Temp createFromParcel(android.os.Parcel in) {
            return new Temp(in);
        }

        public Temp[] newArray(int size) {
            return (new Temp[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8287495254504189246L;

    protected Temp(android.os.Parcel in) {
        this.day = ((Double) in.readValue((Double.class.getClassLoader())));
        this.min = ((Double) in.readValue((Double.class.getClassLoader())));
        this.max = ((Double) in.readValue((Double.class.getClassLoader())));
        this.night = ((Double) in.readValue((Double.class.getClassLoader())));
        this.eve = ((Double) in.readValue((Double.class.getClassLoader())));
        this.morn = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public Temp() {
    }

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Temp withDay(Double day) {
        this.day = day;
        return this;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Temp withMin(Double min) {
        this.min = min;
        return this;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Temp withMax(Double max) {
        this.max = max;
        return this;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public Temp withNight(Double night) {
        this.night = night;
        return this;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Temp withEve(Double eve) {
        this.eve = eve;
        return this;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }

    public Temp withMorn(Double morn) {
        this.morn = morn;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(day);
        dest.writeValue(min);
        dest.writeValue(max);
        dest.writeValue(night);
        dest.writeValue(eve);
        dest.writeValue(morn);
    }

    public int describeContents() {
        return  0;
    }

}
