package me.jonlin.android.sandwich_club;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import me.jonlin.android.sandwich_club.model.Sandwich;
import me.jonlin.android.sandwich_club.utils.JsonUtils;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";

    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        // sandwich IV
        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        //get item position in sandwich list
        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
            /*
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }
*/
        // get current sandwich detail json string
        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];

        ((TextView)findViewById(R.id.textView)).setText(json);


        Sandwich sandwich = JsonUtils.parseSandwichJson(json);

        /*
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }
         */

        //updates UI
        populateUI();
//        Picasso.with(this)
//            .load(sandwich.getImage())
//            .into(ingredientsIv);

//          setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }


    /*
        updates UI with model's details
     */
    private void populateUI() {

    }
}
