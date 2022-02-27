//
// information from IRD is here:
//https://www.ird.govt.nz/-/media/project/ir/home/documents/income-tax/withholding-taxes/rwt-nrwt-withholding-tax-certificate/2020-rwt-and-nrwt-certificate-filing-specification.pdf?modified=20201016012133
//

//error trapping:
// if a bank acccount number is too short?
//   they get zero padded and it will be invalid
// bank acct digit is not a number?
//   ability to enter in letters or other characters?


package com.example.validaton;

//import java.util.ArrayList;
//import java.util.Collections;

public class Validation {

    //public static int[][] useMod(String accountBaseCheck,String modulusFormula) {
    public static java.util.ArrayList useMod(String accountBaseCheck,String weightFormula) {
    // used to determine the modulus and return it so the modulus can be calculated.

        //init the modulus calculation array so it can be returned
        //int[] weightFactor = new int[18];

        java.util.ArrayList<Object>  weightFactor = new ArrayList<Object>(20);
        //accountBaseNum needs to be an int as the AorB modulus selection uses it.
        int accountBaseToCheck =  Integer.parseInt(accountBaseCheck);

        //choose which formula to use based on the calculation required
        switch(weightFormula) {
            case "AorB":
                // if the account number base is under 990000
                if (accountBaseToCheck < 990000) {
                    //weightFactor = new int[] {0, 0, 6, 3, 7, 9, 0, 0, 10, 5, 8, 4, 2, 1, 0, 0, 0, 0};
                    java.util.Collections.addAll(weightFactor,0,0,6,3,7,9,0,0,10,5,8,4,2,1,0,0,0,0,"A",11);
                } // if the account number base is under 990000
                else if (accountBaseToCheck > 990000) {
                    //weightFactor = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 8, 4, 2, 1, 0, 0, 0, 0};
                    java.util.Collections.addAll(weightFactor,0,0,0,0,0,0,0,0,10,5,8,4,2,1,0,0,0,0,"B",11);
                }
                break;
            case "C":
                //weightFactor = new int[] {3,7,0,0,0,0,9,1,10,5,3,4,2,1,0,0,0,0};
                java.util.Collections.addAll(weightFactor,3,7,0,0,0,0,9,1,10,5,3,4,2,1,0,0,0,0,"C",11);
                break;
            case "D":
                //weightFactor = new int[] {0,0,0,0,0,0,0,7,6,5,3,4,2,1,0,0,0,0};
                java.util.Collections.addAll(weightFactor,0,0,0,0,0,0,0,7,6,5,4,3,2,1,0,0,0,0,"D",11);
                break;
            case "E":
                //weightFactor = new int[] {0,0,0,0,0,0,0,7,6,5,4,3,2,1,0,0,0,0};
                java.util.Collections.addAll(weightFactor,0,0,0,0,0,0,0,0,0,0,5,4,3,2,0,0,0,1,"E",11);
                break;
            case "F":
                //weightFactor = new int[] {0,0,0,0,0,0,0,0,0,0,5,4,3,2,0,0,0,1};
                java.util.Collections.addAll(weightFactor,0,0,0,0,0,0,0,1,7,3,1,7,3,1,0,0,0,0,"F",10);
                break;
            case "G":
                //weightFactor = new int[] {0,0,0,0,0,0,0,1,3,7,1,3,7,1,0,3,7,1};
                java.util.Collections.addAll(weightFactor,0,0,0,0,0,0,0,1,3,7,1,3,7,1,0,3,7,1,"G",10);
                break;
            case "X":
                //weightFactor = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                java.util.Collections.addAll(weightFactor,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"X",1);
                break;
            }
        return weightFactor;
        }

    public static String errorMessage(String error) {
        System.out.println(error);
        String bankAccountError = error
        boolean isAccountValid = false;
    }

