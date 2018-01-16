package com.example.hsahu.worldinformation;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsahu.worldinformation.Common.Common;
import com.example.hsahu.worldinformation.dto.Country;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Country country = (Country) getIntent().getSerializableExtra("countryObject");
        String countryCode = country.getAlpha3Code().toLowerCase();
        setTitle(country.getName());
        ((TextView)findViewById(R.id.countryName)).setText(country.getName());
        ((TextView)findViewById(R.id.capitalName)).setText(country.getCapital());
        ((TextView)findViewById(R.id.countryNativeName)).setText(country.getNativeName());
        ((TextView)findViewById(R.id.countryCode)).setText(country.getAlpha3Code());
        ((TextView)findViewById(R.id.deTranslation)).setText(country.getTranslations().get("de"));
        ((TextView)findViewById(R.id.esTranslation)).setText(country.getTranslations().get("es"));
        ((TextView)findViewById(R.id.frTranslation)).setText(country.getTranslations().get("fr"));
        ((TextView)findViewById(R.id.jaTranslation)).setText(country.getTranslations().get("ja"));
        ((TextView)findViewById(R.id.itTranslation)).setText(country.getTranslations().get("it"));
        ((TextView)findViewById(R.id.ptTranslation)).setText(country.getTranslations().get("pt"));
        ((TextView)findViewById(R.id.nlTranslation)).setText(country.getTranslations().get("nl"));
        ((TextView)findViewById(R.id.hrTranslation)).setText(country.getTranslations().get("hr"));
        ((TextView)findViewById(R.id.faTranslation)).setText(country.getTranslations().get("fa"));
        ((TextView)findViewById(R.id.population)).setText(country.getPopulation());
        ((TextView)findViewById(R.id.area)).setText(Double.toString(country.getArea()));
        ((TextView)findViewById(R.id.gini)).setText(Double.toString(country.getGini()));
        ((TextView)findViewById(R.id.demonym)).setText(country.getDemonym());
        if (Common.flagMap.containsKey(countryCode) && Common.flagMap.get(countryCode) != 0) {
            ((ImageView)findViewById(R.id.countryFlag)).setImageResource(Common.flagMap.get(countryCode));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
