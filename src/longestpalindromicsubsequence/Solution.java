/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package longestpalindromicsubsequence;

public class Solution {

  public int longestPalindromeSubseq(String s) {
    int[][] longestSubCount = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); ++i) {
      longestSubCount[i][i] = 1;
    }

    for (int subseqLength = 1; subseqLength < s.length(); ++subseqLength) {
      for (int i = 0; i < s.length(); ++i) {
        int j = i + subseqLength;
        if (j >= s.length()) {
          continue;
        }
        if (s.charAt(i) == s.charAt(j)) {
          longestSubCount[i][j] = longestSubCount[i + 1][j - 1] + 2;
        } else {
          longestSubCount[i][j] = Math.max(longestSubCount[i + 1][j], longestSubCount[i][j - 1]);
        }
      }
    }
    return longestSubCount[0][s.length() - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindromeSubseq("cbbd"));
  }
}
