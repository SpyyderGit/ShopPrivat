package ua.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import ua.com.dao.ProductDao;
import ua.com.dao.ProductMrDao;
import ua.com.dao.ProductTypeDao;
import ua.com.dao.ProductViewDao;
import ua.com.dao.impl.ProductDaoImpl;
import ua.com.dao.impl.ProductMrDaoImpl;
import ua.com.dao.impl.ProductTypeDaoImpl;
import ua.com.dao.impl.ProductViewDaoImpl;
import ua.com.model.ProductMr;
import ua.com.model.ProductType;
import ua.com.service.ProductMrService;
import ua.com.service.ProductService;
import ua.com.service.ProductTypeService;
import ua.com.service.ProductViewService;
import ua.com.service.impl.ProductMrServiceImpl;
import ua.com.service.impl.ProductServiceImpl;
import ua.com.service.impl.ProductTypeServiceImpl;
import ua.com.service.impl.ProductViewServiceImpl;
import ua.com.utils.DBConnector;

import java.sql.*;

/**
 * Created by User on 18.05.2017.
 */

public class MainApp {
    public static void main(String[] args) throws SQLException {

        DBConnector connection = new DBConnector();

        ProductDao productDao = new ProductDaoImpl(connection.jdbcConnect(), connection.templateConnect());
        ProductMrDao mrDao = new ProductMrDaoImpl(connection.templateConnect());

        ProductMr mr = new ProductMr(4, "Sonia");


        ProductTypeDao productTypeDao = new ProductTypeDaoImpl(connection.templateConnect());
        ProductTypeService typeService = new ProductTypeServiceImpl(productTypeDao, productDao);

        ProductType productType = new ProductType();
        productType.setTypeName("PC");
        productType.setIdView(3);
        typeService.addProductTypeService(productType);

        ProductViewDao productViewDao = new ProductViewDaoImpl(connection.templateConnect());
        ProductViewService productViewService = new ProductViewServiceImpl(productViewDao, typeService);
        ProductMrDao productMrDao = new ProductMrDaoImpl(connection.templateConnect());

        ProductService productService = new ProductServiceImpl(productDao, productViewDao, productTypeDao, productMrDao);

        ProductMrService productMrService = new ProductMrServiceImpl(mrDao, productService);

        System.out.println(productService.getByMrService("Sony"));


    }


}
