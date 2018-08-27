package ua.moses.prestaconnect;

import okhttp3.Cache;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.moses.prestaconnect.controller.PrestaController;
import ua.moses.prestaconnect.entity.Category;
import ua.moses.prestaconnect.entity.IMAGES_TYPES;
import ua.moses.prestaconnect.service.PrestaService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PrestaConnect {
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public PrestaConnect(String baseUrl, String securityKey, File cacheDir, int cacheSize) {

        File httpCacheDirectory = new File(cacheDir, ".responsesCache");
        Cache cache = new Cache(httpCacheDirectory, cacheSize* 1024 * 1024);
        this.okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .authenticator((route, response) -> {
                    String credential = Credentials.basic(securityKey, "");
                    return response.request().newBuilder()
                            .header("Authorization", credential)
                            .build();
                })
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(this.okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public String getImageUrl(int productId, int imageId, IMAGES_TYPES type) {
        return this.retrofit.baseUrl() + "images/products/" + productId + "/" + imageId + "/" + type;
    }

    public <T> T service(final Class<T> serviceClass){
        return retrofit.create(serviceClass);
    }

    public PrestaController controller(){
        return new PrestaController(retrofit);
    }

}
