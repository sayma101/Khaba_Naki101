package com.example.khabanaki.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khabanaki.R;
import com.example.khabanaki.models.HomeHorModel;
import com.example.khabanaki.models.HomeVerModel;

import java.util.ArrayList;

public class HomeHorAdapters extends RecyclerView.Adapter<HomeHorAdapters.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    int row_index = -1;

    public HomeHorAdapters(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeHorAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHorAdapters.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        // Change background based on selected item
        if (row_index == position) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg); // Selected background
        } else {
            holder.cardView.setBackgroundResource(R.drawable.default_bg); // Default background
        }

        holder.cardView.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged(); // Refresh the RecyclerView

            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            if (position == 0) {
                homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza 1", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza 2", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza 3", "10:00 - 23:00", "4.9", "Min - 400TK"));
            } else if (position == 1) {
                homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 1", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Burger 2", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.burger3, "Burger 3", "10:00 - 23:00", "4.9", "Min - 400TK"));
            } else if (position == 2) {
                homeVerModels.add(new HomeVerModel(R.drawable.fries1, "Fries 1", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.fries2, "Fries 2", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.fries3, "Fries 3", "10:00 - 23:00", "4.9", "Min - 400TK"));
            } else if (position == 3) {
                homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream 1", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Ice Cream 2", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Ice Cream 3", "10:00 - 23:00", "4.9", "Min - 400TK"));
            } else if (position == 4) {
                homeVerModels.add(new HomeVerModel(R.drawable.sandwich1, "Sandwich 1", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.sandwich2, "Sandwich 2", "10:00 - 23:00", "4.9", "Min - 400TK"));
                homeVerModels.add(new HomeVerModel(R.drawable.sandwich3, "Sandwich 3", "10:00 - 23:00", "4.9", "Min - 400TK"));
            }

            // Pass updated list to the vertical RecyclerView
            updateVerticalRec.callback(position, homeVerModels);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
