package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/send")
    public String sendPaymentInstruction(@RequestBody PaymentInstructionRequest request) {
        // Verify if debit and credit accounts exist
        Account debitAccount = accountRepository.findByAccountNumber(request.getDebitAccountNumber())
                .orElseThrow(() -> new RuntimeException("Debit account not found"));
        Account creditAccount = accountRepository.findByAccountNumber(request.getCreditAccountNumber())
                .orElseThrow(() -> new RuntimeException("Credit account not found"));

        // Create debit and credit instructions
        PaymentInstruction debitInstruction = createPaymentInstruction(debitAccount, request.getAmount(), "DEBIT");
        PaymentInstruction creditInstruction = createPaymentInstruction(creditAccount, request.getAmount(), "CREDIT");

        // Save instructions (you can store them in DB)
        // paymentInstructionRepository.save(debitInstruction);
        // paymentInstructionRepository.save(creditInstruction);

        // Print instructions
        printInstruction(debitInstruction);
        printInstruction(creditInstruction);

        return "Payment instructions processed successfully";
    }

    private PaymentInstruction createPaymentInstruction(Account account, double amount, String type) {
        PaymentInstruction instruction = new PaymentInstruction();
        instruction.setInstructionId(generateInstructionId());
        instruction.setAccountNumber(account.getAccountNumber());
        instruction.setCurrency(account.getCurrency());
        instruction.setInstructionType(type);
        instruction.setAmount(amount);
        instruction.setBank(account.getBank());
        instruction.setBranch(account.getBranch());
        return instruction;
    }

    private void printInstruction(PaymentInstruction instruction) {
        System.out.println("Instruction Type: " + instruction.getInstructionType());
        System.out.println("Account Number: " + instruction.getAccountNumber());
        System.out.println("Currency: " + instruction.getCurrency());
        System.out.println("Amount: " + instruction.getAmount());
        System.out.println("Bank: " + instruction.getBank());
        System.out.println("Branch: " + instruction.getBranch());
    }

    private String generateInstructionId() {
        return "INST-" + System.currentTimeMillis();
    }

    public static class PaymentInstructionRequest {
        private String debitAccountNumber;
        private String creditAccountNumber;
        private double amount;

        // Getters and Setters
        public String getDebitAccountNumber() {
            return debitAccountNumber;
        }

        public void setDebitAccountNumber(String debitAccountNumber) {
            this.debitAccountNumber = debitAccountNumber;
        }

        public String getCreditAccountNumber() {
            return creditAccountNumber;
        }

        public void setCreditAccountNumber(String creditAccountNumber) {
            this.creditAccountNumber = creditAccountNumber;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}