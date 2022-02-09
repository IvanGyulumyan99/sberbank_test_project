package API.ipApi.responseDTO;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "geoname_id",
        "capital",
        "languages",
        "country_flag",
        "country_flag_emoji",
        "country_flag_emoji_unicode",
        "calling_code",
        "is_eu"
})
public class Location {

    @JsonProperty("geoname_id")
    private Integer geonameId;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("languages")
    private List<Language> languages = null;
    @JsonProperty("country_flag")
    private String countryFlag;
    @JsonProperty("country_flag_emoji")
    private String countryFlagEmoji;
    @JsonProperty("country_flag_emoji_unicode")
    private String countryFlagEmojiUnicode;
    @JsonProperty("calling_code")
    private String callingCode;
    @JsonProperty("is_eu")
    private Boolean isEu;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Location() {
    }

    public Location(Integer geonameId, String capital, List<Language> languages, String countryFlag, String countryFlagEmoji, String countryFlagEmojiUnicode, String callingCode, Boolean isEu) {
        super();
        this.geonameId = geonameId;
        this.capital = capital;
        this.languages = languages;
        this.countryFlag = countryFlag;
        this.countryFlagEmoji = countryFlagEmoji;
        this.countryFlagEmojiUnicode = countryFlagEmojiUnicode;
        this.callingCode = callingCode;
        this.isEu = isEu;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
