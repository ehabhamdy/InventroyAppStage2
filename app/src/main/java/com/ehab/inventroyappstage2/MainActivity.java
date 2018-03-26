package com.ehab.inventroyappstage2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ehab.inventroyappstage2.data.Product;
import com.ehab.inventroyappstage2.data.StoreDBHelper;

import java.util.ArrayList;
import java.util.List;

import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry;
import static com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry.*;

public class MainActivity extends AppCompatActivity implements InventroyAdapter.RecyclerViewClickListener {

    public static final String EXTRA_RROCUCT_ID = "productID";
    public static final String EXTRA_RROCUCT_NAME = "productName";
    public static final String EXTRA_PRODUCT_PRICE = "productPrice";
    public static final String EXTRA_QUANTITY = "quantity";
    public static final String EXTRA_SUPPLIER_NAME = "supplierName";
    public static final String EXTRA_SUPPLIER_PHONE = "supplierPhone";
    public static final String EXTRA_BUNDLE = "extraData";

    private RecyclerView inventoryRecyclerView;
    private InventroyAdapter adapter;
    private Cursor productsCursor;
    private String[] projection = {
            InventoryEntry._ID,
            InventoryEntry.COLUMN_PRODUCT_NAME,
            InventoryEntry.COLUMN_PRICE,
            InventoryEntry.COLUMN_QUANTITY,
            InventoryEntry.COLUMN_SUPPLIER_NAME};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inventoryRecyclerView = findViewById(R.id.inventoryRecylcerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        inventoryRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new InventroyAdapter(this);

        inventoryRecyclerView.setAdapter(adapter);

        productsCursor = getContentResolver().query(CONTENT_URI, projection, null, null, null);

        adapter.swapCursor(productsCursor);

        //showInventoryTableRowCount();
    }

    public void addProductOnClick(View view) {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(Product product) {
        Intent intent = new Intent(this, DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong(EXTRA_RROCUCT_ID, product.getId());
        bundle.putString(EXTRA_RROCUCT_NAME, product.getName());
        bundle.putInt(EXTRA_PRODUCT_PRICE, product.getPrice());
        bundle.putInt(EXTRA_QUANTITY, product.getQuantity());
        bundle.putString(EXTRA_SUPPLIER_NAME, product.getSupplierName());
        bundle.putInt(EXTRA_SUPPLIER_PHONE, product.getSupplierPhone());
        intent.putExtra(EXTRA_BUNDLE, bundle);
        startActivity(intent);
    }
}
