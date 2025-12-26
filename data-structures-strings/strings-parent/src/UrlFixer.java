public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";

        // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
        // Also, the URL is missing a crucial component, find out what it is and insert it too!
        // Try to solve it in more than one way using different String functions!

        //alternative 1 with String
        int ind = url.lastIndexOf("bots");
        String url1 = url.substring(0,ind).concat("odds");
        url1 = url1.replaceFirst("https","https:");
        System.out.println(url1);

        //alternative 2 with StringBuilder
        String url2 = url.substring(0,ind)+"odds";
        StringBuilder sb = new StringBuilder(url);
        int ind2 = url.indexOf("//");
        sb.insert(ind2,':');
        sb.replace(ind,sb.length(),"odds");
        /*alternatively: String builder is designed for chaining:
        sb.delete(ind,sb.length()).append("odds");
         */
        System.out.println(sb);



    }
}
