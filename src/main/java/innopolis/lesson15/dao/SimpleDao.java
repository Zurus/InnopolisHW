package innopolis.lesson15.dao;

import innopolis.lesson15.pojo.Laptop;

public interface SimpleDao {
    void addLaptop(Laptop laptop);
    void selectAll();
    int selectLaptopMorePrice(int price);
    Laptop getLaptopById(int id);

    //Метаданные
    void printMetaDataRowSet();
    void printMetaData();

    //Манипуляция с коммитом
    void insertData();
}
