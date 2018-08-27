package ua.moses.prestaconnect.service;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PrestaService {

    @GET("{resource}/{id}?output_format=JSON&display=full")
    Call<JsonElement> get(@Path ("resource") String resource, @Path("id") int id);
    //Call<Map<String, List<T>>> get(@Path ("resource") String resource, @Path("id") int id);

    @GET("{resource}/?output_format=JSON&display=full")
    Call<JsonElement> get(@Path ("resource") String resource);
    //Call<Map<String, List<T>>> get(@Path ("resource") String resource);

}
