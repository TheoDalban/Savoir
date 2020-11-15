package fr.dalbanchin.savwar.adapter;


import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.activities.FavorisActivity;
import fr.dalbanchin.savwar.activities.SavoirDuJour;
import fr.dalbanchin.savwar.storage.SavoirStorage;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;




public class RAdapterTheme extends RecyclerView.Adapter<RAdapterTheme.ThemeHolder> {

    ArrayList<String> msgList;
    
    final static protected String T_AUTRE = "AUTRE";
    final static protected String T_ANIMAUX = "ANIMAUX";
    final static protected String T_CUISINE = "CUISINE";
    final static protected String T_ESPACE = "ESPACE";
    final static protected String T_GEOGRAPHIE = "GEOGRAPHIE";
    final static protected String T_HISTOIRE = "HISTOIRE";
    final static protected String T_HUMAIN = "HUMAIN";
    final static protected String T_NATURE = "NATURE";
    
    
    static class ThemeHolder extends RecyclerView.ViewHolder {
        public LinearLayout row;
        public TextView textView;

        public ThemeHolder(View itemView) {
            super(itemView);

            row = (LinearLayout) itemView.findViewById(R.id.a_row);
            textView = (TextView) itemView.findViewById(R.id.text_row);
        }

    }

    private final Context context;

    public RAdapterTheme(Context c) {
        msgList = new ArrayList<String>();
        msgList.add(T_AUTRE);
        msgList.add(T_ANIMAUX);
        msgList.add(T_CUISINE);
        msgList.add(T_ESPACE);
        msgList.add(T_GEOGRAPHIE);
        msgList.add(T_HISTOIRE);
        msgList.add(T_HUMAIN);
        msgList.add(T_NATURE);
        this.context = c;
    }


    @Override
    public void onBindViewHolder(RAdapterTheme.ThemeHolder viewHolder,int i) {
        final int j = i;
        TextView textView = viewHolder.textView;
        textView.setText(msgList.get(i));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(msgList.get(j)){
                    case T_AUTRE:
                        Toast.makeText(v.getContext(),"C'est vide pour l'instant",Toast.LENGTH_LONG).show();
                        break;
                    case T_ANIMAUX:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 1 );
                        Intent animauxIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(animauxIntent);
                        break;
                    case T_CUISINE:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 2 );
                        Intent cuisineIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(cuisineIntent);
                        break;
                    case T_ESPACE:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 3 );
                        Intent espaceIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(espaceIntent);
                        break;
                    case T_GEOGRAPHIE:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 4 );
                        Intent geographieIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(geographieIntent);
                        break;
                    case T_HISTOIRE:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 5 );
                        Intent histoireIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(histoireIntent);
                        break;
                    case T_HUMAIN:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 6 );
                        Intent humainIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(humainIntent);
                        break;
                    case T_NATURE:
                        SavoirStorage.setsettingsSAVOIRTHEME(context, 7 );
                        Intent natureIntent = new Intent(context, FavorisActivity.class);
                        context.startActivity(natureIntent);
                        break;
                    default:
                        Toast.makeText(v.getContext(),"Ce thème n'existe peut-être pas encore dans nos données",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    @Override
    public RAdapterTheme.ThemeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_theme, parent, false);
        //View view = inflater.inflate(R.layout.row_theme, parent, false);

        ThemeHolder viewHolder = new ThemeHolder(view);
        return viewHolder;
    }
}


