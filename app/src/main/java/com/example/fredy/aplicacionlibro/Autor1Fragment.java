
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


        //frameLayout.setBackgroundResource(Integer.parseInt(urlImagen));


        switch (this.index){


            case 1:
                frameLayout.setBackgroundResource(R.drawable.poesia);

            break;

            case 2:

                frameLayout.setBackgroundResource(R.drawable.poesia2);
            break;

            case 3:
                frameLayout.setBackgroundResource(R.drawable.poesia3);

            break;

            case 4:
                frameLayout.setBackgroundResource(R.drawable.poesia4);
            break;
            case 5:    frameLayout.setBackgroundResource(R.drawable.poesia5);
            break;
            /*
            case 6:    frameLayout.setBackgroundResource(R.drawable.poesia_digital6);
            break;
            case 7:    frameLayout.setBackgroundResource(R.drawable.poesia_digital7);
            break;
            case 8:    frameLayout.setBackgroundResource(R.drawable.poesia_digital8);
            break;
            case 9:    frameLayout.setBackgroundResource(R.drawable.poesia_digital9);
            break;
            case 10:    frameLayout.setBackgroundResource(R.drawable.poesia_digital10);
            break;
            case 11:    frameLayout.setBackgroundResource(R.drawable.poesia_digital11);
            break;
            case 12:    frameLayout.setBackgroundResource(R.drawable.poesia_digital12);
            break;
            case 13:    frameLayout.setBackgroundResource(R.drawable.poesia_digital13);
            break;
            case 14:    frameLayout.setBackgroundResource(R.drawable.poesia_digital14);
            break;
            case 15:    frameLayout.setBackgroundResource(R.drawable.poesia_digital15);
            break;
            case 16:    frameLayout.setBackgroundResource(R.drawable.poesia_digital16);
            break;
            case 17:    frameLayout.setBackgroundResource(R.drawable.poesia_digital17);
            break;
            case 18:    frameLayout.setBackgroundResource(R.drawable.poesia_digital18);
            break;
            case 19:    frameLayout.setBackgroundResource(R.drawable.poesia_digital19);
            break;
            case 20:    frameLayout.setBackgroundResource(R.drawable.poesia_digital20);
            break;
            case 21:    frameLayout.setBackgroundResource(R.drawable.poesia_digital21);
            break;
            case 22:    frameLayout.setBackgroundResource(R.drawable.poesia_digital22);
            break;
            case 23:    frameLayout.setBackgroundResource(R.drawable.poesia_digital23);
            break;
            case 24:    frameLayout.setBackgroundResource(R.drawable.poesia_digital24);
            break;
            case 25:    frameLayout.setBackgroundResource(R.drawable.poesia_digital25);
            break;
            case 26:    frameLayout.setBackgroundResource(R.drawable.poesia_digital26);
            break;
            case 27:    frameLayout.setBackgroundResource(R.drawable.poesia_digital27);
            break;
            case 28:    frameLayout.setBackgroundResource(R.drawable.poesia_digital28);
            break;
            case 29:    frameLayout.setBackgroundResource(R.drawable.poesia_digital29);
            break;
            case 30:    frameLayout.setBackgroundResource(R.drawable.poesia_digital30);
            break;
            case 31:    frameLayout.setBackgroundResource(R.drawable.poesia_digital31);
            break;
            case 32:    frameLayout.setBackgroundResource(R.drawable.poesia_digital32);
            break;
            case 33:    frameLayout.setBackgroundResource(R.drawable.poesia_digital33);
            break;
            case 34:    frameLayout.setBackgroundResource(R.drawable.poesia_digital34);
            break;
            case 35:    frameLayout.setBackgroundResource(R.drawable.poesia_digital35);
            break;
            case 36:    frameLayout.setBackgroundResource(R.drawable.poesia_digital36);
            break;
            case 37:    frameLayout.setBackgroundResource(R.drawable.poesia_digital37);
            break;
            case 38:    frameLayout.setBackgroundResource(R.drawable.poesia_digital38);
            break;
            case 39:    frameLayout.setBackgroundResource(R.drawable.poesia_digital39);
            break;
            case 40:    frameLayout.setBackgroundResource(R.drawable.poesia_digital40);
            break;
            case 41:    frameLayout.setBackgroundResource(R.drawable.poesia_digital41);
            break;
            case 42:    frameLayout.setBackgroundResource(R.drawable.poesia_digital42);
            break;
            case 43:    frameLayout.setBackgroundResource(R.drawable.poesia_digital43);
            break;
            case 44:    frameLayout.setBackgroundResource(R.drawable.poesia_digital44);
            break;
            case 45:    frameLayout.setBackgroundResource(R.drawable.poesia_digital45);
            break;
            case 46:    frameLayout.setBackgroundResource(R.drawable.poesia_digital46);
            break;
            case 47:    frameLayout.setBackgroundResource(R.drawable.poesia_digital47);
            break;
            case 48:    frameLayout.setBackgroundResource(R.drawable.poesia_digital48);
            break;
            case 49:    frameLayout.setBackgroundResource(R.drawable.poesia_digital49);
            break;
            case 50:    frameLayout.setBackgroundResource(R.drawable.poesia_digital50);
            break;
            case 51:    frameLayout.setBackgroundResource(R.drawable.poesia_digital51);
            break;
            case 52:    frameLayout.setBackgroundResource(R.drawable.poesia_digital52);
            break;
            case 53:    frameLayout.setBackgroundResource(R.drawable.poesia_digital53);
            break;
            case 54:    frameLayout.setBackgroundResource(R.drawable.poesia_digital54);
            break;
            case 55:    frameLayout.setBackgroundResource(R.drawable.poesia_digital55);
            break;
            case 56:    frameLayout.setBackgroundResource(R.drawable.poesia_digital56);
            break;
            case 57:    frameLayout.setBackgroundResource(R.drawable.poesia_digital57);
            break;
            case 58:    frameLayout.setBackgroundResource(R.drawable.poesia_digital58);
            break;
            case 59:    frameLayout.setBackgroundResource(R.drawable.poesia_digital59);
            break;
            case 60:    frameLayout.setBackgroundResource(R.drawable.poesia_digital60);
            break;
            case 61:    frameLayout.setBackgroundResource(R.drawable.poesia_digital61);
            break;
            case 62:    frameLayout.setBackgroundResource(R.drawable.poesia_digital62);
            break;
            case 63:    frameLayout.setBackgroundResource(R.drawable.poesia_digital63);
            break;
            case 64:    frameLayout.setBackgroundResource(R.drawable.poesia_digital64);
            break;
            case 65:    frameLayout.setBackgroundResource(R.drawable.poesia_digital65);
            break;
            case 66:    frameLayout.setBackgroundResource(R.drawable.poesia_digital66);
            break;
            case 67:    frameLayout.setBackgroundResource(R.drawable.poesia_digital67);
            break;
            case 68:    frameLayout.setBackgroundResource(R.drawable.poesia_digital68);
            break;
            case 69:    frameLayout.setBackgroundResource(R.drawable.poesia_digital69);
            break;
            case 70:    frameLayout.setBackgroundResource(R.drawable.poesia_digital70);
            break;
            case 71:    frameLayout.setBackgroundResource(R.drawable.poesia_digital71);
            break;
            case 72:    frameLayout.setBackgroundResource(R.drawable.poesia_digital72);
            break;
            case 73:    frameLayout.setBackgroundResource(R.drawable.poesia_digital73);
            break;
            case 74:    frameLayout.setBackgroundResource(R.drawable.poesia_digital74);
            break;
            case 75:    frameLayout.setBackgroundResource(R.drawable.poesia_digital75);
            break;
            case 76:    frameLayout.setBackgroundResource(R.drawable.poesia_digital76);
            break;
            case 77:    frameLayout.setBackgroundResource(R.drawable.poesia_digital77);
            break;
            case 78:    frameLayout.setBackgroundResource(R.drawable.poesia_digital78);
            break;
            case 79:    frameLayout.setBackgroundResource(R.drawable.poesia_digital79);
            break;
            case 80:    frameLayout.setBackgroundResource(R.drawable.poesia_digital80);
            break;
            case 81:    frameLayout.setBackgroundResource(R.drawable.poesia_digital81);
            break;
            case 82:    frameLayout.setBackgroundResource(R.drawable.poesia_digital82);
            break;
            case 83:    frameLayout.setBackgroundResource(R.drawable.poesia_digital83);
            break;
            case 84:    frameLayout.setBackgroundResource(R.drawable.poesia_digital84);
            break;
            case 85:    frameLayout.setBackgroundResource(R.drawable.poesia_digital85);
            break;
            case 86:    frameLayout.setBackgroundResource(R.drawable.poesia_digital86);
            break;
            case 87:    frameLayout.setBackgroundResource(R.drawable.poesia_digital87);
            break;
            case 88:    frameLayout.setBackgroundResource(R.drawable.poesia_digital88);
            break;
            case 89:    frameLayout.setBackgroundResource(R.drawable.poesia_digital89);
            break;
            case 90:    frameLayout.setBackgroundResource(R.drawable.poesia_digital90);
            break;
            case 91:    frameLayout.setBackgroundResource(R.drawable.poesia_digital91);
            break;
            case 92:    frameLayout.setBackgroundResource(R.drawable.poesia_digital92);
            break;
            case 93:    frameLayout.setBackgroundResource(R.drawable.poesia_digital93);
            break;
            case 94:    frameLayout.setBackgroundResource(R.drawable.poesia_digital94);
            break;
            case 95:    frameLayout.setBackgroundResource(R.drawable.poesia_digital95);
            break;
            case 96:    frameLayout.setBackgroundResource(R.drawable.poesia_digital96);
            break;
            case 97:    frameLayout.setBackgroundResource(R.drawable.poesia_digital97);
            break;
            case 98:    frameLayout.setBackgroundResource(R.drawable.poesia_digital98);
            break;
            case 99:    frameLayout.setBackgroundResource(R.drawable.poesia_digital99);
            break;
            case 100:    frameLayout.setBackgroundResource(R.drawable.poesia_digital100);
            break;
            case 101:    frameLayout.setBackgroundResource(R.drawable.poesia_digital101);
            break;
            case 102:    frameLayout.setBackgroundResource(R.drawable.poesia_digital102);
            break;
            case 103:    frameLayout.setBackgroundResource(R.drawable.poesia_digital103);
            break;
            case 104:    frameLayout.setBackgroundResource(R.drawable.poesia_digital104);
            break;
            case 105:    frameLayout.setBackgroundResource(R.drawable.poesia_digital105);
            break;
            case 106:    frameLayout.setBackgroundResource(R.drawable.poesia_digital106);
            break;
            case 107:    frameLayout.setBackgroundResource(R.drawable.poesia_digital107);
            break;
            case 108:    frameLayout.setBackgroundResource(R.drawable.poesia_digital108);
            break;
            case 109:    frameLayout.setBackgroundResource(R.drawable.poesia_digital109);
            break;
            case 110:    frameLayout.setBackgroundResource(R.drawable.poesia_digital110);
            break;
            case 111:    frameLayout.setBackgroundResource(R.drawable.poesia_digital111);
            break;
            case 112:    frameLayout.setBackgroundResource(R.drawable.poesia_digital112);
            break;
            case 113:    frameLayout.setBackgroundResource(R.drawable.poesia_digital113);
            break;
            case 114:    frameLayout.setBackgroundResource(R.drawable.poesia_digital114);
            break;
            case 115:    frameLayout.setBackgroundResource(R.drawable.poesia_digital115);
            break;
            case 116:    frameLayout.setBackgroundResource(R.drawable.poesia_digital116);
            break;
            case 117:    frameLayout.setBackgroundResource(R.drawable.poesia_digital117);
            break;
            case 118:    frameLayout.setBackgroundResource(R.drawable.poesia_digital118);
            break;
            case 119:    frameLayout.setBackgroundResource(R.drawable.poesia_digital119);
            break;
            case 120:    frameLayout.setBackgroundResource(R.drawable.poesia_digital120);
            break;
            case 121:    frameLayout.setBackgroundResource(R.drawable.poesia_digital121);
            break;
            case 122:    frameLayout.setBackgroundResource(R.drawable.poesia_digital122);
            break;
            case 123:    frameLayout.setBackgroundResource(R.drawable.poesia_digital123);
            break;
            case 124:    frameLayout.setBackgroundResource(R.drawable.poesia_digital124);
            break;
            case 125:    frameLayout.setBackgroundResource(R.drawable.poesia_digital125);
            break;
            case 126:    frameLayout.setBackgroundResource(R.drawable.poesia_digital126);
            break;
            case 127:    frameLayout.setBackgroundResource(R.drawable.poesia_digital127);
            break;
            case 128:    frameLayout.setBackgroundResource(R.drawable.poesia_digital128);
            break;
            case 129:    frameLayout.setBackgroundResource(R.drawable.poesia_digital129);
            break;
            case 130:    frameLayout.setBackgroundResource(R.drawable.poesia_digital130);
            break;
            case 131:    frameLayout.setBackgroundResource(R.drawable.poesia_digital131);
            break;
            case 132:    frameLayout.setBackgroundResource(R.drawable.poesia_digital132);
            break;
            case 133:    frameLayout.setBackgroundResource(R.drawable.poesia_digital133);
            break;
            case 134:    frameLayout.setBackgroundResource(R.drawable.poesia_digital134);
            break;
            case 135:    frameLayout.setBackgroundResource(R.drawable.poesia_digital135);
            break;
            case 136:    frameLayout.setBackgroundResource(R.drawable.poesia_digital136);
            break;
            case 137:    frameLayout.setBackgroundResource(R.drawable.poesia_digital137);
            break;
            case 138:    frameLayout.setBackgroundResource(R.drawable.poesia_digital138);
            break;
            case 139:    frameLayout.setBackgroundResource(R.drawable.poesia_digital139);
            break;
            case 140:    frameLayout.setBackgroundResource(R.drawable.poesia_digital140);
            break;
            case 141:    frameLayout.setBackgroundResource(R.drawable.poesia_digital141);
            break;
            case 142:    frameLayout.setBackgroundResource(R.drawable.poesia_digital142);
            break;
            case 143:    frameLayout.setBackgroundResource(R.drawable.poesia_digital143);
            break;
            case 144:    frameLayout.setBackgroundResource(R.drawable.poesia_digital144);
            break;
            case 145:    frameLayout.setBackgroundResource(R.drawable.poesia_digital145);
            break;
            case 146:    frameLayout.setBackgroundResource(R.drawable.poesia_digital146);
            break;

*/

        }



        return rootView;

    }

}
