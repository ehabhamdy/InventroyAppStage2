package com.ehab.inventroyappstage2;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ehab.inventroyappstage2.data.Product;
import com.ehab.inventroyappstage2.data.StoreContract.InventoryEntry;

import java.util.List;

/**
 * Created by ehabhamdy on 3/26/18.
 */

public class InventroyAdapter extends RecyclerView.Adapter<InventroyAdapter.InventoryHolder> {

    private Cursor mCursor;
    private RecyclerViewClickListener mClickListener;

    public interface RecyclerViewClickListener {
        void onClick(Product product);
    }


    public InventroyAdapter( MainActivity activity) {
        mClickListener = activity;
    }

    @Override
    public InventoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new InventoryHolder(itemView);    }

    @Override
    public void onBindViewHolder(InventoryHolder holder, int position) {
        mCursor.moveToPosition(position);
        String name = mCursor.getString(mCursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME));
        int price = mCursor.getInt(mCursor.getColumnIndex(InventoryEntry.COLUMN_PRICE));
        holder.nameTextView.setText(name);
        holder.priceTextView.setText(String.valueOf(price));
    }
    public void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (null == mCursor) return 0;
        return mCursor.getCount();
    }

    public class InventoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView;
        TextView priceTextView;
        public InventoryHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.productNameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            mCursor.moveToPosition(adapterPosition);
            long productId = mCursor.getLong(mCursor.getColumnIndex(InventoryEntry._ID));
            String name = mCursor.getString(mCursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME));
            int quantity = mCursor.getInt(mCursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY));
            int price = mCursor.getInt(mCursor.getColumnIndex(InventoryEntry.COLUMN_PRICE));
            String supplierName = mCursor.getString(mCursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_NAME));
            int supplierPhone = mCursor.getInt(mCursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_PHONE));
            Product d = new Product(productId, name, price, quantity, supplierName, supplierPhone, "US");
            mClickListener.onClick(d);
        }
    }
}
