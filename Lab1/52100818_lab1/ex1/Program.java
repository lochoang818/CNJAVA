public class Program{

        public static void main(String[] args) {
            if (args.length != 3) {
                System.out.println("Invalid expression");
                return;
            }

            double num1, num2, result;
            String operator = args[1];

            try {
                num1 = Double.parseDouble(args[0]);
                num2 = Double.parseDouble(args[2]);

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Division by zero");
                            return;
                        }
                        result = num1 / num2;
                        break;
                    case "^":
                        result = Math.pow(num1, num2);
                        break;
                    default:
                        System.out.println("Unsupported operator");
                        return;
                }

                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid expression");
            }
        }

}