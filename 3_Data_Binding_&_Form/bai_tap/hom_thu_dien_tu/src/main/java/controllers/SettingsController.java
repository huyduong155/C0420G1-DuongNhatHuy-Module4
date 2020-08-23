package controllers;

import model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.ISettingsService;
import service.SettingsService;

import java.util.List;

@Controller
public class SettingsController {
    ISettingsService iSettingsService = new SettingsService();
@GetMapping("/form")
public String showForm(@ModelAttribute("settings")Settings settings, Model model){
    List<String> listLanguage = iSettingsService.getLanguage();
    List<String> listPageSize = iSettingsService.getPageSize();
    model.addAttribute("listLanguage",listLanguage);
    model.addAttribute("listPageSize",listPageSize);

return "form";
}
@PostMapping("/update")
    public String update(@ModelAttribute("settings")Settings settings,Model model){
    model.addAttribute("languages",settings.getLanguages());
    model.addAttribute("pageSize",settings.getPageSize());
    model.addAttribute("spamsFilter",settings.getSpamsFilter());
    model.addAttribute("signature",settings.getSignature());
    return "update";
}
}
