package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;

    private double amount;
    private double convertedAmount;

    private LocalDateTime timestamp;

    public Transaction() {
    }

    public Transaction(Currency sourceCurrency, Currency targetCurrency, double amount, double convertedAmount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters
    public int getId() { return id; }
    public Currency getSourceCurrency() { return sourceCurrency; }
    public Currency getTargetCurrency() { return targetCurrency; }
    public double getAmount() { return amount; }
    public double getConvertedAmount() { return convertedAmount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setSourceCurrency(Currency sourceCurrency) { this.sourceCurrency = sourceCurrency; }
    public void setTargetCurrency(Currency targetCurrency) { this.targetCurrency = targetCurrency; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setConvertedAmount(double convertedAmount) { this.convertedAmount = convertedAmount; }
}
