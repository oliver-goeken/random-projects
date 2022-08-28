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

                System.out.println(bombBaby("10000001", "5485748"));

                break;
            }else{
                System.out.println();
                System.out.println("Choice not recognized!");
            }
        }

        in.close();
    }

    public static String bombBaby(String x, String y){
        Testing t = new Testing();
        
        IntString intX = t.new IntString(x);
        IntString intY = t.new IntString(y);
        
        IntString it = t.new IntString("0");

        while(intX.isLargerThan(t.new IntString("1")) || intY.isLargerThan(t.new IntString("1"))){
            it.add(t.new IntString("1"));
            
            if(intX.isLargerThan(intY)){
                intX.subtract(intY);
            }else if(intY.isLargerThan(intX)){
                intY.subtract(intX);
            }else{
                return "impossible";
            }
        }
        
        if(intX.isLargerThan(t.new IntString("0")) && intY.isLargerThan(t.new IntString("0"))){
            return it.value();
        }else{
            return "impossible";
        }
    }
    public class IntString{
        private int[] val;

        public IntString(String inputStr){
            char[] inputStrCharArr = inputStr.toCharArray();

            int[] inputStrAsArr = new int[inputStrCharArr.length];

            for(int i = inputStrCharArr.length - 1; i >= 0 ; i --){
                inputStrAsArr[inputStrCharArr.length - i - 1] = Character.getNumericValue(inputStrCharArr[i]);
            }

            val = new int[inputStrAsArr.length];

            for(int i = 0; i < val.length; i ++){
                val[i] = inputStrAsArr[i];
            }

            removeTrailingZeros();
        }

        public IntString(int[] value){
            val = new int[value.length];

            for(int i = 0; i < value.length; i ++){
                val[i] = value[i];
            }

            removeTrailingZeros();
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
                outputVal += val[i];
            }

            return outputVal;
        }

        public int[] valueAsArr(){
            return val;
        }

        public int size(){
            return val.length;
        }

        public boolean isEven(){
            return (val[0] % 2 == 0);
        }

        public boolean isLargerThan(IntString otherInt){
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

        public void add(IntString otherString){
            int[] thisVal = valueAsArr();
            int[] otherVal = otherString.valueAsArr();
            int[] resultVal;

            if(thisVal.length > otherVal.length){
                resultVal = new int[thisVal.length + 1];
            }else{
                resultVal = new int[otherVal.length + 1];
            }

            for(int i = 0; i < resultVal.length; i ++){
                int sum = 0;

                if(i < thisVal.length){
                    sum += thisVal[i];
                }

                if(i < otherVal.length){
                    sum += otherVal[i];
                }

                if(sum >= 10){
                    sum -= 10;
                    resultVal[i + 1] += 1;
                }

                resultVal[i] += sum;
            }

            val = resultVal;
            removeTrailingZeros();
        }

        public void subtract(IntString otherInt){
            removeTrailingZeros();
            otherInt.removeTrailingZeros();
            int[] otherVal = otherInt.valueAsArr();
            int[] resultVal = new int[val.length];
            
            for(int i = 0; i < resultVal.length; i ++){
                if(i < otherVal.length){
                    resultVal[i] += (val[i] - otherVal[i]);
                }else{
                    resultVal[i] += val[i];
                }

                if(resultVal[i] < 0){
                    resultVal[i + 1] -= 1;
                    resultVal[i] *= -1;
                    resultVal[i] = 10 - resultVal[i];
                }
            }
            
            val = resultVal;
            removeTrailingZeros();
        }

        public void removeTrailingZeros(){
            int newLength = val.length;

            for(int i = val.length - 1; i >= 0; i --){
                if(val[i] == 0){
                    newLength --;
                }else{
                    break;
                }
            }

            int[] newVal = new int[newLength];

            for(int i = 0; i < newVal.length; i ++){
                newVal[i] = val[i];
            }

            val = newVal;
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