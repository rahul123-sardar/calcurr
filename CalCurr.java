import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class CalCurr {
    
    public static void converter() {
        JFrame f = new JFrame("CURRENCY CONVERTER");
        
        JLabel l1 = new JLabel("Amount:");
        l1.setBounds(20, 40, 80, 30);
        
        JTextField t1 = new JTextField(" ");
        t1.setBounds(100, 40, 100, 30);
        
        JLabel l2 = new JLabel("From:");
        l2.setBounds(20, 90, 80, 30);
        
        JLabel l3 = new JLabel("To:");
        l3.setBounds(220, 90, 80, 30);
        
        // Dropdowns for currencies
        String[] currencies = {
    "USD", "INR", "EUR", "GBP", "JPY", "AUD", "CAD",
    "CHF", "CNY", "NZD", "SGD", "MXN", "ZAR", "KRW",
    "BRL", "AED", "SAR", "TRY", "RUB"
};
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(100, 90, 100, 30);
        
        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(260, 90, 100, 30);
        
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 140, 100, 30);
        
        JTextField resultField = new JTextField("0");
        resultField.setBounds(100, 190, 260, 30);
        resultField.setEditable(false);
        
        // Exchange rates relative to USD
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);      // US Dollar
rates.put("INR", 82.75);    // Indian Rupee
rates.put("EUR", 0.92);     // Euro
rates.put("GBP", 0.81);     // British Pound
rates.put("JPY", 134.25);   // Japanese Yen
rates.put("AUD", 1.50);     // Australian Dollar
rates.put("CAD", 1.35);     // Canadian Dollar
rates.put("CHF", 0.90);     // Swiss Franc
rates.put("CNY", 7.20);     // Chinese Yuan
rates.put("NZD", 1.62);     // New Zealand Dollar
rates.put("SGD", 1.35);     // Singapore Dollar
rates.put("MXN", 17.50);    // Mexican Peso
rates.put("ZAR", 18.50);    // South African Rand
rates.put("KRW", 1300.0);   // South Korean Won
rates.put("BRL", 5.10);     // Brazilian Real
rates.put("AED", 3.67);     // UAE Dirham
rates.put("SAR", 3.75);     // Saudi Riyal
rates.put("TRY", 26.20);    // Turkish Lira
rates.put("RUB", 79.50);    // Russian Ruble

        
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(t1.getText());
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();
                    
                    // Convert the amount to USD first
                    double amountInUSD = amount / rates.get(from);
                    // Then convert USD to target currency
                    double convertedAmount = amountInUSD * rates.get(to);
                    
                    resultField.setText(String.format("%.4f %s", convertedAmount, to));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please enter a valid number.");
                }
            }
        });
        
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(fromCurrency);
        f.add(l3);
        f.add(toCurrency);
        f.add(convertButton);
        f.add(resultField);
        
        f.setLayout(null);
        f.setSize(400, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        converter();
    }
}
