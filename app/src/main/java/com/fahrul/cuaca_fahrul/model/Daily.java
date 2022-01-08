
package com.fahrul.cuaca_fahrul.model;

import java.io.Serializable;
import java.util.List;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Daily implements Serializable, Parcelable
{

    @SerializedName("dt")
    @Expose
    private Long dt;
    @SerializedName("sunrise")
    @Expose
    private Integer sunrise;
    @SerializedName("sunset")
    @Expose
    private Integer sunset;
    @SerializedName("moonrise")
    @Expose
    private Integer moonrise;
    @SerializedName("moonset")
    @Expose
    private Integer moonset;
    @SerializedName("moon_phase")
    @Expose
    private Double moonPhase;
    @SerializedName("temp")
    @Expose
    private Temp temp;
    @SerializedName("feels_like")
    @Expose
    private FeelsLike feelsLike;
    @SerializedName("pressure")
    @Expose
    private Integer pressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("dew_point")
    @Expose
    private Double dewPoint;
    @SerializedName("wind_speed")
    @Expose
    private Double windSpeed;
    @SerializedName("wind_deg")
    @Expose
    private Integer windDeg;
    @SerializedName("wind_gust")
    @Expose
    private Double windGust;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("clouds")
    @Expose
    private Integer clouds;
    @SerializedName("pop")
    @Expose
    private Double pop;
    @SerializedName("uvi")
    @Expose
    private Double uvi;
    @SerializedName("rain")
    @Expose
    private Double rain;
    public final static Creator<Daily> CREATOR = new Creator<Daily>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Daily createFromParcel(android.os.Parcel in) {
            return new Daily(in);
        }

        public Daily[] newArray(int size) {
            return (new Daily[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2475621981170801250L;

    protected Daily(android.os.Parcel in) {
        this.dt = ((Long) in.readValue((Long.class.getClassLoader())));
        this.sunrise = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sunset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.moonrise = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.moonset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.moonPhase = ((Double) in.readValue((Double.class.getClassLoader())));
        this.temp = ((Temp) in.readValue((Temp.class.getClassLoader())));
        this.feelsLike = ((FeelsLike) in.readValue((FeelsLike.class.getClassLoader())));
        this.pressure = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.humidity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dewPoint = ((Double) in.readValue((Double.class.getClassLoader())));
        this.windSpeed = ((Double) in.readValue((Double.class.getClassLoader())));
        this.windDeg = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.windGust = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.weather, (Weather.class.getClassLoader()));
        this.clouds = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pop = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.uvi = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rain = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public Daily() {
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Daily withDt(Long dt) {
        this.dt = dt;
        return this;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Daily withSunrise(Integer sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    public Daily withSunset(Integer sunset) {
        this.sunset = sunset;
        return this;
    }

    public Integer getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(Integer moonrise) {
        this.moonrise = moonrise;
    }

    public Daily withMoonrise(Integer moonrise) {
        this.moonrise = moonrise;
        return this;
    }

    public Integer getMoonset() {
        return moonset;
    }

    public void setMoonset(Integer moonset) {
        this.moonset = moonset;
    }

    public Daily withMoonset(Integer moonset) {
        this.moonset = moonset;
        return this;
    }

    public Double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Daily withMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
        return this;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Daily withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Daily withFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Daily withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Daily withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Daily withDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Daily withWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
    }

    public Daily withWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
        return this;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Daily withWindGust(Double windGust) {
        this.windGust = windGust;
        return this;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Daily withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Daily withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public Daily withPop(Double pop) {
        this.pop = pop;
        return this;
    }

    public Double getUvi() {
        return uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    public Daily withUvi(Double uvi) {
        this.uvi = uvi;
        return this;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Daily withRain(Double rain) {
        this.rain = rain;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(dt);
        dest.writeValue(sunrise);
        dest.writeValue(sunset);
        dest.writeValue(moonrise);
        dest.writeValue(moonset);
        dest.writeValue(moonPhase);
        dest.writeValue(temp);
        dest.writeValue(feelsLike);
        dest.writeValue(pressure);
        dest.writeValue(humidity);
        dest.writeValue(dewPoint);
        dest.writeValue(windSpeed);
        dest.writeValue(windDeg);
        dest.writeValue(windGust);
        dest.writeList(weather);
        dest.writeValue(clouds);
        dest.writeValue(pop);
        dest.writeValue(uvi);
        dest.writeValue(rain);
    }

    public int describeContents() {
        return  0;
    }

}
