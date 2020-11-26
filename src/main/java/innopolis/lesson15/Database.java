package innopolis.lesson15;


import innopolis.lesson15.dao.LaptopDao;
import innopolis.lesson15.dao.SimpleDao;

public class Database {
    public static void main(String[] args) {
        SimpleDao dao = new LaptopDao();
        //dao.selectAll();
        //dao.selectLaptopMorePrice(1000);
        dao.createTable();
        dao.addCustomer();
        dao.selectAllCustomers();
    }
}
