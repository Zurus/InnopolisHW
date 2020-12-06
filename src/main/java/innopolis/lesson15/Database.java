package innopolis.lesson15;


import innopolis.lesson15.dao.LaptopDao;
import innopolis.lesson15.dao.SimpleDao;
import innopolis.lesson15.pojo.Laptop;
import org.junit.Assert;
import org.junit.Test;

public class Database {
    public static void main(String[] args) {
        SimpleDao dao = new LaptopDao();
        dao.selectAll();
        //dao.selectLaptopMorePrice(1000);
    }


    @Test
    public void testMetaData() {
        SimpleDao dao = new LaptopDao();
        dao.printMetaData();
    }

    @Test
    public void testMetaDataRowSet() {
        SimpleDao dao = new LaptopDao();
        dao.printMetaDataRowSet();
    }

    @Test
    public void testGetLaptop() {
        Laptop mockLaptop = new Laptop("Falcon", 100, 1);
        SimpleDao dao = new LaptopDao();
        Laptop laptopFromDB = dao.getLaptopById(1);
        Assert.assertTrue(mockLaptop.equals(laptopFromDB));
    }

    @Test
    public void testGetLaptopMorePrice() {
        int price = 100;
        SimpleDao dao = new LaptopDao();
        int countEtalon = 5;
        int countFromDB = dao.selectLaptopMorePrice(100);
        Assert.assertTrue(countEtalon == countFromDB);
    }

}
