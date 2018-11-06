class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for(int i=0;i<=s.length();i++) {
            for(int j=0;j<=p.length();j++) {
                if(i==0 && j==0) {
                    dp[i][j] = true;
                }
                else if(j==0) dp[i][j] = false;
                else if(p.charAt(j-1) == '*') {
                    boolean x = false;
                    if(j>=2) x = dp[i][j-2];
                    boolean y = false;
                    if(i>=1) y = dp[i-1][j];
                    dp[i][j] = x || (y && isMatchCharacter(s,p,i-1,j-2));
                }
                else {
                    if(i<1) dp[i][j] = false;
                    else dp[i][j] = dp[i-1][j-1] && isMatchCharacter(s,p,i-1,j-1);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatchCharacter(String s, String p, int stringIndex, int patternIndex) {
        if(stringIndex < 0 || stringIndex >= s.length() || patternIndex < 0 || patternIndex >= p.length()) {
            return false;
        }
        if(p.charAt(patternIndex) == '.') {
            return true;
        }
        return s.charAt(stringIndex) == p.charAt(patternIndex);
    }
}