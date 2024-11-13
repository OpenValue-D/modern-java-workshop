package de.openvalue.modernjava.java.examples;

class TextBlocks {

    public static void main(String[] args) {
        // convert this to a TextBlock
        String query =  "SELECT \"EMP_ID\", \"LAST_NAME\" FROM \"EMPLOYEE_TB\"\n" +
                "WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
                "ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";
        System.out.println(query);

        // turn this to a TextBlock, but do not add new lines with \
        String literal =    "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                "elit, sed do eiusmod tempor incididunt ut labore " +
                "et dolore magna aliqua.";
        System.out.println(literal);


        // shift the """ in the end and execute to see how trailing blanks are treated
        String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
        """;
        System.out.println(html);
    }
}
