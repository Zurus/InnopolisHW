package innopolis.lesson15.dao;

import innopolis.lesson15.pojo.Laptop;

public interface SimpleDao {

    void addLaptop(Laptop laptop);
    void selectAll();
    void selectLaptopMorePrice(int price);
    Laptop getLaptopById(int id);
    void createTable();
    void addCustomer();
    void selectAllCustomers();
}
