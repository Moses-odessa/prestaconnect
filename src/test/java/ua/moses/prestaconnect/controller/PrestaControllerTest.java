package ua.moses.prestaconnect.controller;

import org.junit.Before;
import org.junit.Test;
import ua.moses.prestaconnect.PrestaConnect;
import ua.moses.prestaconnect.entity.Category;
import ua.moses.prestaconnect.entity.IMAGES_TYPES;
import ua.moses.prestaconnect.service.SERVICES;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class PrestaControllerTest {
    private PrestaConnect prestaConnect;

    @Before
    public void setUp() {
        prestaConnect = new PrestaConnect("http://homey.in.ua/api/",
                "CM67C92UKYFPE2U7837YH4HGDBV78FBH",
                new File(System.getProperty("user.dir")),
                50);
    }

    @Test
    public void getCategoriesTest() {
        PrestaController controller = prestaConnect.controller();
        List<Category> list = controller.get(SERVICES.CATEGORIES, Category.class);
        assertNotNull(list);
        assertNotEquals(0, list.size());
    }

    @Test
    public void getImageUrlTest() {
        String url = prestaConnect.getImageUrl(1, 1, IMAGES_TYPES.cart_default);
        assertNotNull(url);
        assertNotEquals(0, url.length());
    }
}
