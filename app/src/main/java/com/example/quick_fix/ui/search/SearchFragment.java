package com.example.quick_fix.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quick_fix.R;
import com.example.quick_fix.databinding.FragmentSearchBinding;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private FragmentSearchBinding binding;
    SearchView mySearchView;
    ListView myList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);


        //findViewById(R.id.search_View);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mySearchView = (SearchView)binding.searchView.findViewById(R.id.search_View);
        myList = (ListView)binding.searchListing.findViewById(R.id.search_listing);

        ArrayList<String>list = new ArrayList<>();

        list.add("Tailor - Eric Stacey");
        list.add("Tailor - Michael Lee");
        list.add("Tailor - Charles Jackart");
        list.add("Tailor - Sam Robu");
        list.add("Tailor - Tiffany Lin");
        list.add("Tailor - Jack Katsuno");
        list.add("Tailor - Vivian He");
        list.add("Tailor - Robin Robyn");
        list.add("Tailor - James Macdonald");
        list.add("Tailor - Leon Madigan");
        list.add("Tailor - Joshua Dai");
        list.add("Tailor - Vittorio Lam");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list); //ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

//        final TextView textView = binding.textSearch;
//        searchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}