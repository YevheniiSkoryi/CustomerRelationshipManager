package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import source.entity.Customer;
import source.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customerList",customerList);
        return "list-customers";
    }

    @GetMapping("/newCustomer")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "formAddCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(
            @ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") Integer id,
                                 Model model){
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer",customer);

        return "formAddCustomer";
    }

    @GetMapping("/deleteCustomer")
    public String updateCustomer(@RequestParam("customerId") Integer id){
        customerService.deleteCustomerById(id);

        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String searchCustomerByLastName(@RequestParam("theSearchName") String lastName,
                                           Model model){
        List<Customer> customers = customerService.getCustomersByLastName(lastName);

        model.addAttribute("customerList",customers);
        return "list-customers";
    }

}
