
package com.example.fredy.aplicacionlibro;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



public class Autor1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private static final String ARG_PARAM1 = "urlImagen";
    private static final String ARG_PARAM2 = "index";

    // TODO: Rename and change types of parameters

    private String urlImagen;
    private int index;


    public Autor1Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Autor1Fragment newInstance(String urlImagen, int index) {
        Autor1Fragment fragment = new Autor1Fragment();
        Bundle args = new Bundle();


        args.putString(ARG_PARAM1, urlImagen);
        args.putInt(ARG_PARAM2, index);
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {

            this.urlImagen= getArguments().getString(ARG_PARAM1);
            this.index=getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_autor1, container, false);


        Resources res = getResources();

        View view=inflater.inflate(R.layout.fragment_autor1, container, false);

        FrameLayout frameLayout=(FrameLayout)rootView.findViewById(R.id.fondoApp);
         int idImagen=Integer.parseInt(this.urlImagen);
        frameLayout.setBackgroundResource(idImagen);

        return rootView;

    }

}
