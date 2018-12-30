<%-- Factorial.jsp --%>
<html>
    <style>
        table, th, td {
            border: 1px solid black;
        }

    </style>
    <head>
        <title>Factorial</title>
    </head>

    <body>
        <h1>Factorial Table</h1>
        <table>
            <tr>
                <th>Number</th>
                <th>Factorial</th>
            </tr>
            <% for (int i = 0; i <= 10; i++) {%>
            <tr><td><%= i%></td> <td><%= computeFactorial(i)%></td></tr>
            <% }%>



            <%! private long computeFactorial(int n) {
                    if (n == 0) {
                        return 1;
                    } else {
                        return n * computeFactorial(n - 1);
                    }
                }
            %>

        </table>

    </body>
</html>
