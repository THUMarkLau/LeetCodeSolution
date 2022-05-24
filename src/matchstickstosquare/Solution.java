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
package matchstickstosquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  int edgeCnt = 0;
  boolean[] useMap;
  boolean[] skipMap;
  long edgeLength = 0;

  public boolean makesquare(int[] matchsticks) {
    long sum = 0;
    List<Integer> matchstickList = new ArrayList<>(15);
    useMap = new boolean[matchsticks.length];
    for (int matchstick : matchsticks) {
      sum += matchstick;
      matchstickList.add(matchstick);
    }
    if (sum % 4 != 0) {
      return false;
    }
    Collections.sort(matchstickList);
    edgeLength = sum / 4;
    return makesquare(matchstickList, 0);
  }

  public boolean makesquare(List<Integer> matchstickList, long currLength) {
    int lastEdge = -1;
    for (int i = 0, length = matchstickList.size(); i < length; ++i) {
      int stickLength = matchstickList.get(i);
      if (useMap[i] || stickLength == lastEdge) {
        continue;
      }
      lastEdge = stickLength;
      if (currLength + stickLength == edgeLength) {
        useMap[i] = true;
        ++edgeCnt;
        if (edgeCnt == 4) {
          return true;
        } else {
          if (makesquare(matchstickList, 0)) {
            return true;
          }
          useMap[i] = false;
          --edgeCnt;
        }
      } else if (currLength + stickLength < edgeLength) {
        useMap[i] = true;
        if (makesquare(matchstickList, currLength + stickLength)) {
          return true;
        }
        useMap[i] = false;
      } else {
        return false;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().makesquare(new int[] {5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4}));
  }
}
