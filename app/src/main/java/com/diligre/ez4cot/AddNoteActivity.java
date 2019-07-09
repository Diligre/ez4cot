package com.diligre.ez4cot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class AddNoteActivity extends AppCompatActivity {
    ImageView imageView2;
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";
    public static final String EXTRA_ID = "package com.diligre.ez4cot.EXTRA_ID";
    public static final String EXTRA_NAME = "package com.diligre.ez4cot.EXTRA_NAME";
    public static final String EXTRA_BORN = "package com.diligre.ez4cot.EXTRA_BORN";
    public static final String EXTRA_FROM = "package com.diligre.ez4cot.EXTRA_FROM";
    public static final String EXTRA_LOCATION = "package com.diligre.ez4cot.EXTRA_LOCATION";
    public static final String EXTRA_STUDIES = "package com.diligre.ez4cot.EXTRA_STUDIES";
    public static final String EXTRA_PHONE = "package com.diligre.ez4cot.EXTRA_PHONE";
    public static final String EXTRA_BIOGRAPHY = "package com.diligre.ez4cot.EXTRA_BIOGRAPHY";

    private EditText editTextName;
    private EditText editTextBorn;
    private EditText editTextFrom;
    private EditText editTextLocation;
    private EditText editTextStudies;
    private EditText editTextPhone;
    private EditText editTextBiography;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        editTextName = findViewById(R.id.name);
        editTextBorn = findViewById(R.id.born);
        editTextFrom = findViewById(R.id.from);
        editTextLocation = findViewById(R.id.location);
        editTextStudies = findViewById(R.id.studies);
        editTextPhone = findViewById(R.id.phone);
        editTextBiography = findViewById(R.id.biography);


        ImageManager man = new ImageManager();
        man.fetchImage(this, 360000, url, imageView2);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)){
            setTitle("Edit profile");
            editTextName.setText(intent.getStringExtra(EXTRA_NAME));
            editTextBorn.setText(intent.getStringExtra(EXTRA_BORN));
            editTextFrom.setText(intent.getStringExtra(EXTRA_FROM));
            editTextLocation.setText(intent.getStringExtra(EXTRA_LOCATION));
            editTextStudies.setText(intent.getStringExtra(EXTRA_STUDIES));
            editTextPhone.setText(intent.getStringExtra(EXTRA_PHONE));
            editTextBiography.setText(intent.getStringExtra(EXTRA_BIOGRAPHY));


        } else {
            setTitle("Add Note");
        }

    }
    private  void  saveNote(){
       String name = editTextName.getText().toString();
       String born = editTextBorn.getText().toString();
       String from = editTextFrom.getText().toString();
       String location = editTextLocation.getText().toString();
       String studies = editTextStudies.getText().toString();
       String phone = editTextPhone.getText().toString();
       String biography = editTextBiography.getText().toString();


        if (name.trim().isEmpty() || born.trim().isEmpty() || from.trim().isEmpty()|| location.trim().isEmpty() || studies.trim().isEmpty() || phone.trim().isEmpty() || biography.trim().isEmpty()  ){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_NAME,name);
        data.putExtra(EXTRA_BORN,born);
        data.putExtra(EXTRA_FROM,from);
        data.putExtra(EXTRA_LOCATION,location);
        data.putExtra(EXTRA_STUDIES,studies);
        data.putExtra(EXTRA_PHONE,phone);
        data.putExtra(EXTRA_BIOGRAPHY,biography);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1 ){
            data.putExtra(EXTRA_ID, id);
        }


        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
