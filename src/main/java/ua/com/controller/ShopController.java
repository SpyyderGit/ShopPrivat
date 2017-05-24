package ua.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dao.ProductDao;
import ua.com.dao.ProductMrDao;
import ua.com.dao.ProductTypeDao;
import ua.com.dao.ProductViewDao;
import ua.com.dao.impl.ProductDaoImpl;
import ua.com.dao.impl.ProductMrDaoImpl;
import ua.com.dao.impl.ProductTypeDaoImpl;
import ua.com.dao.impl.ProductViewDaoImpl;
import ua.com.model.Product;
import ua.com.service.ProductMrService;
import ua.com.service.ProductService;
import ua.com.service.ProductTypeService;
import ua.com.service.ProductViewService;
import ua.com.service.impl.ProductMrServiceImpl;
import ua.com.service.impl.ProductServiceImpl;
import ua.com.service.impl.ProductTypeServiceImpl;
import ua.com.service.impl.ProductViewServiceImpl;
import ua.com.utils.DBConnector;

/**
 * Created by User on 22.05.2017.
 */
@Controller
public class ShopController {

    private DBConnector connector = new DBConnector();

    private ProductDao productDao = new ProductDaoImpl(connector.jdbcConnect(), connector.templateConnect());
    private ProductService productService = new ProductServiceImpl(productDao);

    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl(connector.templateConnect());
    private ProductTypeService typeService = new ProductTypeServiceImpl(productTypeDao, productDao);

    private ProductViewDao viewDao = new ProductViewDaoImpl(connector.templateConnect());
    private ProductViewService productViewService = new ProductViewServiceImpl(viewDao, typeService);

    private ProductMrDao productMrDao = new ProductMrDaoImpl(connector.templateConnect());
    private ProductMrService productMrService = new ProductMrServiceImpl(productMrDao, productService);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(ModelMap modelMap) {
        modelMap.addAttribute("prodView", productViewService.getAllProductsViewService());
        modelMap.addAttribute("prodType", typeService.getAllProductsTypeService());
        return "index";
    }

    @RequestMapping(value = "/productType", method = RequestMethod.GET)
    public String getProductType(ModelMap modelMap) {
        modelMap.addAttribute("type", typeService.getAllProductsTypeService());
        return "productType";
    }

    @RequestMapping(value = "/productView", method = RequestMethod.GET)
    public String getProductView(ModelMap modelMap) {
        modelMap.addAttribute("view", productViewService.getAllProductsViewService());
        return "productView";
    }

    @RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
    public String getManufacture(ModelMap modelMap) {
        modelMap.addAttribute("mr", productMrService.getAllMr());
        return "manufacturer";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(ModelMap modelMap) {
        modelMap.addAttribute("name", productService.getAllProductsService());
        return "products";
    }


}