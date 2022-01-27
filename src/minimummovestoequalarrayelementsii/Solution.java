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
package minimummovestoequalarrayelementsii;

import java.util.Arrays;

public class Solution {
  public int minMoves2(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }

    Arrays.sort(nums);

    int mid = nums[nums.length / 2];
    int step = 0;
    for (int num : nums) {
      step += Math.abs(num - mid);
    }

    return step;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().minMoves2(new int[] {1, 2, 3}));
  }
}
