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
package pairsofsongswithtotaldurationsdivisibleby60;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int numPairsDivisibleBy60(int[] times) {
    Map<Integer, Long> remainderMap = new HashMap<>();
    for (int time : times) {
      int remainder = time % 60;
      long currCount = remainderMap.computeIfAbsent(remainder, x -> 0L);
      remainderMap.put(remainder, currCount + 1);
    }

    long divisibleCount = 0;

    if (remainderMap.containsKey(0)) {
      long zeroCount = remainderMap.get(0);
      divisibleCount += zeroCount * (zeroCount - 1) / 2;
    }

    if (remainderMap.containsKey(30)) {
      long thirtyCount = remainderMap.get(30);
      divisibleCount += thirtyCount * (thirtyCount - 1) / 2;
    }

    for (int i = 1; i < 30; i++) {
      if (remainderMap.containsKey(i) && remainderMap.containsKey(60 - i)) {
        divisibleCount += remainderMap.get(i) * remainderMap.get(60 - i);
      }
    }

    return (int) divisibleCount;
  }
}
