package com.ehab.inventroyappstage2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {
    EditText productNameEditText;
    EditText priceEditText;
    EditText quantityEditText;
    EditText supplierNameEditText;
    EditText supplierPhoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        productNameEditText = findViewById(R.id.productNameEditText);
        priceEditText = findViewById(R.id.priceEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        supplierNameEditText = findViewById(R.id.supplierNameEditText);
        supplierPhoneEditText = findViewById(R.id.supplierPhoneEditText);

        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String name = bundle.getString(MainActivity.EXTRA_RROCUCT_NAME);
        String price = bundle.getString(MainActivity.EXTRA_PRODUCT_PRICE);
        String quantity = bundle.getString(MainActivity.EXTRA_QUANTITY);
        String supplierName = bundle.getString(MainActivity.EXTRA_SUPPLIER_NAME);
        String supplierPhone = bundle.getString(MainActivity.EXTRA_SUPPLIER_PHONE);

        productNameEditText.setText(name);
        priceEditText.setText(price);
        quantityEditText.setText(quantity);
        supplierNameEditText.setText(supplierName);
        supplierPhoneEditText.setText(supplierPhone);
    }
}
