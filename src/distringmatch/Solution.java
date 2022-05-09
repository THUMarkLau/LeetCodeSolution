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
package distringmatch;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
  public int[] diStringMatch(String s) {
    int[] result = new int[s.length() + 1];
    LinkedList<Integer> indexOfOrder = new LinkedList<>();
    indexOfOrder.add(0);
    int lastIndex = 0;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == 'I') {
        // current num is smaller than next num
        // insert the next num after current num
        indexOfOrder.add(lastIndex + 1, i + 1);
        lastIndex = lastIndex + 1;
      } else {
        // current num is larger than next num
        // insert the next num before current num
        indexOfOrder.add(lastIndex, i + 1);
      }
    }

    int count = 0;
    for (int index : indexOfOrder) {
      result[index] = count++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().diStringMatch("DDI")));
  }
}
