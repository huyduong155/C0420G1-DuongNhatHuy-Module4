package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/form")
    public String getForm(){
        return "calculator";
    }
    @RequestMapping("/calculator")
    public String addition(@RequestParam(name = "num1",defaultValue = "0") String num1,@RequestParam(name = "num2",defaultValue = "0") String num2,@RequestParam(name = "calculate") String calculate, Model model){
        double result = 0;
        switch (calculate){
            case "Addition(+)":
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case "Subtraction(-)":
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case "Multiplication(x)":
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case "Division(/)":
                if (Double.parseDouble(num2) != 0){
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                }else {
                    model.addAttribute("message","number 2 is not = 0");
                }
                break;
        }
        model.addAttribute("result",result);
        return "calculator";
    }
}
