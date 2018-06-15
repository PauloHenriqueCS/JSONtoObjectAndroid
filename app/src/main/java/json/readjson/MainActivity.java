package json.readjson;

import android.app.Activity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import json.readjson.library.JSONParser;

public class MainActivity extends Activity {

    //URL to get JSON Array
    //private static String url = "http://10.0.2.2/JSON/";

    //JSON Node Names
    private static final String TAG_USER = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private ListView listaItens;
    private String[] itens = {};

    JSONArray user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Creating new JSON Parser
        JSONParser jParser = new JSONParser();

        // Getting JSON from URL
        JSONObject json = jParser.getJSONFromUrl();
        listaItens = (ListView) findViewById(R.id.lista);

        try {
            // Getting JSON Array
            user = json.getJSONArray(TAG_USER);
            JSONObject c = user.getJSONObject(0);

            // Storing  JSON item in a Variable
            //String id = c.getString(TAG_ID);
            String name = c.getString(TAG_NAME);
            //String email = c.getString(TAG_EMAIL);
            itens = new String[2];


            for(int i=0; i<itens.length; i++){
                 c = user.getJSONObject(i);
                 name = c.getString(TAG_NAME);
                itens[i] = name;
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    itens
            );

            listaItens.setAdapter( adaptador );

            //Importing TextView
          //  final TextView uid = (TextView)findViewById(R.id.uid);
           // final TextView name1 = (TextView)findViewById(R.id.name);
           // final TextView email1 = (TextView)findViewById(R.id.email);

            //Set JSON Data in TextView
          //  uid.setText(id);
          //  name1.setText(name);
           // email1.setText(email);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}

