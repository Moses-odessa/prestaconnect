package ua.moses.prestaconnect.entity;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalizedTitle {
    @SerializedName("id")
    private int id;
    @SerializedName("value")
    private String value;
}
