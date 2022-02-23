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
package minimumgeneticmutation;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int minMutation(String start, String end, String[] bank) {
    Queue<Integer> toBeVisitedIndexes = new LinkedList<>();
    boolean[] visited = new boolean[bank.length];
    boolean[] reachEnd = new boolean[bank.length];
    int[] times = new int[bank.length];
    boolean canReachEnd = false;
    for (int i = 0; i < bank.length; ++i) {
      times[i] = Integer.MAX_VALUE;
      if (diff(start, bank[i]) == 1) {
        toBeVisitedIndexes.add(i);
        times[i] = 1;
        visited[i] = true;
      }
      int diffToEnd = diff(end, bank[i]);
      if (diffToEnd == 0) {
        reachEnd[i] = true;
        canReachEnd = true;
      }
    }
    if (!canReachEnd) {
      return -1;
    }
    while (toBeVisitedIndexes.size() > 0) {
      int currIdx = toBeVisitedIndexes.poll();
      String currString = bank[currIdx];
      if (reachEnd[currIdx]) {
        return times[currIdx];
      }
      for (int i = 0; i < bank.length; ++i) {
        if (!visited[i] && diff(currString, bank[i]) == 1) {
          toBeVisitedIndexes.add(i);
          System.out.println(currString + " " + bank[i]);
          visited[i] = true;
          times[i] = times[currIdx] + 1;
        }
      }
    }

    return -1;
  }

  public int diff(String s1, String s2) {
    int diffCount = 0;
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diffCount++;
      }
    }
    return diffCount;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .minMutation(
                "AAAAAAAA",
                "CCCCCCCC",
                new String[] {
                  "AAAAAAAA",
                  "AAAAAAAC",
                  "AAAAAACC",
                  "AAAAACCC",
                  "AAAACCCC",
                  "AACACCCC",
                  "ACCACCCC",
                  "ACCCCCCC",
                  "CCCCCCCA"
                }));
  }
}
