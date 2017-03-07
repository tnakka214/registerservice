package edu.uark.controllers;

import edu.uark.models.api.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import edu.uark.commands.employees.EmployeeByLookupCodeQuery;
//import edu.uark.commands.products.EmployeeQuery;
import edu.uark.commands.employees.EmployeeSaveCommand;
//import edu.uark.commands.products.EmployeesQuery;
//import edu.uark.models.api.ProductListing;


/**
 * Created by tejnakk on 3/6/17.
 */
@RequestMapping(value = "/employee")
public class EmployeeRestController {
//    @RequestMapping(value = "/apiv0/{empolyeeId}", method = RequestMethod.GET)
//    public Product getProduct(@PathVariable UUID empolyeeId) {
//        return (new ProductQuery()).
//                setEmployeeId(empolyeeId).
//                execute();
//    }

//    @RequestMapping(value = "/apiv0/byLookupCode/{productLookupCode}", method = RequestMethod.GET)
//    public Product getProductByLookupCode(@PathVariable String productLookupCode) {
//        return (new ProductByLookupCodeQuery()).
//                setLookupCode(productLookupCode).
//                execute();
//    }

//    @RequestMapping(value = "/apiv0/products", method = RequestMethod.GET)
//    public ProductListing getProducts() {
//        return (new ProductsQuery()).execute();
//    }

    @RequestMapping(value = "/apiv0/", method = RequestMethod.PUT)
    public Employee putEmployee(@RequestBody Employee employee) {
        return (new EmployeeSaveCommand()).
                setApiEmployee(employee).
                execute();
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Successful test. (EmployeeRestController)";
    }
}
