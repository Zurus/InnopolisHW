package innopolis.lesson15;


import innopolis.lesson15.dao.LaptopDao;
import innopolis.lesson15.dao.SimpleDao;
import org.junit.Test;

public class Database {
    public static void main(String[] args) {
        SimpleDao dao = new LaptopDao();
        //dao.selectAll();
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
}
