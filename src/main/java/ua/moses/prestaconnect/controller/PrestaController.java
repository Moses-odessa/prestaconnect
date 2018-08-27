package ua.moses.prestaconnect.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import retrofit2.Call;
import retrofit2.Retrofit;
import ua.moses.prestaconnect.service.PrestaService;
import ua.moses.prestaconnect.service.SERVICES;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrestaController {
    ;
    Retrofit retrofit;

    public PrestaController(Retrofit retrofit) {
        this.retrofit = retrofit;
    }


    public <T> List<T> get(SERVICES serviceType, Type typeClass) {
        PrestaService service = retrofit.create(PrestaService.class);
        Call<JsonElement> call = service.get(serviceType.getPath());
        List<T> result = new ArrayList<>();
        try {

            Type dataType = new TypeToken<HashMap<String, ArrayList<T>>>() {
            }.getType();
            String json = call.execute().body().getAsJsonObject().toString();
            Map<String, List<T>> map = new Gson().fromJson(json, dataType);
            if (map != null) {
                result = map.get(serviceType.getPath());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
