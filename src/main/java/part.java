import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class part {
    String name;
    String telphone;
    ArrayList<String> address0=new ArrayList<String>();

    public  void addressResolution1(String address) {

        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);

        String province = null, city = null, county = null, town = null, village = null;
        //    List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        //    Map<String,String> row=null;
        // part nicai = new part();

        while (m.find()) {
   /*         row=new LinkedHashMap<String,String>();
           province=m.group("province");
           row.put("", province==null?"":province.trim());
           city=m.group("city");
           row.put("city", city==null?"":city.trim());
            county=m.group("county");
           row.put("county", county==null?"":county.trim());
           town=m.group("town");
          row.put("town", town==null?"":town.trim());
           village=m.group("village");
            row.put("village", village==null?"":village.trim());
           table.add(row);
        }
        return table;  */
            province = m.group("province");
            address0.add(province == null ? "" : province.trim());
            city = m.group("city");
            address0.add(city == null ? "" : city.trim());
            county = m.group("county");
            address0.add(county == null ? "" : county.trim());
            town = m.group("town");
            address0.add(town == null ? "" : town.trim());
            village = m.group("village");
            address0.add(village == null ? "" : village.trim());
            //  System.out.println(address0);
        }
    }

    public  void addressResolution2(String address) {

        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇|.+道|.+街)?(?<street>.[^路]+路|.+道|.+巷|.胡同|.里弄|.弄)?(?<num>.[^号]+号)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);

        String province = null, city = null, county = null, town = null, street=null, num=null,village = null;
        //    List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        //    Map<String,String> row=null;
        // part nicai = new part();

        while (m.find()) {
   /*         row=new LinkedHashMap<String,String>();
           province=m.group("province");
           row.put("", province==null?"":province.trim());
           city=m.group("city");
           row.put("city", city==null?"":city.trim());
            county=m.group("county");
           row.put("county", county==null?"":county.trim());
           town=m.group("town");
          row.put("town", town==null?"":town.trim());
           village=m.group("village");
            row.put("village", village==null?"":village.trim());
           table.add(row);
        }
        return table;  */
            province = m.group("province");
            address0.add(province == null ? "" : province.trim());
            city = m.group("city");
            address0.add(city == null ? "" : city.trim());
            county = m.group("county");
            address0.add(county == null ? "" : county.trim());
            town = m.group("town");
            address0.add(town == null ? "" : town.trim());
            street = m.group("street");
            address0.add(street == null ? "" : street.trim());
            num = m.group("num");
            address0.add(num == null ? "" : num.trim());
            village = m.group("village");
            address0.add(village == null ? "" : village.trim());
            // System.out.println(address0);
        }

    }

}

