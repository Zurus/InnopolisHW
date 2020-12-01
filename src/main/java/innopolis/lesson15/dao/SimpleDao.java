package innopolis.lesson15.dao;

import innopolis.lesson15.pojo.Laptop;

public interface SimpleDao {
    void addLaptop(Laptop laptop);
    void selectAll();
    void selectLaptopMorePrice(int price);
    Laptop getLaptopById(int id);

    //Метаданные
    void printMetaDataRowSet();
    void printMetaData();
}
