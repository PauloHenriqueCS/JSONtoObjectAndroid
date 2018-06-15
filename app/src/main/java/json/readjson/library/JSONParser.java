package json.readjson.library;
import android.util.Log;

import com.dezlum.codelabs.getjson.GetJson;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {

    }

    public JSONObject getJSONFromUrl() {

        try {
            String Stringurl = "http://192.168.1.3/json/";
            String json = new GetJson().AsString(Stringurl.trim());
            try {
                jObj = new JSONObject(json);
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // return JSON String
        return jObj;

    }
}