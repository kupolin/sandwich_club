package me.jonlin.android.sandwich_club.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.jonlin.android.sandwich_club.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class JsonUtils {

    private static List<String> jSonArraytoList(JSONArray jsonArr) {
        /*
        //parsing jsonString and set also known as list.
        for (int i = 0; i < jsonArr.length(); i++) {
//                Log.d("JsonUtils.class", alsoKnownAsJSONArray.getString(i));
            Iterator<String> it = jsonArr. (i);
            List<String> list = new ArrayList<>();

            while (it.hasNext()) {
                list.add(it.next());
                it.remove();
            }
            return jsonArr.
        }
    }
*/
        return null;
    }
    /*
        parses a string in JSON format and returns a model object
        @param json - string in json format
        @return sandwich model object

        https://docs.oracle.com/javaee/7/api/javax/json/stream/JsonParser.html
     */
    private static void test() {
//        String json = "{"
        //      + "  \"query\": \"Pizza\", "
//            + "  \"locations\": [ 94043, 90210 ] "
//            + "}";




        /*
        String json;
            = "{\"name\":{\"mainName\":\"Ham and cheese sandwich\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"\",\"description\":\"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}"

        try {
            JSONTokener tokener = new JSONTokener(json);
            // nextValue returns an Object of type:

            //a JSONObject, JSONArray, String, Boolean, Integer, Long, Double or JSONObject#NULL.
            JSONObject object = (JSONObject) tokener.nextValue();
            String query = object.getString("query");
            Log.d("JsonUtils.class", query);

            JSONArray locations = object.getJSONArray("locations");

            for (int i = 0; i < locations.length(); i++) {
//                String.valueOf(locations.getInt(i));
                Log.d("JsonUtils.class", String.valueOf(locations.getInt(i)));
            }
        } catch (Exception e) {
            Log.d("JsonUtils.class", e.toString());
        }
         */
    }

    public static Sandwich parseSandwichJson(String json) {
        Log.d("JsonUtils.class", json);

        //   test();

        try {
            JSONTokener tokener = new JSONTokener(json);
            // nextValue returns an Object of type:

            //a JSONObject, JSONArray, String, Boolean, Integer, Long, Double or JSONObject#NULL.
            JSONObject jsonObject = (JSONObject) tokener.nextValue();

//            (String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image,
//                List<String> ingredients)
            Sandwich model = new Sandwich();

            model.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            model.setDescription("description");
            model.setImage("image");

            JSONObject nameJSONObject = jsonObject.getJSONObject("name");
            model.setMainName(jsonObject.getString("mainName"));

            JSONArray alsoKnownAsJSONArray = nameJSONObject.getJSONArray("alsoKnownAs");
            JSONArray ingredientsJSONArray = jsonObject.getJSONArray("ingredients");

            //model.setAlsoKnownAs(list);
           // nameJSONArray.getString(i);
        }catch (Exception e) {
            Log.d("JsonUtils.class", e.toString());
        }
   //     model.setMainName();

//            String query = object.getString("query");
//        Log.d("JsonUtils.class", query);

   //     JSONArray locations = object.getJSONArray("locations");
/*
        for (int i = 0; i < locations.length(); i++) {
                String.valueOf(locations.getInt(i));
            Log.d("JsonUtils.class", String.valueOf(locations.getInt(i)));
        }
        */
            return null;
    }
        }
