package ua.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.dao.ProductDao;
import ua.com.dao.impl.ProductDaoImpl;
import ua.com.model.Product;
import ua.com.service.ProductService;
import ua.com.service.impl.ProductServiceImpl;
import ua.com.utils.DBConnector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 23.05.17.
 */
@Controller
public class AdminController {

    private DBConnector dbConnector = new DBConnector();
    private ProductDao productDao = new ProductDaoImpl(dbConnector.jdbcConnect(), dbConnector.templateConnect());
    private ProductService productService = new ProductServiceImpl(productDao);

    @RequestMapping(value = "admin/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin/admin";
    }


    @RequestMapping(value = "admin/addProduct", method = RequestMethod.GET)
    public ModelAndView addProduct() {
        Product product = new Product();
        return new ModelAndView("admin/addProduct", "command", product);
    }


    @RequestMapping(value = "admin/addResult", method = RequestMethod.POST)
    public String addResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {

        modelMap.addAttribute("id", product.getProductId());
        modelMap.addAttribute("name", product.getProductName());
        modelMap.addAttribute("price", product.getProductPrice());
        modelMap.addAttribute("remark", product.getProductRemark());
        modelMap.addAttribute("sklad", product.getSklad());
        modelMap.addAttribute("mr_id", product.getMrIdFk());
        modelMap.addAttribute("type_id", product.getTypeIdFk());


        productService.addProductService(product.getProductName(), product.getProductPrice(),
                product.getProductRemark(), product.getSklad(),
                product.getMrIdFk(), product.getTypeIdFk());
        return "admin/addResult";
    }


    @RequestMapping(value = "admin/updateProduct", method = RequestMethod.GET)
    public ModelAndView updateProduct() {
        Product product = new Product();
        return new ModelAndView("admin/updateProduct", "command", product);
    }


    @RequestMapping(value = "admin/updateResult", method = RequestMethod.POST)
    public String updateResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {

        modelMap.addAttribute("id", product.getProductId());
        modelMap.addAttribute("name", product.getProductName());
        modelMap.addAttribute("price", product.getProductPrice());
        modelMap.addAttribute("remark", product.getProductRemark());
        modelMap.addAttribute("sklad", product.getSklad());
        modelMap.addAttribute("mr_id", product.getMrIdFk());
        modelMap.addAttribute("type_id", product.getTypeIdFk());


        productService.updateProductService(product);
        return "admin/updateResult";
    }


    @RequestMapping(value = "admin/delProduct", method = RequestMethod.GET)
    public ModelAndView delProduct() {
        Product product = new Product();
        return new ModelAndView("admin/delProduct", "command", product);
    }


    @RequestMapping(value = "admin/delResult", method = RequestMethod.POST)
    public String delResult(@ModelAttribute("/WEB-INF/shop-servlet.xml") Product product, ModelMap modelMap) {

        modelMap.addAttribute("id", product.getProductId());

        productService.deleteProductService(product.getProductId());
        return "admin/delResult";
    }


}
