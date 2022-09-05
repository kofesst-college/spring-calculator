package me.kofeesst.spring.praktika.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String getCalculator(
            @RequestParam(value = "first", required = false) Integer first,
            @RequestParam(value = "second", required = false) Integer second,
            @RequestParam(value = "sign", required = false) Character sign,
            Model model
    ) {
        if (first != null && second != null && sign != null) {
            Integer result = null;
            switch (sign) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '/':
                    if (second == 0) {
                        model.addAttribute(
                                "error",
                                "Не удалось поделить на ноль"
                        );
                    } else {
                        result = first / second;
                    }
                    break;
            }
            model.addAttribute("result", result);
        }

        return "calculator";
    }

    @PostMapping("/calculator")
    public String postCalculator(
            @RequestParam(value = "first", required = false) Integer first,
            @RequestParam(value = "second", required = false) Integer second,
            @RequestParam(value = "sign", required = false) Character sign,
            Model model
    ) {
        if (first != null && second != null && sign != null) {
            Integer result = null;
            switch (sign) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '/':
                    if (second == 0) {
                        model.addAttribute(
                                "error",
                                "Не удалось поделить на ноль"
                        );
                    } else {
                        result = first / second;
                    }
                    break;
            }
            model.addAttribute("result", result);
        }

        return "calculator";
    }
}
