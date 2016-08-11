import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bsoimu on 8/10/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextContent {

    public String extract;

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

}
