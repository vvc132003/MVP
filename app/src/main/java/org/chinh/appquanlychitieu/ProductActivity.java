package org.chinh.appquanlychitieu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.ui.presenter.ProductPresenter;
import org.chinh.appquanlychitieu.ui.adapter.ProductAdapter;

import java.util.List;

public class ProductActivity extends AppCompatActivity implements IProductConstract.IView {
    private RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;
    private ProductPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPresenter = new ProductPresenter(this);
        mPresenter.setView(this);
        mPresenter.loadHotProducts(); // Load hot products or new products, depending on your logic
    }

    @Override
    public void setHotProductsToUI(List<Product> productList) {
        mProductAdapter = new ProductAdapter(this, productList);
        mRecyclerView.setAdapter(mProductAdapter);
    }

    @Override
    public void setNewProductsToUI(List<Product> productList) {
        // Not needed here, as this example only loads hot products
    }
}
