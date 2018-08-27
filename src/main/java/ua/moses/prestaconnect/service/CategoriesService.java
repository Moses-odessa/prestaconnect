package ua.moses.prestaconnect.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.moses.prestaconnect.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoriesService {

    default String getValue() {
        return "categories";
    }

    @GET("categories/?output_format=JSON&display=full")
    Call<Map<String, List<Category>>> get(@Query("filter[id_parent]") int... filter);

    @GET("categories/?output_format=JSON&display=full")
    Call<Map<String, List<Category>>> get();
}
