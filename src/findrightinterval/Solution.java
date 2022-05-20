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
package findrightinterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] findRightInterval(int[][] intervals) {
    List<int[]> intervalsInList = Arrays.asList(intervals);
    Map<int[], Integer> indexMap = new HashMap<>();
    int length = intervals.length;
    for (int i = 0; i < length; ++i) {
      indexMap.put(intervals[i], i);
    }
    intervalsInList.sort(Comparator.comparingInt(o -> o[0]));
    int[] res = new int[length];
    for (int i = 0; i < length; ++i) {
      int[] currInterval = intervalsInList.get(i);
      int currIndex = indexMap.get(currInterval);
      res[currIndex] = -1;
      for (int j = i; j < length; ++j) {
        int[] nextInterval = intervalsInList.get(j);
        if (currInterval[1] <= nextInterval[0]) {
          res[indexMap.get(currInterval)] = indexMap.get(nextInterval);
          break;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new Solution().findRightInterval(new int[][] {{1, 1}, {2, 3}, {3, 4}})));
  }
}
