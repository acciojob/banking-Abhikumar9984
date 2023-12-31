package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws java.lang.Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name  , balance , 5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws java.lang.Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean valid  = true;
        for(int i = 0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)) {
                valid = false;
                break;
            }
        }

        if(!valid){

            StringBuilder sb  = new StringBuilder();
            int[] freq  = new int[26];

            for(char ch : tradeLicenseId.toCharArray()){
                freq[ch-'a']++;
            }

            int n  = tradeLicenseId.length();
            for(int i  = 0;i<n;i++){
                char maxc = ' ';
                int max  = 0;
                for(int j  = 0;j<26;j++){
                    if(sb.length()>0 && j == sb.charAt(i-1)-'a') continue;
                    if(freq[j]>max){
                        max  = freq[j];
                        maxc  = (char)('a'+j);
                    }
                }
                if(maxc==' '){
                    throw new Exception("Valid License can not be generated");
                }
                sb.append(maxc);
                freq[(int)maxc-'a']--;
            }

            tradeLicenseId = new String(sb.toString());
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}