    public static void main(String[] args) {

    ///***
    //Initialise variables
    //***
    //
    /*
    String bankID = ""; //(2 digits)
    String branchID =""; //(4 digits)
    String accountBase = ""; //(8 digits max)
    String accountSuffix =""; //(4 digits max)
    */

    //init the variable for the modulus
    //int modulo = 0;

    // max length of account base
    int accountBaseLength = 8;
    // max length of account suffix
    int accountSuffixLength = 4;

    java.util.ArrayList weightDigits = new ArrayList(20);

    //*** test data ****//

    // Algo A
    /*
    String bankID = "01"; //(2 digits)
    String branchID = "0902"; //(4 digits)
    String accountBase = "68389"; //(8 digits max)
    String accountSuffix ="00"; //(4 digits max)
     */

    /*
    //Algo D
    String bankID = "08"; //(2 digits)
    String branchID = "6523"; //(4 digits)
    String accountBase = "1954512"; //(8 digits max)
    String accountSuffix ="001"; //(4 digits max)
    */

    //Algo G

    String bankID = "26"; //(2 digits)
    String branchID = "2600"; //(4 digits)
    String accountBase = "0320871"; //(8 digits max)
    String accountSuffix ="032"; //(4 digits max)

   //fields are padded with zeros if they are short
   if (accountBase.length() < accountBaseLength)
        {
       //loop through and pad the account base number
       while (accountBase.length() < accountBaseLength) {
            accountBase = "0" + accountBase;
            }
        }
   //fields are padded with zeros if they are short
   if (accountSuffix.length() < accountSuffixLength)
        {
            //loop through and pad the account suffix number
            while (accountSuffix.length() < accountSuffixLength) {
                accountSuffix = "0" + accountSuffix;
                //return String.format("%1$" + length + "s", inputString).replace(' ', '0');
            }
        }

   //*** not need this in prod, just output for testing
   //System.out.println("Padded Account base is "+ accountBase);
   //System.out.println("Padded Account suffix is "+ accountSuffix);

    //convert branch ID and accountBase to int from string
    //the branch needs to be an int as the numbers are eg between 1 and 999
    int checkBranchID = Integer.parseInt(branchID);

    //select the bank using the bank ID.
    //select the modulus calculation depending on the branchID
    switch(bankID) {
            case "01":
                if ((checkBranchID >= 1 && checkBranchID <= 999) || (checkBranchID >= 1100 && checkBranchID <= 1199) || (checkBranchID >= 1800 && checkBranchID <= 1899))
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                      }
                break;

            case "02":
                 if ((checkBranchID >= 1 && checkBranchID <= 999) || (checkBranchID >= 1100 && checkBranchID <= 1199) || (checkBranchID >= 1800 && checkBranchID <= 1899))
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                 else {
                     errorMessage("Not a valid Branch ID " + bankID);
                        }
                break;

            case "03":
                 if (( checkBranchID >= 1 && checkBranchID <= 999) || (checkBranchID >= 1300 && checkBranchID <= 1399) || (checkBranchID >= 1500 && checkBranchID <= 1599) || (checkBranchID >= 1700 && checkBranchID <= 1799) || (checkBranchID >= 1900 && checkBranchID <= 1999) || (checkBranchID >= 7350 && checkBranchID <= 7399) )
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                 else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                 break;

            case "04":
                 if (checkBranchID >= 2020 && checkBranchID <= 2024)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                 else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "06": // 0001 - 0999, 1400 - 1499
                if ((checkBranchID >= 1 && checkBranchID <= 999) || (checkBranchID >= 1400 && checkBranchID <= 1499))
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "08": // 6500 - 6599 - D // modulusCalc = CalcD;
                if (checkBranchID >= 6500 && checkBranchID <= 6599)
                        {
                            weightDigits = useMod(accountBase,"D");
                            //modulo = 11;
                        }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                        }
                break;

