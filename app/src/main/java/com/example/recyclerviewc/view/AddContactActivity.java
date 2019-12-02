package com.example.recyclerviewc.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.TextUtilsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewc.R;
import com.example.recyclerviewc.model.FavoriteAdapter;
import com.example.recyclerviewc.viewmodel.FContactViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class AddContactActivity extends AppCompatActivity {

    private TextInputEditText etAddName,etAddPhone;
    private Button btOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        btOk = findViewById(R.id.bt_Ok);
        etAddName = findViewById(R.id.et_Add_Name);
        etAddPhone = findViewById(R.id.et_Add_Phone_number);

        btOk.setOnClickListener(v -> sendData());

    }

    private void sendData() {
//        Intent sendIntent = new Intent();
//        if(TextUtils.isEmpty(etAddName.getText()) && TextUtils.isEmpty(etAddPhone.getText())){
//            setResult(RESULT_CANCELED,sendIntent);
//        } else {
//            String name = etAddName.getText().toString();
//            String phone = etAddPhone.getText().toString();
//
//        }
        Bundle bundle = new Bundle();
        bundle.putString("NAME_KEY",etAddName.getText().toString());
        bundle.putString("PHONE_KEY",etAddPhone.getText().toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }

}
