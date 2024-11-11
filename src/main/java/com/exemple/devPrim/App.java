package com.exemple.devPrim;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;
import services.PensionService;
import services.SalaryService;
import services.TaxService;
import services.PensionService;
import services.BrasilTaxService;

public class App  {
    public static void main( String[] args ) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    /*TaxService taxService = new TaxService();
    PensionService pensionService = new PensionService();
    System.out.println(taxService.tax(4000.00));
    System.out.println(pensionService.discount(4000.00));*/

    System.out.printf("Nome: ");
    String name = sc.nextLine();
    System.out.printf("Salário bruto: ");
    double grossSalary = sc.nextDouble();
    
    PensionService pensionService = new PensionService();
    TaxService taxService = new BrasilTaxService();
    SalaryService  salaryService = new SalaryService(taxService, pensionService);
    
    Employee employee = new Employee(name, grossSalary);
    double netSalary= salaryService.netSalary(employee);
    System.out.printf("Salário liquido: %.2f%n", netSalary);

    sc.close();
} 

}
