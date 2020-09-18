package furama.controller;

import furama.model.Contract;
import furama.model.ContractDetail;
import furama.model.Customer;
import furama.model.Service;
import furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping("/")
    public String getFormLogin(){
        return "login";
    }


    @GetMapping("/home")
    public String getFormHome(){
        return "home";
    }


    @GetMapping("/customer")
    public ModelAndView listCustomer(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search",defaultValue = "") String search){
        ModelAndView modelAndView = new ModelAndView("listCustomer");
        Page<Customer> customers= customerService.findAll(search,pageable);
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("search",search);
        return modelAndView;
    }
    @GetMapping("/customer/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("createCustomer");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerType",customerTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/customer/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes redirectAttributes, Model model){
       if (result.hasFieldErrors()){
           model.addAttribute("customerType",customerTypeService.findAll());
           return "createCustomer";
       }
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
    public ModelAndView listService(@PageableDefault(value = 5) Pageable pageable,@RequestParam(value = "search",defaultValue = "") String search){
        ModelAndView modelAndView = new ModelAndView("listService");
        Page<Service> services= serviceService.findAll(search,pageable);
        modelAndView.addObject("services",services);
        modelAndView.addObject("search",search);
        return modelAndView;
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
    public String saveService(@Valid @ModelAttribute("service") Service service,BindingResult result, RedirectAttributes redirectAttributes,Model model){
        if (result.hasFieldErrors()){
          FieldError a = result.getFieldError();
            model.addAttribute("rentType",rentTypeService.findAll());
            model.addAttribute("serviceType",serviceTypeService.findAll());
            return "createService";
        }
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
    @GetMapping("/contract/{id}/create")
    public ModelAndView showCreateContract(@PathVariable String id){
        Customer customer = customerService.findById(id);
        String idCus = customer.getId();
        ModelAndView modelAndView = new ModelAndView("createContract");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("service",serviceService.findAll());
        modelAndView.addObject("customer",idCus);
        return modelAndView;
    }

    @PostMapping("/contract/save")
    public String saveContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes){
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Saved contract successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/contract-detail/create")
    public ModelAndView showCreateFormContractDetail(){
        ModelAndView modelAndView = new ModelAndView("createContractDetail");
        modelAndView.addObject("contractDetail", new ContractDetail());
        modelAndView.addObject("contract",contractService.findAll());
        modelAndView.addObject("attach",attachServiceService.findAll());
        return modelAndView;
    }
    @PostMapping("/contract-detail/save")
    public String saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("success", "Saved contract detail successfully!");
        return "redirect:/contract-detail/create";
    }
    @GetMapping("/customer-service")
    public ModelAndView listCustomerService(@PageableDefault(value = 5) Pageable pageable){
        Page<Contract> contracts= contractService.findAllCusUseSer(pageable);
        return new ModelAndView("listCustomerService","contracts",contracts);
    }
}
