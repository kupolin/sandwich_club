package me.jonlin.android.sandwich_club.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import me.jonlin.android.sandwich_club.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONTokener tokener = new JSONTokener(json);
            // nextValue returns an Object of type:

            //a JSONObject, JSONArray, String, Boolean, Integer, Long, Double or JSONObject#NULL.
            JSONObject jsonObject = (JSONObject) tokener.nextValue();

//          (String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image,
//           List<String> ingredients)
            Sandwich model = new Sandwich();

            model.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            model.setDescription(jsonObject.getString("description"));
            model.setImage(jsonObject.getString("image"));

            /*
            sample:
            {"name":{"mainName":"Pljeskavica","alsoKnownAs":[]},"placeOfOrigin":"Serbia","description":"Pljeskavica, a grilled dish of spiced meat patty mixture of pork, beef and lamb, is a national dish of Serbia, also popular in Bosnia and Herzegovina and Croatia. It is a main course served with onions, kajmak (milk cream), ajvar (relish), and urnebes (spicy cheese salad), either on plate with side dishes, or with lepinja (flatbread, as a type of hamburger). Recently, Pljeskavica has gained popularity elsewhere in Europe and is served in a few speciality fast food restaurants in Germany, Sweden, and Austria.","image":"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Pljeskavica_%286883073017%29.jpg/800px-Pljeskavica_%286883073017%29.jpg","ingredients":["Two or more of beef, lamb, pork, veal","Onions","Bread crumbs","Lard"]}

            json is in the form {"name": {"mainName": "", "alsoKnownAs":[]}, "placeOfOrigin":"", image:"", ingredients:[]}
            */
            JSONObject nameJSONObject = jsonObject.getJSONObject("name");

            //set Main Name (Action Bar title)
            model.setMainName(nameJSONObject.getString("mainName"));

            //set alsoKnownAs
            JSONArray alsoKnownAsJSONArray = nameJSONObject.getJSONArray("alsoKnownAs");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJSONArray.length(); i++) {
                list.add(alsoKnownAsJSONArray.getString(i));
            }
            model.setAlsoKnownAs(list);

            //set ingredients
            JSONArray ingredientsJSONArray = jsonObject.getJSONArray("ingredients");
            list.clear();
            for (int i = 0; i < ingredientsJSONArray.length(); i++) {
                list.add(ingredientsJSONArray.getString(i));
            }
            model.setIngredients(list);
            return model;
        } catch (Exception e) {
            Log.d("JsonUtils.class", e.toString());
        }
        return null;
    }
}
