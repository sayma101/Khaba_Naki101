package com.example.khabanaki.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.khabanaki.databinding.DailyMealFragmentBinding;
import com.example.khabanaki.databinding.DailyMealFragmentBinding;

public class DailyMealFragment extends Fragment {

    private DailyMealFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment using View Binding
        binding = DailyMealFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Avoid memory leaks by setting binding to null when the view is destroyed
        binding = null;
    }
}
