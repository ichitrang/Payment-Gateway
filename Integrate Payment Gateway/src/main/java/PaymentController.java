import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
    private final PaymentService paymentService;

    // constructor and autowiring

    @GetMapping("/payment")
    public String showPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "paymentForm";
    }

    @PostMapping("/payment/process")
    public String processPayment(Payment payment) {
        // Call the payment service to process the payment
        paymentService.processPayment(payment);
        return "paymentSuccess"; // A view indicating successful payment
    }
}
