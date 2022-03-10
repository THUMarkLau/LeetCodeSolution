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
package countnegativenumbersinasortedmatrix;

public class Solution {
  public int countNegatives(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int currRowIndex = 0, currColumnIndex = m - 1;
    int negCount = 0;
    while (currColumnIndex >= 0 && currRowIndex < n) {
      while (currRowIndex < n && grid[currColumnIndex][currRowIndex] >= 0) {
        currRowIndex++;
      }
      negCount += n - currRowIndex;
      currColumnIndex--;
    }

    return negCount;
  }

  public static void main(String[] args) {
    int[][] nums = new int[4][];
    nums[0] = new int[] {4, 3, 2, -1};
    nums[1] = new int[] {3, 2, 1, -1};
    nums[2] = new int[] {1, 1, -1, -2};
    nums[3] = new int[] {-1, -1, -2, -3};

    System.out.println(new Solution().countNegatives(nums));
  }
}
