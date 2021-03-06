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
package randompickindex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

class Solution {
  private Map<Integer, List<Integer>> indexesMap = new TreeMap<>();
  private Random random = new Random();

  public Solution(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      indexesMap.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    List<Integer> indexes = indexesMap.get(target);
    return indexes.get(random.nextInt(indexes.size()));
  }
}
