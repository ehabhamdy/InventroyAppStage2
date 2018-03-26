package com.ehab.inventroyappstage2;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.ehab.inventroyappstage2.MainActivity.EXTRA_BUNDLE;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_PRICE;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_PRODUCT_NAME;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_QUANTITY;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_SUPPLIER_COUNTRY;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_SUPPLIER_NAME;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_SUPPLIER_PHONE;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.CONTENT_URI;

public class DetailsActivity extends AppCompatActivity {
    EditText productNameEditText;
    EditText priceEditText;
    EditText quantityEditText;
    EditText supplierNameEditText;
    EditText supplierPhoneEditText;
    long id;

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
        id = bundle.getLong(MainActivity.EXTRA_RROCUCT_ID);
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

    public void saveClicked(View view) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, productNameEditText.getText().toString());
        values.put(COLUMN_PRICE, priceEditText.getText().toString());
        values.put(COLUMN_QUANTITY, quantityEditText.getText().toString());
        values.put(COLUMN_SUPPLIER_NAME, supplierNameEditText.getText().toString());
        values.put(COLUMN_SUPPLIER_PHONE, supplierPhoneEditText.getText().toString());
        values.put(COLUMN_SUPPLIER_COUNTRY, "US");
        getContentResolver().update(ContentUris.withAppendedId(CONTENT_URI, id), values, null, null);
        Toast.makeText(this, "Product details updated", Toast.LENGTH_SHORT).show();
    }

    public void deleteClicked(View view) {
        getContentResolver().delete(ContentUris.withAppendedId(CONTENT_URI, id), null, null);
        Toast.makeText(this, "Product has been deleted", Toast.LENGTH_SHORT).show();
        finish();

    }
}
