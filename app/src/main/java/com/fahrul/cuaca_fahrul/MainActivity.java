package com.fahrul.cuaca_fahrul;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fahrul.cuaca_fahrul.adapter.AdapterCuaca;
import com.fahrul.cuaca_fahrul.model.Coord;
import com.fahrul.cuaca_fahrul.model.Cuaca;
import com.fahrul.cuaca_fahrul.model.Cuacaone;
import com.fahrul.cuaca_fahrul.service.APIClient;
import com.fahrul.cuaca_fahrul.service.APIInterfacesRest;
import com.location.aravind.getlocation.GeoLocator;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GeoLocator geolocation;
    AdapterCuaca adapterCuaca;
    RecyclerView lstCuaca,ryMain;
    TextView txCuaca, txSuhu, txLLokasi,txTgl;
    SearchView search;
    ImageView images;
    String kota;
    Double lat, lon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geolocation = new GeoLocator(getApplicationContext(),MainActivity.this);


        lat = geolocation.getLattitude();
        lon = geolocation.getLongitude();
        kota = geolocation.getState();

        lstCuaca = findViewById(R.id.ryList);
        txCuaca = findViewById(R.id.txCuaca);
        txLLokasi = findViewById(R.id.txLokasi);
        txSuhu = findViewById(R.id.txSuhu);
        search = findViewById(R.id.seacrch);
        txTgl = findViewById(R.id.txTgl);
        images = findViewById(R.id.images);


      

        GridLayoutManager mlayout = new GridLayoutManager(this, 2, RecyclerView.VERTICAL,false);
        lstCuaca.setLayoutManager(mlayout);
        lstCuaca.setAdapter(adapterCuaca);
        lstCuaca.setHasFixedSize(true);




        callMain(lat,lon);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                kota = s;
                callForecastbyCity(kota);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {


                return false;
            }
        });








    }

    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;
    public void callForecastbyCity(String kota){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<Cuacaone> call3 = apiInterface.getForecastByCity(kota,"a66247bf847d4ef1b04e0357c9291521");
        call3.enqueue(new Callback<Cuacaone>() {
            @Override
            public void onResponse(Call<Cuacaone> call, Response<Cuacaone> response) {
                progressDialog.dismiss();
                Cuacaone dataWeather = response.body();

                if (dataWeather !=null) {

                    //     txtKota.setText(dataWeather.getName());
                    //     txtTemperature.setText(new DecimalFormat("##.##").format(dataWeather.getMain().getTemp()-273.15));

//                    AdapterCuaca adapter = new AdapterCuaca(MainActivity.this,dataWeather.getList(),dataWeather.getCity().getName());
//
//
//                    lstCuaca.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                    lstCuaca.setItemAnimator(new DefaultItemAnimator());
//                    lstCuaca.setAdapter(adapter);

                     lat = dataWeather.getCity().getCoord().getLat();
                     lon = dataWeather.getCity().getCoord().getLon();

                    callLat(lat,lon);



                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Cuacaone> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void callLat(Double lat,Double lon){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<Cuaca> call3 = apiInterface.getForecastBylatlon(lat,lon,"current,hourly,minutely,alerts","metric","a66247bf847d4ef1b04e0357c9291521");
        call3.enqueue(new Callback<Cuaca>() {
            @Override
            public void onResponse(Call<Cuaca> call, Response<Cuaca> response) {
                progressDialog.dismiss();
                Cuaca dataWeather = response.body();

                if (dataWeather !=null) {

                    //     txtKota.setText(dataWeather.getName());
                    //     txtTemperature.setText(new DecimalFormat("##.##").format(dataWeather.getMain().getTemp()-273.15));

                    AdapterCuaca adapter = new AdapterCuaca(MainActivity.this,dataWeather.getDaily(),kota);


                    lstCuaca.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    lstCuaca.setItemAnimator(new DefaultItemAnimator());
                    lstCuaca.setAdapter(adapter);



                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Cuaca> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    public void callMain(Double lat,Double lon){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<Cuaca> call3 = apiInterface.getForecastBylatlon(lat,lon,"current,hourly,minutely,alerts","metric","a66247bf847d4ef1b04e0357c9291521");
        call3.enqueue(new Callback<Cuaca>() {
            @Override
            public void onResponse(Call<Cuaca> call, Response<Cuaca> response) {
                progressDialog.dismiss();
                Cuaca dataWeather = response.body();
                //Toast.makeText(LoginActivity.this,userList.getToken().toString(),Toast.LENGTH_LONG).show();
                if (dataWeather !=null) {


                    String date = "yyyy-MM-dd";
                    Date  crr = Calendar.getInstance().getTime();
                    String tr = new SimpleDateFormat(date).format(crr);



                    for(int i = 0 ; i < dataWeather.getDaily().size(); i++){
                        String trx = new SimpleDateFormat(date, Locale.getDefault()).format(new Date(dataWeather.getDaily().get(i).getDt()*1000));

                        if(tr.equals(trx)){
                            txLLokasi.setText(kota);
                            txSuhu.setText(new DecimalFormat("##.##").format(dataWeather.getDaily().get(i).getTemp().getDay()));
                            txCuaca.setText(dataWeather.getDaily().get(i).getWeather().get(i).getDescription());
                            txTgl.setText(trx);
                            String image = "https://openweathermap.org/img/wn/"+ dataWeather.getDaily().get(i).getWeather().get(0).getIcon()+"@2x.png";
                            Picasso.get().load(image).into(images);
                        }


                    }

                    AdapterCuaca adapter = new AdapterCuaca(MainActivity.this,dataWeather.getDaily(),kota);


                    lstCuaca.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    lstCuaca.setItemAnimator(new DefaultItemAnimator());
                    lstCuaca.setAdapter(adapter);


                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Cuaca> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}