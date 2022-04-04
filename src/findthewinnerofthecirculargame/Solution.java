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
package findthewinnerofthecirculargame;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int findTheWinner(int n, int k) {
    List<Long> remainingIndex = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) {
      remainingIndex.add((long) (i + 1));
    }
    int lastRemoveIndex = 0;
    while (remainingIndex.size() > 1) {
      int currRemoveIndex = (k + lastRemoveIndex - 1) % remainingIndex.size();
      remainingIndex.remove(currRemoveIndex);
      lastRemoveIndex = currRemoveIndex;
    }

    return remainingIndex.get(0).intValue();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findTheWinner(6, 5));
  }
}
