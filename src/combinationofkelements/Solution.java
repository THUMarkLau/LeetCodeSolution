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
package combinationofkelements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> resultList = new LinkedList<>();
    int[] indexes = new int[k];
    for (int i = 0; i < k; ++i) {
      indexes[i] = i;
    }

    while (indexes[0] <= n - k) {
      while (indexes[k - 1] < n) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
          tempList.add(indexes[i] + 1);
        }
        resultList.add(tempList);
        indexes[k - 1] = indexes[k - 1] + 1;
      }
      for (int i = k - 2; i >= 0; --i) {
        if (indexes[i] + 1 < n) {
          indexes[i] = indexes[i] + 1;
          for (int j = 1; j + i < k; ++j) {
            indexes[i + j] = indexes[i] + j;
          }
          break;
        }
      }
    }

    return resultList;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().combine(6, 3));
  }
}
