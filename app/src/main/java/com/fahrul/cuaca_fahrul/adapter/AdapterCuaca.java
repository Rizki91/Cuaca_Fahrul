package com.fahrul.cuaca_fahrul.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fahrul.cuaca_fahrul.R;
import com.fahrul.cuaca_fahrul.model.Daily;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AdapterCuaca extends RecyclerView.Adapter<AdapterCuaca.ViewHolder> {

    java.util.List<Daily> data;
    String lokasi;
    Context context;
    
    public AdapterCuaca (Context context,  java.util.List<Daily>  data , String lokasi){
        this.context = context;
        this.data = data;
        this.lokasi = lokasi;
    }

    @NonNull
    @Override
    public AdapterCuaca.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view ;

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);


        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCuaca.ViewHolder viewHolder, int i) {


        String date = "yyyy-MM-dd";
        Date  crr = Calendar.getInstance().getTime();
        String tr = new SimpleDateFormat(date).format(crr);
        String trx = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(data.get(i).getDt()*1000));

        if(tr.equals(trx)){
            viewHolder.parentLayout.setVisibility(View.GONE);
            viewHolder.crItems.setVisibility(View.GONE);
        }
        viewHolder.txtLokasi.setText(lokasi);
        viewHolder.txtCuaca.setText(data.get(i).getWeather().get(0).getDescription());
        viewHolder.txtSuhu.setText(new DecimalFormat("##.##").format(data.get(i).getTemp().getDay()));
        viewHolder.txtTanggal.setText(trx);
        String image = "https://openweathermap.org/img/wn/"+ data.get(i).getWeather().get(0).getIcon()+"@2x.png";
        Picasso.get().load(image).into(viewHolder.image);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtSuhu,txtLokasi,txtCuaca,txtTanggal;
        private ImageView image;
        private CardView crItems;
        private LinearLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLokasi = (TextView) itemView.findViewById(R.id.txtLokasi);
            txtSuhu = (TextView) itemView.findViewById(R.id.txtSuhu);
            txtCuaca = (TextView) itemView.findViewById(R.id.txtCuaca);
            txtTanggal = (TextView) itemView.findViewById(R.id.txtTgl);
            image = (ImageView)itemView.findViewById(R.id.image);
            parentLayout = (LinearLayout)itemView.findViewById(R.id.lyCuaca);
            crItems = (CardView)itemView.findViewById(R.id.crItem);


        }
    }
}
