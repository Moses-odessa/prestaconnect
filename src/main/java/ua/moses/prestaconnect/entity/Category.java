package ua.moses.prestaconnect.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @SerializedName("id")
    private int id;
    @SerializedName("id_parent")
    private int idParent;
    @SerializedName("active")
    private boolean active;
    @SerializedName("id_shop_default")
    private int idShopDefault;
    @SerializedName("is_root_category")
    private boolean isRootCategory;
    @SerializedName("position")
    private int position;
    @SerializedName("date_add")
    private String dateAdd;
    @SerializedName("date_upd")
    private String dateUpd;
    @SerializedName("name")
    private List<LocalizedTitle> name;
    @SerializedName("link_rewrite")
    private List<LocalizedTitle> linkRewrite;
    @SerializedName("description")
    private List<LocalizedTitle> description;
    @SerializedName("meta_title")
    private List<LocalizedTitle> metaTitle;
    @SerializedName("meta_description")
    private List<LocalizedTitle> metaDescription;
    @SerializedName("meta_keywords")
    private List<LocalizedTitle> metaKeywords;
    @SerializedName("associations")
    private CategoryAssociations associations;
}
