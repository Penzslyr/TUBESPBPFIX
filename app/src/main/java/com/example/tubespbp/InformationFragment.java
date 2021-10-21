package com.example.tubespbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationFragment extends Fragment{
    private DataPengguna dataPengguna;
    private DataHotel dataHotel;
    private UserPref userPref;
    private TextView nama;
    private TextView nik;
    private TextView alamat;
    private TextView namahotel;
    private TextView nokamar;
    private TextView total;
    private String namahotel1;
    private String nokamar1;
    private String hargahotel1;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public InformationFragment newInstance(String param1, String param2) {
        InformationFragment fragment = new InformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);


        userPref = new UserPref(getContext());
        nama = view.findViewById(R.id.nama);
        nik = view.findViewById(R.id.nik);
        alamat = view.findViewById(R.id.alamat);
        //namahotel = view.findViewById(R.id.namahotel);
        //nokamar = view.findViewById(R.id.nokamar);
        total = view.findViewById(R.id.total);
        dataPengguna = userPref.getUserData();
        checkFilled();
        nama.setText(dataPengguna.getNama());
        nik.setText(dataPengguna.getNIK());
        alamat.setText(dataPengguna.getAlamat());
        return view;
    }

    private void checkFilled(){
        if(!userPref.checkFilled()){
            startActivity(new Intent(getContext(), InputActivity.class));
            getActivity().finish();
        }else{
            Toast.makeText(getContext(), "Welcome back !",Toast.LENGTH_SHORT).show();
        }
    }



}