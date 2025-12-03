package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double result;

    public Transaction() {}

    public Transaction(Currency sourceCurrency, Currency targetCurrency, double amount, double result) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.result = result;
    }

    public int getId() { return id; }
    public Currency getSourceCurrency() { return sourceCurrency; }
    public void setSourceCurrency(Currency sourceCurrency) { this.sourceCurrency = sourceCurrency; }
    public Currency getTargetCurrency() { return targetCurrency; }
    public void setTargetCurrency(Currency targetCurrency) { this.targetCurrency = targetCurrency; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
}
