import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.io.*;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
public class address {

    private static Object JsonUntils;





    public static void main(String[] args) throws IOException {

        String readStringAll="";
     //   String[] readString=readStringAll.split("\\.");//将字符串分割

        JSONArray jsonArray = new JSONArray();
        File fin = new File(args[0]);
        FileInputStream in=new FileInputStream(fin);
        BufferedReader br=new BufferedReader((new InputStreamReader(in, "UTF-8")));
        String line=null;
        int position=0;
        String[] readString=new String[20480];
        while((line=br.readLine())!=null) {
            readString[position]=line;


            position++;
        }

        br.close();//关闭文件
//    for(int i=0;i<position;i++) {
//      System.out.println(bufstring[i]);}
     /*   for (int i=0;i<position;i++){

            jsonArray.put(addressResolution(bufstring[i]));
        }*/


   /*     //读入文件
        File readFile=new File("C:\\Users\\那有人\\031702310\\in.txt");
        //输入IO流声明
        InputStream in=null;
        InputStreamReader ir=null;
        BufferedReader br=null;

        try {
            //用流读取文件
            in=new BufferedInputStream(new FileInputStream(readFile));
            //如果你文件已utf-8编码的就按这个编码来读取，不然又中文会读取到乱码
            ir=new InputStreamReader(in,"utf-8");
            //字符输入流中读取文本,这样可以一行一行读取
            br=	new BufferedReader(ir);
            String line="";

            //一行一行读取
            while((line=br.readLine())!=null){
                readStringAll =readStringAll+line;
            }
            //  System.out.println(readStringAll);
        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            //一定要关闭流,倒序关闭
            try {

                if(br!=null){
                    br.close();
                }
                if(ir!=null){
                    ir.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (Exception e2) {
            }
        }

*/



        List<Map<String,Object>> table=new ArrayList<Map<String,Object>>();
        Map<String,Object> row=null;
        row=new LinkedHashMap<String,Object>();


        //在输入的多条语句中操作
        for(int j=0;j<readString.length;j++){
            int flag=0;
            if(readString[j].charAt(0)=='1')   flag=1;
            else if(readString[j].charAt(0)=='2')   flag=2;
            int ch=readString[j].indexOf(',');
            String name=readString[j].substring(2,ch) ;
            readString[j]=readString[j].substring(2,readString[j].length());  //去掉前面的数字
            readString[j] = readString[j].replaceAll(name+",","");  //找到名字并且去掉；
            //    System.out.println(readString[j]);


            int k;//标记手机号后一位
            int num=0;//手机号11位
            for( k=0;k<readString[j].length();k++) {

                if (readString[j].charAt(k) >= 48 && readString[j].charAt(k) <= 57)
                    num++;
                else if(num==11)  break;//找到
                else {
                    num=0;
                    continue;
                }
            }
            String telnum=readString[j].substring(k-11,k) ;  //telnum存11位手机号
            readString[j] = readString[j].replaceAll(telnum,""); //去掉手机号
            // System.out.println(readString[j]);

            part nicai = new part();

            if(flag==1)
                nicai.addressResolution1(readString[j]);
            else if(flag==2)
                nicai.addressResolution2(readString[j]);


            JSONObject jsonObject =new JSONObject();
            jsonObject.put("姓名",name);
            jsonObject.put("手机",telnum);
            jsonObject.put("地址",nicai.address0);
            // System.out.println(jsonObject);

       /*     JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            System.out.println(jsonArray); */

         /*  JSONArray jsonArray = new JSONArray();
            jsonArray=jsonArray.
            System.out.print(jsonArray);*/
            jsonArray.put(jsonObject);


        }

      //  System.out.println(jsonArray);
        //输出

        File file=new File(args[1]);
        FileOutputStream out=new FileOutputStream(file,true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        bw.write(jsonArray.toString());
        bw.flush();





    }







}








