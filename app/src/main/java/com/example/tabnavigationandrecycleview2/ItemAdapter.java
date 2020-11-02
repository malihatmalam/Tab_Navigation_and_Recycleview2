package com.example.tabnavigationandrecycleview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemData> values;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, ArrayList<ItemData> values){
        this.context = context;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);

    }

    // Untuk mengeset item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemData data = values.get(position);

        // set Title
        holder.titleText.setText(data.itemTitle);

        // set SubTitle
        holder.subText.setText(data.itemSubTitle);

        // Ketika di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Anda memilih data"
                        + data.itemTitle, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    // Holdernya
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView subText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.Text_1);
            subText = itemView.findViewById(R.id.Text_2);
        }
    }
}
