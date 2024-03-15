package org.chinh.appquanlychitieu.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.dao.ProductDao;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class ProductPresenter implements IProductConstract.IPresenter {
    private IProductConstract.IView mView;
    private AppDatabase db;
    public ProductPresenter(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).build();
    }

    @Override
    public void setView(IProductConstract.IView view) {
        mView = view;
    }

    @Override
    public void loadHotProducts() {
        ProductDao productDao = db.productDao();
        mView.setHotProductsToUI(productDao.getHotProducts());
    }

    @Override
    public void loadNewProducts() {
        ProductDao productDao = db.productDao();
        mView.setNewProductsToUI(productDao.getNewProducts());
    }


}
