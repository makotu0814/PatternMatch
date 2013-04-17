import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternMatch {

    public static void main(String args[]){
        String str1 = "http://tctechcrunch2011.files.wordpress.com/2013/04/touchingyou200.png?w=200";
        String str2 = "http://1.gravatar.com/avatar/14ffb5918c5a35315a39faed7e13225d?s=96&amp;d=identicon&amp;r=G";
        String str3 = "iframe width=\"640\" height=\"360\" src=\"http://www.youtube.com/embed/kBTiOnP41fY\" frameborder=\"0\" allowfullscreen";

        String regex1 = "http://[^\\s]+?.(jpg|jpeg|png|bmp|gif|tif)";
        String regex2 = "http://www.youtube\\..*/[-\\w]{11}";

        Pattern p1 = Pattern.compile(regex1);
        Pattern p2 = Pattern.compile(regex2);

        System.out.println("Pattern1: extract <media:content> url");
        check(p1, str1);
        check(p1, str2);
        check(p1, str3);

        System.out.println("\nPattern2: extract youtube url");
        check(p2, str1);
        check(p2, str2);
        check(p2, str3);
      }

      private static void check(Pattern p, String target){
        Matcher m = p.matcher(target);

        if (m.find()){
            int start = m.start();
            int end = m.end();
            String str  = target.substring(0, start) + "[" + m.group() + "]" + target.substring(end, target.length());
            System.out.println("○ " + str);
          }else{
            System.out.println("× " + target);
          }
        }
}
//    private static void check(Pattern p, String target){
//        Matcher m = p.matcher(target);
//
//        if (m.find()){
//          System.out.println("○ " + target);
//          System.out.println("[全体] " + m.group());
//          for (int i = 1 ; i <= m.groupCount(); i ++){
//            System.out.println("[Group" + i + "] " + m.group(i));
//          }
//        }else{
//          System.out.println("× " + target);
//        }
//      }
//    }