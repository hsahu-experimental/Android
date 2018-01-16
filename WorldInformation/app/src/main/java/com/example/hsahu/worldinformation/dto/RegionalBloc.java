package com.example.hsahu.worldinformation.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

public class RegionalBloc implements Serializable {

    @SerializedName("acronym")
    private String acronym;

    @SerializedName("name")
    private String name;

    @SerializedName("otherAcronyms")
    private String[] otherAcronyms;

    @SerializedName("otherNames")
    private String[] otherNames;

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public String[] getOtherAcronyms() {
        return otherAcronyms;
    }

    public String[] getOtherNames() {
        return otherNames;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherAcronyms(String[] otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public void setOtherNames(String[] otherNames) {
        this.otherNames = otherNames;
    }

    public RegionalBloc(String acronym, String name, String[] otherAcronyms, String[] otherNames) {
        this.acronym = acronym;
        this.name = name;
        this.otherAcronyms = otherAcronyms;
        this.otherNames = otherNames;
    }

    @Override
    public String toString() {
        return "RegionalBloc{" +
                "acronym='" + acronym + '\'' +
                ", name='" + name + '\'' +
                ", otherAcronyms=" + Arrays.toString(otherAcronyms) +
                ", otherNames=" + Arrays.toString(otherNames) +
                '}';
    }
}
