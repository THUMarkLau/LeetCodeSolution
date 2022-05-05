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
package subarrayproductlessthank;

public class Solution {

  private int[] nums;

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    this.nums = nums;
    int[] numOfSubArray = new int[nums.length];

    numOfSubArray[0] = nums[0] < k ? 1 : 0;

    for (int i = 1; i < nums.length; ++i) {
      numOfSubArray[i] =
          nums[i] < k ? numOfSubArray[i - 1] + getSubArrayInIJ(i, k) : numOfSubArray[i - 1];
    }

    return numOfSubArray[nums.length - 1];
  }

  private int getSubArrayInIJ(int j, int k) {
    int sum = nums[j];
    int count = 1;
    int currIdx = j;
    while (currIdx - 1 >= 0 && sum * nums[currIdx - 1] < k) {
      count++;
      sum *= nums[--currIdx];
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().numSubarrayProductLessThanK(new int[] {3, 3, 6, 2}, 19));
  }
}
