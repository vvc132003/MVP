package org.chinh.appquanlychitieu.ui.constract;

import org.chinh.appquanlychitieu.data.model.Product;

import java.util.List;

public interface  IProductConstract {
    interface IView {
        void setHotProductsToUI(List<Product> productList);
        void setNewProductsToUI(List<Product> productList);
    }

    interface IPresenter {
        void setView(IView view);
        void loadHotProducts();
        void loadNewProducts();
//        void loadCategories();
    }
}
