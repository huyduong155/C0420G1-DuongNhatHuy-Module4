package furama.controller;

import furama.model.Customer;
import furama.model.Service;
import furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FuramaController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/")
    public String getFormHome(){
        return "home";
    }


    @GetMapping("/customer")
    public ModelAndView listCustomer(@PageableDefault(value = 5) Pageable pageable){
        Page<Customer> customers= customerService.findAll(pageable);
        return new ModelAndView("listCustomer","customers",customers);
    }
    @GetMapping("/customer/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("createCustomer");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerType",customerTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/customer/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView showEditForm(@PathVariable String id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("editCustomer");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("customerType",customerTypeService.findAll());
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/customer/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/customer/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable String id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("deleteCustomer");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/customer/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer,RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/service")
    public ModelAndView listService(@PageableDefault(value = 5) Pageable pageable){
        Page<Service> services= serviceService.findAll(pageable);
        return new ModelAndView("listService","services",services);
    }
    @GetMapping("/service/create")
    public ModelAndView showCreateFormService(){
        ModelAndView modelAndView = new ModelAndView("createService");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("rentType",rentTypeService.findAll());
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/service/save")
    public String saveService(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes){
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("success", "Saved Service successfully!");
        return "redirect:/service";
    }
    @GetMapping("/service/{id}/edit")
    public ModelAndView showEditFormService(@PathVariable String id){
        Service service = serviceService.findById(id);
        if(service != null) {
            ModelAndView modelAndView = new ModelAndView("editService");
            modelAndView.addObject("service", service);
            modelAndView.addObject("rentType",rentTypeService.findAll());
            modelAndView.addObject("serviceType",serviceTypeService.findAll());
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/service/update")
    public String updateService(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("success", "Modified service successfully!");
        return "redirect:/service";
    }
    @GetMapping("/service/{id}/delete")
    public ModelAndView showDeleteFormService(@PathVariable String id){
        Service service = serviceService.findById(id);
        if(service != null) {
            ModelAndView modelAndView = new ModelAndView("deleteService");
            modelAndView.addObject("service", service);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/service/delete")
    public String deleteService(@ModelAttribute("service") Service service,RedirectAttributes redirectAttributes){
        serviceService.remove(service.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted service successfully!");
        return "redirect:/service";
    }
    @GetMapping("/contract/create")
    public ModelAndView showCreateFormContract(){
        ModelAndView modelAndView = new ModelAndView("createContract");
        modelAndView.addObject("contract", new Service());
        modelAndView.addObject("rentType",rentTypeService.findAll());
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/contract/save")
    public String saveContract(@ModelAttribute("contract") Service service, RedirectAttributes redirectAttributes){
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("success", "Saved contract successfully!");
        return "redirect:/service";
    }
}
