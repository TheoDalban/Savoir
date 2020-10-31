package fr.dalbanchin.savwar.adapter;


import fr.dalbanchin.savwar.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RAdapterTheme extends RecyclerView.Adapter<RAdapterTheme.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout row;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            row = (LinearLayout) itemView.findViewById(R.id.a_row);
            textView = (TextView) itemView.findViewById(R.id.text_row);
        }
        @Override
        public void onClick (View v) {
            int pos = getAdapterPosition();
            Toast.makeText(v.getContext(), msgList.get(pos), Toast.LENGTH_LONG).show();
        }
    }

    ArrayList<String> msgList;


    public RAdapterTheme(Context c) {
        msgList = new ArrayList<String>();
        msgList.add("1er thème");
        msgList.add("omarmelade a match le movid19 dans une regex");
    }

    @Override
    public void onBindViewHolder(RAdapterTheme.ViewHolder viewHolder, int i) {
        TextView textView = viewHolder.textView;
        textView.setText(msgList.get(i));
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    @Override
    public RAdapterTheme.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.row_theme, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
}


