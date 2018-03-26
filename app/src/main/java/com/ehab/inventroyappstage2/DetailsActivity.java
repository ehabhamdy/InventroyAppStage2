package com.ehab.inventroyappstage2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import static com.ehab.inventroyappstage2.MainActivity.EXTRA_BUNDLE;

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

        Bundle bundle = new Bundle();
        bundle = getIntent().getBundleExtra(EXTRA_BUNDLE);
        String name = bundle.getString(MainActivity.EXTRA_RROCUCT_NAME);
        int price = bundle.getInt(MainActivity.EXTRA_PRODUCT_PRICE);
        int quantity = bundle.getInt(MainActivity.EXTRA_QUANTITY);
        String supplierName = bundle.getString(MainActivity.EXTRA_SUPPLIER_NAME);
        int supplierPhone = bundle.getInt(MainActivity.EXTRA_SUPPLIER_PHONE);

        productNameEditText.setText(name);
        priceEditText.setText(String.valueOf(price));
        quantityEditText.setText(String.valueOf(quantity));
        supplierNameEditText.setText(supplierName);
        supplierPhoneEditText.setText(String.valueOf(supplierPhone));
    }
}
