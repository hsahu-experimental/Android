package com.example.hsahu.worldinformation.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class Country implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("alpha2Code")
    private String alpha2Code;

    @SerializedName("alpha3Code")
    private String alpha3Code;

    @SerializedName("callingCodes")
    private String[] callingCodes;

    @SerializedName("capital")
    private String capital;

    @SerializedName("altSpellings")
    private String[] altSpellings;

    @SerializedName("region")
    private String region;

    @SerializedName("subregion")
    private String subregion;

    @SerializedName("population")
    private String population;

    @SerializedName("latlng")
    private double[] latlng;

    @SerializedName("demonym")
    private String demonym;

    @SerializedName("area")
    private double area;

    @SerializedName("gini")
    private double gini;

    @SerializedName("timezones")
    private String[] timezones;

    @SerializedName("borders")
    private String[] borders;

    @SerializedName("nativeName")
    private String nativeName;

    @SerializedName("numericCode")
    private String numericCode;

    @SerializedName("currencies")
    private Currency[] currencies;

    @SerializedName("languages")
    private Language[] languages;

    @SerializedName("translations")
    private Map<String, String> translations;

    @SerializedName("flag")
    private String flag;

    @SerializedName("regionalBlocs")
    private RegionalBloc[] regionalBlocs;

    @SerializedName("cioc")
    private String cioc;

    public Country() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String[] getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public String[] getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getPopulation() {
        return population;
    }

    public double[] getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public double getArea() {
        return area;
    }

    public double getGini() {
        return gini;
    }

    public String[] getTimezones() {
        return timezones;
    }

    public String[] getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public Currency[] getCurrencies() {
        return currencies;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public String getFlag() {
        return flag;
    }

    public RegionalBloc[] getRegionalBlocs() {
        return regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public void setCallingCodes(String[] callingCodes) {
        this.callingCodes = callingCodes;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setAltSpellings(String[] altSpellings) {
        this.altSpellings = altSpellings;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setLatlng(double[] latlng) {
        this.latlng = latlng;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public void setTimezones(String[] timezones) {
        this.timezones = timezones;
    }

    public void setBorders(String[] borders) {
        this.borders = borders;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public void setCurrencies(Currency[] currencies) {
        this.currencies = currencies;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }

    public void setTranslations(Map<String, String> translations) {
        this.translations = translations;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setRegionalBlocs(RegionalBloc[] regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public Country(String name, String alpha2Code, String alpha3Code, String[] callingCodes, String capital, String[] altSpellings, String region, String subregion, String population, double[] latlng, String demonym, double area, double gini, String[] timezones, String[] borders, String nativeName, String numericCode, Currency[] currencies, Language[] languages, Map<String, String> translations, String flag, RegionalBloc[] regionalBlocs, String cioc) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.callingCodes = callingCodes;
        this.capital = capital;
        this.altSpellings = altSpellings;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.latlng = latlng;
        this.demonym = demonym;
        this.area = area;
        this.gini = gini;
        this.timezones = timezones;
        this.borders = borders;
        this.nativeName = nativeName;
        this.numericCode = numericCode;
        this.currencies = currencies;
        this.languages = languages;
        this.translations = translations;
        this.flag = flag;
        this.regionalBlocs = regionalBlocs;
        this.cioc = cioc;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", callingCodes=" + Arrays.toString(callingCodes) +
                ", capital='" + capital + '\'' +
                ", altSpellings=" + Arrays.toString(altSpellings) +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", population='" + population + '\'' +
                ", latlng=" + Arrays.toString(latlng) +
                ", demonym='" + demonym + '\'' +
                ", area=" + area +
                ", gini=" + gini +
                ", timezones=" + Arrays.toString(timezones) +
                ", borders=" + Arrays.toString(borders) +
                ", nativeName='" + nativeName + '\'' +
                ", numericCode='" + numericCode + '\'' +
                ", currencies=" + Arrays.toString(currencies) +
                ", languages=" + Arrays.toString(languages) +
                ", translations=" + translations +
                ", flag='" + flag + '\'' +
                ", regionalBlocs=" + Arrays.toString(regionalBlocs) +
                ", cioc='" + cioc + '\'' +
                '}';
    }
}
