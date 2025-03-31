# Exercise: Java debugging exercises


## Syntax error

**Requirement**: Find and fix the syntax errors in the code above.

```java
// Code with errors
public class SyntaxError {
    public static void main(String args[]) {
        int x = 10
        System.out.println("Value of x: " + x);
        
        if (x > 5) {
            System.out.println("x is greater than 5")
        }
        
        for (int i = 0; i < 5, i++) {
            System.out.println(i);
        }
    }
}
```

## Division by Zero Fix

**Requirement**: Fix the code to avoid division by zero error.

```java

// Code with error
public class DivisionByZero {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int result = a / b;
        System.out.println("Result: " + result);
    }
}

```

## NullPointerException Fix 

**Requirement**: Fix the code to avoid NullPointerException.

```java
// Code with error
public class NullPointerBug {
    public static void main(String[] args) {
        String text = null;
        printTextLength(text);
    }
    
    public static void printTextLength(String text) {
        System.out.println("Length of string: " + text.length());
    }
}

```

## ArrayIndexOutOfBounds Fix
**Requirement**: Fix the array index out of bounds error.

```java
// Code with error
public class ArrayIndexBug {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        for (int i = 0; i <= numbers.length; i++) {
            System.out.println("Element " + i + ": " + numbers[i]);
        }
    }
}


```


## Interface Implementation Bug Fix


```java

// Code with error
interface Payable {
    double calculatePay();
    void processPayment();
}

class Employee implements Payable {
    private String name;
    private double hourlyRate;
    private double hoursWorked;
    
    public Employee(String name, double hourlyRate, double hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    
    public String getName() {
        return name;
    }
}

class Invoice implements Payable {
    private String vendor;
    private double amount;
    private boolean paid;
    
    public Invoice(String vendor, double amount) {
        this.vendor = vendor;
        this.amount = amount;
        this.paid = false;
    }
    
    @Override
    public double calculatePay() {
        return amount;
    }
    
    
    public String getVendor() {
        return vendor;
    }
}

public class InterfaceBug {
    public static void main(String[] args) {
        Payable employee = new Employee("John Doe", 25.0, 40.0);
        Payable invoice = new Invoice("Office Supplies Inc.", 150.75);
        
        System.out.println("Employee payment: $" + employee.calculatePay());
        System.out.println("Invoice payment: $" + invoice.calculatePay());
        
        employee.processPayment();
        invoice.processPayment();
    }
}
```