            case "09": // - 0000 - E // modulusCalc = CalcE;
                if (branchID == "0000" )
                    {
                        weightDigits = useMod(accountBase,"E");
                        //modulo = 11;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                    break;

            case "10":// - 5165 - 5169 modulusCalc = AorB;
                if (checkBranchID >= 5165 && checkBranchID <= 5169)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "11": // - 5000 - 6499, 6600 - 8999,modulusCalc = AorB
                if ((checkBranchID >= 5000 && checkBranchID <= 6499) || (checkBranchID >= 6600 && checkBranchID <= 8999))
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "12": // 3000 - 3299, 3400 – 3499,3600 - 3699 modulusCalc = AorB
                if ((checkBranchID >= 3000 && checkBranchID <= 3299) || (checkBranchID >= 3400 && checkBranchID <= 3499) || (checkBranchID >= 3600 && checkBranchID <= 3699))
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "13": // 4900 - 4999 modulusCalc = AorB
                if (checkBranchID >= 4900 && checkBranchID <= 4999)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "14": // 4700 - 4799 modulusCalc = AorB
                if (checkBranchID >= 4700 && checkBranchID <= 4799)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "15": //- 3900 - 3999 modulusCalc = AorB
                if (checkBranchID >= 3900 && checkBranchID <= 3999)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "16": // - 4400 - 4499 modulusCalc = AorB
                if (checkBranchID >= 4400 && checkBranchID <= 4499)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                    break;

            case "17": //  3300 - 3399 modulusCalc = AorB
                 if (checkBranchID >= 3300 && checkBranchID <= 3399)
                     {
                         weightDigits = useMod(accountBase,"AorB");
                         //modulo = 11;
                     }
                else
                     {
                         errorMessage("Not a valid Branch ID " + bankID);
                     }
                break;

            case "18": //- 3500 - 3599 modulusCalc = AorB
                if (checkBranchID >= 3500 && checkBranchID <= 3599)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

         case "19": //- 3500 - 3599 modulusCalc = AorB
                if (checkBranchID >= 4600 && checkBranchID <= 4649)
                 {
                     weightDigits = useMod(accountBase,"AorB");
                //modulo = 11;
            }
            else
            {
                errorMessage("Not a valid Branch ID " + bankID);
            }
            break;


            case "20": // 4100 - 4199 modulusCalc = AorB
                if (checkBranchID >= 4100 && checkBranchID <= 4199)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "21"://  4800 - 4899 modulusCalc = AorB
                if (checkBranchID >= 4800 && checkBranchID <= 4899)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "22": // 4000 - 4049 modulusCalc = AorB
                if (checkBranchID >= 4000 && checkBranchID <= 4049)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "23": // 3700 - 3799 modulusCalc = AorB
                if (checkBranchID >= 3700 && checkBranchID <= 3799)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "24": // 4300 - 4349 modulusCalc = AorB
                if (checkBranchID >= 4300 && checkBranchID <= 4399)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "25": // 2500 - 2599 - F // modulusCalc = CalcF;
                if (checkBranchID >= 2500 && checkBranchID <= 2599)
                    {
                        weightDigits = useMod(accountBase,"F");
                        //modulo = 10;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "26": //- 2600 - 2699 - G // modulusCalc = CalcG;
                if (checkBranchID >= 2600 && checkBranchID <= 2699 )
                    {
                        weightDigits = useMod(accountBase,"G");
                        //modulo = 10;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "27": // 3800 - 3849 modulusCalc = AorB
                if (checkBranchID >= 3800 && checkBranchID <= 3849)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "28": // - 2100 - 2149 - G // modulusCalc = CalcG;
                if (checkBranchID >= 2100 && checkBranchID <= 2149)
                    {
                        weightDigits = useMod(accountBase,"G");
                        //modulo = 10;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                    break;
            case "29": // - 2150 - 2299 - G // modulusCalc = CalcG;
                if (checkBranchID >= 2150 && checkBranchID <= 2299 )
                    {
                        weightDigits = useMod(accountBase,"G");
                        //modulo = 10;
                     }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "30": //- 2900 - 2949 modulusCalc = AorB
                if (checkBranchID >= 2900 && checkBranchID <= 2949 )
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;
            case "31": // 2800 - 2849 - X // modulusCalc = CalcX;
                if (checkBranchID >= 2800 && checkBranchID <= 2899)
                    {
                        weightDigits = useMod(accountBase,"X");
                        //modulo = 1;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "33": //- 6700 - 6799 - F // modulusCalc = CalcF
                if (checkBranchID >= 6700 && checkBranchID <= 6799)
                    {
                        weightDigits = useMod(accountBase,"F");
                        //modulo = 10;
                    }
                else {
                    errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;

            case "35": //- 2400 - 2499 modulusCalc = AorB
                if (checkBranchID >= 2400 && checkBranchID <= 2499)
                     {
                         weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                     }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                     }
                break;

            case "38": //- 9000 - 9499 modulusCalc = AorB
                if (checkBranchID >= 9000 && checkBranchID <= 9499)
                    {
                        weightDigits = useMod(accountBase,"AorB");
                        //modulo = 11;
                    }
                else
                    {
                        errorMessage("Not a valid Branch ID " + bankID);
                    }
                break;
     } //end of switch

     //concat the account details together into a big string
    String stringAccountNumber = bankID + branchID + accountBase + accountSuffix;
    System.out.println("bank account  = " + stringAccountNumber);

    //then convert it to a character array (as the modulus calculates the individual numbers in the bank account number:
    char[] fullAccountNumber = stringAccountNumber.toCharArray();

    // eg modulus A on an account number would be:
    // Modulus Numbers       0 0   6 3 7 9   0 0 10 5 8 4 2 1   0 0 0 0 Modulus equals {11}
    // Bank account number = 0 1   0 9 0 2   6 8 3  8 9 0 0 0   0 0 0 0
    // so the calcualtion is:
    // [0*0]+[0*1] + [6*0]+[3*9]+[7*0]+[9*2] + [0*6]+[0*8]+[10*3]+[5*8]+[8*9]+[4*0]+[2*0]+[1*0] + [0*0]+[0*0]*[0*0]*[0*0]
    // = 176
    // 176/11 = 16 remainder 0 so bank acct number is valid

    int totalSum = 0;
    String myDigit = (String) weightDigits.get(18);

    //loop through the account number and multiply/add everything together
     for (int counter = 0; counter < fullAccountNumber.length ; counter++)
        {
            //convert the current account number digit from a string to an integer
            int intAccountDigit = Integer.parseInt(String.valueOf(fullAccountNumber[counter]));
            //mutiply the account digit by the modulus number
            int sum = intAccountDigit * (int) weightDigits.get(counter);
            // print out the result
            //System.out.println( "(" + fullAccountNumber[counter] + " x " + weightDigits.get(counter) + ") = " + sum);


            //if (modulus = E or G ) then they do their stuff here:
            if ( (String) weightDigits.get(18) == "E" || (String) weightDigits.get(18) == "F") {
                while (sum > 9) {
                    String digitString = String.valueOf(sum);
                    //convert the numbers to a char array
                    char[] digitChar = digitString.toCharArray();
                    //multiply the char array members together as ints
                    int firstDigit = Integer.parseInt(String.valueOf(digitChar[0]));
                    int secondDigit = Integer.parseInt(String.valueOf(digitChar[1]));
                    //System.out.println("firstDigit = " + firstDigit);
                    //System.out.println("secondDigit = " + secondDigit);
                    sum = firstDigit + secondDigit;
                    System.out.println("Sum = " + sum);
                    //
                }
            }
            totalSum += sum;
        }

     System.out.println(totalSum);
     // verify the number by dividing by the modulus
     if (( totalSum % (int) weightDigits.get(19) ) != 0 ) {
         errorMessage("Account number invalid");
     }
     else {
         boolean isAccountValid = true;
        }

    } //end of main
} // end of class

