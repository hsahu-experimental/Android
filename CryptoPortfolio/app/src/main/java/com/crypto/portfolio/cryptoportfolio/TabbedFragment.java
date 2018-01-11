package com.crypto.portfolio.cryptoportfolio;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class TabbedFragment extends Fragment {

    private AppBarLayout appBarLayout;
    private TabLayout tabs;
    private ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_tabbed, container, false);

        View coordinator = (View) container.getParent();
        appBarLayout = coordinator.findViewById(R.id.appbar);
        tabs = new TabLayout(getContext());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBarLayout.addView(tabs);

        viewPager = view.findViewById(R.id.pager);
        ViewPageAdapter pageAdapter = new ViewPageAdapter(getFragmentManager());
        viewPager.setAdapter(pageAdapter);
        tabs.setupWithViewPager(viewPager);
        return  view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBarLayout.removeView(tabs);
    }


    public class ViewPageAdapter extends FragmentStatePagerAdapter {

        public ViewPageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        String[] tabs = {"Binance", "Bittrex"};

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: return new BinanceFragment();
                case 1: return new BittrexFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
