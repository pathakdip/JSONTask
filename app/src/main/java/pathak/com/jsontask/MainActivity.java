package pathak.com.jsontask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json=
                "{" +
                "    \"glossary\": {" +
                "        \"title\": \"example glossary\"," +
                "\t\t\"GlossDiv\": {" +
                "            \"title\": \"S\"," +
                "\t\t\t\"GlossList\": {" +
                "                \"GlossEntry\": {" +
                "                    \"ID\": \"SGML\"," +
                "\t\t\t\t\t\"SortAs\": \"SGML\"," +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\"," +
                "\t\t\t\t\t\"Acronym\": \"SGML\"," +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\"," +
                "\t\t\t\t\t\"GlossDef\": {" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]" +
                "                    }," +
                "\t\t\t\t\t\"GlossSee\": \"markup\"" +
                "                }" +
                "            }" +
                "        }" +
                "    }" +
                "}";
        try{
            JsonDemo(json);
        }catch (JSONException je){
            je.printStackTrace();
        }
    }

    public void JsonDemo(String json) throws JSONException{
       String str=null;
        try {
            JSONObject rootJSONObject = new JSONObject(str);
            JSONObject glossaryObject = rootJSONObject.getJSONObject("glossary");

            String titleString = glossaryObject.getString("title");

            Log.d("tag","Title of root"+titleString);

            JSONObject glossDivObject = glossaryObject.getJSONObject("GlossDiv");
            String glossDivTitle = glossDivObject.getString("title");
            Log.d("tag","Title og glossdiv"+glossDivTitle);


            JSONObject glossListObject = glossDivObject.getJSONObject("GlossList");
            JSONObject glossEntryObject = glossListObject.getJSONObject("GlossEntry");
            String id = glossEntryObject.getString("ID");
            Log.d("tag", "id "+id);
            String sortAs = glossEntryObject.getString("SortAs");
            Log.d("tag","sortAs"+sortAs);

            String glossterm = glossEntryObject.getString("GlossTerm");
            Log.d("tag", "glossterm"+glossterm);

            String acronym = glossEntryObject.getString("Acronym");
            Log.d("tag", "acronym"+acronym);

            String abbrev = glossEntryObject.getString("Abbrev");
            Log.d("tag", "abbrev"+abbrev);

            JSONObject glossDef = glossEntryObject.getJSONObject("GlossDef");
            String para = glossDef.getString("para");
            Log.d("tag", "para"+para);

            JSONArray glossSeeAlso =glossDef.getJSONArray("GlossSeeAlso");
            for (int i = 0; i <glossSeeAlso.length() ; i++) {
                String temp = glossSeeAlso.getString(i);
                Log.d("tag", "glossSeeAlso"+temp);

            }
            String glossSee = glossEntryObject.getString("GlossSee");
            Log.d("tag", "glossSee"+glossSee);

            glossaryObject.get("Glossary");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
