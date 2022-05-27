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
package findclosest;

public class Solution {
  public int findClosest(String[] words, String word1, String word2) {
    int lastPosOfWord1 = -1;
    int lastPosOfWord2 = -1;
    int shortestDis = Integer.MAX_VALUE;
    int length = words.length;
    int hashCode1 = word1.hashCode();
    int hashCode2 = word2.hashCode();
    boolean useHashCode = hashCode1 != hashCode2;
    for (int i = 0; i < length; ++i) {
      String currWord = words[i];
      int hashCode = currWord.hashCode();
      if (useHashCode) {
        if (hashCode == hashCode1) {
          if (lastPosOfWord2 != -1) {
            shortestDis = Math.min(shortestDis, i - lastPosOfWord2);
          }
          lastPosOfWord1 = i;
        } else if (hashCode == hashCode2) {
          if (lastPosOfWord1 != -1) {
            shortestDis = Math.min(shortestDis, i - lastPosOfWord1);
          }
          lastPosOfWord2 = i;
        }
      } else {
        if (word1.equals(currWord)) {
          if (lastPosOfWord2 != -1) {
            shortestDis = Math.min(shortestDis, i - lastPosOfWord2);
          }
          lastPosOfWord1 = i;
        } else if (word2.equals(currWord)) {
          if (lastPosOfWord1 != -1) {
            shortestDis = Math.min(shortestDis, i - lastPosOfWord1);
          }
          lastPosOfWord2 = i;
        }
      }
    }
    return shortestDis;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .findClosest(
                new String[] {
                  "I", "am", "a", "student", "from", "a", "university", "in", "a", "city"
                },
                "a",
                "student"));
  }
}
