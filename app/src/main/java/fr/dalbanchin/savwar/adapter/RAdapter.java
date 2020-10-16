package fr.dalbanchin.savwar.adapter;


import fr.dalbanchin.savwar.R;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {

    ArrayList<String> msgList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ConstraintLayout row;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            row = (ConstraintLayout) itemView.findViewById(R.id.a_row);
            textView = (TextView) itemView.findViewById(R.id.text_row);
        }
        @Override
        public void onClick (View v) {
            int pos = getAdapterPosition();
            Toast.makeText(v.getContext(), msgList.get(pos), Toast.LENGTH_LONG).show();
        }
    }
    public RAdapter(Context c) {
        msgList = new ArrayList<String>();
        msgList.add("Hello");
        msgList.add("How are you");
        msgList.add("Gooood!");
    }

    @Override
    public void onBindViewHolder(RAdapter.ViewHolder viewHolder, int i) {
        TextView textView = viewHolder.textView;
        textView.setText(msgList.get(i));

    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    @Override
    public RAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.row, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
}


