package ua.moses.prestaconnect.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryAssociations {
    @SerializedName("categories")
    private List<Id> categories = null;
    @SerializedName("products")
    private List<Id> products = null;
}
