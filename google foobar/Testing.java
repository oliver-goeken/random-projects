import java.util.Scanner;

public class Testing{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        clearScreen();
        
        while (true){
            System.out.println("Options: ");
            System.out.println("[G]earing up for destruction: ");
            System.out.println("[B]unny worker locations: ");
            System.out.println("[BO]mb baby: ");
            System.out.println("[E]xit: ");
            System.out.print("> ");

            String choice = in.nextLine();

            clearScreen();

            if(choice.toLowerCase().equals("e")){
                break;
            }else if(choice.toLowerCase().equals("g")){
                int[] output = gearingUpForDestruction();
                System.out.println(output[0] + ", " + output[1]);

                break;
            }else if(choice.toLowerCase().equals("b")){
                System.out.println(bunnyWorkerLocations(3, 4));

                break;
            }else if(choice.toLowerCase().equals("bo")){
                Testing t = new Testing();
                IntString test = t.new IntString("12345");

                System.out.println(test.value());

                break;
            }else{
                System.out.println();
                System.out.println("Choice not recognized!");
            }
        }

        in.close();
    }

    public static void bombBaby(String x, String y){
        int m = Integer.parseInt(x);
        int f = Integer.parseInt(y);

        if(m % 2 == 0 && f % 2 == 0){
            //return "impossible";
        }else{

        }
    }
    public class IntString{
        private int[] val;

        public IntString(String inputStr){
            char[] inputStrCharArr = inputStr.toCharArray();

            int[] inputStrAsArr = new int[inputStrCharArr.length];

            for(int i = inputStrCharArr.length - 1; i >= 0 ; i --){
                inputStrAsArr[inputStrCharArr.length - i - 1] = inputStrCharArr[i];
            }

            val = new int[inputStrAsArr.length];

            for(int i = 0; i < val.length; i ++){
                val[i] = inputStrAsArr[i];
            }
        }

        @Override
        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }

            if(obj.getClass() != this.getClass()){
                return false;
            }

            final IntString other = (IntString) obj;
            if(this.val != other.val){
                return false;
            }

            return true;
        }

        public String value(){
            String outputVal = "";

            for(int i = val.length - 1; i >= 0; i --){
                outputVal += Character.toString(val[i]);
            }

            return outputVal;
        }

        public int size(){
            return val.length;
        }

        public boolean largerThan(IntString otherInt){
            if(this.size() > otherInt.size()){
                return true;
            }else if(this.size() < otherInt.size()){
                return false;
            }else{
                if(this.val[this.val.length - 1] > otherInt.val[otherInt.val.length - 1]){
                    return true;
                }else{
                    return false;
                }
            }
        }

        public IntString subtract(IntString otherInt){
            return this;
        }
    }


    public static String bunnyWorkerLocations(long x, long y){
        String returnString = "";
        
        if(y == 1){
            returnString = Long.toString(rowAdd(x));
        }else{
            returnString = Long.toString(rowAdd(x + y - 2) + x);
        }
        
        return returnString;
    }
    private static long rowAdd(long row){
        long returnInt = 0;

        for(long i = row; i > 0; i --){
            returnInt += i;
        }

        return returnInt;
    }


    public static int[] gearingUpForDestruction(){
        int[] pegs = {4, 30, 50};

        int[] output = {0, 1};
        int[] failed = {-1, -1};

        int rFinal = 0;

        for(int i = 0; i < pegs.length; i ++){
            int sum = 0;

            if(i % 2 == 0){
                sum -= pegs[i];
            }else{
                sum += pegs[i];
            }

            if(i != 0 && i != (pegs.length - 1)){
                sum *= 2;
            }

            rFinal += sum;
        }

        output[0] = rFinal * 2;

        if(pegs.length % 2 == 0){
            output[1] = 3;
        }

        if(output[0] % output[1] == 0){
            output[0] /= output[1];
            output[1] = 1;
        }

        if(output[0] * output[1] <= 0 || pegs.length <= 1){
            return failed;
        }else{
            return output;
        }
    }


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}