package com.example.hsahu.worldinformation.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsahu.worldinformation.Common.Common;
import com.example.hsahu.worldinformation.CountryActivity;
import com.example.hsahu.worldinformation.R;
import com.example.hsahu.worldinformation.dto.Country;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<Country> countryList;
    private Context context;

    public CardAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewIndex) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_country, viewGroup, false);
        return new CardViewHolder(view, viewIndex);
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
        // TODO
        final int index = position;
        final Country country = countryList.get(index);
        cardViewHolder.countryNameTextView.setText(country.getName());
        if (country.getNativeName() != null && !country.getNativeName().isEmpty() && !country.getName().equalsIgnoreCase(country.getNativeName())) {
            cardViewHolder.countryNativeNameTextView.setText("( " + country.getNativeName() + " )");
            cardViewHolder.countryNativeNameTextView.setVisibility(View.VISIBLE);
        } else {
            cardViewHolder.countryNativeNameTextView.setVisibility(View.GONE);
        }
        String countryCode = country.getAlpha3Code().toLowerCase();
        cardViewHolder.countryFlagImageView.setImageResource(R.drawable.afg);
        Integer flag = Common.flagMap.get(countryCode);
        if (flag != null) {
            cardViewHolder.countryFlagImageView.setImageResource(flag.intValue());
        } else {
            cardViewHolder.countryFlagImageView.setImageResource(0);
        }
        cardViewHolder.regionNameTextView.setText(country.getRegion());
        cardViewHolder.capitalNameTextView.setText(country.getCapital());
        cardViewHolder.parentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CountryActivity.class);
                intent.putExtra("countryObject", country);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}

class CardViewHolder extends RecyclerView.ViewHolder {

    public int index;
    public TextView countryNameTextView;
    public TextView countryNativeNameTextView;
    public TextView capitalNameTextView;
    public TextView regionNameTextView;
    public ImageView countryFlagImageView;
    public View parentCardView;

    CardViewHolder(View view, final int index) {
        super(view);
        this.index = index;
        this.parentCardView = view;
        this.countryNameTextView = view.findViewById(R.id.countryName);
        this.countryNativeNameTextView = view.findViewById(R.id.countryNativeName);
        this.capitalNameTextView = view.findViewById(R.id.capitalName);
        this.regionNameTextView = view.findViewById(R.id.regionName);
        this.countryFlagImageView = view.findViewById(R.id.countryFlag);
    }
}