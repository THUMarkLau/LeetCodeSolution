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
package findallduplicatesinanarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> resultList = new ArrayList<>();
    int occurMark = Integer.MIN_VALUE, visitMark = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      int currNum = nums[i] & visitMark;
      if ((nums[currNum - 1] & occurMark) != 0) {
        // has appear
        resultList.add(currNum);
      } else {
        nums[currNum - 1] = nums[currNum - 1] | occurMark;
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
  }
}
