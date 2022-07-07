package com.example.vnomobile.adapter.pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vnomobile.fragment.FavouritesFragment;
import com.example.vnomobile.fragment.ListOfServersFragment;

public class ListOfServersAndFavouritesAdapter extends FragmentStateAdapter {

    private final Fragment[] fragments = {
            new ListOfServersFragment(),
            new FavouritesFragment()
    };

    public ListOfServersAndFavouritesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
