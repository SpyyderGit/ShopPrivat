package ua.com.service.impl;

import org.apache.log4j.Logger;
import ua.com.dao.ProductDao;
import ua.com.dao.ProductMrDao;
import ua.com.dao.ProductTypeDao;
import ua.com.dao.ProductViewDao;
import ua.com.dao.impl.ProductDaoImpl;
import ua.com.dao.impl.ProductMrDaoImpl;
import ua.com.model.Product;
import ua.com.service.ProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.05.2017.
 */
public class ProductServiceImpl implements ProductService {

    private static final Logger log = Logger.getLogger(ProductDaoImpl.class);
    private ProductDao productDao;
    private ProductViewDao productViewDao;
    private ProductTypeDao productTypeDao;
    private ProductMrDao productMrDao;

    public ProductServiceImpl(ProductDao productDao, ProductViewDao productViewDao, ProductTypeDao productTypeDao, ProductMrDao productMrDao) {
        this.productDao = productDao;
        this.productViewDao = productViewDao;
        this.productTypeDao = productTypeDao;
        this.productMrDao = productMrDao;
    }


    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProductService(String productName, double productPrice, String productRemark, String sklad, int mrIdFk, int typeIdFk) {
        try {
            productDao.addProduct(productName, productPrice, productRemark, sklad, mrIdFk, typeIdFk);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductService(int id) {

        productDao.deleteProduct(id);
    }

    @Override
    public void updateProductService(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public Product getByIdService(int id) throws SQLException {
        return productDao.getById(id);
    }

    @Override
    public Product getByNameService(String name) throws SQLException {
        return productDao.getByName(name);
    }

    @Override
    public List<Product> getByPriceService(double price) {
        return productDao.getByPrice(price);
    }

    @Override
    public List<Product> getBySkladService(String sklad) {
        return productDao.getBySklad(sklad);
    }

    @Override
    public List<Product> getByTypeService(String type) {
        List<Product> productList = new ArrayList<>();
        int typeId = productTypeDao.getByName(type).getTypeId();

        for (Product p : productDao.getAllProducts()) {
            if (p.getTypeIdFk() == typeId) {
                productList.add(p);
            }
        }

        return productList;
    }

    @Override
    public List<Product> getByViewService(String view) {
        return null;
    }

    @Override
    public List<Product> getByMrService(String view) {
        return null;
    }

    @Override
    public List<Product> getAllProductsService() {
        return productDao.getAllProducts();
    }
}
