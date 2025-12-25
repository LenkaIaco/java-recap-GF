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

//        version 1 - no string builder:
//        String intermediateTodo = "My todo:\n";
//        intermediateTodo = intermediateTodo.concat(todoText);
//        todoText = intermediateTodo;
//        todoText =  todoText.concat(" - Download games\n");
//        String indentation = "    ";
//        todoText =  todoText.concat(indentation+" - Diablo");

//version 2 - StringBuilder:
        StringBuilder sbTODO = new StringBuilder(todoText);
        StringBuilder sbFINAL = new StringBuilder("My todo:");
        sbFINAL.append(todoText);
        sbFINAL.append(" - Download games");
        sbFINAL.append(new String(" - Diablo"));
        todoText = sbFINAL.toString();

        todoText = todoText.replace("\n", "");
        //https://www.infoworld.com/article/2075410/matchmaking-with-regular-expressions.html
        todoText = todoText.replaceAll("\s-", "\n -");

        String indentWhat = new String("- Diablo");
        todoText = todoText.replace(indentWhat, indentWhat.indent(4));
        System.out.println(todoText);
    }
}
