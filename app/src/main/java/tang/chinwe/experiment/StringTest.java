package tang.chinwe.experiment;

import org.json.JSONArray;

public class StringTest {
    public static void main(String[] args) {
//        String a = "abc", b = "abc", c = new String("abc");
//        System.out.println("hashcode:" + "a:" + a.hashCode() + "b:" + b.hashCode() + "c:" + c.hashCode());
//        System.out.println("a.equals(b)-"+a.equals(b));
//        System.out.println("a.equals(c)-"+a.equals(c));

//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put("https://v.starhalo.mobi/user/avatar/30/88/89713088.jpg");
//        System.out.println(jsonArray.toString());

        String[] appidpars="com.yestube.downloader.plugin.debug".split("\\.");
        StringBuffer stringBuffer=new StringBuffer();
        for (String par : appidpars) {
            if(!par.equals("plugin")){
                stringBuffer.append(par).append(".");
            }
        }
        String result= stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
    }
}
