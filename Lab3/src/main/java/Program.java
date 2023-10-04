import DAO.ManufactureDAO;
import DAO.PhoneDAO;
import Model.Manufacture;
import Model.Phone;

public class Program {
    public static void main(String[] args) {
       ManufactureDAO manufactureDAO = new ManufactureDAO();
       PhoneDAO phoneDAO =new PhoneDAO();

//       manufactureDAO.add(m);
       for(Manufacture l : manufactureDAO.getAll()){
           System.out.println(l);
       }
        System.out.println(phoneDAO.highestPrice());
       for(Phone pp :phoneDAO.getPhonesByCountry("USA")){
           System.out.println(pp);

       }
        System.out.println(phoneDAO.checkPriceGreaterThan50mil(phoneDAO.get("1")));
        System.out.println(phoneDAO.getPhoneByCriteria());

        /*
        * ex5
        */

        System.out.println("*********");

        Manufacture manufacture= manufactureDAO.get("9");
        System.out.println(manufactureDAO.allManGreaterThan100em());
        System.out.println(manufactureDAO.sumEmployees());





        System.out.println(manufactureDAO.lastManBaseUS());
    }
}
