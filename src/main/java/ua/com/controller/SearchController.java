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

import java.sql.SQLException;

/**
 * Created by User on 24.05.2017.
 */

@Controller
public class SearchController {

    private DBConnector connector = new DBConnector();

    private ProductDao productDao = new ProductDaoImpl(connector.jdbcConnect(), connector.templateConnect());
    private ProductService productService = new ProductServiceImpl(productDao);

    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl(connector.templateConnect());
    private ProductTypeService typeService = new ProductTypeServiceImpl(productTypeDao, productDao);

    private ProductViewDao viewDao = new ProductViewDaoImpl(connector.templateConnect());
    private ProductViewService productViewService = new ProductViewServiceImpl(viewDao, typeService);

    private ProductMrDao productMrDao = new ProductMrDaoImpl(connector.templateConnect());
    private ProductMrService productMrService = new ProductMrServiceImpl(productMrDao, productService);


    @RequestMapping(value = "search/byPrice", method = RequestMethod.GET)
    public ModelAndView byPrice() {
        Product product = new Product();
        return new ModelAndView("search/byPrice", "command", product);
    }


    @RequestMapping(value = "search/byPriceResult", method = RequestMethod.POST)
    public String byPriceResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {
        modelMap.addAttribute("price", productService.getByPriceService(product.getProductPrice()));
        return "search/byPriceResult";
    }


    @RequestMapping(value = "search/byId", method = RequestMethod.GET)
    public ModelAndView byId() {
        Product product = new Product();
        return new ModelAndView("search/byId", "command", product);
    }


    @RequestMapping(value = "search/byIdResult", method = RequestMethod.POST)
    public String byIdResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {
        try {
            modelMap.addAttribute("productName", productService.getByIdService(product.getProductId()).getProductName());
            modelMap.addAttribute("productPrice", productService.getByIdService(product.getProductId()).getProductPrice());
            modelMap.addAttribute("productRemark", productService.getByIdService(product.getProductId()).getProductRemark());
            modelMap.addAttribute("productSklad", productService.getByIdService(product.getProductId()).getSklad());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "search/byIdResult";
    }


    @RequestMapping(value = "search/byName", method = RequestMethod.GET)
    public ModelAndView byName() {
        Product product = new Product();
        return new ModelAndView("search/byName", "command", product);
    }


    @RequestMapping(value = "search/byNameResult", method = RequestMethod.POST)
    public String byNameResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {
        try {
            modelMap.addAttribute("productName", productService.getByNameService(product.getProductName()).getProductName());
            modelMap.addAttribute("productPrice", productService.getByNameService(product.getProductName()).getProductPrice());
            modelMap.addAttribute("productRemark", productService.getByNameService(product.getProductName()).getProductRemark());
            modelMap.addAttribute("productSklad", productService.getByNameService(product.getProductName()).getSklad());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "search/byNameResult";
    }

    @RequestMapping(value = "search/bySklad", method = RequestMethod.GET)
    public ModelAndView bySklad() {
        Product product = new Product();
        return new ModelAndView("search/bySklad", "command", product);
    }


    @RequestMapping(value = "search/bySkladResult", method = RequestMethod.POST)
    public String bySkladResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {
        modelMap.addAttribute("sklad", productService.getBySkladService(product.getSklad()));
        return "search/bySkladResult";
    }

}