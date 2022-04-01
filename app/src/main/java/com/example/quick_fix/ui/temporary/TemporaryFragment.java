package com.example.quick_fix.ui.temporary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quick_fix.CreateListingActivity;

import com.example.quick_fix.databinding.FragmentTemporaryBinding;

public class TemporaryFragment extends Fragment {

    private TemporaryViewModel temporaryViewModel;
    private FragmentTemporaryBinding binding;

    Activity context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        temporaryViewModel =
                new ViewModelProvider(this).get(TemporaryViewModel.class);

        binding = FragmentTemporaryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTemporary;
        temporaryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = binding.buttonCreateListing;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(binding.getRoot().getContext(), CreateListingActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}