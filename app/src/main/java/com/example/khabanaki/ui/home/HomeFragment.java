package com.example.khabanaki.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khabanaki.R;
import com.example.khabanaki.adapters.HomeHorAdapters;
import com.example.khabanaki.adapters.HomeVerAdapter;
import com.example.khabanaki.adapters.UpdateVerticalRec;
import com.example.khabanaki.models.HomeHorModel;
import com.example.khabanaki.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec, homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapters homeHorAdapters;

    ArrayList<HomeVerModel> homeVerModelList; // Correct variable name
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        //////// Horizontal RecyclerView
        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger, "Hamburger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fried_potatoes, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream, "Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich, "Sandwich"));

        homeHorAdapters = new HomeHorAdapters(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapters);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        /////// Vertical RecyclerView
        homeVerModelList = new ArrayList<>(); // Initialize correctly

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList); // Correctly pass list
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));


        return root;
    }

    @Override
    public void callback(int position, ArrayList<HomeVerModel> list) {

      homeVerAdapter = new HomeVerAdapter(getContext(),list);
      homeVerAdapter.notifyDataSetChanged();
      homeVerticalRec.setAdapter(homeVerAdapter);

    }
}
