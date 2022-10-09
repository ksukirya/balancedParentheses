public class balancedParentheses {

    public static void main(String[] args) {

        String test_bal_1 = isBalanced("") == true ? "pass" : "fail";
        String test_bal_2 = isBalanced("()") == true ? "pass" : "fail";
        String test_bal_3 = isBalanced("(()())") == true ? "pass" : "fail";
        String test_bal_4 = isBalanced("((())())") == true ? "pass" : "fail";

        String test_bal_5 = isBalanced(")(") == false ? "pass" : "fail";
        String test_bal_6 = isBalanced("((") == false ? "pass" : "fail";
        String test_bal_7 = isBalanced("())(()))())") == false ? "pass" : "fail";

        System.out.println(test_bal_1);
        System.out.println(test_bal_2);
        System.out.println(test_bal_3);
        System.out.println(test_bal_4);
        System.out.println(test_bal_5);
        System.out.println(test_bal_6);
        System.out.println(test_bal_7);


        String test_dog_1 = inDogish("dpoags") == true ? "pass" : "fail";
        String test_dog_2 = inDogish("dog") == true ? "pass" : "fail";
        String test_dog_3 = inDogish("doooooog") == true ? "pass" : "fail";
        String test_dog_4 = inDogish("dpopgp") == true ? "pass" : "fail";
        String test_dog_5 = inDogish("qwqwedqweqweoqweqwgasd") == true ? "pass" : "fail";

        String test_dog_6 = inDogish("") == false ? "pass" : "fail";
        String test_dog_7 = inDogish("cat") == false ? "pass" : "fail";
        String test_dog_8 = inDogish("apple") == false ? "pass" : "fail";
        String test_dog_9 = inDogish("do") == false ? "pass" : "fail";
        String test_dog_10 = inDogish("g") == false ? "pass" : "fail";

        System.out.println(test_dog_1);
        System.out.println(test_dog_2);
        System.out.println(test_dog_3);
        System.out.println(test_dog_4);
        System.out.println(test_dog_5);
        System.out.println(test_dog_6);
        System.out.println(test_dog_7);
        System.out.println(test_dog_8);
        System.out.println(test_dog_9);
        System.out.println(test_dog_10);

    }

    public static boolean isBalanced(String parentheses) {
        int strayBrackets = 0;
            // for loop to iterate through the string of parentheses and check the character at the indexed location i
            for(int i = 0; i < parentheses.length(); i++)
            {
                if(parentheses.charAt(i)=='('){
                    strayBrackets++;
                }
                else if(parentheses.charAt(i)==')'){
                    strayBrackets--;
                    // if statement to check if the count is below 0, and if so, theres more closing than opening brackets
                    if(strayBrackets < 0){
                        return false;
                    }
                }
            }
            //if statement to check if the count is more than 0, and if so, theres more opening than closing brackets
            if(strayBrackets > 0){ 
                return false;
            }
            // if the function has passed all tests, return true
        return true; 

    }

    public static boolean inDogish(String word) {
        //if the word is empty or null, return false
        if (word.length() == 0 || word == null) {
            return false;
        }
        //method to convert string to lower case
        word = word.toLowerCase();

        //if the letter d does not exist on the word then return false
        if (!dogishHelper(word, 'd')) {
            return false;
        }
        //remove all characters up to the first letter d
        word = word.substring(word.indexOf('d') + 1);

        //if the letter o does not exist on the word then return false
        if (!dogishHelper(word, 'o')) {
            return false;
        }
        //remove all characters up to the first letter o
        word = word.substring(word.indexOf('o') + 1);

        //if the letter g does not exist on the word then return false
        if (!dogishHelper(word, 'g')) {
            return false;
        } else {
            return true;
        }

    }   

    public static boolean dogishHelper(String word, char letter){
        //if the word is empty or null, return false
        if (word.length() == 0 || word == null) {
            return false;
        }
        //if first character in word is the selected letter then return 0
        if (word.charAt(0) == letter) {
            return true;
        }
        //recursive statement to call dogishHelper again
        return dogishHelper(word.substring(1), letter);
    }
}


