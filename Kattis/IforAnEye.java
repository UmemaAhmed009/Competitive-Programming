
import java.util.*;
public class IforAnEye {
    public static void main(String[] args) {
        HashMap<String, String> List = getStringStringHashMap();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i< n;i++){
            String str = sc.nextLine();
            for(int j =0; j< str.length()-2;j++){
                String substring1 = str.substring(j,j+3).toLowerCase();
                String substring2 = str.substring(j,j+2).toLowerCase();
                //Getting the value for key from Hashmap
                if(List.containsKey(substring1)){
                    String sub = List.get(substring1);
                    //Changing the first character of replacing string to uppercase
                    //&&(sub.charAt(0) != '4' && sub.charAt(0)!='2' && sub.charAt(0) != '1')
                    if(str.charAt(j) == Character.toUpperCase(str.charAt(j)))
                    {
                        substring1 = substring1.replace(substring1.charAt(j),str.charAt(j));
                        if(sub.charAt(0) != '4' && sub.charAt(0)!='2' && sub.charAt(0) != '1')
                        {
                            sub = sub.replace(sub.charAt(0),str.charAt(j));
                        }
                    }
                    //replacing the old substring in original string with new substring
                    str = str.replace(substring1,sub);
                }
                else if(List.containsKey(substring2)){
                    String sub = List.get(substring2);
                    //Changing the first character of replacing string to uppercase
                    if(str.charAt(j) == Character.toUpperCase(str.charAt(j)))
                    {
                        substring2 = substring2.replace(substring2.charAt(j),str.charAt(j));
                        if(sub.charAt(0) != '4' && sub.charAt(0)!='2' && sub.charAt(0) != '1')
                        {
                            sub = sub.replace(sub.charAt(0),str.charAt(j));
                        }
                    }
                     str = str.replace(substring2,sub);
                }
            }
            System.out.println(str);
        }

    }

    private static HashMap<String, String> getStringStringHashMap() {
        HashMap<String, String> List = new HashMap<>();
        List.put("at","@");
        List.put("and","&");
        List.put("one","1");
        List.put("won","1");
        List.put("to","2");
        List.put("too","2");
        List.put("two","2");
        List.put("for","4");
        List.put("four","4");
        List.put("bea","b");
        List.put("bee","b");
        List.put("be","b");
        List.put("sea","c");
        List.put("see","c");
        List.put("eye","i");
        List.put("oh","o");
        List.put("owe","o");
        List.put("are","r");
        List.put("you","u");
        List.put("why","y");
        return List;
    }

}
