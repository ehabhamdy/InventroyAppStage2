package com.ehab.inventroyappstage2;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_PRICE;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_PRODUCT_NAME;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_QUANTITY;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_SUPPLIER_COUNTRY;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_SUPPLIER_NAME;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.COLUMN_SUPPLIER_PHONE;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.CONTENT_URI;

public class AddProductActivity extends AppCompatActivity {

    EditText productNameEditText;
    EditText priceEditText;
    EditText quantityEditText;
    EditText supplierNameEditText;
    EditText supplierPhoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productNameEditText = findViewById(R.id.productNameEditText);
        priceEditText = findViewById(R.id.priceEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        supplierNameEditText = findViewById(R.id.supplierNameEditText);
        supplierPhoneEditText = findViewById(R.id.supplierPhoneEditText);
    }

    public void saveButtonClicked(View view) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, productNameEditText.getText().toString());
        values.put(COLUMN_PRICE, priceEditText.getText().toString());
        values.put(COLUMN_QUANTITY, quantityEditText.getText().toString());
        values.put(COLUMN_SUPPLIER_NAME, supplierNameEditText.getText().toString());
        values.put(COLUMN_SUPPLIER_PHONE, supplierPhoneEditText.getText().toString());
        values.put(COLUMN_SUPPLIER_COUNTRY, "US");

        Uri newUri = getContentResolver().insert(CONTENT_URI, values);
    }
}
