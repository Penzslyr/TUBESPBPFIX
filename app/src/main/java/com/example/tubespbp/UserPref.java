package com.example.tubespbp;
import android.content.Context;
import android.content.SharedPreferences;

public class UserPref {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    //    mendefinisikan key
    public static final String IS_FILLED = "isFilled";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_NIK = "NIK";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_NOTELP = "notelp";


    public UserPref(Context context){
        this.context = context;
//        Penamaan bebas namun disini digunakan userPreferences
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setData(String nama, String NIK,String alamat,String notelp){
//        menyimpan data login ke sharedPreferences dengan key dan value
        editor.putBoolean(IS_FILLED,true);
        editor.putString(KEY_NAMA,nama);
        editor.putString(KEY_NIK,NIK);
        editor.putString(KEY_ALAMAT,alamat);
        editor.putString(KEY_NOTELP,notelp);

//        jangan lupa commit karena kalo hanya set editornya saja tidak commit akan sia sia
        editor.commit();
    }

    public DataPengguna getUserData(){
//        mengembalikan object user untuk menampilkan data user jika user sudah login
        String nama,NIK,alamat,notelp;

        nama = sharedPreferences.getString(KEY_NAMA,null);
        NIK = sharedPreferences.getString(KEY_NIK,null);
        alamat = sharedPreferences.getString(KEY_ALAMAT,null);
        notelp = sharedPreferences.getString(KEY_NOTELP,null);

        return new DataPengguna(nama,NIK,alamat,notelp);
    }
    public Boolean checkFilled(){
//        mengembalikan nilai isLogin jika sudah login otomatis nilai true jika tidak mereturn false
        return sharedPreferences.getBoolean(IS_FILLED,false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
        editor.clear();
    }

}