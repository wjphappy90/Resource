package com.itheima.textdemo;

/**
    目标：文本块入门使用
 */
public class TextBlockDemo01 {
    public static void main(String[] args) {
        String html = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";
        System.out.println(html);

        // 使用文本块解决
        String html1 = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
        System.out.println(html1);

            System.out.println("""
        Hello,
        itheima
        text blocks!
        """);

            System.out.println("""
        Hello,
            itheima
        text blocks!
        """);

        System.out.println("""
                Hello,
                itheima
                text blocks!
        """);

        System.out.println("""
    Hello,
    itheima
    text blocks!
        """);
    }
}
