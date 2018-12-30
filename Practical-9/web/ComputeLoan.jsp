<%-- ComputeLoan.jsp --%>
<html>
    <head>
        <title>ComputeLoan</title>
    </head>
    <body>
        <% double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
            double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
            int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate
                    / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
            double totalPayment = monthlyPayment * numberOfYears * 12;%>
        Loan Amount: <%= String.format("%.2f", loanAmount) %><br />
        Annual Interest Rate: <%= String.format("%.2f", annualInterestRate) %><br />
        Number of Years: <%= numberOfYears%><br />
        <b>Monthly Payment: RM<%= String.format("%.2f", monthlyPayment) %><br />
            Total Payment: RM<%= String.format("%.2f", totalPayment) %><br /></b>
    </body>
</html>
