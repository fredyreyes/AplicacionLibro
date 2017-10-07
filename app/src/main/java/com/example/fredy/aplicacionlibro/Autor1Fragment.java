
package com.example.fredy.aplicacionlibro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Autor1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Autor1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Autor1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nombreAutor";
    private static final String ARG_PARAM2 = "textoAutor";
    private static final String ARG_PARAM3 = "urlImagen";
    private static final String ARG_PARAM4 = "index";
    // TODO: Rename and change types of parameters
    private String nombreAutor;
    private String textoAutor;
    private String urlImagen;
    private int index;


    public Autor1Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Autor1Fragment newInstance(String nombreAutor, String textoAutor, String urlImagen, int index) {
        Autor1Fragment fragment = new Autor1Fragment();
        Bundle args = new Bundle();


        args.putString(ARG_PARAM1, nombreAutor);
        args.putString(ARG_PARAM2, textoAutor);
        args.putString(ARG_PARAM3, urlImagen);
        args.putInt(ARG_PARAM4, index);
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            this.nombreAutor = getArguments().getString(ARG_PARAM1);
            this.textoAutor = getArguments().getString(ARG_PARAM2);
            this.urlImagen= getArguments().getString(ARG_PARAM3);
            this.index=getArguments().getInt(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_autor1, container, false);

        /*Context context = getContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
*/

        TextView tvIndex = (TextView) rootView.findViewById(R.id.textIndex);
        TextView tvAutor = (TextView) rootView.findViewById(R.id.textAuthorName);
        TextView tvDescripcion = (TextView) rootView.findViewById(R.id.textDescription);

        tvIndex.setText(String.valueOf(this.index));
        tvDescripcion.setText(String.valueOf(this.textoAutor));
        tvAutor.setText(String.valueOf(this.nombreAutor));


        return rootView;

    }

}
