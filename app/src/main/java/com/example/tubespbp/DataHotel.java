package com.example.tubespbp;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

public class DataHotel extends BaseObservable implements Parcelable {
    private String namaHotel;
    private String noKamar;
    private String harga;
    private String url;

    public DataHotel(){}

    public DataHotel(String namaHotel, String noKamar, String harga, String url) {
        this.namaHotel = namaHotel;
        this.noKamar = noKamar;
        this.harga = harga;
        this.url = url;
    }

    @Bindable
    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }
    @Bindable
    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }
    @Bindable
    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView)
                .load(url)
                .into(imageView);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
