package operate;

import pojo.Product;

public class OperateProduct {
    Product[] products=new Product[10];
    public void init(){
        int index=0;
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product("血瓶", 0, 0, 700, 500);
        }
    }

    public OperateProduct(){
        init();
    }
    public Product[] getProducts() {
        return products;
    }
}
