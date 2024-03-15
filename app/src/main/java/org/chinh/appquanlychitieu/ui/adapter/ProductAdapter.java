package org.chinh.appquanlychitieu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.chinh.appquanlychitieu.DetailActivity;
import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private Context mContext;
    private List<Product> mProductList;
    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.mProductList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = mProductList.get(position);
//        Glide.with(mContext)
//                .load(hero.getImage())
//                .into(holder.mImageHero);
        holder.mTextName.setText(product.name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //KHoi dong Activty DetailActivity
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(Constants.PRODUCT_ID, product.id);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageHero;
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            mImageHero = itemView.findViewById(R.id.iv_image);
            mTextName = itemView.findViewById(R.id.text_product_name); // Đổi tên id theo tên thật của TextView trong layout
        }
    }
}
