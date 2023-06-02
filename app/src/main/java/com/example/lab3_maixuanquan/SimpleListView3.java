package com.example.lab3_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab3_maixuanquan.adapter.FruitAdapter;
import com.example.lab3_maixuanquan.object.Fruit;

import java.util.ArrayList;

public class SimpleListView3 extends AppCompatActivity {
    private static final int REQUEST_GET_SINGLE_FILE = 1;
    private ListView fruitListView;
    private ArrayList<Fruit> fruits;
    private Button btnAdd;
    private Button btnUpdate;

    private ImageView fruitImage;
    private Uri imageUri;
    private EditText txtFruitName;
    private EditText txtDescription;
    private final String REQUIRED = "Required";
    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view3);
        fruitListView = findViewById(R.id.fruit_list);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);

        fruitImage = findViewById(R.id.fruit_image);
        txtFruitName = findViewById(R.id.txtFruitName);
        txtDescription = findViewById(R.id.txtDescription);
        fruits = new ArrayList<>();
        addFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(this, fruits, R.layout.fruit_layout);
        fruitListView.setAdapter(fruitAdapter);
        fruitListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                fruits.remove(position);
                fruitAdapter.notifyDataSetChanged();
                return true;
            }
        });
        fruitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fruitImage.setImageURI(fruits.get(position).getImage());
                imageUri = fruits.get(position).getImage();
                txtDescription.setText(fruits.get(position).getDescription());
                txtFruitName.setText(fruits.get(position).getName());
                selectedPosition = position;
            }
        });
        fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidFruit()) {
                    fruits.add(new Fruit(txtFruitName.getText().toString(), txtDescription.getText().toString(), imageUri));
                    fruitAdapter.notifyDataSetChanged();
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidFruit()) {
                    fruits.set(selectedPosition, new Fruit(txtFruitName.getText().toString(), txtDescription.getText().toString(), imageUri));
                    fruitAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private boolean isValidFruit() {
        boolean result = true;
        if (TextUtils.isEmpty(txtFruitName.getText().toString())) {
            txtFruitName.setError(REQUIRED);
            result = false;
        }
        if (TextUtils.isEmpty(txtDescription.getText().toString())) {
            txtDescription.setError(REQUIRED);
            result = false;
        }
        if (fruitImage.getDrawable() == null) {
            Toast.makeText(this, "Image is required!", Toast.LENGTH_SHORT).show();
            result = false;
        }
        return result;
    }

    private void imageChooser() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_GET_SINGLE_FILE);

    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            // compare the resultCode with the
            //  REQUEST_GET_SINGLE_FILE constant
            if (requestCode == REQUEST_GET_SINGLE_FILE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imageUri = selectedImageUri;
                    fruitImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

    private void addFruit() {
        Resources resources = this.getResources();
        Uri uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(R.drawable.apple))
                .appendPath(resources.getResourceTypeName(R.drawable.apple))
                .appendPath(resources.getResourceEntryName(R.drawable.apple))
                .build();
        Fruit f1 = new Fruit("Apple", "This is apple", uri);
        uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(R.drawable.banana))
                .appendPath(resources.getResourceTypeName(R.drawable.banana))
                .appendPath(resources.getResourceEntryName(R.drawable.banana))
                .build();
        Fruit f2 = new Fruit("Banana", "This is banana", uri);
        uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(R.drawable.dragon_fruit))
                .appendPath(resources.getResourceTypeName(R.drawable.dragon_fruit))
                .appendPath(resources.getResourceEntryName(R.drawable.dragon_fruit))
                .build();
        Fruit f3 = new Fruit("Dragon Fruit", "This is dragon fruit", uri);
        uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(R.drawable.mago))
                .appendPath(resources.getResourceTypeName(R.drawable.mago))
                .appendPath(resources.getResourceEntryName(R.drawable.mago))
                .build();
        Fruit f4 = new Fruit("Mango", "This is mango", uri);
        uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(R.drawable.strawberry))
                .appendPath(resources.getResourceTypeName(R.drawable.strawberry))
                .appendPath(resources.getResourceEntryName(R.drawable.strawberry))
                .build();
        Fruit f5 = new Fruit("Strawberry", "This is strawberry", uri);
        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        fruits.add(f4);
        fruits.add(f5);
    }
}