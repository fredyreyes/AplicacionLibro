package com.example.fredy.aplicacionlibro;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlantillaFragment extends Fragment {


    private static final String ARG_PARAM1 = "urlImagen";
    private static final String ARG_PARAM2 = "index";

    // TODO: Rename and change types of parameters

    private String urlImagen;
    private int index;


    // TODO: Rename and change types and number of parameters
    public static PlantillaFragment newInstance(String urlImagen, int index) {
        PlantillaFragment fragment = new PlantillaFragment();
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



    public PlantillaFragment() {


    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_plantilla, container, false);


        Resources res = getResources();

        View view=inflater.inflate(R.layout.fragment_plantilla, container, false);

        FrameLayout frameLayout=(FrameLayout)rootView.findViewById(R.id.fondoPlantilla);
        int idImagen=Integer.parseInt(this.urlImagen);
        frameLayout.setBackgroundResource(idImagen);

        return rootView;

    }

}
