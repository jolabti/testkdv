package xyz.jncode.mvp_finacel;

public class Function {

    public static String interuptedString(String originalString,
            String stringToBeInserted,
            int index) {

            // Create a new string
            String newString = new String();

                for (int i = 0; i < originalString.length(); i++) {

                        // Insert the original string character
                        // into the new string
                        newString += originalString.charAt(i);

                        if (i == index) {

                            // Insert the string to be inserted
                            // into the new string
                            newString += stringToBeInserted;
                        }
                }

                // return the modified String
            return newString;
    }

    public static final String rulesPricing(String rawPricing){
        String finalPricing="";

        if(Integer.parseInt(rawPricing)< 100000){

            finalPricing = Function.interuptedString(rawPricing,".",1);
        }

        else if(Integer.parseInt(rawPricing)>= 100000){

            finalPricing = Function.interuptedString(rawPricing,".",2);
        }

        else if(Integer.parseInt(rawPricing)>= 1000000){

            finalPricing = Function.interuptedString(rawPricing,".",3);
        }
        else if(Integer.parseInt(rawPricing)>= 10000000){

            finalPricing = Function.interuptedString(rawPricing,".",4);
        }





        return finalPricing;
    }
}
