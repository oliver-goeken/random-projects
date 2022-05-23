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
                

                break;
            }else{
                System.out.println();
                System.out.println("Choice not recognized!");
            }
        }

        in.close();
    }

    public static String bombBaby(String x, String y){
        int m = Integer.parseInt(x);
        int f = Integer.parseInt(y);

        if(m % 2 == 0 && f % 2 == 0){
            return "impossible";
        }else{

        }
    }
    private class IntString{
        int[] val;

        public IntString(String inputStr){
            int[] inputStrAsArr = inputStr.toCharArray();
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

        public boolean largerThan(IntString testInt){
            if(this.size() > testInt.size()){
                
            }
        }

        public int size(){
            return val.length;
        }

        public IntString subtract(IntString otherInt){
            char[] result = new char[this.largerThan(otherInt)?this.size():otherInt.size()];

            // remove empty char array indexes
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