package com.example.anton.myapplication.Fragments.FragmentCar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anton.myapplication.Model.Cars;
import com.example.anton.myapplication.R;

import java.util.ArrayList;
import java.util.Collection;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Cars> carsArrayList = new ArrayList<>();

    public void setCarList(Collection<Cars> carsList){
        carsArrayList.addAll(carsList);
        notifyDataSetChanged();
    }

    public void clearCarList(){
        carsArrayList.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(carsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return carsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView modelTextView;
        private TextView yearTextView;
        private TextView ownerTextView;

        public void bind(Cars cars){
            modelTextView.setText(cars.getModel_id());
            yearTextView.setText(cars.getYear());
            ownerTextView.setText(cars.getOwner());
        }

        public ViewHolder(View itemView) {
            super(itemView);

            modelTextView = itemView.findViewById(R.id.model);
            yearTextView = itemView.findViewById(R.id.year);
            ownerTextView = itemView.findViewById(R.id.owner);

        }
    }
}
