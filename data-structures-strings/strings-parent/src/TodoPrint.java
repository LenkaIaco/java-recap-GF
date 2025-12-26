public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";

        // Add "My todo:" to the beginning of the `todoText`
        // Add " - Download games" to the end of the `todoText`
        // Add " - Diablo" to the end of the `todoText` applying an extra 4 space indention

        // Expected output:
        // My todo:
        //  - Buy milk
        //  - Download games
        //      - Diablo

        String s1 = "My todo:\n".concat(todoText);
        String tab = "\t";
        s1 = s1.concat(" - Download games\n").concat(tab).concat(" - Diablo\n");

        StringBuilder sb = new StringBuilder(todoText);
        sb.insert(0,"My todo:\n");
        sb.append(" - Download games\n");

        sb.append(tab).append(" - Diablo\n");

        System.out.println(s1);
        System.out.println(sb);
    }
}
